package com.cresters.tracker.repository;

import com.cresters.tracker.model.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {

    Optional<Dispatch> findByDispatchId(long dispatchId);
}
