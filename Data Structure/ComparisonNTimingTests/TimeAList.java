import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> altest = new AList<>();
        ArrayList<Integer> Ns = new ArrayList<>();
        for(int i = 1000; i <= 1024000; i *= 2)
            Ns.add(i);
        ArrayList<Double> times = new ArrayList<>();
        int cc = 1000;
        int ini = 1;
        Stopwatch sw = new Stopwatch();
        for(int i = 0; i < 11; i++)
        {
            for(; ini <= cc; ini++)
                altest.addLast(ini);
            double time = sw.elapsedTime();
            times.add(time);
            cc *= 2;
        }
        printTimingTable(Ns, times, Ns);
    }
}
