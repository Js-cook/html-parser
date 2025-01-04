import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class HTMLParser {
    private ArrayList<String> tokens;
    private ArrayList<String> emptyString = new ArrayList(1);
    /*
     * Constructor
     */
    public HTMLParser(){
        tokens = new ArrayList<>();
        emptyString.add(" ");
    }

    public void tokenizer(Scanner inFileReader){
        while(inFileReader.hasNextLine()){
            String[] tokenizedLine = inFileReader.nextLine().split("((?<=<|>| )|(?=<|>| ))");
            for(String token : tokenizedLine){
                tokens.add(token);
            }
        }
        tokens.removeAll(emptyString);
        
        System.out.println(tokens.toString());
    }

    public static void main(String[] args){
        // try{
        //     // Scanner inFile = new Scanner(new File("C:\\Users\\jsc10\\Misc-Projects\\html-parser\\sample.html"));
            
        // } catch(Exception e){
        //     System.err.println(e);
        // }
        System.out.println("Hi there");
    }
}
