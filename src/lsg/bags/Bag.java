package lsg.bags;

import lsg.LearningSoulsGame;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.consumables.food.Hamburger;
import lsg.weapons.Sword;

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
        String str = getClass().getSimpleName() + " [ " + items.size() + " items | " + weight + "/" + capacity + " kg ]\n";
        if(items.isEmpty()){
            str += LearningSoulsGame.BULLET_POINT +" (empty)";
        }
        else {
            for (Collectible item : items) {
                str += LearningSoulsGame.BULLET_POINT + " " + item.toString() + "["+item.getWeight()+" kg]\n";
            }
        }
        return str;
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

    public static void main(String[] args) {
        DragonSlayerLeggings DSL = new DragonSlayerLeggings();
        SmallBag bag = new SmallBag();
        bag.push(new BlackWitchVeil());
        bag.push(DSL);
        bag.push(new Sword());
        bag.push(new Hamburger());
        System.out.println(bag.toString());
        bag.pop(DSL);
        System.out.println("Pop sur "+DSL.toString());
        System.out.println();
        System.out.println(bag.toString());
    }


}
