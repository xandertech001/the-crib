/* 
Xander Rivera 
Computer Programming 1A (C++)
2/17/22
Geo Calculator w/ Functions

This code will act like a calculator, solving the area of multiple shapes using functions. 
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Pi constant for circle
const double PI = 3.14; 

//This function will calculate the area of a square
void areaSquare()
{
  double side;
  cout << "Enter length of the square: ";
	cin >> side;

  cout << "The area of a square with a length of " << side << " is " << side * side << endl;
}

//This function will calculate the area of a rectangle
void areaRectangle()
{
  double length, width;
  cout << "Enter length of the rectangle: ";
	cin >> length; 

	cout << "Enter width of the rectangle: "; 
	cin >> width; 

  cout << "The area of a rectangle with a length of " << length << " and a width of " << width << " is " << length * width << endl;
}

//This function will calculate the area of a triangle
void areaTriangle() 
{ 
	double base, height; 

	cout << "Enter base of the triangle: "; 
	cin >> base; 

	cout << "Enter height of the triangle: "; 
	cin >> height; 

	cout << "The area of a triangle with a base of " << base << " and a height of " << height << " is " << (base * height) / 2 << endl;
}

//This function will calculate the area of a circle
void areaCircle() 
{ 
	double radius; 

	cout << "Enter radius of the circle: "; 
	cin >> radius; 

	cout << "The area of a triangle with a radius of " << radius << " is " << (radius * radius) * PI << endl;
}

//Main Function
int main() {  
	
	//Variables for menu and user selection
	int menu = 1, userSelection; 

	//While menu loop
	while (menu == 1) 
	{ 
		//Prompt options
		cout << "\n\t1) Area of a square" << endl; 
		cout << "\t2) Area of a rectangle" << endl; 
		cout << "\t3) Area of a triangle" << endl; 
		cout << "\t4) Area of a circle" << endl; 
		cout << "\t5) Quit" << endl;
		cout << "------------------------------" << endl;

		//Take in user input
		cin >> userSelection;

		//Switch using user selection
		switch (userSelection) 
		{ 
			//Area of square
			case 1: 
			{ 
				//Call area function
				areaSquare();
				break;
			}
			//Area of rectangle
			case 2: 
			{ 
				//Call area function
				areaRectangle(); 
				break;
			}
			//Area of triangle
			case 3: 
			{ 
				//Call area function
				areaTriangle(); 
				break;
			}
			//Area of circle
			case 4: 
			{ 
				//Call area function
				areaCircle(); 
				break;
			}
			case 5: 
			{ 
				//Stop while loop
				menu = 0; 
				break;
			}
		}//end switch
	}//end while
}//end main