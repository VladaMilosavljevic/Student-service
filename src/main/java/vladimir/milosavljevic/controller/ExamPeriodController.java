package vladimir.milosavljevic.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.service.ExamPeriodService;

@RestController
@RequestMapping("project/examperiod/")
@CrossOrigin(origins = "*")
public class ExamPeriodController {

	@Autowired
	private ExamPeriodService service;

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<ExamPeriodDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@PutMapping("/update/") //
	public ResponseEntity<Object> update(@Valid @RequestBody ExamPeriodDto examPeriodDto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(examPeriodDto));
		} catch (EntityNotPresent ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable int id) {
		Optional<ExamPeriodDto> examPeriod = service.findById(id);
		if (examPeriod.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(examPeriod.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("doesnt exist exam period with id" + id);
	}

	@PostMapping("/save")
	public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody ExamPeriodDto examPeriodDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(examPeriodDto));
		} catch (ExistEntityException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> deleteById(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted");
	}
}
