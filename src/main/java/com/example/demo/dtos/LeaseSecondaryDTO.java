package com.example.demo.dtos;

import com.example.demo.models.Lease;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LeaseSecondaryDTO {
    private Long leaseId;
    private Long leaseReferenceNumber;
    private Date startDate;
    private Date endDate;

    public static LeaseSecondaryDTO mapTpDto(Lease l) {
        LeaseSecondaryDTO leaseSecondaryDTO=new LeaseSecondaryDTO();
        leaseSecondaryDTO.setLeaseId(l.getLeaseId());
        leaseSecondaryDTO.setLeaseReferenceNumber(l.getLeaseReferenceNumber());
        leaseSecondaryDTO.setStartDate(l.getStartDate());
        leaseSecondaryDTO.setEndDate(l.getEndDate());
        return leaseSecondaryDTO;
    }
}
