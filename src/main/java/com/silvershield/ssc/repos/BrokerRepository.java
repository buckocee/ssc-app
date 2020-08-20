package com.silvershield.ssc.repos;

import com.silvershield.ssc.model.Broker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrokerRepository extends JpaRepository<Broker, Integer> {

    Optional<List<Broker>> findBrokersByStatus(Broker.Status status);
}
