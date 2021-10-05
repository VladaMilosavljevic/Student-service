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
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.facade.ProfessorFacade;
import vladimir.milosavljevic.service.ProfessorService;

@RestController
@RequestMapping("/project/professor")
@CrossOrigin(origins = "*")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	@Autowired
	private ProfessorFacade professorFacade;
	
	
	@GetMapping("/page")
	public @ResponseBody ResponseEntity<Page<ProfessorDto>> getByPage(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(professorService.findByPage(pageable));
	}

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<ProfessorDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(professorService.findAll());
	}

	@PutMapping("/update") //
	public ResponseEntity<Object> update(@Valid @RequestBody ProfessorDto professorDto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(professorService.update(professorDto));
		} catch (EntityNotPresent ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable int id) {
		Optional<ProfessorDto> professorDto = professorService.findById(id);
		if (professorDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(professorDto.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("doesnt exist professor with id" + id);
	}

	@PostMapping("/save/{idCity}/{idTitle}")
	public @ResponseBody ResponseEntity<?> save(@Valid @RequestBody ProfessorDto professorDto,
			@PathVariable Integer idCity, @PathVariable Integer idTitle) throws ExistEntityException {
		professorDto = professorFacade.save(professorDto, idCity, idTitle);
		return new ResponseEntity<ProfessorDto>(professorDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable int id) {
		professorService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted profesor with id" + id);
	}
	
	
}
