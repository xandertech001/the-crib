/* 
Xander Rivera 
Computer Programming 1A (C++)
1/2/22
Room Lookup

This program will be able to output a menu from which the user can look up names and room numbers to find teachers within a list. They can also view the list entirely and exit the menu. 
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//formatting constant
const int width = 20; 

//Main Function
int main() {  

	//list 
	string teachers[300];  

	//make everything empty 
	for (int i = 0; i < 300; i++){ 
		teachers[i] = ""; 
	}//end for

	//teachers
	teachers[32] = "ONeill";   
	teachers[232] = "Prince";
	teachers[283] = "Dominguez";
	teachers[148] = "Sanders";
	teachers[13] = "Weaver";
	teachers[174] = "Brown";
	teachers[111] = "Goodrich";

	//values used for the menu and for selection within the switch statement
	int menu = 1; 
	int userSelection; 

	//while loop to continue the menu when the user is still making selections
	while (menu == 1){ 

		//main menu outline 
		cout << "\n--------------SCHOOL ROOM LOOKUP--------------" << endl;
		cout << "\t1: See a list of every teacher's room" << endl;  
		cout << "\t2: See the teacher in a particular room" << endl; 
		cout << "\t3: Search for the room number by name" << endl; 
		cout << "\t4: Quit" << endl;
		cout << "------------------------------------------------" << endl;
		cin >> userSelection; 

		switch (userSelection){ 

			//when the user wants to see all of the teachers and room #
			case 1:{  
				//set to the left
				cout.setf(ios::left);
				
				//this is setting the text to a constant
				cout.width(width); 
				//outputs lables 
				cout << "\nRoom "; 

				cout.width(width);
				cout << " Teacher " << endl; 

				cout.width(width);
				cout << "----"; 

				cout.width(width);
				cout << "-------" << endl;    

				//output all teachers 
				for (int i = 0; i < 300; i++){  	
					if (teachers[i] != ""){ 
						
						//set to the left
						cout.setf(ios::left);
						//set to the constant
						cout.width(width);
						//output room
						cout << i;  

						cout.width(width);
						//output teacher within that room
						cout << teachers[i] << endl;
					} //end if
				}//end for  
				break;
			}//end case 1 

			//when the user wants to see a teacher in a particular room 
			case 2:{ 
				int room;
				//output prompt
				cout << "Please enter the room number: "; 
				//take in user input
				cin >> room;  

				//make sure its within 1 and 299
				if (room > 0 && room < 300){
					//if the room is empty (no teacher)
					if (teachers[room] == ""){ 
						cout << "NO TEACHER ASSIGNED!";  
					} 
					//if there is a teacher, output what room they are in
					else { 
						cout << "Room " << room << " is " << teachers[room] << "'s room."; 
					}//end room check if
				}//end room number if
				else { 
					//for when the user inputs a number that goes over or under numbers 1-300
					cout << "That was not a valid room number, please try again."; 
				}
				break;
			}//end case 2

			//when the user wants to look up the name of a teacher
			case 3:{  
				//string variable used for teacher name look up
				string teacherLookUp; 
				//boolean for when we do find a teacher with the same name as the user input
				bool myfind = false;

				//output prompt
				cout << "Please enter a teacher's name: ";
				//take in user input
				cin >> teacherLookUp; 

				//for loop throught the whole list
				for (int i = 0; i < 300; i++){ 
					//if the name within a certin position is equal to what the user inputted
					if (teachers[i] == teacherLookUp){ 
						//output where that teacher can be found
						cout << teachers[i] << " can be found in room " << i << endl; 
						//we found a teacher so set it to true
						myfind = true;
					}//end if 
				}//end for

				//if the bool is still false (if we didnt find a name)
				if (myfind == false) {
					//prompt saying that person is not there/found
					cout << teacherLookUp << " cannnot be found." << endl; 
				}//end if
				break;		
			}//end case 3

			//for when the user wants to exit the program
			case 4:{  
				menu = 2; 
				break; 
			}
		}//switch
	}//end menu (while loop)
}//end main