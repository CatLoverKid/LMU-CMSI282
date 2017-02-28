import java.io.*;
import java.lang.*;i
import java.util.*;

class Runner{
  private static int totalTime;
  private static int runSize;
  private static int incrementAmount;
  private final int maxCeiling = 100000000;

  public static void main(String args[]){
    incrememntAmount = args[0];
    runSize = args[1];
    while(runSize < maxCeiling){
      System.out.println("*" + runSize + "*");
      for(int i = 0; i < runSize; i++ ){
        System.out.println(Select());
      }
      runSize *= incrementAmount;
    }
  }
}
