public class LinkedListDeque<T> implements Deque<T> {
    private class LinkedList
    {
        public T item;
        public LinkedList next, last;

        public LinkedList(T item)
        {
            this.item = item;
            this.next = this;
            this.last = this;
        }
    }
    
    public LinkedList head, tail;
    public int size;

    public LinkedListDeque()
    {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T item)
    {
        LinkedList p = new LinkedList(item);
        p.next = head;
        p.last = null;
        head = p;
        ++size;
    }

    @Override
    public void addLast(T item)
    {
        LinkedList p = new LinkedList(item);
        p.next = null;
        p.last = tail;
        tail = p;
        ++size;
    }

    @Override
    public boolean isEmpty()
    {
        if(head == null)
            return true;
        else
            return false;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void printDeque()
    {
        for(LinkedList p = head; p != null; p = p.next)
            System.out.print(p.item + " ");
        System.out.println();
    }

    @Override
    public T removeFirst()
    {
        T temp = head.item;
        head = head.next;
        --size;

        return temp;
    }

    @Override
    public T removeLast()
    {
        T temp = tail.item;
        tail = tail.last;
        --size;

        return temp;
    }

    @Override
    public T get(int index)
    {
        LinkedList p = head;
        int count = 1;

        while(count != index)
        {
            p = p.next;
            ++count;
        }

        return p.item;
    }

    public T movePoint(LinkedList p, int count)
    {
        if(count == 1)
            return p.item;
        else
        {
            p = p.next;
            return movePoint(p, --count);
        }
    }

    public T getRecursive(int index)
    {
        LinkedList p = head;

        return movePoint(p, index);
    }
} 