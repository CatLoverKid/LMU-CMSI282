import java.lang.*;
import java.util.*;
import java.io.*;
class Select{
  static int k;
  static ArrayList<Integer> values;
  static long currentTime;
  static int finalResult;
  static private void returnBadData(){
    System.out.println("BAD DATA");
    System.exit(0);
  } 
  static private int partition(ArrayList list, int left, int right, int pivotIndex){
    int pivotValue = (int) list.get(pivotIndex);
    Collections.swap(list, pivotIndex, right);
    int storeIndex = left;
    for(int i = left; i < right; i++){
      if((int) list.get(i) < pivotValue){
        Collections.swap(list, storeIndex, i);
        storeIndex++;
      }
    }
    Collections.swap(list, right, storeIndex);
    return storeIndex; 
  }
  static private int select(ArrayList list, int left, int right, int k){ 
    if(left == right){
      return (int) list.get(left);
    }
    int pivotIndex = left + (int)(Math.random() * ((right - left) + 1));
    pivotIndex = partition(list, left, right, pivotIndex);
    if(k == pivotIndex){
      return (int) list.get(k);
    }else if(k < pivotIndex){
      return select(list, left, pivotIndex - 1, k);
    }else{
      return select(list, pivotIndex + 1, right, k);
    }
  }
    public static void main(String args[])throws Exception{
      BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
      values = new ArrayList<Integer>();
      if(args[0] != null){
        k = Integer.parseInt(args[0]) - 1; 
        if(k == 0){
          returnBadData();
        }
      }else{
        returnBadData();
      }
      String inputString = systemIn.readLine();
      while(inputString != null){
        values.add(Integer.parseInt(inputString));
        inputString = systemIn.readLine();
      }
      currentTime = System.currentTimeMillis();
      finalResult = select(values, 0, values.size() - 1, k);
      System.out.println(finalResult);
   }
}
