package pobj.motx.tme1;

/**
 * 
 * @author 28600291
 *
 * Classe de rerésentation  d'une Case de mots croisés
 */

public class Case {
	
	/** numéro de ligne où se trouve la case */
	private int lig;
	/** numéro de colonne où se trouve la case*/
	private int col;
	/** valeur que contient la case*/
	private char c;
	
	/**
	 * Construit une case de valeurs et coordonnées initiales spécifiées
	 * @param lig numéro de ligne de la case
	 * @param col numéro de colonne de la case
	 * @param c valeur de la case
	 * */
	public Case(int lig, int col, char c) {
		this.lig=lig;
		this.col=col;
		this.c=c;
	}
	
	/** Accède au numéro de ligne de la case
	 * @return numéro de ligne lig de la case
	 */
	public int getLig() {
		return lig;
	}
	
	/** Accède au numéro de colonne de la case
	 * @return numéro de colonne col de la case
	 */
	public int getCol() {
		return col;
	}
	
	/** Accède à la valeur contenue dans la case
	 * @return valeur c de la case
	 */
	public char getChar() {
		return c;
	}
	
	/** Modifie la valeur contenue dans la case
	 * @param c nouvelle à mettre dans la case */
	public void setChar(char c) {
		this.c=c;
	}
	
	/** @return true si la case est vide (si la valeur c = ' '), false sinon */
	public boolean isVide() {
		if (c==' ') {
			return true;
		}
		return false;
	}
	
	/** @return true si la case est pleine (noire), false sinon */
	public boolean isPleine() {
		if (c=='*') {
			return true;
		}
		return false;
	}

}
