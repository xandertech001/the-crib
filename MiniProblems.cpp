/* 
Xander Rivera 
Computer Programing 1A (C++)
10/4/21
Mini problems 


This exersise demonstrates the output of different problems using switch and user input.
*/

//Preprocesor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() { 

  //MINI PROBLEM #1

  //Variable for what the user enters as an input
  char userCharacter; 
  
  //Prompt question
  cout << "\nPlease enter your character: "; 

  //Store it into userCharacter
  cin >> userCharacter; 

  //Print original user character to match input -> output
  cout << userCharacter;

  //Change character to lower case to trigger switch 
  userCharacter = tolower(userCharacter); 

    //switch using userCharacter as a selection
    switch (userCharacter) { 
      //cases 0-9
      case '1':
      case '2': 
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      case '0':
        cout << " is a digit.\n\n"; 
        //break when found
        break; 
      //vowel cases
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
        cout << " is a vowel.\n\n";
        //break when found
        break; 
      //default were input was neither 0-9 or a vowel
      default: 
        cout << " is neither a vowel nor a digit.\n\n";
        //break when found
        break;
    }//end mini problem #1 switch 

  //MINI PROBLEM #2 

  //Variables to store the cost of the drinks and a user input selection
  int selection; 
  double cost; 
 
  //prompt 
  cout << "--------------|Drink Machine|--------------\n"; 
  cout << "\t1) Soda\n";  
  cout << "\t2) Juice\n";  
  cout << "\t3) Water\n"; 
  cout << "-------------------------------------------\n";
  cout << "Select a beverage: ";  

  //store user input as selection 
  cin >> selection; 
  //ignore enter key
  cin.ignore();   

  //set outputs of doubles to 2 places after the decimal
  cout.setf(ios::fixed); 
  cout.precision(2); 

    //switch
    switch (selection) { 
      //if they want soda, it's $0.75
      case 1: 
        cost+=0.75; 
        cout << "You owe: $" << cost << "\n"; 
        //break when found
        break; 
      //if they want juice it's $1.00
      case 2: 
        cost+=1.00; 
        cout << "You owe: $" << cost << "\n";
        //break when found
        break; 
      //if they want water its $1.25
      case 3: 
        cost+=1.25;
        cout << "You owe: $" << cost << "\n"; 
        //break when found
        break; 
      //case were selection was invalid
      default:
        cout << "That was not a valid option, please run again.\n";
        //break when found
        break;
    }//end mini problem #2 switch 
  return 0; 
}//end main