package pobj.motx.tme3.adapt;

import java.util.*;
import pobj.motx.tme3.csp.GrilleContrainte;
import pobj.motx.tme3.csp.IVariable;
import pobj.motx.tme2.Dictionnaire;

/**
 * 
 * @author 28600291
 * 
 * Classe DicoVariable qui implémente IVariable
 */
public class DicoVariable implements IVariable {
	/** Indice de l'emplacement du mot correspondant */
	private int index;
	/** Référence à une GrilleContrainte */
	GrilleContrainte gp;
	
	/** Construit un DicoVariable */
	public DicoVariable(int index, GrilleContrainte gp) {
		this.index = index;
		this.gp = gp;
	}
	
	/** Accède à l'index */
	public int getIndex() {
		return index;
	}
	
	/** Renvoie le domaine défini à partir du dictionnaire qui est associé à l'emplacement du mot dans la GrilleContrainte*/
	public List<String> getDomain(){
		List<String> domain = new ArrayList<String>();
		Dictionnaire d = gp.getMotsPot().get(index);
		for(int i=0; i<d.size(); i++) {
			domain.add(d.get(i));
		}
		return domain;
	}
	
	@Override public String toString() {
		StringBuilder s = new StringBuilder();
		List<String> domain = this.getDomain();
		for(String m : domain) {
			s.append(m+"\n");
		}
		return s.toString();
	}
}
