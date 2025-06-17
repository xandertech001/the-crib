//============================================================================
// Name        : Word Scramble 2.0.cpp
// Author      : Xander
// Version     : 6/10
// Description : Edit your Word Scrambler 1.0 program to add additional features.
//============================================================================

#include <iostream>
#include <string>

using namespace std;

string Split(string text) {

  //variables
  int left;
  int mid;

  //set left (left most chunk)
  left = rand() % (text.length() - 2) + 1;
  text.substr(0, left);

  //set mid (mind  chunk)
  mid = rand() % (text.length() - left - 1) + 1;
  text.substr(left, mid);
  text.substr(left + mid);

  //string combined with new generated chunks
  string combined = text.substr((left + mid)) + text.substr(left, mid) + text.substr(0, left);

  return combined;
}

void Trials(int length) {

	//variables
  int left;
  int mid;

	int count = 0;

  //make string
  char letter = 'a';
  string text = "";
  for (int i = 0; i < length; i++){
    text+=letter;
    letter++;
  }

	//make a copu
  string copy = text;

	//shuffle while the current text does not equal the copy
  do {
		//add to count
		count++;

    //set left (left most chunk)
    left = rand() % (text.length() - 2) + 1;

    //set mid (mind  chunk)
    mid = rand() % (text.length() - left - 1) + 1;

    //string combined with new generated chunks
    text = text.substr((left + mid)) + text.substr(left, mid) + text.substr(0, left);

		//output # with current string
    cout << "#"<< count << " " << text << endl << endl;
    } while(text!=copy);
}


int main() {
  //seed
  srand(time(0));

	//menu/loop controls
  int menu;
  int loop = 1;

  //case 1
  int shuffle;
  string text;

  //case 2
  int length;
  int numtrials;

	//basic menu with options
  while (loop == 1) {
    cout << "How would you like to shuffle the phrase?" << endl;
    cout << "1) Specify a number of times" << endl;
    cout << "2) Run some trials" << endl;
    cout << "3) Quit" << endl;
    cout << "----------------------------------------" << endl;

    cin >> menu;

		//switch for what the user wants to do
    switch (menu) {

      case 1: {
        //prompts
        cout << "\nHow many times would you like to shuffle the phrase?: ";
        cin >> shuffle;
        cin.ignore();

				//prompts
        cout << "\nEnter the phrase to scramble: ";
        getline(cin, text);


        //loop for every shuffle wanted by the user
        for (int i = 0; i < shuffle; i++) {
          //function call with label
          cout << "\nPermutation #" << i + 1 << ":" << Split(text) << endl << endl;
        }
        break;
      }

      case 2: {
        //prompt
        cout << "\nWhat size of string to test?: ";
        cin >> length;
        cin.ignore();

				//prompt
        cout << "\nHow many trials?";
        cin >> numtrials;

				//loop # of times and call trials function
        for (int i = 0; i < numtrials; i++) {
					cout << "\n***************************TRIAL " << i+1 << "***************************" <<  endl << endl;
					Trials(length);
        }
        break;
      }

			//case for quit
      case 3: {
        loop = 0;
        break;
      }

			//default case
      default: {
        cout << "\nPlease enter a valid number (1 - 3):" << endl << endl;
        break;
      }
    }
  }
  return 0;
}
