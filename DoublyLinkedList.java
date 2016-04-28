import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    private int N;        // Número de elementos na lista
    private Node pre;
    private Node post;

    // Construtor
    public DoublyLinkedList() {
        pre  = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
    }

    // Estrutura de itens da lista duplamente linkada com o anterior e próximo
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // Método que verifica se a lista está vazia
    public boolean isEmpty() {
        return N == 0;
    }

    // Método que retorna o tamanho da lista
    public int size() {
        return N;
    }

    // Método para adicionar item a lista
    public void add(Item item) {
        Node last = post.prev;
        Node x = new Node();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
        N++;
    }

    public ListIterator<Item> iterator()  { return new DoublyLinkedListIterator(); }

    private class DoublyLinkedListIterator implements ListIterator<Item> {
        private Node current      = pre.next;  // Elemento a ser retornado pelo next
        private Node lastAccessed = null;      // Ultimo elemento acessado

        private int index = 0;

        public boolean hasNext()      { return index < N; }
        public boolean hasPrevious()  { return index > 0; }
        public int previousIndex()    { return index - 1; }
        public int nextIndex()        { return index;     }

        // Próximo item da lista
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            Item item = current.item;
            current = current.next; 
            index++;
            return item;
        }

        // Item anterior da lista
        public Item previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.prev;
            index--;
            lastAccessed = current;
            return current.item;
        }

        // Substitui o elemento atual
        public void set(Item item) {
            if (lastAccessed == null) throw new IllegalStateException();
            lastAccessed.item = item;
        }

        // Remove elemento da lista
        public void remove() { 
            if (lastAccessed == null) throw new IllegalStateException();
            Node x = lastAccessed.prev;
            Node y = lastAccessed.next;
            x.next = y;
            y.prev = x;
            N--;
            if (current == lastAccessed)
                current = y;
            else
                index--;
            lastAccessed = null;
        }

        // Adicionar elementos a lista 
        public void add(Item item) {
            Node x = current.prev;
            Node y = new Node();
            Node z = current;
            y.item = item;
            x.next = y;
            y.next = z;
            z.prev = y;
            y.prev = x;
            N++;
            index++;
            lastAccessed = null;
        }

    }

    // Método para retornar a lista em ordem como string
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

}
