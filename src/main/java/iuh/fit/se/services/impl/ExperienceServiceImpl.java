package iuh.fit.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.entities.Experience;
import iuh.fit.se.repositories.ExperienceRepository;
import iuh.fit.se.services.ExperienceService;

@Service
public class ExperienceServiceImpl implements ExperienceService{
	@Autowired
	private ExperienceRepository experienceRepository;

	@Override
	public List<Experience> findAll() {
		return experienceRepository.findAll();
	}
	
	
	
}
