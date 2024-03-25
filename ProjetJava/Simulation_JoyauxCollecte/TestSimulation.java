// Groupe 9 Dant
//Abou Karroum Tamer 21205421
// Chakma Emma 21205161

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestSimulation{
    
    public static void main(String[] args) throws IllegalArgumentException {

        

        try {
        	if (args.length == 0) {
        		throw new IllegalArgumentException("Aucun fichier spécifié");
    		}

            	Simulation sim= new Simulation(100);
            	BufferedWriter writer= new BufferedWriter(new FileWriter(new File(args[0])));
            	String logs=sim.lance(50);
            	writer.write(logs);
            	writer.close();
        } catch (IOException e) {
            System.out.println("Erreur d'ouverture: "+args[1]);
        } catch (IllegalArgumentException e) {
    System.out.println("Erreur: Ajouter un fichier en paramètre");
	}  

        
    }
    
   }


