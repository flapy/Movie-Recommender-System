import java.util.*;
class Rating
{
	static List <Rating> ratings = new ArrayList <Rating>();
	double rating;
	int movieId;
	int userId;
	public Rating(int movieId,double rating,int userId)
	{
		this.rating = rating;
		this.movieId = movieId;
		this.userId = userId;
	}
	public static void addRating(Rating r)
	{
		ratings.add(r);
	}
	public static List <Rating> getRatings()
	{
		CSVReader.parseRatings();
		return ratings;
	}
}