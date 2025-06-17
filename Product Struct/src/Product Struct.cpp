//============================================================================
// Name        : Product Struct.cpp
// Author      : Xander
// Version     : 6/9
// Description : Design and implement a struct to represent a product sold at a convenience store like 7-11.
//============================================================================

#include <iostream>
#include <string>

using namespace std;

//structure
struct Product{
	string product;
	string brand;
	double price;
	string barcode;

	//construct
	Product(string pro, string bran, double pri, string bar){
		product = pro;
		brand = bran;
		price = pri;
		barcode = bar;
	}
};

//printing function
void print (Product pro){
	cout << pro.product << " is made by "<< pro.brand << ", costs $" << pro.price << " and has barcode: " << pro.barcode << endl;
}

int main() {

	//calling product to set parameters
	Product Tea("Iced Tea", "Simple Tea", 2.99, "98UUMM3671Z");
	Product Water("Water", "Deer Park", 1.05, "T8827K111A9I2");

	//print using print function
	print(Tea);
	print(Water);

  return 0;
}
