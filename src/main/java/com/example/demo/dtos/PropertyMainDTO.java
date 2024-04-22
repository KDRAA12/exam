package com.example.demo.dtos;

import com.example.demo.models.Lease;
import com.example.demo.models.Property;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class PropertyMainDTO {
    private Long propertyId;
    private String propertyRef;
    private String city;
    private String state;
    private Double monthlyRentalRat;
    List<LeaseSecondaryDTO> leases;

    public   static PropertyMainDTO mapTpDto(Property property){
        PropertyMainDTO pr=new PropertyMainDTO();
        pr.setPropertyId(property.getPropertyId());
        pr.setPropertyRef(property.getPropertyRef());
        pr.setCity(property.getCity());
        pr.setState(pr.getState());
        List<LeaseSecondaryDTO> leases=new ArrayList<>();
        for(Lease l:property.getLeases()){
            leases.add(LeaseSecondaryDTO.mapTpDto(l));
        }
        pr.setLeases(leases);
        return pr;
    }

}
