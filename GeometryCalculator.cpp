/* 
Xander Rivera 
Computer Programing 1A (C++)
9/13/21
Geometry Calculator 


This program will be able to take user input to operate a geometry caluclator
*/

//Preprocesor directive library
#include <iostream> 

//Standard namespace
using namespace std; 


//area of a rectangle 
int rectangleArea() { 

//variables for base and height of the rectangle
double base = 0; 
double height = 0; 

//promt for the base of the rectangle
cout << "Input the base of the rectangle: "; 
//save the input from the user and set it as the base
cin >> base; 
//prompt for the height of the rectangle
cout << "Input the height of the rectangle: "; 
//save the input from the user and set it as the height
cin >> height; 

//display full question + answer
cout << "The area of a rectangle with a base of " << base << " and a height of " << height << " is: " << base*height;

//return 0 is successful 
return 0;
}

//area of a triangle
int triangleArea() { 

//variables for base and height of the triangle
double base = 0; 
double height = 0; 

//promt for the base of the triangle
cout << "Input the base of the triangle: "; 
//save the input from the user and set it as the base
cin >> base; 
//prompt for the height of the triangle
cout << "Input the height of the triangle: "; 
//save the input from the user and set it as the height
cin >> height; 

//display full question + answer
cout << "The area of a triangle with a base of " << base << " and a height of " << height << " is: " << base*height;

//return 0 is successful 
return 0;
}

//area of a circle
int circleArea() { 

//variables for radius of the circle 
double radius = 0; 

//promt for the radius of the circle
cout << "Input the radius of the circle: ";
//save the input from the user and set it as the radius
cin >> radius; 

//display full question + answer
cout << "The area of a circle with a radius of " << radius << " is: " << (radius*radius)*3.14;

//return 0 is successful 
return 0;
}

//volume of a sphere
int volumeSphere() { 

//variables for radius of the sphere
double radius = 0; 

//promt for the radius of the sphere
cout << "Input the radius of the sphere: ";
//save the input from the user and set it as the radius
cin >> radius; 

//display full question + answer
cout << "The volume of a sphere with a radius of " << radius << " is: " << (radius*radius*radius)*3.14*4/3;

//return 0 is successful 
return 0;
}

//volume of a cylinder
int volumeCylinder() {  

//variables for the radius and height of the cylinder
double radius = 0;
double height = 0; 

//promt for the height of the cylinder
cout << "Input the height of the Cylinder: "; 
//save the input from the user and set it as the height
cin >> height; 
//promt for the radius of the cylinder
cout << "Input the radius of the Cylinder: ";
//save the input from the user and set it as the radius
cin >> radius; 

//display full question + answer
cout << "The volume of a cylinder with a radius of " << radius << " and height of " << height << "is: " << 3.14*(radius*radius)*height;

//return 0 is successful 
return 0;
}

//Main Function
int main() { 

//variable for characters the uses to interact 
char ui; 

//prompt options for calculator 
cout << "Please enter a value: 1: Area of a rectangle, 2: Area of a triangle, 3: Area of a circle, 4: Volume of a sphere, or 5: volume of a Cylinder\n"; 
//save the input from the user and set it as ui (user input) to be used in the switch to select an equation 
cin >> ui;

//switch to select equations within the calculator
switch (ui) { 

  case '1':
  //area of a rectangle function call
    rectangleArea();
    break;
  case '2':
  //area of a triangle function call
    triangleArea();
    break;
  case '3': 
  //area of a circle function call
    circleArea();
    break;  
  case '4':
  //volume of a sphere function call
    volumeSphere(); 
    break; 
  case '5': 
  //volume of a cylinder function call
    volumeCylinder(); 
    break;
  //defalt switch, when user does not input a valid option, prompt again and make another selection
  default:
    cout << "Please select a valid option.";
}

//return 0 is successful 
return 0;
}