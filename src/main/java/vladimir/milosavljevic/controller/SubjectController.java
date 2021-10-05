package vladimir.milosavljevic.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import vladimir.milosavljevic.dto.ProfessorDto;
import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.dto.SubjectDto;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.facade.SubjectFacade;
import vladimir.milosavljevic.service.SubjectService;

@RestController
@RequestMapping("project/subject")
@CrossOrigin(origins = "*")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SubjectFacade subjectFacade;

	@GetMapping("/page")
	public @ResponseBody ResponseEntity<Page<SubjectDto>> getByPage(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(subjectService.findByPage(pageable));
	}

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<SubjectDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(subjectService.findAll());
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable int id) {
		Optional<SubjectDto> dto = subjectService.findById(id);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("doesnt exist subject with id" + id);
	}

	@PostMapping("/save/{idProfessor}")
	public @ResponseBody ResponseEntity<?> save(@Valid @RequestBody SubjectDto subjectDto,
			@PathVariable Integer idProfessor) throws ExistEntityException {
		subjectDto = subjectFacade.save(subjectDto, idProfessor);

		return new ResponseEntity<SubjectDto>(subjectDto, HttpStatus.OK);
	}

	@PutMapping("/update/") //
	public ResponseEntity<Object> update(@Valid @RequestBody SubjectDto subjectDto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(subjectService.update(subjectDto));
		} catch (EntityNotPresent ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable int id) {
		subjectService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted subject with id" + id);
	}
}
