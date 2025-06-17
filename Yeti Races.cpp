/*
Xander Rivera 
Computer Programming 1A (C++)
3/29/22
Yeti Races
Write a program that runs a random yeti race.  There are three yetis participating in each race.  
During each round, a random number from 0 to 1 is generated for each yeti. 
The yeti advances one place if the random number is 1 and doesn’t move if it is zero. 
The race proceeds until at least one of the yetis reaches the finish line.
 
The user should be welcomed to the races and start with $100. 
The user places a wager and selects their choice of winning yeti.  
The race proceeds, and the user’s total is adjusted according to wins/losses. 
If only their yeti wins, the user gets the amount of their wager added to their total. 
If two tie, they get ½ the amount of their wager added to their total. If there is a three-way tie, the user gets 1/3 of their bet added to their total. 
The user should be able to continue watching races until s/he chooses to stop or has run out of money.

*/

//Preprocessor directive library
#include <iostream>

//Standard namespace
using namespace std;

double total = 100.00; 

void ShowLane(int yetiNum, int pos)
{
	cout << yetiNum << "|";
	for (int i = 1; i <= 20; i++)
	{
		if (pos == i)
		{
			cout << "Y";
		}
		else
		{
			cout << "-";
		}
	}
	cout << "|" << endl;
}

/*
verifies that bet is a real amount of money
and is legal based on amount left in total
returns true if bet IS valid, false otherwise
PARAMETERS:
-total – how much money the player has left
-bet – how much money they are trying to wager
*/
bool VerifyBet(double total, double bet)
{
	if (bet > 0 && bet <= total)
	{
		return true;
	}
	else
	{
		return false;
	}
}

/*
verifies that user has selected a valid yeti: 1, 2, or 3
returns true if yeti IS valid, false otherwise
PARAMETERS:
-yetiChoice – the number entered to indicate which yeti to bet on
*/
bool VerifyYeti(int yetiChoice)
{
	if (yetiChoice == 1 || yetiChoice == 2 || yetiChoice == 3)
	{
		return true;
	}
	else
	{
		return false;
	}
}

/*
prompts the user for a bet amount and keeps prompting if not valid
repeat process for selection of yeti
PARAMETERS:
-total – amount of money the player currently has
-bet – amount of money they want to wager
-yetiChoice – which yeti they want to bet on
*/
void MakeChoices(double total, double &bet, int &yetiChoice)
{

	cout << "Please enter the amount you'd like to bet: $";
	cin >> bet;

	while (!VerifyBet(total, bet))
	{
		cout << "Please enter a valid amount: $";
		cin >> bet;
	}

	cout << "Please enter your choice of Yeti (1, 2, or 3): ";
	cin >> yetiChoice;

	while (!VerifyYeti(yetiChoice))
	{ 
		cout << "Please enter a valid Yeti (1, 2, or 3):";
		cin >> yetiChoice;
	}
}

// Welcome to game message displayed
void SplashScreen(){
	cout << R"(
	
		Welcome to...
	 __     __  _   _   _____                    _ 
	 \ \   / / | | (_) |  __ \                  | |
	  \ \_/ ___| |_ _  | |__) |__ _  ___ ___ ___| |
	   \   / _ | __| | |  _  // _` |/ __/ _ / __| |
	    | |  __| |_| | | | \ | (_| | (_|  __\__ |_|
	    |_|\___|\__|_| |_|  \_\__,_|\___\___|___(_)	
----------------------------------------------------------
	)" << '\n';          
}

/*
Determines who the winner(s) are, outputs a corresponding message, determines the amount
won or lost and adds that amount to the total, then returns true if someone has, in fact,
won and false otherwise (i.e. if the race is not over yet!). Note this is a special case where
I have used both a reference parameter and return type other than void so that I can use this to
control my game loop
PARAMETERS:
-pos1 – where yeti 1 is on the track
-pos2 – where yeti 2 is on the track
-pos3 – where yeti 3 is on the track
-total – amount of money the player currently has
-bet – amount the player wagered
-yetiChoice – which yeti they bet on
*/
bool CheckWin(int pos1, int pos2, int pos3, double &total, double bet, int yetiChoice) {

	if ((pos3 == 20) && (pos1 == 20) && (pos1 == 20))
	{
    cout << "All Yeti's tied!" << endl;
    if (yetiChoice == 3 || yetiChoice == 1 || yetiChoice == 2)
			{
        cout << "You won $" << bet/3 << "!" << endl;
        cout << "Current total is: $" << total + bet/3 << endl;
      } 
      return true;
    } 

	if (pos3 == 20 && pos1 == 20)
	{
    cout << "Yeti #3 and Yeti #1 tied!" << endl;
    if (yetiChoice == 3 || yetiChoice == 1)
			{
        cout << "You won $" << bet/2 << "!" << endl;
        cout << "Current total is: $" << total + bet/2 << endl;
      } 
		else 
			{
        cout << "You lost $" << bet/2 << "!" << endl;
        cout << "Current total is: $" << total - bet/2 << endl;
      }
      return true;
    } 
	
	 if (pos2 == 20 && pos3 == 20)
	{
    cout << "Yeti #3 and Yeti #2 tied!" << endl;
    if (yetiChoice == 3 || yetiChoice == 2)
			{
        cout << "You won $" << bet/2 << "!" << endl;
        cout << "Current total is: $" << total + bet/2 << endl;
      } 
		else 
			{
        cout << "You lost $" << bet/2 << "!" << endl;
        cout << "Current total is: $" << total - bet/2 << endl;
      }
      return true;
    } 
	
	if (pos1 == 20 && pos2 == 20)
	{
    cout << "Yeti #1 and Yeti #2 tied!" << endl;
    if (yetiChoice == 1 || yetiChoice == 2)
			{
        cout << "You won $" << bet/2 << "!" << endl;
        cout << "Current total is: $" << total + bet/2 << endl;
      } 
		else 
			{
        cout << "You lost $" << bet/2 << "!" << endl;
        cout << "Current total is: $" << total - bet/2 << endl;
      }
      return true;
    } 
	
  if (pos1 > 19)
	{
    cout << "Yeti #1 won!" << endl;
    if (yetiChoice == 1)
			{
        cout << "You won $" << bet << "!" << endl;
        cout << "Current total is: $" << total + bet << endl;
      } 
		else 
			{
        cout << "You lost $" << bet << "!" << endl;
        cout << "Current total is: $" << total - bet << endl;
      }
    return true;
  } 
	
	if (pos2 > 19)
	{
    cout << "Yeti #2 won!" << endl;
    if (yetiChoice == 2)
			{
        cout << "You won $" << bet << "!" << endl;
        cout << "Current total is: $" << total + bet << endl;
      } 
		else 
			{
        cout << "You lost $" << bet << "!" << endl;
        cout << "Current total is: $" << total - bet << endl;
      }
    return true;
  } 

    if (pos3 > 19)
	{
    cout << "Yeti #3 won!" << endl;
    if (yetiChoice == 3)
			{
        cout << "You won $" << bet << "!" << endl;
        cout << "Current total is: $" << total + bet << endl;
      } 
		else 
			{
        cout << "You lost $" << bet << "!" << endl;
        cout << "Current total is: $" << total - bet << endl;
      }
      return true;
    } 
	return false;
}
	
//Generates and returns a number between 0 and 1
int IncreasePositionBy(){ 
	return  rand() % (1-0+1)+0;
}

/*Asks if the user wants to play again
Return true if they DO and false if they DON'T
should not depend on case
*/
bool PlayAgain(){ 
	int PAdecision;
	cout << "Play again? (1 for yes 2 for no): "; 
	cin >> PAdecision; 

	while (!(PAdecision == 1 || PAdecision == 2)){
		cout << "Please enter a valid responce (1 for yes 2 for no): ";
		cin >> PAdecision;
		}

	if (PAdecision == 1)
	{ 
		return true;	
	}
	else 
	{ 
		cout << "Goodbye!";
		return false;	
	}
}

/*
  Forces execution to wait specified # of seconds
  Seconds must be positive value
  Function requires you to include ctime library in your preprocessor directives
  i.e. #include<ctime>
*/
void Wait(double seconds){
  clock_t endwait; /*variable to hold stop time*/
  endwait = clock () + seconds * CLOCKS_PER_SEC ; /* stop time =current time + wait*/
  while (clock() < endwait) {} /*keeps us looping until we hit stop time*/
}


//Main Function
int main() 
{
	srand(time(0));

	SplashScreen(); 

	bool game = true; 

	while (game == true){
		
		cout.setf(ios::fixed);
		cout.precision(2); 
		int pos1 = 1;
		int pos2 = 1;
		int pos3 = 1;
		int yetiChoice;

		double bet = 0.0;

		if (total <= 0)
		{ 
			cout << "You bet all your money away! Try again next time.";	
			game = false;
			break;
		}
		
		cout << "Starting total: $" << total + bet << endl;

		MakeChoices(total, bet, yetiChoice);

		system("clear");

		cout << "STARTING POSITIONS !!" << endl;

		ShowLane(1, pos1); 
		ShowLane(2, pos2); 
		ShowLane(3, pos3); 

		Wait(2);

		system("clear");
                                                      
	  cout << R"(
	   _____  ____   ____   ____   ____    _ _ _ _ _ _ 
	  / ____|/ __ \ / __ \ / __ \ / __ \  | | | | | | |
	 | |  __| |  | | |  | | |  | | |  | | | | | | | | |
	 | | |_ | |  | | |  | | |  | | |  | | | | | | | | |
	 | |__| | |__| | |__| | |__| | |__| | |_|_|_|_|_|_|
	  \_____|\____/ \____/ \____/ \____/  (_|_|_|_|_|_)
	                                                                    
		)" << '\n';      

		Wait(1);

		system("clear");
		
		do {

		system("clear");
		
		ShowLane(1, pos1+=IncreasePositionBy()); 
		ShowLane(2, pos2+=IncreasePositionBy()); 
		ShowLane(3, pos3+=IncreasePositionBy()); 


		Wait(0.1);
			
		}while (!CheckWin(pos1, pos2, pos3, total, bet, yetiChoice));

		if (pos1 >= 20)
		{ 
			if (yetiChoice == 1)
			{ 
				total = total + bet; 	
			}
			else 
			{ 
				total = total - bet; 	
			}
		}
		else if (pos2 >= 20)
		{ 
			if (yetiChoice == 2)
			{ 
				total = total + bet; 	
			}
			else 
			{ 
				total = total - bet; 	
			}
		}
		else if (pos3 >= 20)
		{ 
			if (yetiChoice == 3)
			{ 
				total = total + bet; 	
			}
			else 
			{ 
				total = total - bet; 	
			}
		}
		else if ((pos3 == 20) && (pos1 == 20) && (pos1 == 20))
		{ 
			total = total + bet/3;	
		}
		else if ((pos3 == 20) && (pos1 == 20))
		{ 
			if (yetiChoice == 3 || yetiChoice == 1)
			{ 
				total = total + bet/2; 	
			}
			else 
			{ 
				total = total - bet/2; 	
			}
		}
		else if ((pos2 == 20) && (pos1 == 20))
		{ 
			if (yetiChoice == 2 || yetiChoice == 1)
			{ 
				total = total + bet/2; 	
			}
			else 
			{ 
				total = total - bet/2; 	
			}
		}
		else if ((pos3 == 20) && (pos2 == 20))
		{ 
			if (yetiChoice == 3 || yetiChoice == 2)
			{ 
				total = total + bet/2; 	
			}
			else 
			{ 
				total = total - bet/2; 	
			}
		}
		game = PlayAgain(); 
		system("clear");
	}
}