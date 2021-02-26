public class RotatingDLList<T> extends SLList<T> {
    public RotatingDLList()
    {
        first = null;
        size = 0;
    }

    public void rotateRight()
    {

        T temp = removeLast();
        addFirst(temp);
    }
}
