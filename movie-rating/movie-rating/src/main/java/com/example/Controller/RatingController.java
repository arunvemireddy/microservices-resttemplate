package com.example.Controller;


import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.movierating.DTO.MovieDTO;
import com.example.movierating.DTO.MovieRatingDTO;



@RestController
@RequestMapping(path = "/movieReview")
public class RatingController {

	@Autowired
	public RestTemplate restTemplate;
	
	private static final Logger logger =  LoggerFactory.getLogger(RatingController.class);

	
	public MovieRatingDTO giveRating(int id, String name) {
		MovieRatingDTO movieRatingDTO = new MovieRatingDTO();
		movieRatingDTO.setMovieId(id);
		movieRatingDTO.setMovieName(name);
		movieRatingDTO.setRating(4.5);
		return movieRatingDTO;
	}

	@RequestMapping(path = "/getRating")
	public List<MovieRatingDTO> movieRating() {
        ResponseEntity<List<MovieDTO>> responseEntity = restTemplate.exchange(
                "http://movie-catalogue/movieCatalogue/getMovies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MovieDTO>>() {});

        List<MovieDTO> movieList = responseEntity.getBody();
        List<MovieRatingDTO> movieRatingDTOs = new ArrayList<>();
        
        for (MovieDTO movieDTO : movieList) {
        	logger.info(movieDTO.getMovieId()+" "+movieDTO.getMovieName());
            movieRatingDTOs.add(giveRating(movieDTO.getMovieId(), movieDTO.getMovieName()));
        }
        return movieRatingDTOs;
	}

}
