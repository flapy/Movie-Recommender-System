import java.util.*;
import java.math.*;
class Point
{
	double arr[];
	int clusterNumber;
	public Point()
	{

	}
	public Point(double arr[])
	{
		this.arr = new double[arr.length + 2];
		this.arr = arr;
	}
	public void setClusterNumber(int no)
	{
		clusterNumber = no;
	}
	public double getClusterNumber()
	{
		return clusterNumber;
	}
	public static double calcDistance(Point a,Point b)
	{
		double arr1[] = a.arr;
		double arr2[] = b.arr;
		int no = arr1.length;
		double ans = 0;
		for (int i = 0; i < no; i++)
		{
			double dif = arr1[i] - arr2[i];
			ans += Math.pow(dif,2);
		}
		return Math.sqrt(ans);
	}
	// public static List<Point> getRandPoints(int n,int max,int min)
	// {
	// 	List <Point> l = new ArrayList<Point> ();
	// 	Random r = new Random();
	// 	double tempX, tempY;
	// 	for (int i = 0; i < n; i++)
	// 	{
	// 		tempX = min + (max - min) * r.nextDouble();
 //    		tempY = min + (max - min) * r.nextDouble();
 //    		l.add(new Point(tempX,tempY));
	// 	}
	// 	return l;
	// }
}