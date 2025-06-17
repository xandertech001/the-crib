/* 
Xander Rivera 
Computer Programming 1A (C++)
1/31/22
Magic 8-ball

This code acts like an Magic 8-ball, outputing random affirmative or negative responses to various user questions. 
*/

//Preprocessor directive library
#include <iostream> 
#include <ctime>
#include <string>

//Standard namespace
using namespace std; 

//Main Function
int main() { 

	/*This is used to make sure that the numbers are random by using a different starting number every time. */
	srand(time(0)); 

	//This array declaration holds possible 8 ball outputs/answers.
	string Magic8Ball [20]; 

	Magic8Ball [0] = "It is certain";
	Magic8Ball [1] = "It is decidedly so.";
	Magic8Ball [2] = "Without a doubt.";
	Magic8Ball [3] = "Yes definitely.";
	Magic8Ball [4] = "You may rely on it.";
	Magic8Ball [5] = "As I see it, yes.";
	Magic8Ball [6] = "Most likely.";
	Magic8Ball [7] = "Outlook good.";
	Magic8Ball [8] = "Yes.";
	Magic8Ball [9] = "Signs point to yes.";
	Magic8Ball [10] = "Reply hazy, try again.";
	Magic8Ball [11] = "Ask again later.";
	Magic8Ball [12] = "Better not tell you now.";
	Magic8Ball [13] = "Cannot predict now.";
	Magic8Ball [14] = "Concentrate and ask again.";
	Magic8Ball [15] = "Don't count on it.";
	Magic8Ball [16] = "My reply is no.";
	Magic8Ball [17] = "My sources say no.";
	Magic8Ball [18] = "Outlook not so good.";
	Magic8Ball [19] = "Very doubtful.";

	//These integers hold user selection for the menu and loop of the meny
	int userSelection, menuLoop = 0; 

	//String for user input question (but we dont use it at all)
	string userQuestion = ""; 

	//Menu loop using while + menuLoop int
	while (menuLoop == 0){ 

		//Prompt
		cout << "\nSelect from options below: " << endl; 
		cout << "1) Ask a question" << endl;
		cout << "2) Quit" << endl;
		cout << "----------------------------" << endl;

		//Take in user selection as userSelection
		cin >> userSelection; 
		//Ignore enter key
		cin.ignore(); 

		//Switch for what the user wants to do
		switch (userSelection){ 

			//Case for when they want a question answered
			case 1:{ 
				//output promt
				cout << "\nWhat is your question?:" << endl;
				/*Get the line (the question) and put in in userQuestion (which we dont use)*/ 
				getline(cin, userQuestion);
				/*Get a random position within the Magic8Ball array and whatever was in that place, output that responce. */
				cout << Magic8Ball[rand()%20] << endl;  
				//Break from the switch
				break;
			}//end case 1

			//Case for when they want to quit
			case 2:{ 
				//Output leaving prompt
				cout << "\nThanks for trusting Magic 8 Ball for all your important decisions!" << endl;
				//Set variable to 1 so it stops looping
				menuLoop = 1; 
				//Break from the switch
				break;
			}//end case 2

		}//end switch
	}//end while
}//end main