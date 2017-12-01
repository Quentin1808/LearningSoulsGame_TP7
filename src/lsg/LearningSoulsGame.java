package lsg;

import lsg.buffs.rings.DragonSlayerRing;
import lsg.buffs.rings.RingOfDeath;
import lsg.buffs.rings.RingOfSwords;
import lsg.characters.*;
import java.lang.Character;

import lsg.consumables.Consumable;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.food.Hamburger;
import lsg.weapons.Weapon;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.armor.*;


import java.util.Scanner;

public class LearningSoulsGame {

    //On déclare 1 Hero et 1 Monstre ainsi qu'un Scanner
    private lsg.characters.Hero hero1 = new Hero();
    private lsg.characters.Character monster1 = new Monster();
    private Scanner scanner = new Scanner(System.in);
    public static final String BULLET_POINT = "\u2219";


    //Méthode refresh qui permet d'afficher les valeurs de chaque combattant
    private void refresh(){

        hero1.printStats();
//        System.out.println(BULLET_POINT + hero1.getWeapon().toString());
//        System.out.println(BULLET_POINT + hero1.getConsumable().toString());
        System.out.println(hero1.armorToString());
        System.out.println(hero1.printRings());
        System.out.println(hero1.printConsummable());
        System.out.println(hero1.printWeapon());
        hero1.printBag();


        System.out.println();
        monster1.printStats();
        System.out.println();
    }

    //Méthode qui permet d'attribuer les armes aux deux combattants
    private void init() {

//        hero1.setWeapon(new Sword());
//        monster1.setWeapon(new Claw());

        hero1.setWeapon(new Sword());
        hero1.setConsumable(new Hamburger());
        ((Hero)hero1).setArmorItem(new DragonSlayerLeggings(), 1);
        RingOfDeath ringOfDeath = new RingOfDeath();
        DragonSlayerRing dragonSlayerRing = new DragonSlayerRing();
        ((Hero)hero1).setRing(ringOfDeath, 1);
        ((Hero)hero1).setRing(dragonSlayerRing, 2);
        monster1 = new Lycanthrope();
    }

    //Méthode dans laquelle les combattants vont être intervertis tant qu'un des deux et vivant
    private void fight1v1() {

        lsg.characters.Character p1 = hero1;
        lsg.characters.Character p2 = monster1;

        int att;
        int dmg;
        int val;

        lsg.characters.Character tmp;
        refresh();
        while(hero1.isAlive() && monster1.isAlive()) {

            if(p1 instanceof Hero) {
                System.out.print("Hero's action for next move : (1) attack | (2) consume > ");
                val = scanner.nextInt();
                //while (val != 1 || val != 2) {
                  //  System.out.print("Hero's action for next move : (1) attack | (2) consume > ");
                  //  val = scanner.nextInt();
                //}
                if (val == 1) {

                    //System.out.print("\nHit enter key for next move > ");
                    //scanner.nextLine();

                    att = p1.attack();
                    dmg = p2.getHitWith(att);
                    System.out.println("\n" + p1.getName() + " attacks " + p2.getName() + " with " + p1.getWeapon().getName() + " (ATTACK:" + att + " | DMG : " + dmg + ")");
                    refresh();
                    tmp = p2;
                    p2 = p1;
                    p1 = tmp;
                } else if (val == 2) {
                    p1.consume();
                    tmp = p2;
                    p2 = p1;
                    p1 = tmp;
                }else{
                    System.out.print("Hero's action for next move : (1) attack | (2) consume > ");
                    val = scanner.nextInt();
                }

            }else
            {
                att = p1.attack();
                dmg = p2.getHitWith(att);
                System.out.println("\n" + p1.getName() + " attacks " + p2.getName() + " with " + p1.getWeapon().getName() + " (ATTACK:" + att + " | DMG : " + dmg + ")");
                refresh();
                tmp = p2;
                p2 = p1;
                p1 = tmp;
            }
        }
        System.out.println("\n--- " + p2.getName() + " WINS !!! ---");
    }

    private void play_v1() {
        init();
        fight1v1();
    }

    private void play_v2(){
        init();
        BlackWitchVeil b = new BlackWitchVeil();
        DragonSlayerLeggings d = new DragonSlayerLeggings();
        RingedKnightArmor r = new RingedKnightArmor();
        ((Hero)hero1).setArmorItem(b,1);
        ((Hero)hero1).setArmorItem(d,2);
        ((Hero)hero1).setArmorItem(r,3);
        fight1v1();
    }

    private void play_v3(){
        init();
//        monster1 = new Lycanthrope();
//
//        BlackWitchVeil b = new BlackWitchVeil();
//        DragonSlayerLeggings d = new DragonSlayerLeggings();
//        RingedKnightArmor r = new RingedKnightArmor();
//        ((Hero)hero1).setArmorItem(b,1);
//        ((Hero)hero1).setArmorItem(d,2);
//        ((Hero)hero1).setArmorItem(r,3);
        fight1v1();
    }

    public void createExhaustedHero(){
        hero1.getHitWith(99);
        hero1.setWeapon(new Weapon("Grosse arme", 0, 0, 1000, 100));
        hero1.attack();
        System.out.println(hero1.toString());
    }

//    public void aTable(){
//        MenuBestOfV4 menu = new MenuBestOfV4();
//        for (Consumable element: menu) {
//            hero1.use(element);
//            System.out.println(hero1.toString());
//        }
//        System.out.println(hero1.getWeapon().toString());
//    }

    private void title(){
        System.out.println("###############################");
        System.out.println("#   THE LEARNING SOULS GAME   #");
        System.out.println("###############################");
        System.out.println();
    }

    public static void main(String[] args) {

        LearningSoulsGame lsg = new LearningSoulsGame();
        //lsg.createExhaustedHero();
        //lsg.aTable();
        //lsg.title();

        lsg.init();
        lsg.refresh();
        //lsg.fight1v1();
       /*Monster M1 = new Monster("STUDENTATORT");
       Monster M2 = new Monster();
       Monster M3 = new Monster();


       System.out.println(Hero1.isAlive());

       Hero1.printStats();
       M1.printStats();
       M2.printStats();
       M3.printStats();*/



    }
}
