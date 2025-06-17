/* 
Xander Rivera 
Computer Programing 1A (C++)
9/17/21
Top 3 classes 

This program provides you with the opportunity to work with input of mixed types and formatting of output.
*/

//Preprocesor directive library
#include <iostream> 
//Standard namespace
using namespace std; 

//Constant format int
const int width = 25;

//Main Function
int main() { 

  //Variable to contain name
  string name;

  //Variable to contain the name of the classes
  string class1;  
  string class2; 
  string class3;
  
  //Variable to contain name of the teachers
  string teacher1;
  string teacher2; 
  string teacher3; 

  //Variable to contain the room number
  int room1;
  int room2; 
  int room3; 

  //Ask for for name of student 
  cout << "What is your name?: ";
  getline(cin,name);

  //1st class  

  //Ask for name of first class
  cout << "\nWhat is your first favorite class?: "; 
  //Save user input as variable class1, this stores the name of the first class
  getline(cin,class1); 

  //Ask for the first teacher of the first class
  cout << "Who teaches " <<  class1 << "?: "; 
  //Save user input as variable teacher1, this stores the name of the first teacher
  getline(cin,teacher1); 

  //Ask for the room where the first teacher teaches the first class
  cout << "Room number where " << teacher1 << " teaches " <<  class1 << "?: ";
  //Save user input as variable room1, this stores the room number of the first class
  cin >> room1; 
  //Ignore enter input 
  cin.ignore();

  //2rd class  

  //Ask for name of second class
  cout << "\nWhat is your second favorite class?: ";  
  //Save user input as variable class2, this stores the name of the second class
  getline(cin,class2); 

  //Ask for the room where the second teacher teaches the second class
  cout << "Who teaches " <<  class2 << "?: "; 
  //Save user input as variable teacher2, this stores the name of the second teacher
  getline(cin,teacher2); 

  //Ask for the room where the second teacher teaches the second class
  cout << "Room number where " << teacher2 << " teaches " <<  class2 << "?: ";
  //Save user input as variable room2, this stores the room number of the second class
  cin >> room2;
  //Ignore enter input 
  cin.ignore(); 

  //3rd class  

  //Ask for name of third class
  cout << "\nWhat is your third favorite class?: ";  
  //Save user input as variable class3, this stores the name of the third class
  getline(cin,class3); 

  //Ask for the room where the third teacher teaches the third class
  cout << "Who teaches " << class3 << "?: "; 
  //Save user input as variable teacher3, this stores the name of the third teacher
  getline(cin,teacher3); 

  //Ask for the room where the third teacher teaches the third class
  cout << "Room number where " << teacher3 << " teaches " << class3 << "?: "; 
  //Save user input as variable room3, this stores the room number of the third class
  cin >> room3; 
  //Ignore enter input 
  cin.ignore(); 

  //Output top 3 classes

  //Set format to start to the left
  cout.setf(ios::left);

  //output headdings of the schedule

  cout << "\n" << name << "'s Favorite Classes\n"; 
  cout << "******************************************\n";

  //Set width to the constant of 25
  cout.width(width);
  cout << "Class:";
  //Set width to the constant of 25
  cout.width(width);
  cout << "Teacher:";
  //Set width to the constant of 25
  cout.width(width);
  cout << "Room:" << endl;

  //output dividers

  //Set width to the constant of 25
  cout.width(width);
  cout << "-------------";
  //Set width to the constant of 25
  cout.width(width);
  cout << "-------------";
  //Set width to the constant of 25
  cout.width(width);
  cout << "-------------" << endl;

  //output the information for class 1

  //Set width to the constant of 25
  cout.width(width);
  cout << class1; 
  //Set width to the constant of 25
  cout.width(width);
  cout << teacher1; 
  //Set width to the constant of 25
  cout.width(width); 
  cout << room1 << endl;

  //output the information for class 2

  //Set width to the constant of 25
  cout.width(width);
  cout << class2; 
  //Set width to the constant of 25
  cout.width(width);
  cout << teacher2; 
  //Set width to the constant of 25
  cout.width(width); 
  cout << room2 << endl;  

  //output the information for class 3

  //Set width to the constant of 25
  cout.width(width);
  cout << class3; 
  //Set width to the constant of 25
  cout.width(width);
  cout << teacher3; 
  //Set width to the constant of 25
  cout.width(width); 
  cout << room3 << endl;

return 0; 
}