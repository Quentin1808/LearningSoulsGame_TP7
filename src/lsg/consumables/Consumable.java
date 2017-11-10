package lsg.consumables;

import lsg.bags.Collectible;

public class Consumable implements Collectible {

    private String name;
    private int capacity;
    private String stat;

    public Consumable(String name, int capacity, String stat){
        this.name = name;
        this.capacity = capacity;
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return this.getName() + " [" + this.getCapacity() + " " + this.getStat() + " point(s)]";
    }

    public int use(){

        int cap = this.getCapacity();
        this.setCapacity(0);
        return cap;

    }

    @Override
    public int getWeight() {
        return 1;
    }
}
