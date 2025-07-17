package example.rest;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRestController {
	//@RequestMapping("/movie-api") //Default: GET
	@GetMapping("/movie-api")
	public Collection<Movie> getAllMovies(){
		Collection<Movie> movieCollection = 
				MovieRepository.getAllMovies();
		return movieCollection;
	}
	// http://localhost:8080/movie-api/102
	@GetMapping("/movie-api/{movieId}")
	public Movie getSingleMovie(@PathVariable Integer movieId) {
		Movie loadedMovie = 
		MovieRepository.getOneMovie(movieId);
		//System.out.println("Loaded movie is " + loadedMovie);
		if(loadedMovie == null)
			throw new MovieNotFoundException("Movie with given ID does not exist.");
		return loadedMovie;		
	}
	
	@GetMapping("/movie-api/having-genre/{genre}")
	public Collection<Movie> getAllMoviesHavingGenre(@PathVariable String genre){
		return MovieRepository.getAllMovies().stream()
		.filter(currentMovie -> currentMovie.getGenre().equals(genre))
		.collect(Collectors.toList());
		/*
		//Retrieving all movies
		Collection<Movie> movieCollection = 
				MovieRepository.getAllMovies();
		
		//Obtaining a stream based upon some condition using a filter
		Stream<Movie> filteredStream =
		movieCollection.stream().
		filter(currentMovie -> currentMovie.getGenre().equals(genre));
		
		//Returning a filtered collection which is obtained based upon filtered
		//stream by using collect() operation
		
		return filteredStream.collect(Collectors.toList());*/
		
	}
	
	//@RequestMapping(value = "/movie-api", method = RequestMethod.POST)//POST
	@PostMapping("/movie-api")
	public void addNewMovie(@RequestBody Movie movieObject) {
		System.out.println("Received Movie: " + movieObject);
		MovieRepository.createNewMovie(movieObject);
	}
	
	@PutMapping("/movie-api")
	public void updateMovie(@RequestBody Movie movieObject) {
		MovieRepository.updateMovie(movieObject);
	}
	
	@DeleteMapping("/movie-api/{movieId}")
	public void deleteMovie(@PathVariable Integer movieId) {
		MovieRepository.deleteMovie(movieId);
	}	
	
	@PostMapping("/movie-info")
	public void acceptMovieInfo(@RequestBody MovieInfo movieInfoRef) {
		System.out.println(movieInfoRef);
		//Depending upon the requirement, further processing may take place
	}
}








