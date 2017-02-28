import java.io.*;

class SumoSolver {
  static int amountToSpend = 0;
 
 
 
  int partition (MyTuple array[], int left, int right){
	  int i = left;
	  int j = right;
	  MyTuple temp;
	  MyTuple pivot = array[(left + right) / 2];
	  
	  while(i <= j){
		  while(array[i].getCost() < pivot.getCost()){i++;}
		  while(array[i].getCost() > pivot.getCost()){j --;}
		  if(i <= j){
			  temp = array[i];
			  array[i] = array [j];
			  array[j] = temp;
			  i++;
			  j--;
		  }
		  
	  }
	  return i;
  }
  
  MyTuple quickSort(MyTuple array[], int left, int right){
	int index = partition(array, left, right);
	if(left < index - 1){quickSort(array, left, right);}
	if(index < right){quickSort(array, index, right);}
  }
 

 
  public static void main(String args[]){
	MyTuple[] products = new MyTuple[(args.length - 1) / 2];
    amountToSpend = Integer.parseInt(args[args.length - 1]);

    for(int i = 0; i < args.length - 1; i+= 2){
      products[i / 2] = new MyTuple(Integer.parseInt(args[i]), Integer.parseInt(args[i + 1]));
    }
	products = quickSort(products, 0, products.length - 1);
 }
}