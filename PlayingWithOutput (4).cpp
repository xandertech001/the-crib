/* 
Xander Rivera 
Computer Programing 1A (C++)
9/1/21

This is the playing with output assignment. 
My code will display my initials and a ROFLcopter to the console. 
I use multiple cout commands to output each like apart of each initial and ROFLcopter. 
*/

//Preprocesor directive library
#include <iostream> 

using namespace std; 


//Initial output function
int MyInitial () {
//This outputs my initials to the console

cout << "      ###       ###        @@@@@@@@@@@@@@     \n";
cout << "       ###     ###         @@@         @@@    \n";
cout << "        ###   ###          @@@         @@@    \n";
cout << "         ### ###           @@@         @@@    \n";
cout << "           ###             @@@       @@@      \n";
cout << "           ###             @@@     @@@        \n";
cout << "         ### ###           @@@@@@@@           \n";
cout << "        ###   ###          @@@     @@@        \n";
cout << "       ###     ###         @@@       @@@      \n";
cout << "      ###       ###        @@@         @@@    \n";
cout << "     ###         ###       @@@           @@@  \n" << endl;

return 0;
}

//ROFLcopter output function
int ROFLcopter() { 
//This outputs the ROFLcopter to the console 

cout << "                ROFL:ROFL:ROFL:ROFL           \n"; 
cout << "                         ^                    \n"; 
cout << "                        _ ___                 \n"; 
cout << "             L      _ _/   []\\               \n"; 
cout << "            LOL=====_         \\              \n"; 
cout << "             L       \\_________]             \n"; 
cout << "                         I   I                \n"; 
cout << "                        -------/              \n" << endl; 

return 0;
}

//Main Function
int main() { 

MyInitial();
ROFLcopter();

return 0; 
}