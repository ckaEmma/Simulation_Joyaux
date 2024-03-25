
// Groupe 9 Dant
//Abou Karroum Tamer 21205421
// Chakma Emma 21205161
public class Joyaux extends Contenu{
	private int prix;
	private static final int PRIXMIN = 1;
	private static final int PRIXMAX = 9000;
	
	
	public Joyaux(String s,int prix){
		super(s,1);
		if (prix>PRIXMAX){
			this.prix=PRIXMAX;
		}else if(prix<PRIXMIN){
			this.prix=PRIXMIN;
		}else{
			this.prix=prix;
		}
		
	}
	
	public Joyaux(){
		this("Diamant",4000);
	}
	
	public int getPrix(){
		return prix;
	}
	
	
}
