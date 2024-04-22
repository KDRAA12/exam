package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lease {
    @Id
    @GeneratedValue
    private Long leaseId;

    @Column(unique = true)
    private Long leaseReferenceNumber;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @Lazy
    private Property property;


}
