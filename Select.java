import java.lang.*;
import java.util.*;
import java.io.*;

class Select{

  static Double k;
  static ArrayList values;

  static private void returnBadData(){
    System.out.println("BAD DATA");
    System.exit(0);
  }

    public static void main(String args[]) throws Exception{
      BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
      values = new ArrayList();

      if(args[0] != null){
        k = Double.parseDouble(args[0]); 
        if(k == 0){
          returnBadData();
        }
      }else{
        returnBadData();
      }

      String inputString = systemIn.readLine();
      while(inputString != null){
        values.add(Double.parseDouble(inputString));
        inputString = systemIn.readLine();
      }
    }


















}
