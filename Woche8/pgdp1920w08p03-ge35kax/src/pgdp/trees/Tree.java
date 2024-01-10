package pgdp.trees;
import java.util.Comparator;
import java.util.function.Predicate;

public class Tree<T> {

    public Tree(Comparator<T> comp) {
    }

    public void insert(T value) {
    }

    @Override
    public String toString() {
        return null;
    }

    public int size() {
        return -1;
    }

    public void remove(T value) {
    }
    
    public boolean contains(T value) {
        return false;
    }

    public int countMatches(Predicate<T> filter) {
        return -1;
    }

    public T[] getAll(Predicate<T> filter) {
        // Generics und Arrays vertragen sich nicht besonders gut
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[countMatches(filter)];
        return null;
    }
}
