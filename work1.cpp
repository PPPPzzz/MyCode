#include<iostream>
using namespace std;

int main()
{
	int year;
	char addr[20];

	cin >> year;
	cin.get();
	cin.getline(addr, 20);
	cout << year << endl;
	cout << addr << endl;

	return 0;
}