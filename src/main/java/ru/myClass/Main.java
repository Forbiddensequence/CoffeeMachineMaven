package ru.myClass;
import ru.myClass.Coffee.CoffeeMachine;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var coffeeMachine = new CoffeeMachine();
        Scanner in =new Scanner(System.in);
        var coffeeList=new ArrayList<>();
        var commandList=new ArrayList<>(coffeeMachine.getReciepts().keySet());
        commandList.add("water");
        commandList.add("coffee");
        commandList.add("milk");
        while(true){
            String command=in.nextLine();
            command=command.toLowerCase();
            if(command.equals("turn off")){
                break;
            }

            String[] commandWords=command.split(" ");
            if(commandWords.length<2||(!commandList.contains(commandWords[0]))){
               continue;
            }

            try {
                int N=Integer.parseInt(commandWords[1]);
                if(coffeeMachine.isInReciepts(commandWords[0])){
                    coffeeList.add(coffeeMachine.makeCoffe(N,commandWords[0]));
                }
                if(commandWords[0].equals("coffee")){
                    coffeeMachine.addCoffee(N);
                }
                if(commandWords[0].equals("water")){
                    coffeeMachine.addWater(N);
                }
                if(commandWords[0].equals("milk")){
                    coffeeMachine.addMilk(N);
                }
                System.out.println(coffeeMachine.stateOfReservoirs());
            }catch (NumberFormatException e ){
                System.err.println("Error isn't number for this command");
            }

        }
    }
}
