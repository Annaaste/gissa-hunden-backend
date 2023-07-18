package com.annapanna.gissahundenbackend.repository;

import com.annapanna.gissahundenbackend.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {

}
