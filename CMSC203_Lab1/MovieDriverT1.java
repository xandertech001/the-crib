import java.util.*;

public class MovieDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Movie mainMovie = new Movie();

		System.out.println("Enter the name of a movie");
		String movieName = sc.nextLine();

		mainMovie.setTitle(movieName);

		System.out.println("Enter the rating of the movie");
		String movieRating = sc.nextLine();

		mainMovie.setRating(movieRating);

		System.out.println("Enter the number of tickets sold for this movie");
		int movieTickets = sc.nextInt();

		mainMovie.setSoldTickets(movieTickets);

		sc.close();

		System.out.println("Goodbye");

	}

}
