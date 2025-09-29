import java.util.*;

public class MovieDriver {

	public static void main(String[] args) {
		boolean repeat = false;
		Scanner sc = new Scanner(System.in);

		do {
		

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

			System.out.print(mainMovie);

			sc.nextLine();

			System.out.println("\nDo you want to enter another? (y or n)");
			String response = sc.nextLine();

			if (response.equalsIgnoreCase("y")) {
				repeat = true;
			} else {
				repeat = false;
			}
			

		} while (repeat);

		sc.close();

		System.out.println("Goodbye");

	}

}
