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

import vladimir.milosavljevic.dto.RegisteredExamDto;
import vladimir.milosavljevic.dto.SubjectDto;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.facade.RegisteredExamFacade;
import vladimir.milosavljevic.service.RegisteredExamService;

@RestController
@RequestMapping("/project/registeredexam")
@CrossOrigin(origins = "*")
public class RegisteredExamController {

	@Autowired
	private RegisteredExamFacade facade;
	@Autowired
	private RegisteredExamService service;

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<RegisteredExamDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable int id) {
		Optional<RegisteredExamDto> dto = service.findById(id);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("doesnt exist registered exam with id" + id);
	}

	@PostMapping("/save/{idStudent}/{idExam}")
	public @ResponseBody ResponseEntity<?> save(@Valid @RequestBody RegisteredExamDto registeredExamDto,
			@PathVariable Integer idStudent, @PathVariable Integer idExam) throws Exception {
		registeredExamDto = facade.save(registeredExamDto, idStudent, idExam);

		return new ResponseEntity<RegisteredExamDto>(registeredExamDto, HttpStatus.OK);
	}

	@PutMapping("/update/") //
	public ResponseEntity<Object> update(@Valid @RequestBody RegisteredExamDto registeredExamDto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(registeredExamDto));
		} catch (EntityNotPresent ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted registered exam with id" + id);
	}
}
