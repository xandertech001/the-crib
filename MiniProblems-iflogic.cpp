/* 
input1ander Rivera 
Computer Programing 1A (C++)
10/18/21 
Mini-Problems - if+logic

This code will run a series of mini problems/questions that useses compound conditional if statements to check with in conjunction with user input. 
*/

//Preprocesor directive librarinput2
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() { 

  //First mini problem 

  //variables to hold the 1st and 2nd number inputs
  int input1; 
  int input2; 

  //prompt store it in input1 and ignore enter key
  cout << "\nEnter the first positive number: "; 
  cin >> input1; 
  cin.ignore(); 

  //prompt store it in input2 and ignore enter key
  cout << "End the second positive number: "; 
  cin >> input2; 
  cin.ignore(); 

	if (input2 > 1 && input2 > 1) 
		{
		//if the remander of the quotient divided either way is 0, then it can be factored
		if (input1%input2 == 0 || input2%input1 == 0) 
			{
				cout << "Yes! One of these numbers is a factor of the other.";
			}  
		//if it doesnt hit the first condition, output it wasn't a factor.
		else 
			{ 
				cout << "No! One of these numbers is NOT a factor of the other."; 
			}
				}
	else  
		{ 
			cout << "Please enter a POSITIVE integers above 1.";
		}
  //Second mini problem 

  //variable to hold the 3rd input 
  int input3; 

  //prompt store it in input1 and ignore enter key
  cout << "\n\nEnter score 1 (Enter as a whole number): "; 
  cin >> input1; 
  cin.ignore(); 

  //prompt store it in input2 and ignore enter key
  cout << "Enter score 2 (Enter as a whole number): "; 
  cin >> input2; 
  cin.ignore(); 

  //prompt store it in input3 and ignore enter key
  cout << "Enter score 3 (Enter as a whole number): "; 
  cin >> input3; 
  cin.ignore(); 

  //checking for max number, check to see if one is greater than the others
  if (input1 > input2 && input1 > input3) 
    { 
      cout << "Score 1 is the highest."; 
    }
  else if (input2 > input1 && input2 > input3) 
    { 
      cout << "Score 2 is the highest."; 
    } 
  else 
    { 
      cout << "Score 3 is the highest."; 
    }

  //checking for min number, check to see if one is less than the others
  if (input1 < input2 && input1 < input3) 
    { 
      cout << " Score 1 is the lowest."; 
    }
  else if (input2 < input1 && input2 < input3) 
    { 
      cout << " Score 2 is the lowest."; 
    } 
  else 
    { 
      cout << " Score 3 is the lowest."; 
    }

  //Third mini problem 

  //prompt store it in input1 and ignore enter key
  cout << "\n\nHow many shirts would You like to buy? (Enter as a whole number): "; 
  cin >> input1; 
  cin.ignore(); 

  //check if the number of shirts is within 1 and 24, if it is then check for the amount and add the respective price
  if (input1 < 1 || input1 > 24)
    { 
      cout << "Sorry, your amount does not fit within what we offer, please try again"; 
    } 
  else if (input1 <= 3 || input1 == 1)
    { 
      cout << "Total cost: $" << input1 * 12;
    } 
  else if (input1 > 3 && input1 < 10) 
    { 
      cout << "Total cost: $" << input1 * 10.57; 
    } 
  else
    { 
      cout << "Total cost: $" << input1 * 7; 
    }

  //Fourth mini problem 

  //prompt store it in input1 and ignore enter key
  cout << "\n\nEnter X whole number coordinate: "; 
  cin >> input1; 
  cin.ignore(); 

  //prompt store it in input2 and ignore enter key
  cout << "Enter Y whole number coordinate: "; 
  cin >> input2;
  cin.ignore(); 

  //check if it's at the origin
  if (input1 == 0 && input2 == 0) 
    { 
      cout << "Point (" << input1 << "," << input2 << ") is at the origin."; 
    } 
  else {  
    //check to see if at y-axis
    if (input1 == 0) 
      { 
        cout << "Point (" << input1 << "," << input2 << ") is on the y-axis."; 
      } 
    //check to see if at y-axis
    else if (input2 == 0)
      { 
        cout << "Point (" << input1 << "," << input2 << ") is on the x-axis."; 
      }
    else {  
        //check to see which quadrant
       if (input1 >= 1 && input2 >= 1) 
        { 
           cout << "Point (" << input1 << "," << input2 << ") is in quadrant I.";
        } 
       else if (input1 <= -1 && input2 >= 1) 
        { 
          cout << "Point (" << input1 << "," << input2 << ") is in quadrant II."; 
        } 
      else if (input1 <= -1 && input2 <= -1) 
        { 
          cout << "Point (" << input1 << "," << input2 << ") is in quadrant III.";
        } 
      else 
        { 
          cout << "Point (" << input1 << "," << input2 << ") is in quadrant IV.";
        } 
    }//end second else 
  }//end first else

  //Fifth mini problem  

  //char variable to hold if you are a resident or not
  char whereUlive;  
 
  //prompt store it in whereUlive and ignore enter key
  cout << "\n\nEnter 'R' if you are a resident or 'N' if you are non-resident: "; 
  cin >> whereUlive; 

  //prompt store it in input1 and ignore enter key
  cout << "How many credits are you taking?: ";
  cin >> input1; 
  cin.ignore();  

  //set char variable to uppercase to hit if statement conditions
  whereUlive = toupper(whereUlive);

  //fix decimal places to 2
  cout.setf(ios::fixed); 
  cin.precision(2); 

  //if residental, add price respectively
  if (whereUlive == 'R') 
    { 
      input2 = 250.00 * input1; 
        if (input2 > 3350.00) 
          { 
            input2 = 3350.00; 
          } 
    }
  //if NOT residental, add price respectively
  else if (whereUlive == 'N')  
    { 
      input2 = 450.00 * input1; 
      if (input2 > 6000.00) 
          { 
            input2 = 6000.00; 
          }  
    }
  //if not valid
  else 
    { 
      cout << "That was not a valid input, please try again";  
      return 0;
    }

  //check amount of credits and output price of education based on prerequisites and if you are part or whole time 
  if (input1 >= 1 && input1 < 12) 
    { 
      cout <<"You are a part-time student and you owe $" << input2; 
    } 
  else if (input1 >= 12 && input1 <= 20)
    { 
      cout << "You are a full-time student and you owe $" << input2; 
    }
  else if (input1 > 20)
    { 
      cout << "That is over the maximum, please consider cutting a few classes.";
    } 
  else  
    { 
      cout << "Your amount is not valid, please try again."; 
    }
  return 0; 
}//end main