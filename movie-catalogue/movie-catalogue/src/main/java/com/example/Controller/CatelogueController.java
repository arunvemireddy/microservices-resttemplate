package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.Movies;

@RestController
@RequestMapping(path = "/movieCatalogue")
public class CatelogueController {
	
	
	private static Movies createMovie(int id, String name, String director, String[] cast) {
        Movies movie = new Movies();
        movie.setMovieId(id);
        movie.setMovieName(name);
        movie.setDirector(director);
        movie.setCast(cast);
        return movie;
    }

	@RequestMapping(path = "/getMovies")
	public List<Movies> catelogue() {

		List<Movies> movieList = new ArrayList<>();

        String[] cast1 = {"Leonardo DiCaprio", "Kate Winslet"};
        String[] cast2 = {"Sam Neill", "Laura Dern"};
        String[] cast3 = {"Matthew McConaughey", "Anne Hathaway"};

        movieList.add(createMovie(1, "Titanic", "James Cameron", cast1));
        movieList.add(createMovie(2, "Jurassic Park", "Stephen Spielberg", cast2));
        movieList.add(createMovie(3, "Interstellar", "Christopher Nolan", cast3));

		return movieList;
	}
}
