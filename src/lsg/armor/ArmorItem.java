package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible{

    private String name;
    private float armorValue;

    public float getArmorValue() {
        return armorValue;
    }

    public String getName(){
        return name;
    }

    public ArmorItem(String name, float armorValue){
        this.name = name;
        this.armorValue = armorValue;
    }

    @Override
    public String toString() {
        return this.getName() + "(" +this.getArmorValue() + ")";
    }

    @Override
    public int getWeight() {
        return 4;
    }
}
