import java.util.ArrayList;

public class Tree<T> {
    private T root;
    private ArrayList<Tree<T>> subtrees;

    // Constructors for empty trees
    public Tree(){

        this.root = null;
        this.subtrees = new ArrayList<>();

    }

    // Constructor for trees with no children
    public Tree(T root){

        this.root = root;
        this.subtrees = new ArrayList<>();

    }

    // Constructor for trees with children
    public Tree(T root, ArrayList<Tree<T>> subtrees) {

        this.root = root;
        this.subtrees = new ArrayList<>(subtrees);
    }

    public boolean isEmpty(){
        return this.root == null;
    }




}
