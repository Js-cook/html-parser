import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import components.TreeNode;

public class HTMLParser {
    // private ArrayList<String> tokens;
    private ArrayList<String> emptyString = new ArrayList(1);

    /**
     * Nested class to represent the HTML tags as nodes for a tree
     */
    private static class HTMLNode {
        boolean isClosed;
        private String tag;
        ArrayList<HTMLNode> children;
        HTMLNode parent;
        private Map<String, String> attributes;

        public HTMLNode(){
            this.isClosed = false;
            this.tag = "";
            this.children = null;
            this.parent = null;
            this.attributes = new TreeMap<>();
        }

        public void addChildNode(HTMLNode child){
            this.children.add(child);
        }

        public void setTagName(String name){
            this.tag = name;
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
        // tokens = new ArrayList<>();
        emptyString.add(" ");
    }

    /***
     * Splits the input file into tokens to be parsed
     * @param inFileReader
     *      Scanner object that corresponds to the input file
     */
    private ArrayList<String> tokenizer(Scanner inFileReader){
        ArrayList<String> tokens = new ArrayList<>();

        while(inFileReader.hasNextLine()){
            String[] tokenizedLine = inFileReader.nextLine().split("((?<=<|>| )|(?=<|>| ))");
            for(String token : tokenizedLine){
                tokens.add(token);
            }
        }
        tokens.removeAll(emptyString);

        return tokens;
    }

    private HTMLNode parseHelper(ArrayList<String> tokens){
        String firstToken = tokens.removeFirst();
        HTMLNode newNode = new HTMLNode();

        if(firstToken.equals("<")){
            String nextToken = tokens.removeFirst();
            tokens.removeFirst(); // get rid of >
            newNode.setTagName(nextToken);
            // TODO: add all attributes prolly need helper fn
            newNode.addChildNode(parseHelper(tokens));
            newNode.closeNode();
            // remove all three tokens from closer
            for(int i = 0; i < 3 ; i++){
                tokens.removeFirst();
            }
        } else {
            // text node so no children
            newNode.setTagName(firstToken);
            newNode.closeNode();
        }

        return newNode;
    }

    public void parse(Scanner inFileReader){
        ArrayList<String> tokenizedFile = tokenizer(inFileReader);
        
        // do other stuff
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
