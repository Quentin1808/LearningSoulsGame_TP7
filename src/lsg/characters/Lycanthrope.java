package lsg.characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster{

    public Lycanthrope(){
        super("Lycanthrope");
        Claw c = new Claw();
        this.setWeapon(c);
        this.setSkinThickness(30.0f);
    }
}
