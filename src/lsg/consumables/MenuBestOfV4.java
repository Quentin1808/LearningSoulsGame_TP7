package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class MenuBestOfV4 extends LinkedHashSet<Consumable> {

    public MenuBestOfV4(){
        this.add(new Hamburger());
        this.add(new Wine());
        this.add(new Americain());
        this.add(new Coffee());
        this.add(new Whisky());
        this.add(new RepairKit());
    }


    @Override
    public String toString() {
        String chaine = getClass().getSimpleName() + " :\n";
        int compteur = 1;

        Iterator<Consumable> iterator = this.iterator();
        while(iterator.hasNext()){
            chaine += (compteur) + " : " + iterator.next().toString() + "\n";
            compteur++;
        }

        return chaine;
    }

    public static void main(String[] args) {

        MenuBestOfV4 menu4 = new MenuBestOfV4();
        System.out.println(menu4.toString());
    }
}
