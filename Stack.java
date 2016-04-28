
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private int N;
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }

    // Construtor
    public Stack() {
        first = null;
        N = 0;
    }

    // Método que verifica se está vazia
    public boolean isEmpty() {
        return first == null;
    }

    // Método que retorna o tamanho da pilha
    public int size() {
        return N;
    }

    // Método para adicionar elementos no topo da pilha
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // Método que remove e retorna o elemento do topo da pilha
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // Método que retorna a pilha em ordem no formato de String
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator()  { return new ListIterator();  }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

}

