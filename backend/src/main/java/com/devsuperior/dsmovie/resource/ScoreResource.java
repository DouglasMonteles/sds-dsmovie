package com.devsuperior.dsmovie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dtos.MovieDTO;
import com.devsuperior.dsmovie.dtos.ScoreDTO;
import com.devsuperior.dsmovie.services.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreResource {
	
	@Autowired
	private ScoreService scoreService;

	@PutMapping
	public ResponseEntity<MovieDTO> saveScore(@RequestBody ScoreDTO scoreDTO) {
		var movie = this.scoreService.saveScore(scoreDTO);
		return ResponseEntity.ok().body(movie);
	}
	
}
