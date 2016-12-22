import java.util.*;
class Similarity
{
	public int union(User u1,User u2)
	{
		List <Rating> ratedMoviedU1 = u1.getRatedMovies();
		List <Rating> ratedMoviedU2 = u2.getRatedMovies();
		HashSet<Integer> hs = new HashSet<Integer> ();
		for (Rating r : ratedMoviedU1)
		{
			hs.add(r.movieId);
		}
		for (Rating r : ratedMoviedU2)
		{
			hs.add(r.movieId);
		}
		return hs.size();
	}
	public int intersection(User u1,User u2)
	{
		List <Rating> ratedMoviedU1 = u1.getRatedMovies();
		List <Rating> ratedMoviedU2 = u2.getRatedMovies();
		HashSet<Integer> hs = new HashSet<Integer> ();
		for (Rating r : ratedMoviedU1)
		{
			hs.add(r.movieId);
		}
		int cnt = 0;
		for (Rating r : ratedMoviedU2)
		{
			if (hs.contains(r.movieId))
			{
				cnt++;
			}
		}
		return cnt;
	}
	public double calculateSimilarity(User u1,User u2)
	{
		double similarity = (double)intersection(u1,u2) / (double)union(u1,u2);
		return similarity;
	}
}