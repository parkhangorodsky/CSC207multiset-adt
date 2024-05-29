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

    public int size() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int size = 1;
            for (Tree<T> subtree : this.subtrees) {
                size += subtree.size();
            }
            return size;
        }

    }

    public int count(T item) {
        if (this.isEmpty()) {
            return 0;
        } else {
            int num = 0;
            if (this.root.equals(item)){
                num = 1;
            }
            for (Tree<T> subtree : this.subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }




}
