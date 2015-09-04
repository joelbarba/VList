package joel.barba;

public class CVistaItem {

	public long id_item;
	public String nom;
	public String imatge;
	public long nivell_sel;
	public boolean sel;

	public CVistaItem(long id, String nom, String imatge, long nivell_sel) {
		this.id_item = id;
		this.nom = nom;
		this.imatge = imatge;
		this.sel = false;
		this.nivell_sel = nivell_sel;
	}
	
	public void setItem(long id, String nom, String imatge) { 
		//this.id_item = id;
		//this.nom = nom;
		//this.imatge = imatge;		
	}



	
}
