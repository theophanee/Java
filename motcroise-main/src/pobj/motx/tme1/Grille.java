package pobj.motx.tme1;

/**
* 
* @author 28600291
*
* Classe de rerésentation  d'une Grille de mots croisés
*/
public class Grille {
	/** Matrice de cases représentant la grille*/
	private Case[][] cases;
	
	/**
	 * Construit une grille de hauteur lignes sur largeur colonnes
	 * @param hauteur nombre de lignes dans la grille
	 * @param largeur nombre de colonnes dans la grille
	 * */
	public Grille(int hauteur, int largeur) {
		cases=new Case[hauteur][largeur];
		for (int i=0; i<hauteur; i++) {
			for (int j=0; j<largeur; j++) {
				cases[i][j]= new Case(i,j,' ');
			}
		}
	}
	
	/** Accède à la case de la grille situé à la hauteur lig et largeur col
	 * @param lig de la case
	 * @param col de la case
	 * @return la case de la grille situé à la hauteur lig et largeur col
	 */
	public Case getCase(int lig, int col) {
		return cases[lig][col];
	}
	
	/** Donne la hauteur (nombre de lignes) de la grille*/
	public int nbLig() {
		return cases.length;
	}
	
	/** Donne la largeur (nombre de colonnes) de la grille */
	public int nbCol() {
		return cases[0].length;
	}
	
	/** Retourne une copie à l’identique de la grille courante */
	public Grille copy() {
		int nblig=this.nbLig();
		int nbcol=this.nbCol();
		
		Grille g = new Grille(nblig,nbcol);
		
		for (int i=0; i<nblig; i++) {
			for(int j=0; j<nbcol; j++) {
				g.cases[i][j].setChar(this.cases[i][j].getChar());
			}
		}
		return g;
	}
	
	/** Permet d’afficher une grille sur la consolede façon « lisible » */
	@Override public String toString() {
		return GrilleLoader.serialize(this, false);
	}

}
