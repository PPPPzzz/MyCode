public class OffByN implements CharacterComparator{
    private int N;

    public OffByN(int n)
    {
        N = n;
    }

    @Override
    public boolean equalChars(char x, char y)
    {
        if(x - y == 5 || x - y == -5)
            return true;
        else
            return false;
    }
}
