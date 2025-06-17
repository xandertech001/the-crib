import java.util.Scanner; //import the Scanner functions to help with user inputs

/*Main Class that will manage the game and also the screen interface.*/ 
/*References used throughout my code are listed here:
 * https://www.youtube.com/watch?v=1ONhXmQuWP8&ab_channel=KeepOnCoding 
 * https://www.youtube.com/watch?v=IUqKuGNasdM&ab_channel=KeepOnCoding 
 * https://www.geeksforgeeks.org/java-program-to-emulate-n-dice-roller/
 * https://stackoverflow.com/questions/19870467/how-do-i-get-press-any-key-to-continue-to-work-in-my-java-code
 * https://stackoverflow.com/questions/39823874/simple-java-text-based-game-loop
 */

public class DiceThrone {

    /*Main Function that will drive the Dice throne game.*/

    /*Dice Throne is a game where two people can sit and play and experience a series of rounds of competitive dice-based gameplay. 
     *A game meant to see who's character is stronger and who has the better rolls. 
     *I believe that this is a great game as it's a unique take on the game that I and my dad play in real life in board game form. 
     *I wanted to see how I could use what I learned in AP computer science and make that game within java.
     */

    public static void main(String[] args) {

        /*Variable for holding the users option selection*/
        int gameoptions;

        /*Create an instance of the Dice Throne Class*/
        DiceThrone DiceThrone = new DiceThrone();

        /*
         * A display labelled break statement
     	   The labeled break statement terminates the outermost loop whereas the normal break statement terminates the innermost loop.
         */
        display: while (true) {

            /*call the Game Menu Function*/
            gameoptions = DiceThrone.displayGameMenu();
            /*This switch will determine which of the cases are requested from the user and do the following based on that request:*/
            switch (gameoptions) {
            
                /*Case 1 will start and call the new game function to make a new game and display it to the user.*/
                case 1:
                    DiceThrone.startNewGame();
                    break;
                    
                /*Case 2 will start and call the instructions for the game and display that function to the user.*/
                case 2:
                    DiceThrone.displayGameInstruction();
                    break; 
                    
                /*Case 3 will end the game and stop the program and display*/
                case 3:
                    System.out.println("Thank you for playing, See you soon!");
                    break display; /* Labeled Break to make sure we go back to loop until users exits the program*/
                    
                    /*If input did not trigger any of the 3 cases, this will be the default output*/
                default:
                    /*Let user know that the option was invalid*/
                    System.out.println("Invalid action.");
                
                    break;
            } //end switch

        } //end while 

    } //end main


    /*This main function for controlling the main UI for the dice throne game*/
    int displayGameMenu() {

        /* Display the Game Menu */
        System.out.println("********** Dice Throne Game Menu ********************");
        System.out.println();
        System.out.println("(1) Start a new game");
        System.out.println("(2) Display game help");
        System.out.println("(3) Exit game");
        System.out.println("-------------------------------------------------------");
        System.out.print("Choose an option (Only Numbers 1-3 will work): ");


        /*The scanner will scan for a string inputted by the user*/
        Scanner sc = new Scanner(System.in);
        
        /*The user's option selection will be held as an integer called userinput*/
        int userinput = sc.nextInt();

        /*Create a list to hold the balid menu options from 1-3*/
        int[] validoptions = {1,2,3};
        
        
        /*This will set the variable toFind which is an integer, equal to the user input that was entered by the user*/
        int toFind = userinput;

        /*Set the found variable to false, this is how we can tell if the input was valid.*/
        boolean found = false;

        /*loop through all the valid options */
        for (int n : validoptions) {
            /*If the integer is equal to what was found, do the following:*/
            if (n == toFind) {
                /*Set the founded integer to true*/
                found = true;
                break;
            } //end if
        } //end for

        if (found) {
            /*If the input entered is found it is valid, do nothing*/

        } //end if
        else {
            /*Invalid option entered have user retry*/
            System.out.println(toFind + " is not a valid option please try again.");
            this.displayGameMenu();

        } //end else
        /*Return the function that finds the valid options*/
        return toFind;

    } //end function


    /*This is the new game function 
     * it will take the user's name 
     * assign player 1 with the Warrior class 
     * assign player 2 with the Mage class 
     * and show the abilities and attributes of each class.
     * then both players are called to battle for 10 rounds.*/
    void startNewGame() {
        String p1Name = null; // Variable to hold the first player name
        String p2Name = null; // Variable to hold the second player name


        /*The scanner will scan for a string inputted by the user*/
        Scanner sc = new Scanner(System.in);
        /*Output this statement*/
        System.out.print("Please enter player one name: ");
        /*This will take the string inputed by the user */
        p1Name = sc.nextLine();

        /*Output this statement*/
        System.out.println(p1Name + " you have been assigned a Warrior Class");
        /*This says that Player 1 is of the Player class and declares it as a new player with the name inputted by the user and "Warrior" as a class.*/
        Player Player1 = new Player(p1Name, "Warrior");

        /*Output this statement*/
        System.out.println("********************************");

        /*Output this statement*/
        System.out.println("Please enter player two name: ");
        /*This will take the string inputted by the user*/
        p2Name = sc.nextLine();
        /*Output this statement*/
        System.out.println(p2Name + " you have been assigned a Mage Class");
        /*This says that Player 2 is of the Player class and declares it as a new player with the name inputted by the user and "Mage" as a class.*/
        Player Player2 = new Player(p2Name, "Mage");

        /*Output this statement*/
        System.out.println("********************************");

        /*Output this statement*/
        System.out.println("");
        System.out.println("**** Players Created: ****");


        /*Output this statement*/
        System.out.println("**** Abilities Added by Class ****");
        /*This will set the attributes of both classes respectfully*/
        Player1.setAttributes();
        Player2.setAttributes();
        /*Output this statement*/
        System.out.println("");
        /*This function will introduce both characters*/
        Player1.introduceSelf();
        Player2.introduceSelf();
        /*Output this statement*/
        System.out.println("**** Abilities Activated ****");

        /*The Battle function is called and calls both players to battle for 10 rounds.*/
        Battle(10, Player1, Player2);

    } //end function

    /*This function explains what the computer is doing and how the game is played.*/
    void displayGameInstruction() {
        /*Output these statements*/
        System.out.println();
        System.out.println("All players roll 3 dice per round.");
        System.out.println("-----------");
        System.out.println("Your rolls will be read and added up to a sum, that sum represents your casted ability.");
        System.out.println("Then all of the damage that was done will get resolved and reflected onto your character.");
        System.out.println("First player to make there opponents health pool reach 0 wins the game");
        System.out.println("Press Enter key to continue...");
        /*This scanner waits for the input from the user*/
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    } //end function

    /*This function is how we will declare and reward the winner of the round. 
     *Within this function, Player 1&2 come from the Player class. 
     *This makes sure that while writing the function, the computer recognizes what each aspect of variables is and what they represent. 
     */
    void DeclareWinner(Player Player1, Player Player2) {
        /*Output these statements*/
        System.out.println("░░░░▄▄▄░░▄██▄░░░");
        System.out.println("░░░░░▐▀█▀▌░░░░▀█▄░░░");
        System.out.println("░░░░░▐█▄█▌░░░░░░▀█▄░░");
        System.out.println("░░░░░░▀▄▀░░░▄▄▄▄▄▀▀░░");
        System.out.println("░░░░▄▄▄██▀▀▀▀░░░░░░░");
        System.out.println("░░░█▀▄▄▄█░▀▀░░");
        System.out.println("░░░▌░▄▄▄▐▌▀▀▀░░");
        System.out.println("▄░▐░░░▄▄░█░▀▀ ░░");
        System.out.println("▀█▌░░░▄░▀█▀░▀ ░░");
        System.out.println("░░░░░░░▄▄▐▌▄▄░░░");
        System.out.println("░░░░░░░▀███▀█░▄░░");
        System.out.println("░░░░░░▐▌▀▄▀▄▀▐▄░░");
        System.out.println("░░░░░░▐▀░░░░░░▐▌░░");
        System.out.println("░░░░░░█░░░░░░░░█░░░░░░░");
        System.out.println("░░░░░░█░░░░░░░░█░░░░░░░");
        System.out.println("░░░░░░█░░░░░░░░█░░░░░░░");
        System.out.println("░░░░▄██▄░░░░░▄██▄░░");
        /*If Player 1 and Player 2 are at the same health pool, do the following:*/
        if (Player1.healtPool <=0 && Player2.healtPool <= 0) {
            /*Output these statements*/
            System.out.println("!@#$%^&*()!@#$%^&*()!@#$%^&*()");
            System.out.println("    Both Players Died! (TIE??) ");
            System.out.println(" Play again for a true winner! ");
            System.out.println("!@#$%^&*()!@#$%^&*()!@#$%^&*()");
            /*If Player 1's health pool is less than or equal to 0, do the following:*/
        } //end if
        else if (Player1.healtPool <= 0) {
            /*Output these statements*/
            System.out.println("!@#$%^&*()!@#$%^&*()!@#$%^&*()");
            System.out.println("        Player 2 has won!     ");
            System.out.println("      Thank you for playing!  ");
            System.out.println("!@#$%^&*()!@#$%^&*()!@#$%^&*()");
        }//end if
        
        /*If Player 2's health pool is less than or equal to 0, do the following:*/
        else if (Player2.healtPool <= 0) {
            /*Output these statements*/
            System.out.println("!@#$%^&*()!@#$%^&*()!@#$%^&*()");
            System.out.println("        Player 1 has won!     ");
            System.out.println("      Thank you for playing!  ");
            System.out.println("!@#$%^&*()!@#$%^&*()!@#$%^&*()");
        } //end if


    } //end function

    /*This function is the main battle feature of the dice throne game. It will demonstrate and show who won that round.  
     *We identify that players 1 and 2 are from the Player class.  
     *This makes sure that while writing the function, the computer recognizes what each aspect of variables is and what they represent. 
     */
    void Battle(int numOfRounds, Player Player1, Player Player2) {


        /* variables that will hold the player return values*/
        int pl1rtn, pl2rtn;

        /* will control the loop until a winner is found */
        boolean winner = false;

        /*Loop for the number of desired rounds */
        for (int i = 1; i <= numOfRounds; i++) { // i will hold the current round.  it will be increased when we loop
            /*This says that while there is no winner, do the following:*/
            while (!winner) {
                /*Output this statement*/
                System.out.println("**** Round" + i + "Activated ****");
                /*Player 1 will roll their dice*/
                pl1rtn = Player1.rolldice();
                /*Player 1's ability will be determined*/
                pl1rtn = Player1.selectAbility(pl1rtn);
                /*That ability will now be applied to Player 2*/
                Player2.ApplyDamage(pl1rtn);

                /*Player 2 will roll their dice*/
                pl2rtn = Player2.rolldice();
                /*Player 2's ability will be determined*/
                pl2rtn = Player2.selectAbility(pl2rtn);
                /*That ability will now be applied to Player 1*/
                Player1.ApplyDamage(pl2rtn);
                /*Output this statement*/
                System.out.println("**** Round Ended ****");


                /*This says if Player 1's health pool is less than or equal to 0, do the following:*/
                if (Player1.healtPool <= 0) {
                 
                    /*This call will declare the winner*/
                    DeclareWinner(Player1, Player2);
                    /*A winner has been declared*/
                    winner = true;
                } //end if
                /*If the previous if statement was not true and Player 2's health pool is less than or equal to 0, do the following:*/
                else if (Player2.healtPool <= 0) {
                    
                    /*This call will declare the winner*/
                    DeclareWinner(Player1, Player2);
                    /*A winner has been declared*/
                    winner = true;
                } //end if

            } //end while

        } //end for
    } /*End Battle Functions*/

} /*End DiceThone Class */




