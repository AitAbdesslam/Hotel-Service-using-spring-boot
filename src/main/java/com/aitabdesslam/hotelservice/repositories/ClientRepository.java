package com.aitabdesslam.hotelservice.repositories;

import com.aitabdesslam.hotelservice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByEmail(String email);

    boolean existsByEmail(String email);
}
