/* 
Xander Rivera 
Computer Programming 1A (C++)
3/17/2022
The Game of Rocks! 1.0

The game starts with a random number of rocks in a pile from 15 to 30.  
Two players alternate turns and on each turn, the player has a choice 
to remove 1, 2, or 3 rocks from the pile. 
The player who removes the last rock is the loser.

*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

/*generates and returns a random number between 15 and 30, inclusive
*/
int genPile()
{
  return rand()%(30-15+1)+15;
}


/*subtracts number of rocks (remove) from pile's total (pile)
if the all rocks are gone, display a message that the pile 
is empty and set the lose variable equal to true to indicate the
game has been lost
Parameters:
lose – has the game been lost?
pile – total number of rocks left in the pile
remove – the desired amount of rocks to remove in this turn
*/
void adjustPile(bool &lose, int &pile, int remove)
{ 
  pile = pile - remove;  

  if (pile < 1)
  { 
    cout << "\nThe pile is empty!\n";
    lose = true;  
  }
}

/*Computer determines and returns number of rocks to take, 
based on following rules:
1 or 2 rocks: take 1
3 rocks: take 2
4 rocks: take 3
more than 4 - take random number 1-3
and returns a value representing the number of rocks to remove (do not adjust the value inside pile here!)
Parameter:
pile – total number of rocks remaining in the current pile being played
*/
int compDecision(int pile)
{ 
  switch (pile)
  { 
    case 1:
    case 2: 
    { 
      return 1; 
    }
    case 3: 
    { 
    	return 2;
    }
    case 4: 
    { 
    	return 3;
    }
    default: 
    { 
      return rand() % (3 - 1 + 1) + 1;
    }
	}
}

/*Determines if the number of rocks indicated
is valid for the pile (i.e. not too many,
not too few. Returns true if the selected number IS valid
Parameters:
remove – # of rocks the user is trying to remove
pile – total number of rocks remaining in the pile
*/
bool valid(int remove, int pile)
{ 
  if (remove > 3 || remove > pile)
  { 
    return false;  
  }
	else 
	{ 
		return true;	
	}
}

/*A single turn is played.

For human user, they are prompted to ask how many rocks to remove, and the pile is adjusted accordingly

For computer,computer makes its decision, the number of rocks it removes is displayed, and the pile is adjusted accordingly

This function calls helper functions:
-valid
-adjustPile
-compDecision

Parameters:
player – which player’s turn it currently is – 1=user 2=computer
pLose – has the human player has lost
cLose – has the computer has lost
pile – total number of rocks remaining in the pile
person - the human player's name
*/
void turn(int player, bool &pLose, bool &cLose, int &pile, string person)
{ 
  int take = 0;  
	if (player == 1)
	{
		cout << "\nIt's your turn, " << person << ". How many rocks would you like to take from the pile?: ";	
		cin >> take;
		
		while (!valid(take, pile))
		{ 
			cout << "\nThat is not a valid number to take. Select again: ";
			cin >> take;
		}
		
		adjustPile(pLose, pile, take);
	}
	else 
	{
		int ctake = compDecision(pile);
		
		cout << "\n\nThe computer took " << ctake << " rocks.\n";
		adjustPile(cLose, pile, ctake);
	}
}

/*determines whether or not game is over
Outputs message about who has lost, when appropriate
Returns true if the game IS over, false if it is still ongoing
Parameters:
pLose – has the player lost?
cLose – has the computer lost?
*/
bool gameOver(bool pLose, bool cLose)
{ 
  if (cLose == true)
  { 
		cout << "\nCheck out the big brain on you! You beat the computer!";
		return true;
  }
	else if (pLose == true)
	{ 
		cout << "\nThe computer has won! In your face!";
		return true; 	
	}
	else 
	{ 
		return false;	
	}
} 

//Main Function
int main() 
{
  srand(time(0));
    
  string person; 
    
  cout<<"Welcome to the Game of Rocks!"<<endl;
  cout<<"What is your name, human player (so I can know who I'm about to crush!)? ";
  getline(cin, person);

  //create the pile
	int pile=genPile(); 

  //has the human player lost?
	bool pLose=false; 
	//has the computer player lost?
	bool cLose=false; 
	
	//whose turn? (1=human, 2=computer)
	int player=2; 

  //keep going until someone has lost 
	do 
	{
		//wipes the console clean
		system("clear");
		
		//switch between players before start of next turn
		if(player==1) 
			player++;
		else
			player--;
	
    //output current number in pile
		cout<<"# Rocks in Pile: "<<pile<<endl; 
		
		//play a single turn 
		turn(player,pLose,cLose, pile, person); 
		
		//pause before clearing screen so human can
		//see how many rocks the computer took
  	cout<<"Hit enter to continue."<<endl;
		cin.get();

	}while(!gameOver(pLose,cLose)); 

	return 0;
}

