package ru.myClass.Coffee;

import java.util.HashMap;

public class CoffeeMachine {
    private int coffeeLevel,milkLevel,waterLevel;

    public HashMap<String, double[]> getReciepts() {
        return reciepts;
    }

    private HashMap<String,double[]> reciepts;
    public int getCoffeeLevel() {
        return coffeeLevel;
    }

    public void setCoffeeLevel(int coffeeLevel) {
        this.coffeeLevel = coffeeLevel;
    }

    public int getMilkLevel() {
        return milkLevel;
    }

    public void setMilkLevel(int milkLevel) {
        this.milkLevel = milkLevel;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public CoffeeMachine(int coffeeLevel, int milkLevel, int waterLevel) {
        this();
        this.coffeeLevel = coffeeLevel;
        this.milkLevel = milkLevel;
        this.waterLevel = waterLevel;
    }

    public CoffeeMachine() {
        this.coffeeLevel = 0;
        this.milkLevel = 0;
        this.waterLevel = 0;
        reciepts=new HashMap<>();
        reciepts.put("ristretto",new double[]{0.5,0.5,0});
        reciepts.put("cappuccino",new double[]{0.15,0.4,0.45});
        reciepts.put("lungo",new double[]{0.15,0.85,0});
        reciepts.put("espresso",new double[]{0.3,0.7,0});
        reciepts.put("latte",new double[]{0.1,0.3,0.60});
    }

    public Coffee makeCoffe(int N, String coffeName){
        if(N<10) return null;
        if(reciepts.get(coffeName)==null) return null;
        int neededCoffe=(int)(reciepts.get(coffeName)[0]*N);
        int neededWater=(int)(reciepts.get(coffeName)[1]*N);
        int neededMilk=(int)(reciepts.get(coffeName)[2]*N);
        if(!((neededCoffe<= getCoffeeLevel())&&(neededWater<=getWaterLevel())&&(neededMilk<=getMilkLevel()))){
            return null;
        }
        addCoffee(-neededCoffe);
        addWater(-neededWater);
        addMilk(-neededMilk);
        return new Coffee(N,coffeName);
    }

    public Coffee makeRistretto(int N){
        return makeCoffe(N,"ristretto");
    }

    public Coffee makeCappucino(int N){
        return makeCoffe(N,"cappuccino");
    }

    public Coffee makeLungo(int N){
        return makeCoffe(N,"lungo");
    }

    public Coffee makeEspresso(int N){
        return makeCoffe(N,"espresso");
    }

    public Coffee makeLatte(int N){
        return makeCoffe(N,"latte");
    }

    public void addCoffee(int N){
        if((getCoffeeLevel()+N)<0){
           return;
        }
        setCoffeeLevel(getCoffeeLevel()+N);
    }

    public void addMilk(int N){
        if((getMilkLevel()+N)<0){
            return;
        }
        setMilkLevel(getMilkLevel()+N);
    }

    public void addWater(int N){
        if((getWaterLevel()+N)<0){
            return;
        }
        setWaterLevel(getWaterLevel()+N);
    }

    public String stateOfReservoirs(){
        return getCoffeeLevel()+" "+getWaterLevel()+" "+getMilkLevel();
    }

    public boolean isInReciepts(String coffeetype){
        return reciepts.get(coffeetype) != null;
    }
}

