package lsg.bags;

import lsg.LearningSoulsGame;

import java.util.HashSet;

public class Bag {

    private int capacity;
    private int weight;
    private HashSet<Collectible> items;

    public Bag(int capacity){
        this.capacity = capacity;
        this.items = new HashSet<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void push(Collectible item){
        if(this.weight + item.getWeight() <= capacity) {
            items.add(item);
            weight = weight + item.getWeight();
        }
    }

    public Collectible pop(Collectible item){

        Collectible i;

       if(items.contains(item)){
           i = item;
           items.remove(item);
           this.setWeight(this.getWeight() - i.getWeight());
           return i;
       }else
           return null;
    }

    public boolean contains(Collectible item){
        return items.contains(item);
    }

    public Collectible[] getItems(){
        return items.toArray(new Collectible[items.size()]);
    }

    @Override
    public String toString() {
        String result = String.format("%s [ %d items | %d/%d kg ]",getClass().getSimpleName(),items.size(), weight, capacity);
        if(items.size() == 0){
            result += "\n" + LearningSoulsGame.BULLET_POINT + "(empty)";
        }
        else{
            for (Collectible item: items) {
                result += "\n"+ LearningSoulsGame.BULLET_POINT + item.toString() + "[" + item.getWeight() + " kg]";
            }
        }
        return result;
    }

    public static void transfer(Bag from, Bag into){
        if(from == into){
            return;
        }
        for(Collectible item: from.getItems()){
            into.push(item);
            if(into.contains(item)){
                from.pop(item);
            }
        }

    }
}
