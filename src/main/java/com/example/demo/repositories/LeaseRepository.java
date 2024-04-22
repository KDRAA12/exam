package com.example.demo.repositories;


import com.example.demo.models.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease,Long> {

    @Query(value = "select l from Lease l order by l.leaseId desc ")
    List<Lease> findAllOrderedByReferenceNumberDesc();
}
