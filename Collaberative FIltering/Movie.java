import java.util.*;
class Movie
{
	String genre, movieTitle;
	int movieId;
	public static List <Movie> movies = new ArrayList <Movie> ();
	public Movie(String movieTitle,int movieId,String genre)
	{
		this.movieTitle = movieTitle;
		this.movieId = movieId;
		this.genre = genre;
	}
	public static void addMovie(Movie m)
	{
		movies.add(m);
	}
	public static HashMap <Integer,Movie> hashMovies(List <Movie> movies)
	{
		HashMap <Integer,Movie> moviesHashed = new HashMap <Integer,Movie>();;
		for (Movie m : movies)
		{
			moviesHashed.put(m.movieId,m);
		}
		return moviesHashed;
	}
	public static List<Movie> getMovies()
	{
		CSVReader.parseMovies();
		return movies;
	}
}