package com.example.demo.dtos;


import com.example.demo.models.Lease;
import com.example.demo.models.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertySecondaryDTO {
    private Long propertyId;
    private String propertyRef;
    private String city;
    private String state;
    private Double monthlyRentalRat;

    public   static PropertySecondaryDTO mapTpDto(Property property){
        PropertySecondaryDTO pr=new PropertySecondaryDTO();
        pr.setPropertyId(property.getPropertyId());
        pr.setPropertyRef(property.getPropertyRef());
        pr.setCity(property.getCity());
        pr.setState(pr.getState());
        return pr;
    }
}
