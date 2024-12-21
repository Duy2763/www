package iuh.fit.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.entities.Candidate;
import iuh.fit.se.repositories.CandidateRepository;
import iuh.fit.se.services.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	private CandidateRepository candidateRepository;
	
	@Override
	public List<Candidate> findAll() {
		return candidateRepository.findAll();
	}

	@Override
	public boolean save(Candidate candidate) {
		candidateRepository.save(candidate);
		return true;
	}

	@Override
	public boolean delete(long id) {
		if (candidateRepository.existsById(id)) {
			candidateRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Candidate candidate) {
		candidateRepository.saveAndFlush(candidate);
		return true;
	}

	@Override
	public Candidate findById(long id) {
		return candidateRepository.findById(id).get();
	}

	@Override
	public List<Candidate> search(String keyword) {
		return candidateRepository.search(keyword);
	}

	@Override
	public List<Candidate> candidateMinFiveYears() {
		return candidateRepository.candidateMinFiveYears();
	}

	@Override
	public List<Candidate> candidateByRoleStaff() {
		return candidateRepository.candidateByRoleStaff();
	}

	
	
}
