package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

public class MenuBestOfV1 {

    private Consumable menu[] = new Consumable[]{new Hamburger(), new Wine(), new Americain(), new Coffee(), new Whisky()};

    @Override
    public String toString() {
        String chaine = getClass().getSimpleName() + " :\n";

        for (int i =0; i<menu.length; i++){
            chaine += i+1 + " : " + menu[i].toString() + "\n";
        }

        return chaine;
    }

    public static void main(String[] args) {

        MenuBestOfV1 menu1 = new MenuBestOfV1();
        System.out.println(menu1.toString());
    }
}
