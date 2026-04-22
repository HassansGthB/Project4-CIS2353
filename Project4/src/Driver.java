import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args){
        Scanner infile;
        try{
            infile = new Scanner(new File("Project4/src/inputNone.txt"));

            // Create simulator
            SupportTicketSimulator sim = new SupportTicketSimulator();

            // Read each line and add to simulator
            while(infile.hasNextLine()){
                String line = infile.nextLine();
                sim.add(line);
            }
            
            // Process tickets until empty
            while(!sim.isEmpty()){
                Ticket next = sim.processNextTicket();
                System.out.println("Now helping: " + next);
            }

            infile.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Can't find file!");
            System.out.println(ex.getMessage());
        }
        
    }

}
