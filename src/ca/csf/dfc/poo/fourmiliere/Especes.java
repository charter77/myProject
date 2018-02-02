package ca.csf.dfc.poo.fourmiliere;

public enum Especes {
	JAUNES("Jaunes"), ROUGES("Rouges"), NOIRS("Noirs"), BRUNES("Brunes"), VERTES("Vertes");
	
	private String m_espece;
	
	private Especes(String p_espece) {
		this.m_espece = p_espece;
	}
	
	public String toString() {
		return this.m_espece;
	}
}
