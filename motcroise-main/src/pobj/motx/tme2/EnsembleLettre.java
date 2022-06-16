package pobj.motx.tme2;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author 28600291
 * 
 * Classe représentant un ensemble de lettres
 */
public class EnsembleLettre {
	/** Ensemble de lettres */
	private List<Character> lettres;
	
	/** Construit un ensemble de lettres */
	public EnsembleLettre() {
		lettres = new ArrayList<Character>();
	}
	
	/** Détermine la présence d'une lettre particulière c
	 * 
	 * @param c lettre dont on doit verifier la présence
	 * @return vrai si la lettre est présente dans l'ensemble, faux sinon
	 */
	public boolean contains(Character c) {
		for(Character l : lettres) {
			if (l == c) {
				return true;
			}
		}
		return false;
	}
	
	/** Ajoute le caractère c dans l'ensemble de lettres
	 * 
	 * @param c lettre à ajouter dans l'ensemble
	 */
	public void add(Character c) {
		if (!(lettres.contains(c))) {
			lettres.add(c);
		}
	}
	
	/**Retourne la taille de l'ensemble de lettres */
	public int size() {
		return lettres.size();
	}
	
	/** Accède à l'ensemble de lettres */
	public List<Character> getLettres(){
		return this.lettres;
	}
	
	/** Retourne une copie de l'ensemble de lettre courante */
	public EnsembleLettre copy() {
		EnsembleLettre l = new EnsembleLettre();
		for(Character c : lettres) {
			l.add(c);
		}
		return l;
	}
	
	/** Retourne un ensemble de lettres résultant de l'intersection de l'ensemble courant avec e2
	 * 
	 * @param e2 deuxième ensemble avec lequel on effectue l'intersection
	 * @return intersection des deux ensembles
	 */
	public EnsembleLettre intersection(EnsembleLettre e2) {
		EnsembleLettre e1 = this.copy();
		e1.getLettres().retainAll(e2.getLettres());
		
		return e1;
	}
}
