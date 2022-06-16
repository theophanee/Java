package pobj.motx.tme3.csp;

import java.util.*;

/**
 * 
 * @author 28600291
 * 
 *Interface représentant un problème CSP
 */
public interface ICSP {
	List<IVariable> getVars();
	boolean isConsistent();
	ICSP assign(IVariable vi, String val);
}
