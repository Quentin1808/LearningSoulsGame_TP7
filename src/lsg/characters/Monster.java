package lsg.characters;

import lsg.buffs.talismans.Talisman;

public class Monster extends Character {

    private static int INSTANCES_COUNT = 0;
    private float skinThickness = 20;
    private Talisman talisman;

    public Monster() {
        super();
        INSTANCES_COUNT++;
        this.setName("Monster_" + INSTANCES_COUNT);
        this.setLife(10);
        this.setStamina(10);
        this.setMaxLife(10);
        this.setMaxStamina(10);

    }

    public Monster(String name) {
            this();
            this.setName(name);

    }

    protected void setSkinThickness(float skinThickness){
        this.skinThickness = skinThickness;
    }

    public float getSkinThickness(){
        return skinThickness;
    }

    public Talisman getTalisman() {
        return talisman;
    }

    public void setTalisman(Talisman talisman) {
        this.talisman = talisman;
    }

    @Override
    protected float computeProtection() {
        return getSkinThickness();
    }

    @Override
    protected float computeBuff() {
        return (talisman == null)? 0 : talisman.computeBuffValue();
    }
}
