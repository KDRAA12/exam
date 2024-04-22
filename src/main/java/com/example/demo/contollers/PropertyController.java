package com.example.demo.contollers;


import com.example.demo.dtos.PropertyMainDTO;
import com.example.demo.models.Lease;
import com.example.demo.models.Property;
import com.example.demo.services.LeaseService;
import com.example.demo.services.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/properties")
@AllArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;
    private final LeaseService leaseService;
    @GetMapping
    public List<PropertyMainDTO> findAll(@RequestParam(required = false) String state){
        return propertyService.findAll(state)
                .stream()
                .map(PropertyMainDTO::mapTpDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/leases")
    public void addLease(
            @PathVariable Long id,
            @RequestBody Lease lease){
        Property property=propertyService.findById(id);
         leaseService.addLeaseToProperty(property,lease);
    }

    @GetMapping("/income")
    public Double projectedIncome(@RequestParam String state){
        return propertyService.projectedIncome(state);
    }






}
