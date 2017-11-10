package lsg.buffs.talismans;

import java.util.Calendar;

import lsg.buffs.BuffItem;

public class Talisman extends BuffItem {
	
	private float buff ;
	private int start, end ;

	/**
	 * Constructeur de la classe Talisman
	 * @param name Nom du Talisman
	 * @param buff Valeur du buff du Talisman
	 * @param start Date à laquelle commence le buff en question
	 * @param end Date à laquelle se termine le buff en question
	 */
	public Talisman(String name, float buff, int start, int end) {
		super(name) ;
		this.buff = buff ;
		this.start = start ;
		this.end = end ;
	}


	/**
	 * Méthode qui permet de retourner la valeur du buff en fonction de la date et l'heure
	 * @return la valeur du buff
	 */
	@Override
	public float computeBuffValue() {
		int now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
		if(start <= end){
			if(now >= start && now < end) return buff ;
			else return 0f ;
		}else{
			if( (now <= 23 && now >= start) || (now >=0 && now < end)) return buff ;
			else return 0f ;
		}
	}
	
}
