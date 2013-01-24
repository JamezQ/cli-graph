#include<iostream>
#include<cmath>
using namespace std;


double round(double number)
{
  return number < 0.0 ? ceil(number - 0.5) : floor(number + 0.5);
}

static string axis = "+ ";
static string line = "# ";
static string graph = ". ";
int main() {

  int size = 15;
  double step = (1.0);
  
  int *values = new int[size+size+1];
  
  for(int i = 0;i< size+size+1;++i) {
    double x = (i - (size));
    x = x*step;
    // EQUATION
    double value = -x;
    /// EQUATION
    value = value/step;
    values[i] = int(round(value));
  }
  // cout << "TABLE:" << endl;
  // for(int i = 0; i < size+size+1;++i) {
  //   cout << (i - (size)) << " : " << values[i] << endl;
  // }
  for(int i = 0; i < size+size+1;++i) {
    cout << endl;
  }
  for(int i = 0;i < size;++i) {

    for(int b = 0; b < size;++b) {
      if(size - i == values[b]) 
	cout << line;
      else 
	cout << graph;
    }
    
    if(size -i == values[size]) 
      cout << line;
    else
      cout << axis;
    
    for(int b = 0; b < size;++b) {
      if(size - i == values[b+size+1])
	cout << line;
      else
	cout << graph;
    }
    cout << endl;
  }
  for(int i = 0;i < size*2+1;++i) {
    if( 0 == values[i] )
      cout << line;
    else
      cout << axis;
  }
  cout << endl;

  for(int i = 0;i < size;++i) {
    for(int b = 0; b < size;++b) {
      if(0-i-1 == values[b])
	cout << line;
      else
	cout << graph;
    }
    if(0 -i-1 == values[size]) 
      cout << line;
    else
      cout << axis;

    for(int b = 0; b < size;++b) {
      if(0-i-1 == values[b+size+1])
	cout << line;
      else
	cout << graph;
    }
    cout << endl;
  }

  delete[] values;
}
