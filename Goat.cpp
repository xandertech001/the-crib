/*
Xander Rivera
Computer Programming 1A (C++)
2/16/22
Indecisive Goat

The user will be able to view an indecisive move alongside a bridge as it figures out were to go and will output the steps that the goat took to get off the bridge. The user can also see the statisitcs over 50 trials of the goat on the bridge. 
*/

//Preprocessor directive library
#include <iostream>

//Standard namespace
using namespace std;

const string GOAT = "🐐";

//Wait function to slow down output of the console
void Wait(double seconds) {
  clock_t endwait;
  endwait = clock() + seconds * CLOCKS_PER_SEC;
  while (clock() < endwait) {}
}

//Function for finding max number
void FindMAX(int arr[50]) {
  int i, max;
  max = arr[0];

  for (i = 1; i < 50; i++) {
    if (max < arr[i])
      max = arr[i];
  }

  cout << "Greatest # Steps Taken: " << max << endl;;
}

//Function for finding min number
void FindMIN(int arr[50]) {
  int i, min;
  min = arr[0];

  for (i = 1; i < 50; i++) {
    if (min > arr[i])
      min = arr[i];
  }

  cout << "Fewest # Steps Taken: " << min << endl;;
}

/*Function goat run, this will run the trials and single trials and either output the bridge or 50 trial statistics*/
int GoatRun(bool Runstatistics) {
  int gLoc = 5;
  int numSteps = 0;
  int move = 0;

  //If we want to output the bridge and not the statisitcs, then run this secion of code
  if (Runstatistics == false) {
    cout << " " << endl;
    do {
      cout.width(4);
      cout << "Step #:";
      cout.width(4);
      cout << numSteps;

      cout.width(4);
      cout << " |";

      for (int i = 1; i <= 9; i++) {
        if (i == gLoc) {

          cout << GOAT;
        } else {

          cout << " ";
        }
      }
      cout << "|" << endl;

      move = rand() % 2;
      if (move == 1) {
        gLoc++;
      } else {
        gLoc--;
      }
      numSteps++;

      Wait(0.2);

    } while ((gLoc < 10) && (gLoc > 0));

    cout.width(4);
    cout << "Step #:";
    cout.width(4);
    cout << numSteps;
    cout.width(4);
    cout << " |";
    cout.width(11);
    cout << "|";

    cout << "\nTotal steps taken: " << numSteps;
  }
  //For when we want to see the statisitcs over 50 trials 
  else {
    do {
      move = rand() % 2;
      if (move == 1) {
        gLoc++;
      } else {
        gLoc--;
      }
      numSteps++;

    } while ((gLoc < 10) && (gLoc > 0));
  }
  return numSteps;

}

//Main Function
int main() {

  //Make sure that the value we start off with are random to make different numbers
  srand(time(0));

  //Variables for user seleciton within switch and menu status
  int userSelection;
  int menu = 1;

  //While loop for menu
  while (menu == 1) {
    //Prompt
    cout << "\n\n\t1 - View single simulation" << endl;
    cout << "\t2 - Run statistics over trials" << endl;
    cout << "\t3 - Quit" << endl;
    cout << "---------------------------------------------" << endl;

    //Take in user input at user selection
    cin >> userSelection;

    //Switch function to reflect what the user wants to output/do 
    switch (userSelection) {
    case 1: {

      /*GoatRun function call passing false, meaning we dont want the statistics and it will run the code under GoatRun while outputing where the goat is on the bridge.*/
      GoatRun(false);

      break;
    } //end case 1

    case 2: {
      //Array to hold number of steps after 50 trials
      int GoatRuntArray[50];

      //For loop, this will loop 50 times
      for (int i = 0; i < 50; i++) {
        /*This function call will run the code GoatRun without printing the goat because we are passing the boolean as true (meaning that the user does want the statistics) and then setting the number of steps as the first position in the array. Then the array will increment and go to the next posision within the array. */
        GoatRuntArray[i] = GoatRun(true);
      } //end for

      //Variables for average and sum 
      int sum = 0;
      int average = 0;

      // Find sum of all array elements
      for (int i = 0; i < 50; i++) {
        //This will go into the array again and add each number into variable 'sum' 
        sum += GoatRuntArray[i];
      }

      //Output results
      cout << "Statistics Over 50 Trails:" << endl;

      //Divide by 50 beause it's 50 trials
      average = sum / 50;
      //Output
      cout << "Average = " << average << endl;

      //Call FindMAX and FindMIN to find the max and min of the array passing the array. 
      FindMAX(GoatRuntArray);
      FindMIN(GoatRuntArray);

      break;
    } //end case 2

    case 3: {
      menu = 0;
    } //end case 3
    } //end switch
  } //end while

  return 0;
} //end main