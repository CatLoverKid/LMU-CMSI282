import java.io.*;

class formRdmNum{

  private double numOfNum;
  static private double currentNum = 0;

  public static void main(String args[]){
    if(args[0] == null || args[1] == null){
      System.out.println("Expected input of type integer and String");
    }else{
      System.out.println("Sending " + args[0] + " random integers to: " + args[1] + ".numbers");
    }
    try {
      File statText = new File(".\\" + args[1] + ".numbers");
      FileOutputStream is = new FileOutputStream(statText);
      OutputStreamWriter osw = new OutputStreamWriter(is);    
      Writer w = new BufferedWriter(osw);


      for(double i = 0; i < Double.parseDouble(args[0]); i++){
        currentNum = Math.random() * 1000;
        w.write((int) currentNum + "\n");
      }
      w.close();

    } catch (IOException e){
      System.err.println("Problem writing to the file");
    }
  }
}
