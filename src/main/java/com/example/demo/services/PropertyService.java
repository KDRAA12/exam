package com.example.demo.services;


import com.example.demo.models.Lease;
import com.example.demo.models.Property;
import com.example.demo.repositories.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public List<Property> findAll(String state) {
        if (state != null && !state.isEmpty()) {
            return propertyRepository.findAllByState(state);
        }
        return propertyRepository.findAll();
    }


    public Double projectedIncome(String state) {
        List<Property> properties = propertyRepository.findAllByState(state);
        Double total = 0d;
        for (Property property : properties) {
            for (Lease lease : property.getLeases()) {
                total += monthsBetween(lease.getStartDate(), lease.getEndDate()) * property.getMonthlyRentalRat();
            }
        }


        return total;

    }

    private int monthsBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Both startDate and endDate must be provided");
        }

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        int startDateTotalMonths = 12 * startCalendar.get(Calendar.YEAR)
                + startCalendar.get(Calendar.MONTH);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int endDateTotalMonths = 12 * endCalendar.get(Calendar.YEAR)
                + endCalendar.get(Calendar.MONTH);

        return endDateTotalMonths-startDateTotalMonths;
    }

    public Property findById(Long id) {
        return propertyRepository.findById(id).orElseThrow(()->new RuntimeException("property not found"));
    }
}