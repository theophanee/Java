package pobj.motx.tme3.csp;


import pobj.motx.tme2.*;


/**
 * 
 * @author 28600291
 * 
 * Classe représentant la contrainte de croisement entre deux mots et une contrainte particulière
 */
public class CroixContrainte implements IContrainte {
	/** Premier emplacement */
	private int m1;
	/** Indice de la case où a lieu ce croisement pour le premier emplacement */
	private int c1;
	/** Deuxième emplacement */
	private int m2;
	/** Indice de la case où a lieu ce croisement pour le deuxième emplacement */
	private int c2;
	
	
	/**
	 * Construit une CroixContrainte représentant la contrainte de croisement entre deux mots m1 et m2
	 * 
	 * @param m1 premier emplacement
	 * @param c1 indice du croisement dans le premier emplacement
	 * @param m2 deuxième emplacement
	 * @param c2 indice du croisement dans le deuxième emplacement
	 */
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}
	
	/** Effectue le principe de réduction sur la GrillePotentiel grille
	 * 
	 * @return le nombre de mots filtrés
	 */
	public int reduce(GrillePotentiel grille) {
		Dictionnaire dm1 = grille.getMotsPot().get(m1);
		Dictionnaire dm2 = grille.getMotsPot().get(m2);
		EnsembleLettre l1 = dm1.calculEnsemble(c1);
		EnsembleLettre l2 = dm2.calculEnsemble(c2);
		EnsembleLettre s = l1.intersection(l2);
		
		int motsfiltres = 0;
		if(l1.size()>s.size()) {
			motsfiltres += dm1.filtreParEnsemble(c1,s);
		}
		
		if(l2.size()>s.size()) {
			motsfiltres += dm2.filtreParEnsemble(c2,s);
		}
		
		return motsfiltres;
	}
	
	/** Teste l'égalité de deux objets */
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof CroixContrainte))
			return false;
		CroixContrainte c = (CroixContrainte)o;
		return this.m1 == c.m1 && this.c1 == c.c1 && this.m2 == c.m2 && this.c2 == c.c2;
	}
}
