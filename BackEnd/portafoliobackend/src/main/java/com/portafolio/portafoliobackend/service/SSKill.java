package com.portafolio.portafoliobackend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.portafoliobackend.entity.Skill;
import com.portafolio.portafoliobackend.repository.ISkill;

@Service
@Transactional
public class SSKill {
	
	@Autowired
	ISkill iSkill;
	
	public List<Skill> list(){
        return iSkill.findAll();
    }
	
	public Optional<Skill> getOne(int id){
        return iSkill.findById(id);
    }
	
	public Optional<Skill> getByNombreSkill(String nombreSkill){
        return iSkill.findByNombreSkill(nombreSkill);
    }
	
	public void save(Skill skill){
		iSkill.save(skill);
    }
	
	 public void delete(int id){
		 iSkill.deleteById(id);
     }
	 
	 public boolean existsById(int id){
         return iSkill.existsById(id);
     }
	 
	 public boolean existsByNombreSkill(String nombreSkill){
         return iSkill.existsByNombreSkill(nombreSkill);
     }

}
