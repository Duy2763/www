package iuh.fit.se.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String workDescription;
	private Roles role;
	private String companyName;
	private LocalDate fromDate;
	private LocalDate toDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
	private Candidate candidate;

	public Experience(long id, String workDescription, Roles role, String companyName, LocalDate fromDate,
			LocalDate toDate, Candidate candidate) {
		super();
		this.id = id;
		this.workDescription = workDescription;
		this.role = role;
		this.companyName = companyName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.candidate = candidate;
	}

	public Experience() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", workDescription=" + workDescription + ", role=" + role + ", companyName="
				+ companyName + ", fromDate=" + fromDate + ", toDate=" + toDate + ", candidate=" + candidate + "]";
	}
	
}
