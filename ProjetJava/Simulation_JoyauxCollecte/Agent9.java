// Groupe 9 Dant
//Abou Karroum Tamer 21205421
// Chakma Emma 21205161


import java.sql.ConnectionBuilder;
import java.util.ArrayList;

public class Agent9{
    
    private int x;
    private int y;

    private ArrayList<Joyaux> sac;
    private int bouclier;

    private final Grille grille;

    public Agent9(Grille g){
        this.x=0;
        this.y=0;
        this.sac= new ArrayList<Joyaux>();
        this.bouclier=0;
        this.grille=g;
    }


    public void seDeplacer(int xnew, int ynew) throws DeplacementIncorrectException,CoordonneesIncorrectesException,CaseNonPleineException{

        if (!grille.sontValides(xnew,ynew)){
            throw new DeplacementIncorrectException("x ou y hors case");
        }else{
            
            if (!grille.caseEstVide(x,y)){
                System.out.println(grille.getCase(xnew,ynew));
                Contenu c= grille.getCase(xnew,ynew);

                if (c instanceof Joyaux){
                    this.x=xnew;
                    this.y=ynew;
                    sac.add((Joyaux)c);
                     grille.videCase(x,y);
                }else if(c instanceof Bouclier){
                            this.bouclier+= ((Bouclier)c).getDur();
                            grille.videCase(xnew,ynew);
                        }else{
                                if (this.bouclier>0){
                                    this.bouclier-=1;
                                    
                                }else{
                                sac.clear();
                                this.x=xnew;
                                this.y=ynew;
                                }
                            }
            }else{
                this.x=xnew;
                this.y=ynew;
            }

        }
    }

    public void seDeplacer(int xnew,int ynew, int f) throws DeplacementIncorrectException, CoordonneesIncorrectesException,CaseNonPleineException{

    if (!grille.sontValides(xnew,ynew)){
            throw new DeplacementIncorrectException("x ou y hors case");
        }else{
            
            if (!grille.caseEstVide(xnew,ynew)){

                Contenu c= grille.getCase(xnew,ynew);

                if (c instanceof Joyaux){
                    sac.add((Joyaux)c);
                    grille.videCase(xnew,ynew);
                    this.x=xnew;
                    this.y=ynew;
                }else if(c instanceof Bouclier){
                            this.bouclier+= ((Bouclier)c).getDur();
                            grille.videCase(xnew,ynew);
                        }else{
                            if (((Gardien)c).getPV()<=f){
                                grille.videCase(x,y);
                            }else{
                                if (this.bouclier>0) {
                                    this.bouclier-=1;
                                }else{
                                    sac.clear();
                                }
                                ((Gardien)c).removePV(f);
                            }
                        }
            }else{
                this.x=xnew;
                this.y=ynew;
            }

        }        
    }


    public int fortune(){

        int fortune=0;

        for (Joyaux j: sac){
            fortune+= j.getPrix();
        }

        return fortune;
    }


    public ArrayList<Joyaux> contenuSac(){

        String s="Contenu du Sac:\n";

        for (int i=0;i<sac.size();i++){
            s+="joyaux "+i+": Prix: "+ sac.get(i).getPrix()+"\n";
        }

        s+="Nombre: "+sac.size();

        System.out.println(s);

        return sac;

    }

    public int getX(){ return this.x;}

    public int getY(){ return this.y;}

    public String toString(){
        
        String s="Agent:\n Contenu du Sac:\n";

        for (int i=0;i<sac.size();i++){
            s+="joyaux "+i+": Prix: "+ sac.get(i).getPrix()+"\n";
        }

        s+="Nombre: "+sac.size()+"\n";
        s+="Fortune: "+this.fortune()+"\n";
        s+="Bouclier: "+this.bouclier+"\n";

        return s;
    }
}
