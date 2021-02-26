public class SLList<Item> {
    public class IntNode {
        public Item item;
        public IntNode next;
    
        public IntNode(Item i, IntNode n)
        {
            item = i;
            next = n;
        }
    }

    public IntNode first;
    public int size;

    public SLList()
    {
        first = null;
        size = 0;
    }

    public SLList(Item x)
    {
        first = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(Item x)
    {
        first = new IntNode(x, first);
        ++size;
    }

    public Item getFirst()
    {
        return first.item;
    }

    public void addLast(Item x)
    {
        ++size;
        
        if(first == null)
        {
            first = new IntNode(x, null);
            return ;
        }

        IntNode p = first;
        while(p.next != null)
            p = p.next;

        p.next = new IntNode(x, null);
    }

    public int size()
    {
        return size;
    }

    public void print()
    {
        IntNode p = first;
        
        for(int i = 0; i < size; ++i)
        {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Item removeLast()
    {
        IntNode p = first;
        --size;

        if(size == 0)
        {
            first = null;

            return p.item;
        }

        int i = size;
        while(i > 1)
        {
            --i;
            p = p.next;
        }
        Item t = p.next.item;
        p.next = null;

        return t;
    }
}
