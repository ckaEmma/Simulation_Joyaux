// Groupe 9 Dant
//Abou Karroum Tamer 21205421
// Chakma Emma 21205161

public class Gardien extends Contenu{
	private int pv;
	private static final int PVMAX = 200;
	private static final int PVMIN = 0;
	
	public Gardien(int point){
		super("Gardien",1);
		if(point>PVMAX){
			this.pv = PVMAX;
		}
		else if(point<PVMIN){
			this.pv = PVMIN;
		}
		else{
			this.pv = point;
		}
		
	}
	
	public Gardien(){
		this(100);
	}
	
	public int getPV(){
		return this.pv;
	}
	
	public void removePV(int point){
		this.pv -= point;
	}

}
