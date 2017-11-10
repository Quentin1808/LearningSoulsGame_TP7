package lsg.buffs.rings;

import lsg.characters.Hero;
import lsg.weapons.Sword;

public class RingOfSwords extends Ring{

	/**
	 * Constructeur de l'anneau "Ring OF Sword"
	 */
	public RingOfSwords() {
		super("Ring of Swords", 10) ;
	}

	/**
	 * Méthode qui permet de récupérer la valeur de l'anneau
	 * @return valeur du pouvoir de l'anneau
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null && (hero.getWeapon() instanceof Sword) )  return power ;
		else return 0f ;
		
	}
	
	/**
	 * Un test...
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		Hero hero = new Hero() ;
		RingOfSwords r = new RingOfSwords() ;
		hero.setRing(r, 1);
		hero.setWeapon(new Sword());
		System.out.println(r);
	}
}
