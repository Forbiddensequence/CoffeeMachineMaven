package ru.myClass.Coffee;

class Coffee {
    private int milliliters;
    private String name;

    public int getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(int milliliters) {
        this.milliliters = milliliters;
    }

    public Coffee(int milliliters, String name) {
        this.milliliters = milliliters;
        this.name = name;
    }
}
