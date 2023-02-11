package com.cresters.tracker.repository;

import com.cresters.tracker.model.DriverLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface DriverRepository extends JpaRepository<DriverLocation, Long> {

    Optional<DriverLocation> findByDriverId(Long driverId);
}
