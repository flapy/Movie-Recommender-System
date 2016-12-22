import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {

    static List <User> users;
    static List <Rating> ratings;
    static HashMap <Integer,Double> hm;
    public static void parseMovies()
    {
        String csvFile = "movies.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

        	Movie movie; 
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
                    String genre = features[2];
                    movie = new Movie(title,movieId,genre);
                	Movie.addMovie(movie);
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
    }

    public static void parseRatings()
    {
        String csvFile = "ratings.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        HashSet <Integer> hs = new HashSet <Integer> ();
        try {

            Movie movie; 
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
                    int userId = Integer.parseInt(features[0]);     
                    if (!hs.contains(userId))
                    {
                        hs.add(userId);
                        User user = new User(userId);
                        User.addUser(user);
                    }               
                    int movieId = Integer.parseInt(features[1]);
                    double rating = Double.parseDouble(features[2]);
                    Rating.addRating(new Rating(movieId,rating,userId));
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
    }

}
