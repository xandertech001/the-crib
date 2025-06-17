/* 
Xander Rivera 
Computer Programing 1A (C++)
9/15/21
TicTacToe Boards


This code will output tictactoe boards w/out spaces
*/

//Preprocesor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//constant 
const int width = 4;

//Main Function
int main() { 

//output string labling regular tictactoe board
cout << "TicTacToe Board" <<endl;

//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|"; 
//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|" << endl;

//output a line for the horizontal lines of the board
cout << "-----------" <<endl;

//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|"; 
//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|" << endl;

//output a line for the horizontal lines of the board
cout << "-----------" <<endl;

//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|"; 
//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|" << endl;

//output string labling wonky tictactoe board
cout << "\nWonky Board\n";

//set the format to display the width to the left 
cout.setf(ios::left);

//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|"; 
//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|" << endl;

//undo the display for the width to the left
cout.unsetf(ios::left);

//output a line for the horizontal lines of the board
cout << "-----------" <<endl;

//we do not set it to the left as the middle section is the same w/out formating

//set the width to the constant (4)
cout.width(width); 

//output a line for the virtical lines of the board
cout << "|"; 
//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|" << endl;

//output a line for the horizontal lines of the board
cout << "-----------" <<endl;


//set the format to display the width to the left 
cout.setf(ios::left);

//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|"; 
//set the width to the constant (4)
cout.width(width); 
//output a line for the virtical lines of the board
cout << "|" << endl;


}