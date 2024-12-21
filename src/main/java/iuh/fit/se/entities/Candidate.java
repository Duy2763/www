package iuh.fit.se.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Phone is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
	private String phone;
	@NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
	private String email;
	@NotBlank(message = "Full Name is mandatory")
    @Size(min = 2, max = 20, message = "Full Name must be between 2 and 20 characters")
	private String fullName;
	@NotNull(message = "Date of Birth is mandatory")
    @Past(message = "Date of Birth must be in the past")
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "candidate")
	private List<Experience> experiences;

	public Candidate(long id, String phone, String email, String fullName, LocalDate dateOfBirth,
			List<Experience> experiences) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.experiences = experiences;
	}

	public Candidate() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", phone=" + phone + ", email=" + email + ", fullName=" + fullName
				+ ", dateOfBirth=" + dateOfBirth + ", experiences=" + experiences + "]";
	}
	
	
}
