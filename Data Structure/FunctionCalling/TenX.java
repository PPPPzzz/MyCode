public class TenX implements IntUnrayFunction{
    public int apply(int x)
    {
        return 10 * x;
    }

    public static int do_twice(IntUnrayFunction f, int x)
    {
        return f.apply(f.apply(x));
    }

    // public static void main(String[] args) {
    //     System.out.println(do_twice(new TenX(), 2));
    // }
}