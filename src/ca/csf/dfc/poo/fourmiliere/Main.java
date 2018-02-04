package ca.csf.dfc.poo.fourmiliere;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	private static LinkedList<Fourmiliere> listeFourmiliere = new LinkedList<Fourmiliere>();
	//private static Scanner inputScanner = new Scanner(System. in );

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		afficherMenu();
	}

	public static void afficherMenu() {
		int choix = 0;
		while (choix != 6) {
			System.out.print("Choisir l'une des options suivante: \n"
					+ "1. Créer une fourmilière.\n"
					+ "2. Afficher une fourmilière.\n"
					+ "3. Simuler une fourmilière.\n"
					+ "4. Modifier une fourmilière.\n"
					+ "5. Guerre de fourmilières.\n"
					+ "6. Quitter.\n");
			choix = validerInt(1,6);
			switch (choix) {
			case 1:
				// Création d'une fourmilière
				creationFourmiliere();
				break;
			case 2:
				// Affichage d'une fourmilière
				if (listeFourmiliere.size() > 0) {
					System.out.println("Choisir la fourmilière à afficher: ");
					int choixF = 0;
					for (Fourmiliere f : listeFourmiliere) {
						System.out.println(choixF +1 + ". " + f.getEspeceFourmis().toString());
						choixF++;
					}
					Fourmiliere temp = null;
					int choixFourmiliere = validerInt(1, choixF);
					for (Fourmiliere f: listeFourmiliere) {
						System.out.println("entre la loop de selection");
						System.out.println(Especes.values()[choixFourmiliere-1]);
						if (f.getEspeceFourmis().equals(Especes.values()[choixFourmiliere-1])) {
							temp = f;
							System.out.println(temp);
						}
					}
					if (temp != null) {
						afficherFourmiliere(temp);
					}
				}
				else {
					System.out.print("Aucune fourmilière de présente, veuillez commencer par en créer une!\n");
				}
				break;
			case 3:
				// Simuler les fourmilière
				if (listeFourmiliere.size() > 0) {
					System.out.println("Choisir le nombre de jours à simuler: ");
					int nbJours = validerInt(1, 2500);
					for (int i = 0; i < nbJours; i++) {
						simuler();
					}
				}
				else {
					System.out.println("Aucune fourmilière présente dans la liste!");
				}
				break;
			case 4:
				// Modifier une fourmilière
				if (listeFourmiliere.size() > 0) {
					System.out.print("Choisir l'espèce que vous voulez modifier: \n");
					int choixF = 0;
					for (Fourmiliere f : listeFourmiliere) {
						System.out.println(choixF +1 + ". " + f.getEspeceFourmis().toString());
						choixF++;
					}
					int choixFourmiliere = validerInt(1, choixF);
					System.out.print("La quantité de reines à ajouter: \n");
					int nbReines = validerInt(0, 25);
					System.out.print("La quantité de nourriture à ajouter: \n");
					int nbNourriture = validerInt(0, 100);
					Fourmiliere temp = null;
					for (Fourmiliere f: listeFourmiliere) {
						if (f.getEspeceFourmis().equals(Especes.values()[choixFourmiliere-1])) {
							temp = f;
						}
					}
					modifier(temp, nbReines, nbNourriture);
				}
				else {
					System.out.print("Aucune fourmilière de présente dans la liste!\n");
				}
				break;
			case 5:
				// Faire la guerre entre fourmilière
				if (listeFourmiliere.size() > 0) {
					ArrayList<Fourmiliere> listeOfferte = new ArrayList<Fourmiliere>();
					for (Fourmiliere fourmiliere : listeFourmiliere) {
						if (fourmiliere.getEstEnGuerreAvec() == null) {
							listeOfferte.add(fourmiliere);
						}
					}
					Fourmiliere f1 = null;
					Fourmiliere f2 = null;
					boolean choixCorrect = false;
					do {
						System.out.println("Choisir la 1 ère fourmilère qui va entrer en guerre: ");
						int choixF1 = 0;
						for (Fourmiliere f : listeOfferte) {
							System.out.println(choixF1 +1 + ". " + f.getEspeceFourmis().toString());
							choixF1++;
						}
						choixF1 = validerInt(1, choixF1 +1);
						for (Fourmiliere f: listeFourmiliere)
							if (f.getEspeceFourmis().equals(Especes.values()[choixF1-1])) {
								f1 = f;
							}
						System.out.println("Choisir la 2e fourmilère: ");
						int choixF2 = 0;
						for (Fourmiliere f : listeFourmiliere) {
							System.out.println(choixF2 +1 + ". " + f.getEspeceFourmis().toString());
							choixF2++;
						}
						choixF2 = validerInt(1, choixF2 +1);
						for (Fourmiliere f: listeFourmiliere)
							if (f.getEspeceFourmis().equals(Especes.values()[choixF2-1])) {
								f2 = f;
							}
						if (f1 != f2) {
							choixCorrect = true;
						}
						else {
							System.out.println("La fourmilière a été choisit 2 fois!");
						}
					} while (!choixCorrect);
					guerre(f1, f2);
				}
				else {
					System.out.print("Aucune fourmilière de présente dans la liste!\n");
				}
				break;
			case 6:
				System.out.println("Aurevoir!");
				choix = 6;
				break;
			default:
				break;
			}
		}
		//inputScanner.close();
	}
	
	/**
	 * Méthode pour construire une fourmilière
	 */
	public static void creationFourmiliere() {
		boolean especeOK = false;
		int choixEspece = 0;
		System.out.print("Quantité de reines désirée? \n");
		int nbReines = validerInt(1, 10);
		System.out.print("Quantité de nourriture? \n");
		int nbNourriture = validerInt(1, 100);
		while (!especeOK) {
			especeOK = true;
			System.out.print("L'espèce des fourmis pour la fourmilière? \n");
			int nbEspece = 0;
			for (Especes espece : Especes.values()) {
				System.out.println((nbEspece + 1) + ". " + espece);
				nbEspece++;
			}
			boolean valide = false;
			do {
				System.out.print("Choisissez l'espèce de votre fourmillière: \n");
				choixEspece = validerInt(1, nbEspece + 1);
				valide = choixEspece >= 1 && choixEspece <= nbEspece;
				if (!valide) {
					System.out.println("Saisir une valeur entre 1 et " + nbEspece + " inclus.");
				}
			} while (!valide);
			for (Fourmiliere f: listeFourmiliere) {
				if (f.getEspeceFourmis().equals(Especes.values()[choixEspece-1])) {
					System.out.println("Une fourmilière de la même espèce existe déjà, choisir un autre.");
					especeOK = false;
				}
			}
			if (especeOK) {
				listeFourmiliere.add(new Fourmiliere(nbReines, nbNourriture, Especes.values()[choixEspece-1]));
			}
		}
		System.out.println("La fourmilière a été ajoutée!");
	}
		
	/**
	 * Méthode pour modifier une foumilière
	 * @param f (foumilière à modifier)
	 * @param p_nbReines (nombre de reine à ajouter)
	 * @param p_nbNourriture (nombre de nourriture à ajouter)
	 */
	public static void modifier(Fourmiliere f, int p_nbReines, int p_nbNourriture) {
		Fourmiliere maFourmilieretemp = null;
		for (Fourmiliere liste: listeFourmiliere) {
			if (liste.getEspeceFourmis().equals(f.getEspeceFourmis())) {
				maFourmilieretemp = liste;
			}
		}
		maFourmilieretemp.setNbNourriture(maFourmilieretemp.getNbNourriture() + p_nbNourriture);
		for (int i = 0; i < p_nbReines; i++) {
			maFourmilieretemp.listeFourmis.add(new Reines(maFourmilieretemp));
			maFourmilieretemp.setNbReine(maFourmilieretemp.getNbReine() + 1);
		}
	}
	
	/**
	 * Méthode pour afficher une fourmilière
	 * @param p_fourmiliere
	 */
	public static void afficherFourmiliere(Fourmiliere p_fourmiliere) {		
		System.out.println(p_fourmiliere);
	}
	
	/**
	 * Méthode pour simuler les fourmilières
	 */
	public static void simuler() {
		for (Fourmiliere fourmiliere : listeFourmiliere) {
			fourmiliere.OperationJournaliere();
		}
	}
	
	/**
	 * Méthode pour mettre en guerre 2 fourmilières
	 * @param p_fourmiliere1
	 * @param p_fourmiliere2
	 */
	public static void guerre(Fourmiliere p_fourmiliere1, Fourmiliere p_fourmiliere2) {
		if (listeFourmiliere.size() > 1) {
			p_fourmiliere1.setEstEnGuerreAvec(p_fourmiliere2);
			p_fourmiliere2.setEstEnGuerreAvec(p_fourmiliere1);	
			listeFourmiliere.remove(p_fourmiliere1);
			listeFourmiliere.addFirst(p_fourmiliere1);
		}
		else {
			System.out.println("Doit avoir au moins 2 fourmilières pas en guerre!");
		}
	}
	
	/**
	 * Méthode pour faire la validation de la saisit d'entier seulement
	 * @param p_Min
	 * @param p_Max
	 * @return
	 */
	public static int validerInt(int p_Min, int p_Max){
		int result = -1;
		do {
			Scanner inputScanner = new Scanner(System. in );
			if (inputScanner.hasNextInt()) {
				result = inputScanner.nextInt();
				if (result < p_Min || result > p_Max) {
					System.out.println("Valeur erroné: saisir un nombre entre " + p_Min + " et " + p_Max);
				}
			}
			else {
				System.out.println("Type erroné: saisir un nombre");
				result = -1;
			}
		} while (result < p_Min || result > p_Max);
		return result;
	}

}
