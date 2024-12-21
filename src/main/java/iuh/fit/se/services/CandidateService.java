package iuh.fit.se.services;

import java.util.List;

import iuh.fit.se.entities.Candidate;

public interface CandidateService {
	List<Candidate> findAll();
	boolean save(Candidate candidate);
	boolean delete(long id);
	boolean update(Candidate candidate);
	Candidate findById(long id);
	List<Candidate> search(String keyword);
	List<Candidate> candidateMinFiveYears();
	List<Candidate> candidateByRoleStaff();
	
}
