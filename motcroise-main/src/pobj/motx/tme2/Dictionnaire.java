package pobj.motx.tme2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<>();

	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}
	
	/**
	 * Accès au i-eme mot du dictionnaire.
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param len la longueur voulue 
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	/**Modifie le dictionnaire pour ne garder que les mots dont la ième lettre est égale au caractère de l'argument c
	 * @param c caractère 
	 * @param i place de la lettre dans le mot
	 * @return le nombre de mots qui ont été supprimés du dictionnaire
	 */
	public int filtreParLettre(char c, int i) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for(String m : mots) {
			if (i >= 0 && i < m.length()) {
				if(m.charAt(i) == c) {
					cible.add(m);
				}
				else {
					cpt++;
				}
			}
			else {
				cpt++;
			}
		}
		mots = cible;
		return cpt;
	}
	
	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	
	/** Charge un dictionnaire depuis un fichier texte
	 * @param path Fichier texte
	 * @return un dictionnaire des mots contenus dans path
	 */
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dico = new Dictionnaire();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				dico.mots.add(line);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		return dico;
	}
	
	/** Calcule l'EnsembleLettre possible à une position donnéé
	 * 
	 * @param c
	 * @return
	 */
	public EnsembleLettre calculEnsemble(int c) {
		EnsembleLettre e = new EnsembleLettre();
		
		for(String mot : mots) {
			e.add(mot.charAt(c));
		}
		
		return e;
	}
	
	
	public int filtreParEnsemble(int indice, EnsembleLettre lp) {
		List<String> cible = new ArrayList<String>();
		int cpt=0;
		for(String m : mots) {
			if(lp.contains(m.charAt(indice))) {
				cible.add(m);
			}
			else {
				cpt++;
			}
		}
		mots=cible;
		return cpt;
		
	}
	
}
