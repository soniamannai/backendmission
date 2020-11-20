package com.sonia.spring.pfe.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonia.spring.pfe.mission.model.CandidatureMission;
@Repository
public interface CandidatureMissionRepository extends JpaRepository<CandidatureMission, Long> {

}
