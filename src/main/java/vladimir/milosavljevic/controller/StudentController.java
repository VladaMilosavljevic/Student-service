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
import vladimir.milosavljevic.dto.CityDto;
import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.facade.StudentFacade;
import vladimir.milosavljevic.service.CityService;
import vladimir.milosavljevic.service.StudentService;

@RestController
@RequestMapping("/project/student")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentFacade studentFacade;
	
	
	@GetMapping("/page")
	public @ResponseBody ResponseEntity<Page<StudentDto>> getByPage(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.findByPage(pageable));
	}

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<StudentDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
	}

	@PutMapping("/update") //
	public ResponseEntity<Object> update( @Valid @RequestBody StudentDto studentDto)
			throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(studentService.update(studentDto));
		} catch (EntityNotPresent ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable int id) {
		Optional<StudentDto> studentDto = studentService.findById(id);
		if (studentDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(studentDto.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("doesnt exist student with id" + id);
	}

	@PostMapping("/save/{idCity}")
	public @ResponseBody ResponseEntity<?> save(@Valid @RequestBody StudentDto studentDto, @PathVariable Integer idCity)
			throws ExistEntityException {
		studentDto = studentFacade.save(studentDto, idCity);
		return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable int id) {
		studentService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted student with id" + id);
	}

}
