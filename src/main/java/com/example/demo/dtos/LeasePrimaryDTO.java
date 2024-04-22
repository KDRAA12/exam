package com.example.demo.dtos;

import com.example.demo.models.Lease;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeasePrimaryDTO {
    private Long leaseId;
    private Long leaseReferenceNumber;
    private Date startDate;
    private Date endDate;
    private PropertySecondaryDTO property;

    public static LeasePrimaryDTO mapTpDto(Lease l) {
        LeasePrimaryDTO leaseSecondaryDTO=new LeasePrimaryDTO();
        leaseSecondaryDTO.setLeaseId(l.getLeaseId());
        leaseSecondaryDTO.setLeaseReferenceNumber(l.getLeaseReferenceNumber());
        leaseSecondaryDTO.setStartDate(l.getStartDate());
        leaseSecondaryDTO.setEndDate(l.getEndDate());
        leaseSecondaryDTO.setProperty(PropertySecondaryDTO.mapTpDto(l.getProperty()));
        return leaseSecondaryDTO;
    }
}
