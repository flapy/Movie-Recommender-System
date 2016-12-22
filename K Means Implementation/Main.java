import java.util.*;
import java.math.*;
class Main
{
	public static void main(String args[])
	{
		BuildRelevanceMatirx brm = new BuildRelevanceMatirx(10,20);
		HashMap <String,Integer> mapTags = brm.mapTags();
		HashMap <Integer,String> mapMovies = brm.mapMovies();
		double mat[] [] = brm.init();
		KMeanClustring kmc = new KMeanClustring(5);
		kmc.doSomething(mat);
	}
}