package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Property {

    @Id
    @GeneratedValue
    private Long propertyId;
    @NotNull
    private String propertyRef;
    private String city;
    private String state;
    private Double monthlyRentalRat;
    @Lazy
    @OneToMany(cascade = CascadeType.ALL)
    List<Lease> leases=new ArrayList<>();
//    propertyRef, (required field) (e.g. 1210 Kilo Road etc.)
//    city, (optional field)
//    state, (optional field)
//    monthlyRentalRat
}
