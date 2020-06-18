package net.guides.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Candidate;
import net.guides.springboot2.crud.repository.EmployeeRepository;
import net.guides.springboot2.crud.repository.CandidateRepository ;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private CandidateRepository employeeRepository;
	List<Candidate> matches ;

	@GetMapping("/interviews")
	public List<Candidate> getAllParticipants() {
		return employeeRepository.findAll();
	}

	@GetMapping("/interviews/{id}")
	public ResponseEntity<Candidate> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Candidate candidate = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(candidate);
	}

	@PostMapping("/interviews")
	public Candidate createEmployee(@Validated @RequestBody Candidate candidate) {
		return employeeRepository.save(candidate);
	}

	@GetMapping("/interviewstag")
	public List<Candidate> getEmployeeByTag(@RequestParam(value = "tag" , defaultValue = "NOSUB")String tag) {
		System.out.println("Hey ! ");
		return employeeRepository.findByTag(tag) ;
	}



	/*
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	*/
}
