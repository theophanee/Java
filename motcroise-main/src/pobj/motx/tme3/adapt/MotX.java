package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme3.csp.GrilleContrainte;
import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IVariable;

/**
 * 
 * @author 28600291
 * 
 * Classe MotX qui implémente ICSP
 */
public class MotX implements ICSP {
	
	private List<IVariable> vars;
	private GrilleContrainte gc;
	
	/** Construit un MotX qui initialise une liste de DicoVariable */
	public MotX(GrilleContrainte gc) {
		this.gc = gc;
		vars = new ArrayList<IVariable>();
		List<Emplacement> emplacements = gc.getGrille().getPlaces();
		
		for(int i=0; i<emplacements.size(); i++) {
			Emplacement e = emplacements.get(i);
			if (e.hasCaseVide()) {
				vars.add(new DicoVariable(i, gc));
			}
		}
		
	}
	
	/** Accède à la GrilleContrainte */
	public GrilleContrainte getGc() {
		return gc;
	}
	
	/** Accède au variables du problème */
	@Override
	public List<IVariable> getVars() {
		return vars;
	}
	
	/** Teste si un problème est encore satisfiable */
	@Override
	public boolean isConsistent() {
		return !(gc.isDead());
	}
	
	/** Affecte une des variables du problème
	 * Renvoie un nouveau problème CSP, de même nature que le précédent, mais qui compte une variable de moins (sa valeur étant fixée)
	 */
	@Override
	public ICSP assign(IVariable vi, String val) {
		if(vi instanceof DicoVariable) {
			DicoVariable dv = (DicoVariable)vi;
			return new MotX(gc.fixer(dv.getIndex(), val));
		}
		return new MotX(gc);
	}

}
