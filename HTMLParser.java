import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class HTMLParser {
    private ArrayList<String> tokens;
    private ArrayList<String> emptyString = new ArrayList(1);

    /**
     * Nested class to represent the HTML tags as nodes for a tree
     */
    private static class HTMLNode {
        private boolean isClosed;
        private String tag;
        private ArrayList<HTMLNode> children;
        private HTMLNode parent;
        private Map<String, String> attributes;

        public HTMLNode(String tagName){
            this.isClosed = false;
            this.tag = tagName;
            this.children = null;
            this.parent = null;
            this.attributes = new TreeMap<>();
        }

        public void addChildNode(HTMLNode child){
            this.children.add(child);
        }

        public void addAttribute(String k, String v){
            this.attributes.put(k, v);
        }

        public void setParent(HTMLNode parent){
            this.parent = parent;
        }

        public void closeNode(){
            this.isClosed = true;
        }
    }

    /**
     * Constructor
     */
    public HTMLParser(){
        tokens = new ArrayList<>();
        emptyString.add(" ");
    }

    /***
     * Splits the input file into tokens to be parsed
     * @param inFileReader
     *      Scanner object that corresponds to the input file
     */
    private void tokenizer(Scanner inFileReader){
        while(inFileReader.hasNextLine()){
            String[] tokenizedLine = inFileReader.nextLine().split("((?<=<|>| )|(?=<|>| ))");
            for(String token : tokenizedLine){
                tokens.add(token);
            }
        }
        tokens.removeAll(emptyString);

        // System.out.println(tokens.toString());
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
