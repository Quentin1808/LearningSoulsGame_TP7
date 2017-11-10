package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.Arrays;
import java.util.HashSet;

public class MenuBestOfV2 {

    private HashSet<Consumable> menu = new HashSet<>(Arrays.asList(new Hamburger(), new Wine(), new Americain(), new Coffee(), new Whisky()));

    @Override
    public String toString() {
        String chaine = getClass().getSimpleName() + " :\n";
        int compteur = 1;


        for (Consumable cons : menu){
            chaine += compteur + " : " + cons.toString() + "\n";
            compteur++;
        }

        return chaine;
    }

    public static void main(String[] args) {

        MenuBestOfV2 menu2 = new MenuBestOfV2();
        System.out.println(menu2.toString());
    }
}
