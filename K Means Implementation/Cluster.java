import java.util.*;
class Cluster
{
	List <Point> points;
	Point centroid;
	int id;
	public Cluster(int id)
	{
		this.id = id;
		points = new ArrayList<Point> ();
		centroid = null;
	}
	public List<Point> getPoints()
	{
		return points;
	}
	public void setCentroid(Point centroid)
	{
		this.centroid = centroid;
	}
	public Point getCentroid()
	{
		return centroid;
	}
	public void setPoints(List<Point> points)
	{
		this.points = points;
	}
	public void addPoint(Point p)
	{
		points.add(p);
	}
}