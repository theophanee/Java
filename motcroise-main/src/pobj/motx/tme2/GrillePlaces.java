package pobj.motx.tme2;
import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;
import pobj.motx.tme1.Case;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 28600291
 *
 * Classe qui explore une Grille pour trouver tous les emplacements des mots qu'elle contient
 */

public class GrillePlaces {
	/** Emplacements de mots détectés */
	private List<Emplacement> places;
	/** Grille fournie */
	private Grille g;
	/** Nombre d'emplacements horizontaux */
	private int nbHorizontal;
	
	
	/** Construit une GrillePlaces à partir d'une Grille
	 * @param grille Grille pour laquelle on cherche les emplacements
	 */
	public GrillePlaces(Grille grille) {
		places = new ArrayList<Emplacement>();
		g = grille;
		int lig = grille.nbLig();
		int col = grille.nbCol();
		
		for(int i=0; i<lig; i++) {
			cherchePlaces(getLig(i));
		}
		nbHorizontal = places.size();
		
		for(int j=0; j<col; j++) {
			cherchePlaces(getCol(j));
		}
	}
	
	/** Retourne les cases qui constituent une ligne donnée sans les copier
	 * 
	 * @param lig Ligne pour laquelle on retourne les cases
	 * @return La liste des cases qui constituent la ligne lig
	 */
	private List<Case> getLig(int lig){
		ArrayList<Case> cases = new ArrayList<Case>();
		for (int j=0; j<g.nbCol(); j++) {
			cases.add(g.getCase(lig,j));
		}
		return cases;
	}
	
	
	/** Retourne les cases qui constituent une colonne donnée sans les copier
	 * 
	 * @param col Colonne pour laquelle on retourne les cases
	 * @return La liste des cases qui constituent la colonne col
	 */
	private List<Case> getCol(int col){
		ArrayList<Case> cases = new ArrayList<Case>();
		for (int i=0; i<g.nbLig(); i++) {
			cases.add(g.getCase(i,col));
		}
		return cases;
	}
	
	
	/**Cherche les emplacements dans la liste de cases fournie et les ajoute à la liste des emplacements List<Emplacement>
	 * Un emplacement de mot est défini dès que nous avons deux cases contiguës non pleines (donc vides ou avec une lettre déjà placée)
	 * @param cases Liste de cases qui constituent une ligne ou une colonne
	 */
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for(int i=0; i<cases.size(); i++) {
			Case c = cases.get(i);
			if(!c.isPleine()) {
				e.addCase(c);
			}
			else {
				if(e.size()>=2) {
					places.add(e);
				}
				e = new Emplacement();
			}
		}
		if (e.size() >=2) {
			places.add(e);
		}
	}
	
	/** Accède à la valeur nbHorizontal (le nombre d'emplacements horizontaux)
	 * @return nbHorizontal
	 */
	public int getNbHorizontal() {
		return nbHorizontal;
	}
	
	
	/** Accède à la liste d'emplacements de la Grille
	 * @return places La liste des emplacements
	 */
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	@Override public String toString() {
		String s="";
		for (int i=0; i< places.size(); i++) {
			s+= i +" "+ places.get(i)+" ";
		}
		return s;
	}
	
	
	/** Retourne une nouvelle grille où les cases constituant l’emplacement de mot d’indice m qui ont pour contenu les lettres de soluce
	 *
	 * @param m numéro de l'emplacement
	 * @param soluce 
	 * @return nouvelle grille où les cases constituant l’emplacement de mot d’indice m ont pour contenu les lettres de soluce
	 */
	public GrillePlaces fixer(int m, String soluce) {
		Grille g2 = this.g.copy();
		Emplacement e = this.getPlaces().get(m);
		
		for(int i=0; i<e.size(); i++) {
			Case c = e.getCase(i);
			int ligC = c.getLig();
			int colC = c.getCol();
			g2.getCase(ligC, colC).setChar(soluce.charAt(i));
		}
		return new GrillePlaces(g2);
	}
	
	
}
