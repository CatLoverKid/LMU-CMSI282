import java.io.*;
import java.util.*;

class BucketSort{
  private static ArrayList<Double> inputList = new ArrayList<Double>(); 
  private static double largestNum;
  private static double smallestNum;

  public static void main(String args[])throws Exception{
    BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
    String inputString = systemIn.readLine();
    largestNum = Double.parseDouble(inputString);
    smallestNum = Double.parseDouble(inputString);
    while(inputString != null){
      largestNum = Math.max(largestNum, Double.parseDouble(inputString));
      smallestNum = Math.min(smallestNum, Double.parseDouble(inputString));
      inputList.add(Double.parseDouble(inputString));
      inputString = systemIn.readLine();
    }
    System.out.println(BucketSorter(inputList));
  }


    private static ArrayList<Double> BucketSorter(ArrayList<Double> inList){
      ArrayList<ArrayList<Double>> buckets = new ArrayList<ArrayList<Double>>(); // create a new bucket to use
      
      for(int i = 0; i < inList.size(); i ++){
        buckets.add(new ArrayList<Double>()); // add a new array
      }
      ArrayList<Double> tempBucket = new ArrayList<Double>();
      for(int i = 0; i < inList.size(); i++){
        double currentNumber = inList.get(i);
    	int bucketPos = (int)(currentNumber - (int)smallestNum) / (((int)largestNum - (int)smallestNum + 1) / (inList.size() - 1));
        //System.out.println("Adding the number: " + currentNumber + " at " + bucketPos);
        tempBucket = buckets.get(bucketPos);
    	tempBucket.add(currentNumber);
	    buckets.set(bucketPos, tempBucket);
      }



      ArrayList<Double> finalList = new ArrayList<Double>();
      for(int i = 0; i < buckets.size(); i ++){
        buckets.set(i, insertSort(buckets.get(i)));
        for(int j = 0; j < buckets.get(i).size(); j++){
          finalList.add(buckets.get(i).get(j));
        }
      }
      return finalList;
    }




    private static ArrayList<Double> insertSort(ArrayList<Double> bucket) {
      double temp;
      int j;
      for(int i = 0; i < bucket.size(); i++){
        j = i;
        while( j > 0 && (double)bucket.get(j - 1) > (double)bucket.get(j)){
          temp = (double)bucket.get(j);
	  bucket.set(j, bucket.get(j - 1));
	  bucket.set(j - 1, temp);
  	  j--;
        }
      }
      return bucket;
    }
}
