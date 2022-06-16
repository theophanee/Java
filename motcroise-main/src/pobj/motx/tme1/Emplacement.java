package pobj.motx.tme1;
import java.util.ArrayList;

/**
* 
* @author 28600291
*
* Classe de rerésentation  des empacement des mots dans la grille mots croisés
*/
public class Emplacement {
	/** Représente les cases (contiguës) de la grille qui composent l’emplacement du mot */
	private ArrayList<Case> cases;
	
	/** Construit un emplacement initialement vide */
	public Emplacement() {
		cases = new ArrayList<>();
	}
	
	/**Ajoute une case à l'emplacement
	 * @param e case à ajouter à l'emplacement
	 */
	public void addCase(Case e) {
		cases.add(e);
	}
	
	/** Donne la taille (nombre de cases) de l'emplacement
	 * @return taille de l'empacement
	 */
	public int size() {
		return cases.size();
	}
	
	/** Accède à la case i de l'empacement
	 * @param i indice de la case à retrouver
	 * @return case d'indice i de l'emplacement
	 */
	public Case getCase(int i) {
		return cases.get(i);
	}
	
	/** Permet d’afficher le mot à cet emplacement */
	@Override public String toString() {
		String s = "";
		for(Case cas : cases) {
			s+=cas.getChar();
		}
		return s;
	}
	
	public boolean hasCaseVide() {
		for(Case c : cases) {
			if(c.isVide()) {
				return true;
			}
		}
		return false;
	}
}
