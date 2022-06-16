package pobj.motx.tme3.csp;

import java.util.List;
import java.util.ArrayList;
import pobj.motx.tme1.*;
import pobj.motx.tme2.*;

/**
 * 
 * @author 28600291
 * 
 * Classe représentant une GrillePotentiel qui prend en plus en compte les contraintes de croisements
 */

public class GrilleContrainte extends GrillePotentiel {
	/** Liste des contraintes de croisement */
	private List<IContrainte> contraintes;
	
	/** Construit une Grille Contrainte à partir d'une GrillePlaces et d'un Dictionnaire
	 * 
	 * @param grille une GrillePlaces
	 * @param dicoComplet Dictionnaire complet français
	 */
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		contraintes = new ArrayList<IContrainte>();
		
		int nbH = grille.getNbHorizontal();
		List<Emplacement> placements = grille.getPlaces();
		
		for(int i=0; i<nbH; i++) {
			for(int j=nbH; j<placements.size(); j++) {
				Emplacement h = placements.get(i);	//emplacements horizontaux
				Emplacement v = placements.get(j);	//emplacements verticaux
				
				for(int m=0; m<h.size(); m++) {
					for(int n=0; n<v.size(); n++) {
						if((h.getCase(m) == v.getCase(n)) && h.getCase(m).isVide()) {
							CroixContrainte c = new CroixContrainte(i,m,j,n);
							c.reduce(this);
							contraintes.add(c);
							
						}
					}
				}
			}
		}
		propage();
	}
	
	/** Initialise une nouvelle GrilleContrainte avec la grille résultant d'une nouvelle grille où les cases constituant l’emplacement de mot d’indice m qui ont pour contenu les lettres de soluce
	 * 
	 * @param m numéro de l'emplacement
	 * @param soluce
	 * @return
	 */
	public GrilleContrainte fixer(int m, String soluce) {
		return new GrilleContrainte(this.getGrille().fixer(m, soluce), this.getDicoComplet());
	}
	
	/** Accède à la liste des contraintes */
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	
	/** Réalise la propagation des contraintes */
	private boolean propage() {
		
		while(true) {
			int cpt = 0;
			for(IContrainte c : contraintes) {
				cpt += c.reduce(this);
			}
			if(this.isDead()) {
				return false;
			}
			if(cpt == 0) {
				return true;
			}
		}
	}
}
