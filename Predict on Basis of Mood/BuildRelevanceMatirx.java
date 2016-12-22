import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class BuildRelevanceMatirx
{
	double mat[][];
	public BuildRelevanceMatirx(int n,int m)
	{
		mat = new double[10005][1130];
	}
	public double [] [] init()
	{
		System.out.println("Building Matrix");
		String csvFile = "genome-scores.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try
        {
	        br = new BufferedReader(new FileReader(csvFile));
	        int cnt = 0;
		    while ((line = br.readLine()) != null) {
		    	// Do NOT read the first Line!
	        	if (cnt == 0)
	        	{
	        		cnt++ ;
	        		continue;
	        	}
	        	cnt++;
	            String[] features = line.split(cvsSplitBy);
	            try
	            {
	                int movieId = Integer.parseInt(features[0]);
	                int tagId = Integer.parseInt(features[1]);
	                double relavance = Double.parseDouble(features[2]);
	                mat[movieId][tagId] = relavance;
	                if (movieId == 10000 && tagId == 1128)
	     	          	break;
	            }
	            catch (Exception e)
	            {
	            	//System.out.println("Na Ho Paya\n");
	            }
	    	}
	    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       	return mat;
	}
	public HashMap <String,Integer> mapTags()
	{
		System.out.println("Mapping tags");
		HashMap <String,Integer> hm = new HashMap <String,Integer>();
		String csvFile = "genome-tags.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try
        {
	        br = new BufferedReader(new FileReader(csvFile));
	        int cnt = 0;
		    while ((line = br.readLine()) != null) {
		    	// Do NOT read the first Line!
	        	if (cnt == 0)
	        	{
	        		cnt++ ;
	        		continue;
	        	}
	            String[] features = line.split(cvsSplitBy);
	            try
	            {
	                int tagId = Integer.parseInt(features[0]);
	                String tag = features[1];
	                hm.put(tag,tagId);
	            }
	            catch (Exception e)
	            {
	            	//System.out.println("Na Ho Paya\n");
	            }
	    	}
	    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hm;
	}
	public HashMap <Integer,String> mapMovies()
	{
		System.out.println("Mapping Movies");
		String csvFile = "movies.csv";
		HashMap <Integer,String> hm = new HashMap <Integer,String>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int cnt = 0;
            while ((line = br.readLine()) != null) {

            	// Do NOT read the first Line!
            	if (cnt == 0)
            	{
            		cnt++ ;
            		continue;
            	}
                String[] features = line.split(cvsSplitBy);
                try
                {
	                int movieId = Integer.parseInt(features[0]);
	                String title = features[1];
                	hm.put(movieId,title);
	            }
	            catch (Exception e)
	            {
	            	//System.out.println("Na Ho Paya\n");
	            }
         
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hm;
	}
}