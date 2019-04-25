package businessLogikPackage;

public class FilmModel {
	
	public FilmModel(String bezeichnung, int id) {
		this.bezeichnung = bezeichnung;
		this.id = id;
	}
	
	private String bezeichnung;
	private int id;	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setBezeichnung(String bezeichnung){
		this.bezeichnung = bezeichnung;
	}
	
	public String getBezeichnung(){
		return this.bezeichnung;
	}	
}