package com.example.demo.services;


import com.example.demo.models.Lease;
import com.example.demo.models.Property;
import com.example.demo.repositories.LeaseRepository;
import com.example.demo.repositories.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LeaseService {
    private final LeaseRepository leaseRepository;
    private final PropertyRepository   propertyRepository;

    public List<Lease> findAll() {
        return leaseRepository.findAllOrderedByReferenceNumberDesc();
    }

    public void addLeaseToProperty(Property p, Lease lease) {
        lease.setProperty(p);
        lease=leaseRepository.save(lease);
        p.getLeases().add(lease);
        propertyRepository.save(p);
        leaseRepository.save(lease);
    }
}
