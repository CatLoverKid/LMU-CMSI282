import java.io.*;

    class Food {
        int weight ;
        int cost;
        boolean used;
        public Food (int Weight, int Cost, boolean Used){
            weight = Weight;
            cost = Cost;
            used = Used;
        }
        public String toString(){
            return "(Weight: " + weight + ", Cost: $" + cost + ") ";
        };
    }
    
class SumoSolver {
    public static void storeToString () {
    System.out.println("Money to Spend: $" + amountToSpend);
    for(int i = 0; i < store.length; i ++)if(store[i].used){System.out.print(store[i].toString());}
    }
    
    static int amountToSpend = 0;
    static Food[] store;
    static Food[][][] memo;
    static Food[][] table;
 
    public static void main(String args[]){
        store = new Food[(args.length - 1) / 2];
        amountToSpend = Integer.parseInt(args[args.length - 1]);
        for(int i = 0; i < args.length - 1; i+= 2){store[i / 2] = new Food(Integer.parseInt(args[i]), Integer.parseInt(args[i + 1]), false);}
        table = new Food[amountToSpend][store.length];
        memo = new Food[amountToSpend][store.length][amountToSpend*store.length];
        
        for(int i = 0; i < amountToSpend; i++){
            for(int j = 0; j < store.length; j ++){
                if(store[j] > i){
                    store[j].used = true;
                    
                }
            }
        }
    }
}


