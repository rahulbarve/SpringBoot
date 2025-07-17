package example.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieRepository {
	//This class is meant for holding several Movie objects
	private static Map<Integer, Movie> allMovies;
	
	static {
		allMovies = new HashMap<>();
		Movie m1 = new Movie(101, "Life of PI", "Emotional", 125);
		Movie m2 = new Movie(102, "Speed", "Action", 85);
		Movie m3 = new Movie(103, "Predator", "Horror", 95);
		Movie m4 = new Movie(104, "Commando", "Action", 80);
		Movie m5 = new Movie(105, "Tremors", "Horror", 90);
		Movie m6 = new Movie(106, "Terminator", "Horror", 95);
		
		allMovies.put(m1.getMovieId(), m1);
		allMovies.put(m2.getMovieId(), m2);
		allMovies.put(m3.getMovieId(), m3);		
		allMovies.put(m4.getMovieId(), m4);
		allMovies.put(m5.getMovieId(), m5);
		allMovies.put(m6.getMovieId(), m6);
	}
	
	//This method returns all movies
	public static Collection<Movie> getAllMovies(){
		Collection<Movie> allAvailableMovies = 
				allMovies.values();
		return allAvailableMovies;
	}
	
	//This method returns a single movie based upon ID
	public static Movie getOneMovie(Integer movieId) {
		Movie foundMovie = allMovies.get(movieId);
		return foundMovie;
	}
	
	public static void createNewMovie(Movie movieObject) {
		allMovies.put(movieObject.getMovieId(), movieObject);
	}
	
	public static void updateMovie(Movie movieObject) {
		allMovies.put(movieObject.getMovieId(), movieObject);
	}
	
	public static void deleteMovie(Integer movieId) {
		allMovies.remove(movieId);
	}

}









