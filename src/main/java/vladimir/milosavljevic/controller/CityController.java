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


import vladimir.milosavljevic.dto.CityDto;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.service.CityService;


@RestController
@RequestMapping("project/city")
@CrossOrigin(origins = "*")
public class CityController {

	@Autowired
	private CityService cityService;

	@PostMapping("/save")
	public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody CityDto cityDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cityService.save(cityDto));
		} catch (ExistEntityException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<CityDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(cityService.findAll());
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable int id) {
		Optional<CityDto> cityDto = cityService.findById(id);
		if (cityDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(cityDto.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid city id!");
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> deleteById(@PathVariable int id) {
		cityService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted");
	}
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody CityDto cityDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cityService.update(cityDto));
		} catch (EntityNotPresent ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
}
}
