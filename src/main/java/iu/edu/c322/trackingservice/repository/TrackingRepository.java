package iu.edu.c322.trackingservice.repository;

import iu.edu.c322.trackingservice.model.Tracker;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TrackingRepository extends JpaRepository<Tracker, Integer> {
}
