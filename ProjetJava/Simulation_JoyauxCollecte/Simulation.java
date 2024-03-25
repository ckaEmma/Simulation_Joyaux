// Groupe 9 Dant
//Abou Karroum Tamer 21205421
// Chakma Emma 21205161
import java.util.ArrayList;

public class Simulation {
   
    private Agent9 A1;
    private final Grille grille;
    private ArrayList<Contenu> tab;
 
    

    public Simulation(int m) {

        this.grille= new Grille(10,10);

        for (int i=0;i<m;i++){

            try {
                if (Math.random()<0.1){
                    Contenu g= new Gardien(Simulation.randomiser(10,100));
                    this.grille.setCase(Simulation.randomiser(0,20),Simulation.randomiser(0,20),g);
                }else{
                    if (Math.random()<0.1){
                        Contenu b= new Bouclier();
                        this.grille.setCase(Simulation.randomiser(0,20),Simulation.randomiser(0,20),b);
                    }else{
                        Contenu j= new Joyaux("wow", Simulation.randomiser(5,100));
                        this.grille.setCase(Simulation.randomiser(0,20),Simulation.randomiser(0,20),j);
                    }
                }
            }catch (CoordonneesIncorrectesException e){
                i-=1;
            }
        }

        this.A1= new Agent9(this.grille);
    }

    public String lance(int nbEtapes){

        int i;
        String logs="";

        for (i=0;i<nbEtapes;i++){
            
            try{
                System.out.println(i);
                if (Math.random()<0.3){
                    this.A1.seDeplacer(A1.getX()+Simulation.randomiser(-1,1 ), A1.getY()+Simulation.randomiser(-1,1 ), Simulation.randomiser(10, 100));
                }else{
                    this.A1.seDeplacer(A1.getX()+Simulation.randomiser(-1,1 ), A1.getY()+Simulation.randomiser(-1,1 ));
                }

                System.out.println(this.toString());
                logs+="Etape "+i+":\n"+this.toString()+"\n\n\n";
                Thread.sleep(50);
                

            }catch (DeplacementIncorrectException e){
                i-=1;
            }catch (CoordonneesIncorrectesException e){
                i-=1;
            }catch (CaseNonPleineException e){
                i-=1;
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }
        return logs;
    }



    public String toString(){

       String s= this.grille.toString() +"\n\n"+ this.A1.toString();

        return s;
    }




    private static int randomiser(int min,int max){
        return (int)(Math.random()*(max-min+1))+min;
    }

}
