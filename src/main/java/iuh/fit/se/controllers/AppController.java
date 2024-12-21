package iuh.fit.se.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.fit.se.entities.Candidate;
import iuh.fit.se.services.CandidateService;
import iuh.fit.se.services.ExperienceService;
import jakarta.validation.Valid;

@Controller
public class AppController {
	@Autowired
	ExperienceService experienceService;
	@Autowired
	CandidateService candidateService;
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, new java.beans.PropertyEditorSupport() {
//			@Override
//			public void setAsText(String text) throws IllegalArgumentException {
//				try {
//					setValue(dateFormat.parse(text));
//				} catch (Exception e) {
//					setValue(null); 
//              }
//			}
//		});
//	}
	
	@GetMapping("/home")
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/candidate")
	public String getAllCandidate(Model model) {
		model.addAttribute("candidates", candidateService.findAll());
		return "candidate-list";
	}
	
	@GetMapping("/report1")
	public String getReport1(Model model) {
		model.addAttribute("candidates", candidateService.candidateMinFiveYears());
		return "report1";
	}
	
	@GetMapping("/report2")
	public String getReport2(Model model) {
		model.addAttribute("candidates", candidateService.candidateByRoleStaff());
		return "report2";
	}
	
	@GetMapping("/candidate/search")
	public String getSearchCandidate(Model model, @RequestParam("keyword") String keyword) {
		model.addAttribute("candidates", candidateService.search(keyword));
		return "candidate-list";
	}
	
	@GetMapping("/candidate/candidate-add")
	public String addCandidateForm(Model model) {
		model.addAttribute("newCandidate", new Candidate());
		return "candidate-add";
	}
	
	@GetMapping("/candidate/candidate-update/{id}")
	public String addCandidateForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("updateCandidate", candidateService.findById(id));
		return "candidate-update";
	}
	
	@PostMapping("/candidate/save")
	public String saveCandidate(@Valid @ModelAttribute("newCandidate") Candidate candidate, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "candidate-add";
        }
        candidateService.save(candidate);
        return "redirect:/candidate";
	}
	
	@PostMapping("/candidate/update/{id}")
	public String updateCandidate(@PathVariable("id") long id, @ModelAttribute("updateCandidate") Candidate candidate) {
		candidate.setId(id);
		candidateService.save(candidate);
		return "redirect:/candidate";
	}
	
	@GetMapping("/candidate/delete/{id}")
	public String deleteCandidate(@PathVariable("id") long id) {
		candidateService.delete(id);
		return "redirect:/candidate";
	}
	
	
	
}
