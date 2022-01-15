package com.devsuperior.dsmovie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dtos.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
		var moviesDTO = this.movieService.findAll(pageable);
		return ResponseEntity.ok().body(moviesDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		var movieDTO = this.movieService.findById(id);
		return ResponseEntity.ok().body(movieDTO);
	}
	
}
