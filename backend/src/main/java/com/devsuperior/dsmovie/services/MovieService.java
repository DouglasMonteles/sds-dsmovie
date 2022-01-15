package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dtos.MovieDTO;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		var movies = this.movieRepository.findAll(pageable);
		var moviesDTO = movies.map(movie -> new MovieDTO(movie));
		
		return moviesDTO;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		var movie = this.movieRepository.findById(id).get();
		var movieDTO = new MovieDTO(movie);
		
		return movieDTO; 
	}
	
}
