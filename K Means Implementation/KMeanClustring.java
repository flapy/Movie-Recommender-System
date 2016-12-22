import java.util.*;
class KMeanClustring
{
	List <Cluster> clusters;
	int k;
	public KMeanClustring(int k)
	{
		this.k = k;
		clusters = new ArrayList<Cluster> ();
	}
	public boolean cmp(double arr1[],double arr2[])
	{
		int m = arr1.length;
		for (int i = 1; i < m; i++)
		{
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	public void doSomething(double mat[][])
	{
		int n = 10000;
		int m = 1128;
		int counter = 1;
		int clusterId = 1;
		for (int i = 0; i < k; i++)
		{
			Cluster cluster = new Cluster(clusterId++);
			double tempArr[] = new double[m + 2];
			for (int j = 1; j <= m; j++)
			{
				tempArr[j] = mat[counter][j];
			}
			Point point = new Point(tempArr);
			cluster.setCentroid(point);
			clusters.add(cluster);
			counter += counter * 8;
			if (counter > n)
				break;
		}
		List <Point> points = new ArrayList <Point> ();
		for (int i = 1; i <= n; i++)
		{
			double tempArr[] = new double[m+2]; 
			for (int j = 1; j <= m; j++)
			{
				tempArr[j] = mat[i][j];
			}
			Point point = new Point(tempArr);
			points.add(point);
		}
		while (true)
		{
			for (Point point : points)
			{
				double min = Double.MAX_VALUE;
				Cluster store = null;
				int id;
				for (Cluster cluster : clusters)
				{
					double tempDist = Point.calcDistance(cluster.getCentroid(),point);
					if (tempDist < min)
					{
						min = tempDist;
						store = cluster;
					}
				}
				store.addPoint(point);
			}

			boolean flag = true;
			for (Cluster cluster : clusters)
			{
				double sumX = 0;
				double sumY = 0;
				List <Point> tempPoints = cluster.getPoints();
				double mid[] = new double[m + 2];
				for (Point temp : tempPoints)
				{
					double tempArr [] = temp.arr;
					for (int i = 1 ; i <= m; ++i)
					{
						mid[i] += tempArr[i];
					}
				}

				for (int i = 1 ; i <= m; ++i)
				{
					mid[i] = mid[i] / m;
				}

				Point oldCentroid = cluster.getCentroid();
				if (!cmp(oldCentroid.arr,mid))
				{
					flag = false;
					cluster.setCentroid(new Point(mid));
				}
			}	
			if (flag)
			{
				break;
			}
			
			for (Cluster cluster : clusters)
			{
				cluster.points.clear();
			}
		}

		for (Cluster c : clusters)
		{
			List <Point> poi = c.getPoints();
			for (Point po : poi)
			{
				for (int i = 1 ; i <= m; ++i)
				{
					System.out.print(po.arr[i] + " ");
				}
				System.out.println();
			}
		}
	}
}