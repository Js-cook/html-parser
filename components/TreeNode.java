package components;
import java.util.LinkedList;

public class TreeNode<T> {
    T root;
    TreeNode<T> parent;
    LinkedList<TreeNode<T>> children;

    /**
     * Constructor.
     */
    public TreeNode(){
        this.root = null;
        this.parent = null;
        this.children = new LinkedList<>();
    }

    public void setRoot(T root){
        this.root = root;
    }

    public void setParent(TreeNode<T> parent){
        this.parent = parent;
    }

    public void addChildNode(TreeNode<T> child){
        this.children.add(child);
    }

}
