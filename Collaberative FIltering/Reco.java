import java.util.*;
import java.io.*;
class Reco implements Comparator<Rating>
{
	static HashMap <Integer,Movie> moviesHashed;
	static HashMap <Integer,User> usersHashed;
	static double mat[][];
	public Reco()
	{

	}
	public int compare(Rating r1,Rating r2)
	{
		double d1 = r1.rating;
		double d2 = r2.rating;
		double ans = -d1 + d2;
		if (ans > 0)
			return 1;
		return -1;
	}
	public static void buildMatrix(List <Movie> movies,List<User> users)
	{
		int n, m;
		// n = users.size();
		// m = movies.size();
		n = 1000;
		m = 1000;
		mat = new double[n + 2][m + 2];
		for (int i = 1; i <= n; i++)
		{
			User u = usersHashed.get(i);
			List <Rating> ratedMovies = u.getRatedMovies();
			for (Rating r : ratedMovies)
			{
				int j = r.movieId;
				if (j <= 1000)
				mat[i][j] = r.rating;
			}
		}
	}
	public static void init(List <Rating> ratings)
	{
		for (Rating r : ratings)
		{
			User user = usersHashed.get(r.userId);
			user.addRatedMovies(r);
		}
	}
	public static void generateFileForParsedMovies(List <Movie> movies)throws Exception
	{
		PrintWriter pw = new PrintWriter("ParsedMovies.txt");
		for (Movie m : movies)
		{
			pw.println(m.movieId + " " + m.movieTitle + " " + m.genre);
			//pw.write("\n");
		}
		pw.close();
	}

	public static void generateFileForParsedRatings(List <Rating> ratings)throws Exception
	{
		PrintWriter pw = new PrintWriter("ParsedRatings.txt");
		for (Rating m : ratings)
		{
			pw.println(m.userId + " " + m.movieId + " " + m.rating);
			//pw.write("\n");
		}
		pw.close();
	}
	public static void generateFileForParsedUsers(List <User> users)throws Exception
	{
		PrintWriter pw = new PrintWriter("ParsedUsers.txt");
		for (User m : users)
		{
			pw.println(m.userId);
			pw.println("Movies Rated by user " + m.userId+ " are ") ;
			List <Rating> wm = m.getRatedMovies();
			for (Rating r : wm)
			{
				pw.println(r.movieId + " " + " " + r.rating);
			}
			pw.println();
		}
		pw.close();
	}
	public static void jaccardSimilarity(int id,int n)
	{
		Similarity s = new Similarity();
		double ans = -3;
		int index = 0;
		for (int i = 1; i <= n; i++)
		{
			if (i != id)
			{
				double similarity = s.calculateSimilarity(usersHashed.get(id),usersHashed.get(i));
				if (similarity > ans)
				{
					ans = similarity;
					index = i;
				}
			}
		}
		System.out.println("User " + id +" is more Similar to " + index);
	}
	public static void main(String args[]) throws Exception
	{
		System.out.println("Parsing Movies");
		List <Movie> movies = Movie.getMovies();
		System.out.println("Parsing Ratings");
		List <Rating> ratings = Rating.getRatings();
		List <User> users = User.getUsers();
		System.out.println("Parsing Done");
		/*
			Uncomment these lines to get .txt Files 
			from respective .csv files
		*/
		// generateFileForParsedMovies(movies);
		// generateFileForParsedRatings(ratings);
		// generateFileForParsedUsers(users);

		// System.out.println("No of users " + users.size());
		// System.out.println("No of movies " +movies.size());
		// System.out.println("No of users " + users.size());

		System.out.println("Hashing Movies");
		moviesHashed = Movie.hashMovies(movies);
		System.out.println("Hashing Users");
		usersHashed = User.hashUsers(users);
		init(ratings);

		System.out.println("Hashing Done!");
		System.out.println("Building Matrix\n");
		buildMatrix(movies,users);
		

		// System.out.println("Enter User id");
		// Scanner sc = new Scanner(System.in);
		int id = 3;
		List <Rating> ratedMovies = usersHashed.get(id).ratedMovies;
		int commonMovie = Integer.MIN_VALUE;
		jaccardSimilarity(id,1000);
		// // int n = users.size();
		// int n = 1000;
		// List <Rating> recommended = new ArrayList<Rating> ();
		// int ind = 0;
		// // 2608 Max One User Rated
		// for (int i = 1; i <= n; i++)
		// {
		// 	// System.out.println(i);
		// 	if (i != id)
		// 	{
		// 		List <Rating> temp = usersHashed.get(i).ratedMovies;
		// 		// System.out.println(temp.size());
		// 		// System.out.println(ratedMovies.size());
		// 		int cnt = 0;
		// 		List <Rating> notCommon = new ArrayList <Rating>();
		// 		for (Rating cur : temp)
		// 		{
		// 			boolean found = false;
		// 			for (Rating given : ratedMovies)
		// 			{
		// 				if (given.movieId == cur.movieId)
		// 				{
		// 					found = true;
		// 					cnt++;
		// 					break;
		// 				}
		// 			}
		// 			if (!found)
		// 			notCommon.add(cur);
		// 		}
		// 		// System.out.println(cnt);
		// 		if (cnt > commonMovie)
		// 		{
		// 			ind = i;
		// 			commonMovie = cnt;
		// 			recommended = notCommon;
		// 		}
		// 	}
		// }
		// // Collections.sort(recommended,new Reco());
		// PrintWriter pw = new PrintWriter("Recommended.txt");
		// System.out.println(ind);
		// System.out.println(commonMovie);
		// pw.println("Top 20 recommended Movies are");
		// int topCount = 0;
		// for (Rating m : recommended)
		// {
		// 	pw.println(m.movieId);
		// 	topCount++;
		// 	if (topCount == 20)
		// 		break;
		// }
		// pw.close();
	}
}