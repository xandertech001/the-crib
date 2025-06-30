import java.util.Scanner;

public class MovieDriver_Task2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String continueInput;

        do {
            Movie movie = new Movie();

            System.out.println("Enter the name of a movie:");
            String title = keyboard.nextLine();
            movie.setTitle(title);

            System.out.println("Enter the rating of the movie:");
            String rating = keyboard.nextLine();
            movie.setRating(rating);

            System.out.println("Enter the number of tickets sold:");
            int soldTickets = keyboard.nextInt();
            movie.setSoldTickets(soldTickets);

            // Clear buffer
            keyboard.nextLine();

            System.out.println(movie.toString());

            System.out.println("Do you want to enter another? (y/n)");
            continueInput = keyboard.nextLine();
            System.out.println();  // For spacing between entries
        } while (continueInput.equalsIgnoreCase("y"));

        System.out.println("Thank you for using the Movie Driver!");
        keyboard.close();
    }
}
