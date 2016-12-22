import java.util.*;
class User 
{
	public static List <User> users = new ArrayList <User>();
	public List <Rating> ratedMovies;
	int userId;
	public User()
	{
		users = new ArrayList <User> ();
	}
	public User(int userId)
	{
		ratedMovies = new ArrayList <Rating>();
		this.userId = userId;
	}
	public static void addUser(User u)
	{
		users.add(u);
	}
	public static List<User> getUsers()
	{
		return users;
	}
	public void addRatedMovies(Rating r)
	{
		ratedMovies.add(r);
	}
	public List <Rating> getRatedMovies()
	{
		return ratedMovies;
	}
	public static HashMap<Integer,User> hashUsers(List <User> users)
	{
		HashMap <Integer,User> usersHashed = new HashMap <Integer,User>();
		System.out.println(users.size());
		for (User user : users)
		{
			usersHashed.put(user.userId,user);
		}
		return usersHashed;
	}
}