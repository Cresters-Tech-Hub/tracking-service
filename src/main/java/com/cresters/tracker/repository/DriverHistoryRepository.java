package com.cresters.tracker.repository;

import com.cresters.tracker.model.DispatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverHistoryRepository extends JpaRepository<DispatchHistory, Long> {

}
