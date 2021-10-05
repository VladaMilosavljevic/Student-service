package vladimir.milosavljevic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import vladimir.milosavljevic.dto.TitleDto;
import vladimir.milosavljevic.service.TitleService;


@RestController
@RequestMapping("/project/title")
@CrossOrigin(origins = "*")
public class TitleController {

	@Autowired
	private TitleService service;

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<TitleDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable int id) {
		Optional<TitleDto> title = service.findById(id);
		if (title.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(title.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid title id!");
	}
}
