/* 
Xander Rivera 
Computer Programming 1A (C++)
2/8/22
Treasure Hunt

This code will run a text-base game where the user has limited guesses to find randomly hidden treasure within a 0 - 9 range. 
*/

//Preprocessor directive library
#include <iostream>

//Standard namespace
using namespace std;

//Main Function
int main() {

  //Using clock for different random numbers
  srand(time(0));

  //Variables (array, 3 treasures, # of guesses, the user's guess, and menu tracker)
  int map[10];
  int tres1, tres2, tres3, totalGuesses = 3, userGuess, menu = 1;

	//Boolean for when treasure is found
  bool found = false;

  //Sets array = 0 all positions
  for (int i = 0; i < 10; i++) 
	{
    map[i] = 0;
  } //end for

	//Generate random numbers until they are all different
  do 
	{
    tres1 = rand() % 10;
    tres2 = rand() % 10;
    tres3 = rand() % 10;
  } while (!(tres1 != tres2 && tres1 != tres3 && tres2 != tres3));

	//Set those random numbers to positions within the array (this is the placement of the treasure)
  map[tres1] = 9;
  map[tres2] = 9;
  map[tres3] = 9;

	//While loop (as menu = 1)
  while (menu == 1) 
	{
		//Prompt
    cout << "\nGuess where the treasure is in your map of locations 0-9! Matey!!! Total guesses remaining: " << totalGuesses << endl;
		//Take in the user's guess
    cin >> userGuess;

		//Make sure it's within 0 - 9
    if (userGuess <= 9 && userGuess >= 0) 
		{
			//If what the user guessed was a treasure
      if (map[userGuess] == 9) 
			{
				//Prompt
        cout << "You found the treasure!" << endl;
				//Set found bool to true becaus ethe user found the treasure
        found = true;
				//Output the final map
        cout << "The Map Revealed:" << endl;
        cout << " 0  1  2  3  4  5  6  7  8  9" << endl;
        for (int i = 0; i < 10; i++) 
				{
          cout << "[" << map[i] << "]";
        }
				//Reset number of guesses for next round if the user continues
        totalGuesses = 3;
        cout << "\n\nDo you want to play again? Yes - 1 | No - 0" << endl;
				//Take in user input and set it as menu and will either stop or continue looping 
        cin >> menu;

				//If the user wants to play again
        if (menu == 1) 
				{
					//Set previous treasures back to 0
					map[tres1] = 0;
          map[tres2] = 0;
          map[tres3] = 0;
					//Generate different treasures and set them as 9
          do 
					{
            tres1 = rand() % 10;
            tres2 = rand() % 10;
            tres3 = rand() % 10;
          } while (!(tres1 != tres2 && tres1 != tres3 && tres2 != tres3));

          map[tres1] = 9;
          map[tres2] = 9;
          map[tres3] = 9;
        }
      }
			//If they didn't guess correctly 
			else 
			{
				//Subtract 1 from their total number of guesses
        totalGuesses--;
				//Prompt and it will allow the user to guess again 
        cout << "Nope!" << endl;
      }
    } //end if

		//If the user ran out of guesses
    if (totalGuesses == 0) 
		{
			//Output the final map (show them where the treasure was )
      cout << "The Map Revealed:" << endl;
      cout << " 0  1  2  3  4  5  6  7  8  9" << endl;
      for (int i = 0; i < 10; i++) 
			{
        cout << "[" << map[i] << "]";
      }
			//Reset number of guesses for next round if the user continues
      totalGuesses = 3;
			//Take in user input and set it as menu and will either stop or continue looping
      cout << "\n\nDo you want to play again? Yes - 1 | No - 0" << endl;
      cin >> menu;
			//If the user wants to play again
      if (menu == 1) 
			{
				//Set previous treasures back to 0
				map[tres1] = 0;
        map[tres2] = 0;
        map[tres3] = 0;
				//Generate different treasures and set them as 9
				do
				{
         tres1 = rand() % 10;
         tres2 = rand() % 10;
         tres3 = rand() % 10;
        } while (!(tres1 != tres2 && tres1 != tres3 && tres2 != tres3));

        map[tres1] = 9;
        map[tres2] = 9;
      	map[tres3] = 9;
      }//end if
    } //end if
  } //end while 
} //end main 