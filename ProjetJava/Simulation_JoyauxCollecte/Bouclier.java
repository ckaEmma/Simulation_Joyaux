// Groupe 9 Dant
//Abou Karroum Tamer 21205421
// Chakma Emma 21205161


public class Bouclier extends Contenu{

    private int durabilite;

    public Bouclier(){

        super("Bouclier",1);
        this.durabilite= (int)(Math.random()*3)+1;

    }

    public int getDur(){
        return this.durabilite;
    }
    
}
