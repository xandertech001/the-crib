/*
Xander Rivera
Computer Programming 1A (C++)
11/17
Zombie Sandwich Shop

BRAINNNNSSSS!!! This program will output a menu from which the user can choose and select zombie foods.
*/

//Preprocessor directive library
#include <iostream>

//Standard namespace
using namespace std;

//Tax constant
const double tax = .06;

//Function to calculate and output totals + tax
int outputTotal(double total) { 
	//Output initial total
	cout << "Total: $" << total << endl; 
	//Output tax of the initial total
	cout << "Tax: $" << total * tax << endl; 
	//Output new total + tax
	cout << "Total with Tax: $" << (total * tax) + total << endl;

	//return 0 if successful 
	return 0;
}//function

//Main Function
int main() {

	//Variables for order selection, total bill, and while loop
  int order;
  int continueorder = 1;
  double total = 0;

	//While continueorder is equal to one, repeat
  while (continueorder == 1) {

		//Menu outline
    cout << "-------------_=+(ZOMBIE SANDWITCH SHOP)+=_-------------" << endl;
    cout << "\t1) Thalamustard-Crusted Filet - $17.50" << endl;
    cout << "\t2) Hypothamoussaka - $12.95" << endl;
    cout << "\t3) Pons Pasta Special - $15.00" << endl;
    cout << "\t4) Medulla Frittata - $9.99" << endl;
    cout << "\t5) Amyg-Dal-a - $11.56" << endl;
    cout << "\t6) CHIPpocampus & Dip - $7.99" << endl;
    cout << "\t7) Finish Current Sale + Start a New Sale." << endl;
    cout << "\t8) Quit Forever! THE APOCALYPSE!" << endl;
    cout << "-------------------------------------------------------" << endl; 
		//Take user input and store it in order and ignore enter key 
		cin >> order;  
		cin.ignore();

		//Set output to only display 2 decimal places
		cout.setf(ios::fixed); 
		cout.precision(2); 

		//Switch using order as a selection
    switch (order) {
      case 1:
        {
					/*add the respective total to the bill and call the outputTotal function to display total + tax*/
          total+= 17.50;
          outputTotal(total);
          break;
        }
      case 2:
        {
					/*add the respective total to the bill and call the outputTotal function to display total + tax*/
          total+= 12.95;
          outputTotal(total);
          break;
        }
      case 3:
        {
					/*add the respective total to the bill and call the outputTotal function to display total + tax*/
          total+= 15;
          outputTotal(total);
          break;
        }
      case 4:
        {
					/*add the respective total to the bill and call the outputTotal function to display total + tax*/
          total+= 9.99;
          outputTotal(total);
          break;
        }
      case 5:
        {
					/*add the respective total to the bill and call the outputTotal function to display total + tax*/
          total+= 11.56;
          outputTotal(total);
          break;
        }
      case 6:
        {
					/*add the respective total to the bill and call the outputTotal function to display total + tax*/
          total+= 7.99;
          outputTotal(total);
          break;
        }
      case 7:
        {
					/*Call the outputTotal function to output final total + tax and reset order and total to 1 and 0, this will allow the user to make a new bill */
          outputTotal(total);
          total = 0;
          break;
        }
      case 8:
        {
				 //Set continueorder to 2 so it doesn't repeat and output zombie + message.
          continueorder = 2;
          cout << "Nice knowin ya! Good luck!\n";
          cout << "                  .....     " << endl;
          cout << "                / C C /    " << endl;
          cout << "                /<    /      " << endl;
          cout << "   _ __________/_#__=o       " << endl;
          cout << "  /(- /(\\_\\________   \\      " << endl;
          cout << "  \\ ) \\ )_     \\o     \\     " << endl;
          cout << "  /|\\ /|\\       |o     |       " << endl;
          cout << "                |     _|       " << endl;
          cout << "                /o   __\\       " << endl;
          cout << "                /       |        " << endl;
          cout << "               / /      |         " << endl;
          cout << "              /_/\\______|        " << endl;
          cout << "             (   _(    <          " << endl;
          cout << "              \\    \\    \\       " << endl;
          cout << "               \\    \\    \\      " << endl;
          cout << "                \\____\\____\\   " << endl;
          cout << "               ____\\_\\__\\_\\ " << endl;
          break;
        }
      default: 
				{ 
					//When input is malicious, have the user try again and output the following message.
					cout << "HURRY UP AND MAKE A VALID SELECTION! OTHER PEOPLE NEED THEIR BRrrrrAAAIINnnSss!!!" << endl;
				}
		}//switch
	}//while

	//return 0 if successful 
	return 0; 
}//main
