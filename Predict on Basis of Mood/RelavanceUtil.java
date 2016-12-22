import java.util.*;
class RelavanceUtil implements Comparator<RelavanceUtil>
{
	double relavance;
	String movie;
	public RelavanceUtil()
	{

	}
	public RelavanceUtil(String movie,double relavance)
	{
		this.movie = movie;
		this.relavance = relavance;
	}
	public int compare(RelavanceUtil r1,RelavanceUtil r2)
	{
		double d1 = r1.relavance;
		double d2 = r2.relavance;
		double ans = -d1 + d2;
		if (ans > 0)
			return 1;
		return -1;
	}
}