package test.astralife.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.astralife.exception.ResourceNotFoundException;
import test.astralife.model.Division;
import test.astralife.repository.DivisionRepository;

@RestController
@RequestMapping("/main")
public class DivisionController {
	@Autowired
	private DivisionRepository divisionRepository;

	@GetMapping("/divisions")
	public List<Division> getAllDivisions() {
		return divisionRepository.findAll();
	}

	@GetMapping("/divisions/{division_id}")
	public ResponseEntity<Division> getDivisionById(@PathVariable(value = "division_id") Long divisionId)
			throws ResourceNotFoundException {
		Division division = divisionRepository.findById(divisionId)
				.orElseThrow(() -> new ResourceNotFoundException("Division not found for this division_id :: " + divisionId));
		return ResponseEntity.ok().body(division);
	}

	@PostMapping("/divisions")
	public Division createDivision(@Valid @RequestBody Division division) {
		return divisionRepository.save(division);
	}

	@PutMapping("/divisions/{division_id}")
	public ResponseEntity<Division> updateDivision(@PathVariable(value = "division_id") Long divisionId,
			@Valid @RequestBody Division divisionDetails) throws ResourceNotFoundException {
		Division division = divisionRepository.findById(divisionId)
				.orElseThrow(() -> new ResourceNotFoundException("Division not found for this division_id :: " + divisionId));

		division.setName(divisionDetails.getName());
		final Division updatedDivision = divisionRepository.save(division);
		return ResponseEntity.ok(updatedDivision);
	}

	@DeleteMapping("/divisions/{division_id}")
	public Map<String, Boolean> deleteDivision(@PathVariable(value = "division_id") Long divisionId)
			throws ResourceNotFoundException {
		Division division = divisionRepository.findById(divisionId)
				.orElseThrow(() -> new ResourceNotFoundException("Division not found for this division_id :: " + divisionId));

		divisionRepository.delete(division);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
