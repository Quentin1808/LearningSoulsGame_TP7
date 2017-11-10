package lsg.buffs.rings;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;

public class DragonSlayerRing extends Ring{

	/**
	 * Constructeur de l'anneau "Dragon Slayer Ring"
	 */
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14) ;
	}

	/**
	 * Méthode qui permet de récupérer la valeur de l'anneau
	 * @return valeur du pouvoir de l'anneau
	 */
	@Override
	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}

	/**
	 * Méthode qui parcours les items du Hero et regarde si il possède l'anneau "Dragon Slayer Ring"
	 * @return vrai si le Hero possède l'anneau
	 */
	private boolean hasDragonsSlayerItem(){
		ArmorItem[] items = hero.getArmorItems() ;
		for(ArmorItem item: items){
			if(item instanceof DragonSlayerLeggings) return true ; 
		}
		return false ;
	}
	
}
