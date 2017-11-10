package lsg.weapons;

import lsg.bags.Collectible;
import lsg.consumables.repair.RepairKit;

public class Weapon implements Collectible {

    private String name;
    private int minDamage;
    private int maxDamage;
    private int stamCost;
    private int durability;
    public static final String DURABILITY_STAT_STRING = "durability";

    public Weapon(String name, int minD, int maxD, int sc, int dur){
        this.name = name;
        this.minDamage = minD;
        this.maxDamage = maxD;
        this.stamCost = sc;
        this.durability = dur;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    private void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    private void setStamCost(int stamCost) {
        this.stamCost = stamCost;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getStamCost() {
        return stamCost;
    }

    public int getDurability() {
        return durability;
    }

    public void use(){
        this.durability--;
    }

    public boolean isBroken(){
        return (this.getDurability() <= 0);
    }

    @Override
    public String toString() {
        return (this.getName() + " (min:" + this.getMinDamage() + " max:" + this.getMaxDamage() + " stam:" + this.getStamCost() + " dur:" + this.getDurability() + ")");
    }

    public void repairWith(RepairKit kit){
        this.durability += kit.use();
    }

    @Override
    public int getWeight() {
        return 2;
    }
}
