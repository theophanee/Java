package pobj.motx.tme2;

import java.util.List;
import java.util.ArrayList;
import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;
import pobj.motx.tme1.Case;

/**
 * 
 * @author 28600291
 * 
 * Classe qui enrichit la classe GrillePlaces en associant chaque emplacement de mot à son domaine potentiel
 *
 */
public class GrillePotentiel {
	/** Stocke la grille actuelle (partiellement remplie) */
	private GrillePlaces grille;
	/** Stocke le dictionnaire français complet */
	private Dictionnaire dicoComplet;
	/** Stocke le domaine potentiel de chaque emplacement dans la grille */
	private List<Dictionnaire> motsPot;
	
	
	/**
	 * Construit une GrillePotentiel en initialisant les attributs aux valeurs données et le domaine des emplacements
	 * @param grille Grille actuelle
	 * @param dicoComplet Dictionnaire complet français
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		
		this.grille = grille;
		this.dicoComplet = dicoComplet;
		motsPot = new ArrayList<>();
		
		int tailleG = grille.getPlaces().size();
		
		for(int i=0; i<tailleG; i++) {
			Dictionnaire dicoPartiel = dicoComplet.copy();
			Emplacement e = grille.getPlaces().get(i);
			
			int tailleMot = e.size();
			dicoPartiel.filtreLongueur(tailleMot);
			
			for (int j=0; j< e.size(); j++) {
				if (!(e.getCase(j).isVide())){
					char chCase = e.getCase(j).getChar();
					dicoPartiel.filtreParLettre(chCase,j);
				}
			}
			
			motsPot.add(dicoPartiel);
			
		}
	}
	
	
	/**Retourne vrai si et seulement si un emplacement a un domaine potentiel vide */
	public boolean isDead() {
		for(Dictionnaire d : motsPot) {
			if (d.size() == 0) {
				return true;
			}
		}
		return false;
	}
	
	
	/**Accède à la grille actuelle
	 * 
	 * @return grille La grille actuelle
	 */
	public GrillePlaces getGrille() {
		return grille;
	}
	
	
	/** Accède au dictionnaire français complet
	 * 
	 * @return dicoComplet le dictionnaire complet
	 */
	public Dictionnaire getDicoComplet() {
		return dicoComplet;
	}
	
	
	/** Accède à la liste des domaines potentiels de chaque emplacement 
	 * 
	 * @return motsPot la liste des domaines potentiels
	 */
	public List<Dictionnaire> getMotsPot(){
		return motsPot;
	}
	
	/** Initialise une nouvelle GrillePotentiel avec la grille résultant d'une nouvelle grille où les cases constituant l’emplacement de mot d’indice m qui ont pour contenu les lettres de soluce
	 * 
	 * @param m numéro de l'emplacement
	 * @param soluce
	 * @return
	 */
	public GrillePotentiel fixer(int m, String soluce) {
		return new GrillePotentiel(grille.fixer(m, soluce), dicoComplet);
	}
}
