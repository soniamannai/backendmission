package com.sonia.spring.pfe.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonia.spring.pfe.mission.model.Commercial;
@Repository
public interface CommericalRepository extends JpaRepository<Commercial, Long> {

}
