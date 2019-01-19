#include <iostream>
#include <iomanip>
#include <fstream>
#include <cstdlib>
using namespace std;
 
// global variables  ////////////////////////////////////
ifstream inFile;
 
// Knapsack functions ///////////////////////////////////
void getInstance (int & W, // Knapsack capacity
                  int & n, // number of items
                  int* & v, // values of items
                  int* & w) // weights of items
{
    inFile >> n;
    inFile >> W;
    w = new int[n];
    for (int i=0; i<n; i++)
        inFile >> w[i];
    v = new int[n];
    for (int i=0; i<n; i++)
        inFile >> v[i];
}
 
void putInstance (int W, // Knapsack capacity
                  int n, // number of items
                  int * v, // values of items
                  int * w) // weights of items
{
    cout << "There are " << n << " items." << endl;
    cout << "The knapsack capacity is " << W << "." << endl << endl;
     
    for (int i = 0; i < n; i++) {
        cout << "\t" << i;
    }
    cout << endl;
     
    cout << "w: ";
    for (int j = 0; j < n; j++) {
        cout << "\t" << w[j];
    }
    cout << endl;
     
    cout << "v: ";
    for (int k = 0; k < n; k++) {
        cout << "\t" << v[k];
    }
    cout << endl;
     
    cout << "W = " << W << endl;
}
 
void solveInstance (int W, // Knapsack capacity
                    int n, // number of items
                    int * v, // values of items
                    int * w) // weights of items
{
     
}
 
int main() {   
    inFile.open("PA2_data.txt");
     
    if (!inFile.is_open()) {
        cerr << "Can't find input file." << endl;
        exit(1);
    }
 
    int nInsts; // number of problem instances
 
    inFile >> nInsts;
     
    for (int i=1; i<= nInsts; i++)
    {
        int W; // Knapsack weight capacity
        int n; // Number of items
        int * v; // Values of items
        int * w; // Weights of items
        getInstance (W, n, v, w);
         
        cout << "--------------------------------\n";
        cout << "Problem instance #" <<  i << "\n";
        putInstance (W, n, v, w);
        solveInstance (W, n, v, w);
        cout << endl;
         
        int nFeasible = 0;
    }
    inFile.close();
}
