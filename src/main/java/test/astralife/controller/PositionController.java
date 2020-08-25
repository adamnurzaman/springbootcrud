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
import test.astralife.model.Position;
import test.astralife.repository.PositionRepository;

@RestController
@RequestMapping("/main")
public class PositionController {
	@Autowired
	private PositionRepository positionRepository;

	@GetMapping("/positions")
	public List<Position> getAllPositions() {
		return positionRepository.findAll();
	}

	@GetMapping("/positions/{position_id}")
	public ResponseEntity<Position> getPositionById(@PathVariable(value = "position_id") Long positionId)
			throws ResourceNotFoundException {
		Position position = positionRepository.findById(positionId)
				.orElseThrow(() -> new ResourceNotFoundException("Position not found for this position_id :: " + positionId));
		return ResponseEntity.ok().body(position);
	}

	@PostMapping("/positions")
	public Position createPosition(@Valid @RequestBody Position position) {
		return positionRepository.save(position);
	}

	@PutMapping("/positions/{position_id}")
	public ResponseEntity<Position> updatePosition(@PathVariable(value = "position_id") Long positionId,
			@Valid @RequestBody Position positionDetails) throws ResourceNotFoundException {
		Position position = positionRepository.findById(positionId)
				.orElseThrow(() -> new ResourceNotFoundException("Position not found for this position_id :: " + positionId));

		position.setLevel(positionDetails.getLevel());
		position.setName(positionDetails.getName());
		final Position updatedPosition = positionRepository.save(position);
		return ResponseEntity.ok(updatedPosition);
	}

	@DeleteMapping("/positions/{position_id}")
	public Map<String, Boolean> deletePosition(@PathVariable(value = "position_id") Long positionId)
			throws ResourceNotFoundException {
		Position position = positionRepository.findById(positionId)
				.orElseThrow(() -> new ResourceNotFoundException("Position not found for this position_id :: " + positionId));

		positionRepository.delete(position);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
