package iuh.fit.se.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.Experience;

@Repository
public interface ExperienceService {
	List<Experience> findAll();
}
