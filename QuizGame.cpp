/* 
Xander Rivera 
Computer Programing 1A (C++)
10/12/21
Game Quiz 

This is a program that will output a game and be able to take user input and determine if the answer by the user is correct or not. 
*/

//Preprocesor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() { 

  //Variables to hold user input and track how many questions was answered correctly
  char userAnswer; 
  int totalCorrect = 0; 
    
  //Prompt question #1
  cout << "\n------------------------------------"; 
  cout << "\nQuestion #1: \n"; 
  cout << "How many total continents are there?\n";
  cout << "\tA) 4\n"; 
  cout << "\tB) 9\n"; 
  cout << "\tC) 6\n"; 
  cout << "\tD) 7\n"; 

  //Store answer into userAnswer variable for later use
  cin >> userAnswer; 

  //Change any lower case inputs to an upper case 
  userAnswer = toupper(userAnswer); 

  /*switch, look for the correct answer. If what was entered by the user was 'D', then add one to their score and return that they got the question correct. If not, return that they got the question incorrect and don't add a point.*/
  switch (userAnswer) { 
    case 'D': 
    { 
      cout << "That's correct!\n"; 
      totalCorrect = totalCorrect + 1;
      break;
    }
    default: 
    { 
      cout << "That's incorrect.\n"; 
      break;
    }
  }

  //Prompt question #2
  cout << "\n------------------------------------"; 
  cout << "\nQuestion #2: \n"; 
  cout << "Which of the following is the largest desert on Earth?\n";
  cout << "\tA) Gobi\n"; 
  cout << "\tB) Antartica\n"; 
  cout << "\tC) Sahara\n"; 
  cout << "\tD) Arabian\n"; 

  //Store answer into userAnswer variable for later use
  cin >> userAnswer; 

  //Change any lower case inputs to an upper case 
  userAnswer = toupper(userAnswer);

  /*switch, look for the correct answer. If what was entered by the user was 'B', then add one to their score and return that they got the question correct. If not, return that they got the question incorrect and don't add a point.*/
  switch (userAnswer) { 
    case 'B': 
    { 
      cout << "That's correct!\n";
      totalCorrect = totalCorrect + 1;
      break; 
    }
    default: 
    { 
      cout << "That's incorrect.\n";
      break;
    }
  }

  //Prompt question #3
  cout << "\n------------------------------------"; 
  cout << "\nQuestion #3: \n"; 
  cout << "Which of the following is the largest city by population?\n";
  cout << "\tA) Sao Paulo\n"; 
  cout << "\tB) Shanghai\n"; 
  cout << "\tC) Tokyo\n"; 
  cout << "\tD) Delhi\n"; 

  //Store answer into userAnswer variable for later use
  cin >> userAnswer; 

  //Change any lower case inputs to an upper case 
  userAnswer = toupper(userAnswer);

  /*switch, look for the correct answer. If what was entered by the user was 'C', then add one to their score and return that they got the question correct. If not, return that they got the question incorrect and don't add a point.*/
  switch (userAnswer) { 
    case 'C': 
    { 
      cout << "That's correct!\n";
      totalCorrect = totalCorrect + 1;
      break; 
    }
    default: 
    { 
      cout << "That's incorrect.\n";
      break;
    }
  }

  //Prompt question #4
  cout << "\n------------------------------------"; 
  cout << "\nQuestion #4: \n"; 
  cout << "Which of the following is the richest country?\n";
  cout << "\tA) Luxembourg\n"; 
  cout << "\tB) Ireland\n"; 
  cout << "\tC) United States of America\n"; 
  cout << "\tD) Switzerland\n"; 

  //Store answer into userAnswer variable for later use
  cin >> userAnswer; 

  //Change any lower case inputs to an upper case 
  userAnswer = toupper(userAnswer);

  /*switch, look for the correct answer. If what was entered by the user was 'A', then add one to their score and return that they got the question correct. If not, return that they got the question incorrect and don't add a point.*/
  switch (userAnswer) { 
    case 'A': 
    { 
      cout << "That's correct!\n";
      totalCorrect = totalCorrect + 1;
      break; 
    }
    default: 
    { 
      cout << "That's incorrect.\n";
      break;
    }
  }

  //Prompt question #5
  cout << "\n------------------------------------"; 
  cout << "\nQuestion #5: \n"; 
  cout << "Which of the following is the second most populous country?\n";
  cout << "\tA) Indonesia\n"; 
  cout << "\tB) India\n"; 
  cout << "\tC) China\n"; 
  cout << "\tD) United States of America\n"; 

  //Store answer into userAnswer variable for later use
  cin >> userAnswer; 

  //Change any lower case inputs to an upper case 
  userAnswer = toupper(userAnswer); 

  /*switch, look for the correct answer. If what was entered by the user was 'B', then add one to their score and return that they got the question correct. If not, return that they got the question incorrect and don't add a point.*/
  switch (userAnswer) { 
    case 'B': 
    { 
      cout << "That's correct!\n";
      totalCorrect = totalCorrect + 1;
      break; 
    }
    default: 
    { 
      cout << "That's incorrect.\n";
      break;
    }
  }

  cout << "\n------------------------------------";
  //if the total amount of questions answered correctly is 5, output the following
  if (totalCorrect == 5)  
    { 
      cout << "\nYou scored a total of " << totalCorrect << " out of 5!\nGreat Job! You really know your geography!";
    }
  //if the total amount of questions answered correctly is greater than or equal to 3 but not equal to 5, output the following
  else if (totalCorrect >= 3) 
    { 
      cout << "\nYou scored a total of " << totalCorrect << " out of 5!\nGood Job! You know quite a lot about geography!";
    }
  //else if the total amount of questions answered correctly is not equal or greater than 3, output the following
  else 
    { 
      cout << "\nYou scored a total of " << totalCorrect << " out of 5!\nNice try! You know a little about geography! Keep up the practice!";
    }
  cout << "\n------------------------------------\n";
 return 0;
}//end main