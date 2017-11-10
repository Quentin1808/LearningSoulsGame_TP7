package lsg.buffs.rings;

import lsg.buffs.BuffItem;
import lsg.characters.Hero;

public abstract class Ring extends BuffItem {
	
	protected int power ; 
	protected Hero hero ;

	/**
	 * Constructeur de Ring
	 * @param name nom de l'anneau
	 * @param power puissance de l'anneau
	 */
	public Ring(String name, int power) {
		super(name) ;
		this.power = power ;
	}

	/**
	 * Méthode qui permet d'attribuer un Hero
	 * @param hero Hero qui va recevoir l'anneau en question
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Hero getHero() {
		return hero;
	}

	/**
	 * Méthode qui retourne La puissance de l'anneau
	 * @return valeur de la puissance du Hero
	 */
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
