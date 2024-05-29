import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


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

    // Return the number of nodes in this tree
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

    // Return the number of nodes with the root value equal to item
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

    // Return the string representation of this tree
    @Override
    public String toString() {
        return this.strIndented(0);
    }

    private String strIndented(int depth) {
        if (this.isEmpty()) {
            return "";
        } else {
            StringBuilder str;
            str = new StringBuilder("   ".repeat(depth) + this.root.toString() + "\n");
            for (Tree<T> subtree : this.subtrees) {
                str.append(subtree.strIndented(depth + 1));
            }
            return str.toString();
        }
    }

    // Return the average value in this tree.
    public double average() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int[] sumAndCount = this.averageHelper();
            return (double) sumAndCount[0] / sumAndCount[1];
        }
    }

    private int[] averageHelper() {
        int[] pair = new int[2];
        if (!this.isEmpty()) {
            pair[0] += (Integer) this.root;
            pair[1] += 1;
            for (Tree<T> subtree : this.subtrees) {
                int[] subPair = subtree.averageHelper();
                pair[0] += subPair[0];
                pair[1] += subPair[1];
            }
        }
        return pair;
    }

    // Return true if this and other trees are equal
    // Okay this is a messy code..
    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Tree)){
            return false;
        } else if (this == other) {
            return true;
        } else if (this.isEmpty() && ((Tree<?>) other).isEmpty()) {
            return true;
        } else if (this.isEmpty() || ((Tree<?>) other).isEmpty()) {
            return false;
        } else if (this.root != ((Tree<?>) other).root) {
            return false;
        } else if (this.size() != ((Tree<?>) other).size()) {
            return false;
        } else {
            return this.subtrees.equals(((Tree<?>) other).subtrees);
        }
    }

    // Return true if this tree contains the item
    public boolean contains(T item) {
        if (this.isEmpty()) {
            return false;
        } else {

            if (this.root.equals(item)) {
                return true;
            } else {
                for (Tree<T> subtree : this.subtrees) {
                    if (subtree.contains(item)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    // Return all leaf items in this tree
    public ArrayList<T> leaves() {
        if (this.isEmpty()) {
            return new ArrayList<>();
        } else if (this.subtrees.isEmpty()) {
            ArrayList<T> leaves =  new ArrayList<>();
            leaves.add(this.root);
            return leaves;
        } else {
            ArrayList<T> leaves = new ArrayList<>();
            for (Tree<T> subtree : this.subtrees) {
                leaves.addAll(subtree.leaves());
            }
            return leaves;
        }
    }


}
