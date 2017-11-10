package lsg.bags;

import java.util.HashSet;

public class Bag {

    private int capacity;
    private int weight;
    private HashSet<Collectible> items;

    public Bag(int capacity){
        this.capacity = capacity;
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
        items.add(item);
        this.setWeight(item.getWeight());
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
        //Collectible ListeItems [] = new Collectible [];
        int i = 0;

        for (Collectible item : items){
            //ListeItems[i] = item;
            i++;
        }
        int c =0;
        Collectible ListeItems [] = new Collectible [i];
        for (Collectible item : items){
            ListeItems[c] = item;
            c++;
        }

        return ListeItems;
    }

    @Override
    public String toString() {

        String chaine = getClass().getSimpleName() + " [ " + items.size() + " items | " + this.getWeight() + "/" + this.getCapacity() + " kg ]";



        return chaine;
    }
}
