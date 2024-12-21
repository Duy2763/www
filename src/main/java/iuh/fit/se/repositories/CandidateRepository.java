package iuh.fit.se.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{
	@Query(value = "SELECT * FROM candidate c WHERE c.full_name LIKE %:keyword% OR c.phone LIKE %:keyword%", nativeQuery = true)
	List<Candidate> search(@Param("keyword") String keyword);
	
	@Query(value = "SELECT c.* FROM candidate c "
			+ "JOIN experience e ON c.id = e.candidate_id "
			+ "GROUP BY c.id, c.full_name, c.email, c.phone, c.date_of_birth "
			+ "HAVING SUM(DATEDIFF(e.to_date, e.from_date) / 365) >= 5"
			, nativeQuery = true)
	List<Candidate> candidateMinFiveYears();
	
	
	@Query(value = "SELECT DISTINCT c.* FROM candidate c "
	        + "JOIN experience e ON c.id = e.candidate_id "
	        + "WHERE e.role = 2", nativeQuery = true)
	List<Candidate> candidateByRoleStaff();
}
