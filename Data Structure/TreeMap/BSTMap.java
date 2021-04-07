import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class Node {
        Node left, right;
        K key;
        V value;
        public Node(K key, V value) {
            left = null;
            right = null;
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        if(root == null)
            return false;
        Node temp = root;
        while(!temp.key.equals(key))
        {
            if(key.compareTo(temp.key) < 0)
                temp = temp.left;
            else
                temp = temp.right;
            if(temp == null)
                return false;
        }
        return true;
    }

    @Override
    public V get(K key) {
        if(root == null)
            return null;
        Node temp = root;
        while(!temp.key.equals(key))
        {
            if(key.compareTo(temp.key) < 0)
                temp = temp.left;
            else
                temp = temp.right;
            if(temp == null)
                return null;
        }
        return temp.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if(root == null)
        {
            root = new Node(key, value);
            ++size;
        }
        else
        {
            Node temp = root;
            while(!temp.key.equals(key))
            {
                if(key.compareTo(temp.key) < 0)
                {
                    if(temp.left != null)
                        temp = temp.left;
                    else
                    {
                        temp.left = new Node(key, value);
                        ++size;
                        return;
                    }
                }
                else
                {
                    if(temp.right != null)
                        temp = temp.right;
                    else
                    {
                        temp.right = new Node(key, value);
                        ++size;
                        return;
                    }
                }
            }
            temp.value = value;
        }
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
        Node temp = root;
        printProcess(temp);
    }

    public void printProcess(Node node) {
        if(node.left != null)
            printProcess(node.left);
        System.out.println(node.key + " ");
        if(node.right != null)
            printProcess(node.right);
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTiterator();
    }

    private class BSTiterator implements Iterator<K> {
        public boolean hasNext() {
            return false;
        }

        public K next() {
            return root.key;
        }
    }
}
