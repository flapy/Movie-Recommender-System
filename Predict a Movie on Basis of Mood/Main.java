import java.util.*;
class Main
{
	public static void main(String args[])
	{
		BuildRelevanceMatirx brm = new BuildRelevanceMatirx(10,20);
		HashMap <String,Integer> mapTags = brm.mapTags();
		HashMap <Integer,String> mapMovies = brm.mapMovies();
		double mat[] [] = brm.init();
		System.out.println("Enter the type of movies you want to see");
		String str = "";
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		int tagId = mapTags.get(str);
		List <RelavanceUtil> l = new ArrayList <RelavanceUtil> ();
		for (int i = 1; i <= 10000; i++)
		{
			String movie = mapMovies.get(i);
			l.add(new RelavanceUtil(movie,mat[i][tagId]));
		}
		Collections.sort(l,new RelavanceUtil());
		int cnt = 0;
		for (RelavanceUtil ru : l)
		{
			System.out.println(ru.movie);
			cnt++;
			if (cnt == 10)
				break;
		}
	}
}