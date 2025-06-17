/* 
Xander Rivera 
Computer Programming 1A (C++)
12/7/21
Calendar

My program will be able to calculate a year's monthly days and account for leap years. 
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Buffer is used as a set width for orginization of the dates
const int buffer = 4; 

//Main Function
int main() {  

	//Variables 

	//Starting day of the month
	int startDay; 
	//String for the name of the months
	string month;  
	//The number of days within that month
	int numDays;  
	//The year it is
	int year;  

	//Prompt and store as the year
	cout << "What year is it?: "; 
	cin >> year;

	//Prompt and start as the starting point of Jan 1st 
	cout << "What day does the year start on? 0-Sunday, 1-Mon, 2-Tues, 3-Wed, etc: "; 
	cin >> startDay; 

	//Output header for the year being outputted 
	cout << "\n" << year << endl;  


	//Loop 12 times
	for (int count = 1; count <= 12; count++) { 
		/*When we hit 1, 2, 3, etc, we count those as months, we can use this within our switch to know what month the program is on. 

		This switch statement will replace the respective values to make sure we are naming the right month and that month contains the right amount of days as it's not uniform.  
		
		*/
		switch (count) {
			
			//January
			case 1: 
			{ 
				month = "\n\nJanuary"; 
				numDays = 31; 
				break; 
			}  

			//Febuary 
			case 2: 
			{ 
				/*This if statement is to determine weither or not the year is a leap year or not, if so, then the number of days within said leap year in Feb is 29 not 28. */
				 if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) { 
					 numDays = 29; 
				 } 
				 else { 
					 numDays = 28; 
				 }
				month = "\n\nFebuary"; 
				break; 
			} 

			//March 
			case 3: 
			{ 
				month = "\n\nMarch"; 
				numDays = 31; 
				break; 
			} 

			//April 
			case 4: 
			{ 
				month = "\n\nApril"; 
				numDays = 30; 
				break; 
			} 

			//May 
			case 5: 
			{ 
				month = "\n\nMay"; 
				numDays = 31; 
				break; 
			} 

			//June 
			case 6: 
			{ 
				month = "\n\nJune"; 
				numDays = 30; 
				break; 
			}

			//July 
			case 7: 
			{ 
				month = "\n\nJuly"; 
				numDays = 31; 
				break; 
			} 

			//August 
			case 8: 
			{ 
				month = "\n\nAugust"; 
				numDays = 31;
				break; 
			} 

			//September 
			case 9: 
			{ 
				month = "\n\nSeptember"; 
				numDays = 30; 
				break; 
			}  

			//October 
			case 10: 
			{ 
				month = "\n\nOctober"; 
				numDays = 31; 
				break; 
			}  

			//November 
			case 11: 
			{ 
				month = "\n\nNovember"; 
				numDays = 30; 
				break; 
			} 

			//December 
			case 12: 
			{ 
				month = "\n\nDecember"; 
				numDays = 31; 
			
				break; 
			}
		}//End Switch 

		//Allignment to the left
		cout.setf(ios::left);



		//Output header for the month
		cout << month << endl;  
		cout << "-------------------------" <<endl;
		
		//Output week headers
		cout << "Su  M   T   W   R   F   S" << endl;  

		//Space loop
		for (int i = 0; i < startDay; i++) 
		{
			//Set to constant for equal spacing
			cout.width(buffer);
			cout << " ";   
		} 

		//Output however many days there are and set them to our constant.
		for (int i = 1; i <=numDays; i++) 
		{ 
			cout.width(buffer); 
			cout << i; 

			/*This if statement makes sure to cut off when it's a multiple of 7 as there are only 7 days within a week. */
			if (((i+startDay)%7) == 0)
			{  
				cout << endl;
			}
		} 

		/*This resets our starting value for the next month to be printed, if May for example, ends on Mon, we want June to start Tus, the next day. */
		startDay = (startDay+numDays)%7;  
		
	} //End loop
} //End main