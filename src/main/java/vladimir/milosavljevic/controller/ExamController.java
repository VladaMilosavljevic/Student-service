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
import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.facade.ExamFacade;
import vladimir.milosavljevic.service.ExamService;

@RestController
@RequestMapping("/project/exam")
@CrossOrigin(origins = "*")
public class ExamController {
	@Autowired
	private ExamService examService;
	@Autowired
	private ExamFacade examFacade;

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<ExamDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(examService.findAll());
	}

	@PutMapping("/update/") //
	public ResponseEntity<Object> update(@Valid @RequestBody ExamDto examDto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(examService.update(examDto));
		} catch (EntityNotPresent ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable int id) {
		Optional<ExamDto> examDto = examService.findById(id);
		if (examDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(examDto.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("doesnt exist exam with id" + id);
	}

	@PostMapping("/save/{idsubject}/{idExamPeriod}")
	public @ResponseBody ResponseEntity<?> save(@Valid @RequestBody ExamDto examDto, @PathVariable Integer idsubject,
			@PathVariable Integer idExamPeriod) throws Exception {
		examDto = examFacade.save(examDto, idsubject, idExamPeriod);

		return new ResponseEntity<ExamDto>(examDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable int id) {
		examService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted exam with id" + id);
	}
}
