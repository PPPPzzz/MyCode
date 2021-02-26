public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public VengefulSLList()
    {
        deletedItems = new SLList<>();
    }

    public VengefulSLList(Item x)
    {
        super(x);
        deletedItems = new SLList<>();
    }

    public void printLostItems()
    {
        deletedItems.print();
    }

    @Override
    public Item removeLast()
    {
        Item x = super.removeLast();
        deletedItems.addLast(x);

        return x;
    }
}
