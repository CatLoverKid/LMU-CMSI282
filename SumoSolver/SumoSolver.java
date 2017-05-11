import java.io.*;
import java.util.*;

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
    static boolean[] initBoolean;
    static boolean[][][] table; 
 
    public static void main(String args[]){
        store = new Food[(args.length + 1) / 2];
        initBoolean = new boolean[(args.length - 1) / 2];
        amountToSpend = Integer.parseInt(args[args.length - 1]);
        for(int i = 1; i < store.length; i+= 2){store[i] = new Food(Integer.parseInt(args[i]), Integer.parseInt(args[i + 1]), false);}
        table = new boolean[store.length][amountToSpend + 1][store.length];
        System.out.println(Arrays.toString(findValue(store.length, amountToSpend, store, initBoolean)));
    }
	
	
	
    static boolean[] findValue(int item, int pocketChange, Food[] store, boolean[] BooleanArray){
		System.out.println();
		System.out.println("NEW LOOP--------------------------------------------------");
		System.out.println(Arrays.toString(BooleanArray));
		System.out.println(store.length);
		System.out.println("Cost: " + store[item].cost +  ", Weight: " + store[item].weight + ", Pocket Change: " + pocketChange);
		
		
        if (item==0|| pocketChange==0){
			System.out.println("Both values are 0");
            table[item][pocketChange] = BooleanArray;
            return BooleanArray;
        }
	
		else if (store[item].cost > pocketChange){
			System.out.println("Item is too Expensive");
            return findValue(item - 1, pocketChange, store, table[item][pocketChange]);
        
		
		}else{
            if(getTotalWeight(findValue(item - 1, pocketChange, store, table[item][pocketChange])) < getTotalWeight(findValue(item - 1, pocketChange - store[item].cost, store, table[item][pocketChange])) + store[item].weight){
                table[item][pocketChange][item] = true;
				System.out.println("Purchased");
				System.out.println(Arrays.toString(table[item][pocketChange]));
                return table[item][pocketChange];
            }else{
				System.out.println("returning: " + BooleanArray);
                return BooleanArray;
            }
        }
	}
	
	
    public static int getTotalWeight(boolean[] array){
            int temp = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i]){temp += store[i].cost;}    
        }
        return temp;
    }
}