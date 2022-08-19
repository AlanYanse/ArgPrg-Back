package com.portafolio.portafoliobackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.portafoliobackend.entity.Skill;

@Repository
public interface ISkill extends JpaRepository<Skill, Integer> {
	
	public Optional<Skill> findByNombreSkill(String nombreSkill);
	public boolean existsByNombreSkill(String nombreSkill);

}
