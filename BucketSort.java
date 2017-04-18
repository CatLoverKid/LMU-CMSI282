import java.io.*;
import java.util.*;

class BucketSort{
  private static ArrayList inputList = new ArrayList(); 
  private static double largestNum;

  public static void main(String args[])throws Exception{
    BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
    String inputString = systemIn.readLine();
    largestNum = Double.parseDouble(inputString);
    while(inputString != null){
      largestNum = Math.max(largestNum, Double.parseDouble(inputString));
      inputList.add(Double.parseDouble(inputString));
      inputString = systemIn.readLine();
    }
    System.out.println(BucketSorter(inputList));
  }

    private static ArrayList BucketSorter(ArrayList inList){
      ArrayList buckets = new ArrayList(inList.size());
      for(int i = 0; i < buckets.size(); i ++){
        buckets.set(i, new ArrayList(1));
      }
      for(int i = 0; i < inList.size(); i++){
        ArrayList bucket = buckets.get((int)inList.get(i) / (int)largestNum * buckets.size());
        bucket.add(bucket, inList.get(i));
      }
      for(int i = 0; i < buckets.size(); i ++){
        buckets.set(i, insertSort(buckets.get(i)));
      }
      return buckets;
    }

    private static ArrayList insertSort(ArrayList bucket) {
      double temp;
      int j;
      for(int i = 0; i < bucket.size(); i++){
        j = i;
        while(j > 0 && (double)bucket.get(j - 1) > (double)bucket.get(j)){
          temp = (double)bucket.get(j);
	  bucket.set(j, j - 1);
	  bucket.set(j - 1, temp);
  	  j--;
        }
      }
      return bucket;
    }
}
