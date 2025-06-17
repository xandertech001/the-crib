/* 
Xander Rivera 
Computer Programming 1A (C++)
10/31/21
Voyager Cruises 

This program will demonstrate a calculator for after people leave the cruise. It will calculate people, meal plans, rooms, day of departure, day that the bill was paid, and if any deposit is present to then give a total of how much your cruise costs.
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Constants for food calculations
const double adultD = 15.80; 
const double adultS = 11.75; 
const double childCost = 0.6;   
const double tipAndtax = 0.18; 

//Constant for day of departure
const double weekendD = 0.07; 

//Constants for room types
const double roomA = 55.00; 
const double roomB = 75.00;  
const double roomC = 85.00; 
const double roomD = 100.00; 
const double roomE = 130.00; 

//Constants for discounts
const double discountUnder100 = 0.005;
const double discountUnder400 = 0.03;
const double discountUnder800 = 0.04;
const double discountOver800 = 0.05; 

//Constants for formating output
const int decimal = 2; 
const int x = 61;  

//Main Function
int main() { 
	
	//Variables used for meal calculations 
	int adults; 
	int children; 
	char mealPlan;  
	double costAdult; 
	double costChild; 

	//Variables used to collecting room, departure, deposit, and total bill
	char room; 
	int days; 
	double deposit; 
	double total; 

	//Heading 
	cout << "\n------=+=-Thank you for staying with us at Voyager Cruises!-=+=------\n\n";  
	//Prompt
	cout << "\tPlease enter # of adults: ";  
	//Set user input to # of adults and ignore enter key
	cin >> adults;  
	cin.ignore(); 

	//Prompt
	cout << "\n\tPlease enter # of children: ";  
	//Set user input to # of children and ignore enter key
	cin >> children; 
	cin.ignore(); 
	
	//Prompt
	cout << "\n\tPlease enter your meal plan ('D' for deluxe and 'S' for standard): "; 
	//Set user input to type of meal plan and set it to an uppercase letter
	cin >> mealPlan; 
	mealPlan = toupper(mealPlan);   

	//Switch
	switch (mealPlan) {
		//When user input is 'D'
		case 'D':
		//DELUXE MEAL
      //calculate adults by multiplying by the rate and the # of adults
			costAdult = adultD * adults;   
			//calculate child cost by the rate of the children's meals (D)
			costChild = (childCost * adultS) * children;  
			//add 18% tip
			total = (tipAndtax * (costAdult + costChild)) + costAdult + costChild; 
			break;
		//When user input is 'S;
		case 'S': 
		//STANDARD MEAL
			//calculate adults by multiplying by the rate and the # of adults
			costAdult = adultS * adults;  
			//calculate child cost by the rate of the children's meals (S)
			costChild = (childCost * adultS) * children;  
			//add 18% tip
			total = (tipAndtax * (costAdult + costChild)) + costAdult + costChild;
			break;
	}//end switch

	//Prompt
	cout << "\n\tPlease enter your room type (A, B, C, D, or E): ";  
	//Set user input to room type and set it to an uppercase letter
	cin >> room; 
	room = toupper(room);  

	//Switch
	switch (room) { 
		//When user input is 'A'
		case 'A': 
			//Add the cost of room A to the total and break
			total+=roomA; 
		 	break;
		case 'B': 
		//When user input is 'B'
			//Add the cost of room B to the total and break
			total+=roomB; 
			break;
		case 'C':
		//When user input is 'C' 
			//Add the cost of room C to the total and break
			total+=roomC; 
			break;
		case 'D': 
		//When user input is 'D' 
			//Add the cost of room D to the total and break
			total+=roomD; 
			break; 
		case 'E': 
		//When user input is 'E' 
			//Add the cost of room E to the total and break
			total+=roomE; 
			break;  
	}//end switch

	//Prompt
	cout << "\n\tPlease enter day of departure (1-Sun 2-Mon 3-Tue 4-Wed 5-Thur 6-Fri 7-Sat): ";  
	//Set user input to the day of departure and ignore enter key
	cin >> days; 
	cin.ignore();

	//If they left on a weekend
	if (days == 6 || days == 7 || days == 1)
		{ 
			//Add the 7% fee
			total+=(total*weekendD); 
		}

	//Prompt
	cout << "\n\tPlease enter # of days since your stay with us: "; 
	//Set user input to number of days after the cruise ended and ignore enter key"
	cin >> days;  
	cin.ignore(); 

	//All needed to be within 10 days  

	//If the total was under $100
	if (days >=0 && days <= 10 && total < 100)  
		{
			//Take off respective discount
			total-=(total*discountUnder100);
		} 
	//If the total was greater or equal to $100 but under $400
	else if (days >=0 && days <= 10 && total >=100 && total < 400) 
		{ 
			//Take off respective discount
			total-=(total*discountUnder400);
		} 
	//If the total was greater or equal to $400 but under $800
	else if (days >=0 && days <= 10 && total >=400 && total < 800) 
		{ 
			//Take off respective discount
			total-=(total*discountUnder800);
		} 
	//If the total was greater or equal to $800
	else if (days >=0 && days <= 10 && total >=800) 
		{ 
			//Take off respective discount
			total-=(total*discountOver800);
		}

	//Prompt 
	cout << "\n\tPlease enter your deposit, if any: $";  
	//Set user input to their deposit and ignore enter key
	cin >> deposit; 
	cin.ignore(); 

	//Take the deposit amount off of the total
	total-=deposit; 

	//Set to 2 decial places
	cout.setf(ios::fixed); 
	cout.precision(decimal);  
	//Line 
	cout << "---------------------------------------------------------------------\n"; 
	//Set to a width of 61
	cout.width(x);
	//Output the total of the user's bill
 	cout << "Your total is: " << total;

	//return 0 if successful
	return 0;
}//end main 	