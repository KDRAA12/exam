package com.example.demo.repositories;

import com.example.demo.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {
    @Query("select p from Property p where p.state=:state order by p.monthlyRentalRat")
    List<Property> findAllByState(String state);



}
