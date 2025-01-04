import java.io.File;
import java.util.Scanner;

public class demo {
    public static void main(String[] args){
        HTMLParser parser = new HTMLParser();
        try{
            Scanner inFileReader = new Scanner(new File("C:\\Users\\jsc10\\Misc-Projects\\html-parser\\sample.html"));
            parser.tokenizer(inFileReader);
        } catch(Exception e){
            System.err.println(e);
        }
    }
}
