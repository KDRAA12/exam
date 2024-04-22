package com.example.demo.contollers;


import com.example.demo.dtos.LeasePrimaryDTO;
import com.example.demo.models.Lease;
import com.example.demo.services.LeaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leases")
@AllArgsConstructor
public class LeaseController {
    private final LeaseService leaseService;

    @GetMapping
    public List<LeasePrimaryDTO> findAll() {
        return  leaseService.findAll()
                .stream()
                .map(LeasePrimaryDTO::mapTpDto)
                .collect(Collectors.toList());
    }

}
