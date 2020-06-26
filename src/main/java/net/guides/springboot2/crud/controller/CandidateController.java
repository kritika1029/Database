package net.guides.springboot2.crud.controller;

import java.util.LinkedList;
import java.util.List;



//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Candidate;
//import net.guides.springboot2.crud.repository.EmployeeRepository;
import net.guides.springboot2.crud.repository.CandidateRepository ;

@RestController
@RequestMapping("/api/v1")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    List<Candidate> matches ;
	

    @GetMapping("/interviews")
    public List<Candidate> getAllParticipants() {
        return candidateRepository.findAll();
    }

    @GetMapping("/interviews/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable(value = "id") Long candidateId)
            throws ResourceNotFoundException {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id : " + candidateId));
        return ResponseEntity.ok().body(candidate);
    }

    @PostMapping("/interviews")
    public Candidate createCandidate(@Validated @RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @GetMapping("/interviewstag")
    public List<Candidate> getCandidateByTag(@RequestParam(value = "tag" , defaultValue = "NOSUB")String tag ,
    		                                 @RequestParam(value = "date" , defaultValue = "NOSUB")String date1,
    		                                 @RequestParam(value = "uniqueId" , defaultValue = "NOSUB")String unique_id,
    		                                 @RequestParam(value = "time1" )int time,
    		                                 @RequestParam(value = "time2" )int time2)
    {
        List<Candidate> matches ;
        List<Candidate> resultant = new LinkedList<>() ;
        
        System.out.println("Hey ! ");
        System.out.println(tag);
        System.out.println(date1);
        System.out.println(unique_id);
        System.out.println(time);
        System.out.println(time2);
        matches = candidateRepository.findByTag(tag) ;
        int length = matches.size() ;
        System.out.println("Length = " + length);
        for(int candidate = 0 ; candidate < length ; candidate ++)
        {
        	
            System.out.println(matches.get(candidate).getdate1());
            if((date1.equals(matches.get(candidate).getdate1())) && !(unique_id.equalsIgnoreCase(matches.get(candidate).getUniqueId())))
            {
            	for(int i=time;i<time2;i+=100)
            	{
            		for(int j=(matches.get(candidate).getTime());j<(matches.get(candidate).getTime2());j+=100)
            		{
            			if(i==j)
            			{
            	
            	
                        System.out.println("In here !");
                        resultant.add(matches.get(candidate)) ;
            			}
            		}
            	}
            }

        }
        
        
        return resultant ;
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

