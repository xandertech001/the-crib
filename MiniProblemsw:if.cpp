/* 
Xander Rivera 
Computer Programing 1A (C++)
10/6/21
Mini problems w/ If statements

The user will be able to use input to operate if statements that output different outcomes based on the user's input. 
*/

//Preprocesor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() { 

  //Mini Problem #1

  //Variable to hold the percent 
  float prct; 

  //prompt, set input as percent, and ignore enter key
  cout << "\nPlease enter your percent: "; 
  cin >> prct; 
  cin.ignore(); 

  //promp before to avoid repetition 
  cout << "Your corresponding grade is: ";

  //if above or equal to 89.5
  if(prct>=89.5) 
    {
      cout << "A";
    } 
  //if above or equal to 79.5
  else if (prct>=79.5) 
    { 
      cout << "B"; 
    }
  //if above or equal to 69.5
  else if (prct>=69.5) 
    { 
      cout << "C"; 
    }
  //if above or equal to 59.5
  else if (prct>=59.5) 
    { 
      cout << "D"; 
    }
  //anything other than previous listed 
  else 
    { 
      cout << "E";
    }

  //Mini Problem #2

  //Variable to store the user input number
  int userNum; 

  //promt, store input it in userNum, ignore enter key
  cout << "\n\nPlease enter your number: "; 
  cin >> userNum; 
  cin.ignore(); 

  //promp before to avoid repetition
  cout << "The number " << userNum << " is "; 

  //if above or equal to one
  if (userNum >=1)
    { 
      cout << "positive.";
    }
  //if equal to 0
  else if (userNum == 0)
    {
      cout << "zero.";
    } 
  //anything other than previous listed 
  else 
    { 
      cout << "negative.";
    }

  //Mini Problem #3 

  //Variables to store the temperature and scale used
  double temp; 
  char scale; 

  //Set to only display 2 places after the decimals
  cout.setf(ios::fixed);
  cout.precision(2);

  //prompt what the temperature is and stoe it in temp, ignore enter key
  cout << "\n\nPlease enter your temperature: "; 
  cin >> temp; 
  cin.ignore();
  
  //prompt what scale is being used and store it in scale
  cout << "PLease enter your scale ('C' for celcius and 'F' f or Fahrenheit): "; 
  cin >> scale; 

  //Set the char of scale to an uppercase for if statements
  scale = toupper(scale);  

  //promp before to avoid repetition
  cout << temp << " degrees "; 

  //if Fahrenheit is being used for the scale, do the following conversion
  if (scale == 'F')
    { 
      cout << "Fahrenheit is " << (temp -32) / 1.8 << " degrees Celcius.\n";
    }
  //if Celcius is being used for the scale, do the following conversion
  else if (scale == 'C')
    { 
      cout << "Celcius is " << (temp * 1.8) + 32 << " degrees Fahrenheit.\n"; 
    }
  //When not a valid option
  else  
    { 
      cout << "Please run again with a valid selection.\n";
    }
  //return 0 if succesful 
  return 0;
}//end main