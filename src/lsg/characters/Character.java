package lsg.characters;
import lsg.bags.Bag;
import lsg.bags.Collectible;
import lsg.bags.SmallBag;
import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.helpers.*;
import lsg.weapons.Weapon;

import java.util.Locale;

import static java.lang.String.format;

public abstract class Character {

    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;
    private Dice dice;
    private Weapon weapon;
    public static final String LIFE_STAT_STRING = "life";
    public static final String STAM_STAT_STRING = "stamina";
    public static final String PROTECTION_STAT_STRING = "protection";
    public static final String BUFF_STAT_STRING = "buff";
    private Bag bag;

    private Consumable consumable;

    protected Character() {
        dice = new Dice(101);
        this.bag = new SmallBag();
    }

    public Character(String name) {
        this();
        this.setName(name);
    }

    public int getLife() {
        return life;
    }

    protected void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    protected void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    protected void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public int getStamina() {
        return stamina;
    }

    protected void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable){
        this.consumable = consumable;
    }

    public boolean isAlive() {
        return (this.getLife()>0);
    }

    public void printStats() {
        System.out.println(toString());
    }

    private int attackWith(Weapon weapon){

        int dmg;
        int precision;
        int degats = 0;

        if (weapon.isBroken() || this.getStamina() <= 0){
            weapon.use();
            return 0;
        }else {
            precision = this.dice.roll();

            if (precision == 0){
                dmg = weapon.getMinDamage();
            }else {
                if (precision == 100){
                    dmg = weapon.getMaxDamage();
                }else {
                    dmg = (precision  * (weapon.getMaxDamage() - weapon.getMinDamage()) / 100) + weapon.getMinDamage();

                    degats = (dmg);
                }
            }
            if (this.getStamina() < weapon.getStamCost()){
                degats = degats * this.getStamina() / weapon.getStamCost();
                this.setStamina(0);
            }else {
                int newS;
                newS = this.getStamina() - weapon.getStamCost();
                this.setStamina(newS);
            }
        }
        weapon.use();
        return degats;

    }

    public int attack(){
       return attackWith(this.weapon);
    }

    public int getHitWith(int value){

        if(computeProtection() >= 100){
            return 0;
        }else {

            int dmg = Math.round(value - (value * computeProtection()) / 100);

            dmg = (this.getLife() - dmg < 0) ? this.getLife() : dmg;

            this.setLife(this.getLife() - dmg);
            return dmg;
        }
    }

    @Override
    public String toString() {
        //return "[" + this.getClass().getName() + "]\t" + this.getName() + "\tLIFE: " + this.getLife() + "\tSTAMINA: " + this.getStamina() + "\t" + (this.isAlive()? ("(ALIVE)"):("(DEAD)"));
        String LIFE = format("%5d", this.getLife());
        String STAMINA = format("%5d", this.getStamina());
        return (String.format(Locale.US,"%-20s %-20s "+LIFE_STAT_STRING.toUpperCase() +":%-10s " + STAM_STAT_STRING.toUpperCase() + ":%-10s PROTECTION:%-10s BUFF:%-10s", ("[ " + this.getClass().getSimpleName() + " ]"), this.getName(), LIFE, STAMINA, String.format(Locale.US,"%6.2f", computeProtection()), String.format(Locale.US, "%6.2f", computeBuff())) + (this.isAlive() ? "(ALIVE)" : "(DEAD)"));
//        return (format(Locale.US,"%-20s %-20s LIFE:%-10s STAMINA:%-10s PROTECTION:%-10.2f BUFF:%-10.2f", ("[ " + this.getClass().getSimpleName() + " ]"), this.getName(), LIFE, STAMINA, format(Locale.US,"%6.2f",computeProtection()), format(Locale.US,"%6.2f",computeBuff()))+(this.isAlive()? ("(ALIVE)"):("(DEAD)")));
    }

    protected abstract float computeProtection();

    protected abstract float computeBuff();

    private void drink(Drink boisson){
        System.out.println(this.name + " drinks " + boisson.toString());
        //this.setStamina(getStamina() + boisson.use());
        if(this.getStamina() + boisson.use() <= this.getMaxStamina()){
            this.setStamina(getStamina() + boisson.use());
        }else{
            this.setStamina(this.getMaxStamina());
        }
    }

    private void eat(Food nourriture){
        System.out.println(this.name + " eats " + nourriture.toString());
        //this.setLife(getLife() + nourriture.use());
        //(this.getLife() + nourriture.use() <= this.getMaxLife()) ? this.setLife(getLife() + nourriture.use()) : this.setLife(this.getMaxLife());
        if(this.getLife() + nourriture.use() <= this.getMaxLife()){
            this.setLife(getLife() + nourriture.use());
        }else{
            this.setLife(this.getMaxLife());
        }
    }

    private void repairWeaponWith(RepairKit kit){
        System.out.println(this.name + " repairs " + weapon.toString() + " with " + kit.toString());
        this.weapon.repairWith(kit);
    }

    public void use(Consumable consumable){

        if (consumable instanceof Drink){
                drink((Drink) consumable);
        }else
            if (consumable instanceof Food){
                eat((Food) consumable);
            }
            else if(consumable instanceof RepairKit){
                repairWeaponWith((RepairKit) consumable);
            }

    }

    public void consume(){
        use(consumable);
    }

    public void pickUp(Collectible item){
        if(this.bag != null) {
            this.bag.push(item);
            if(this.bag.contains(item)){
                System.out.print(getName() + " picks up " + item );
            }
        }
    }

    public Collectible pullOut(Collectible item){
        if(this.bag != null){
            System.out.print(getName() + " pulls out " + item );
            return this.bag.pop(item);
        }
        return null;
    }

    public void printBag(){
        System.out.println("BAG : " + this.bag);
    }

    public int getBagCapacity(){
        return this.bag.getCapacity();
    }

    public int getBagWeight(){
        return this.bag.getWeight();
    }

    public Collectible[] getBagItems(){
        return this.bag.getItems();
    }

    public void equip(Weapon weapon){
        if(pullOut(weapon) != null){
            setWeapon(weapon);
            System.out.println(" and equips it !");
        }
    }

    public void equip(Consumable consumable){
        if(pullOut(consumable) != null){
            setConsumable(consumable);
            System.out.println(" and equips it !");
        }
    }

}

//Question 4.2 L'erreur est dû au faites que la méthode computeProtection