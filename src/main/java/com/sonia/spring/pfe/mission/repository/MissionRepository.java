package com.sonia.spring.pfe.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonia.spring.pfe.mission.model.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long>   {

}
