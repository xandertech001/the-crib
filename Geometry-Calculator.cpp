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

//area fuction to determine the area of a shape
int area(string fname) { 

//variables for base and height to determine area
double base = 0; 
double height = 0; 

//promt the user for the base for area
cout << "Input the base of the "<< fname <<": "; 
//save the input from the user and set it as the base variable
cin >> base; 
//prompt the user for the height for area
cout << "Input the height of the "<< fname <<": "; 
//save the input from the user and set it as the height variable
cin >> height; 

//display full question + answer
cout << "The area of a "<< fname <<" with a base of " << base << " and a height of " << height << " is: " << base * height;

//return 0 is successful 
return 0; 
} //End Function

//area of a circle fuction to solve for area of a circle
int circleArea() { 

//variable to contain the radius of the circle for the area
double radius = 0; 

//promt the user for the radius of the circle 
cout << "Input the radius of the circle: ";
//save the input from the user and set it as the radius variable
cin >> radius; 

//display full question + answer
cout << "The area of a circle with a radius of " << radius << " is: " << (radius * radius) * 3.14 << endl;

//return 0 is successful 
return 0;
}

//volume of a sphere fuction to solve the for the volume of a sphere
int volumeSphere() { 

//variable for radius of the sphere
double radius = 0; 

//promt the user for the radius of the sphere
cout << "Input the radius of the sphere: ";
//save the input from the user and set it as the radius
cin >> radius; 

//display full question + answer
cout << "The volume of a sphere with a radius of " << radius << " is: " << (radius * radius * radius) * 3.14 * 4/3;

//return 0 is successful 
return 0;
}

//volume of a cylinder
int volumeCylinder() {  

//variables for the radius and height of the cylinder
double radius = 0;
double height = 0; 

//promt the user for the height of the cylinder
cout << "Input the height of the Cylinder: "; 
//save the input from the user and set it as the height
cin >> height; 
//promt the user for the radius of the cylinder
cout << "Input the radius of the Cylinder: ";
//save the input from the user and set it as the radius
cin >> radius; 

//display full question + answer
cout << "The volume of a cylinder with a radius of " << radius << " and height of " << height << "is: " << 3.14 * (radius * radius) * height;

//return 0 is successful 
return 0;
}

//Main Function
int main() { 

//variable for integers the uses to interact 
int ui = 0; 

while (ui != 6) {

//prompt options for calculator 
cout << "\n\n------------------------------------\nPlease select a equation:\n1: Area of a rectangle\n2: Area of a triangle\n3: Area of a circle\n4: Volume of a sphere\n5: volume of a Cylinder\n6: To exit\n------------------------------------\n\n"; 
//save the input from the user and set it as ui (user input) to be used in the switch to select an equation 
cin >> ui;

  //switch to select equations within the calculator
  switch (ui) { 
    case 1:
    //area function call w/rectangle
      area("rectangle");
    //stop
      break;
    case 2:
    //area function call w/rectangle
      area("triangle");
    //stop
      break;
    case 3: 
    //area of a circle function call
      circleArea();
    //stop
      break;  
    case 4:
    //volume of a sphere function call
      volumeSphere(); 
    //stop
      break; 
    case 5: 
    //volume of a cylinder function call
      volumeCylinder(); 
    //stop
      break;
    //case when user wants to exit
    case 6:
    //stop
      break;
  //defalt switch, when user does not input a valid option, prompt again and make another selection
    default:
      cout << "Please select a valid option.\n"; 
  }//end switch
}//end while 

//return 0 is successful 
return 0;
}