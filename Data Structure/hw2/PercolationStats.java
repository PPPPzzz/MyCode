package hw2;

import java.lang.IllegalArgumentException;
import java.util.Arrays;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    Percolation a;
    int[] sample;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        // perform T independent experiments on an N-by-N grid
        if(N <= 0 || T <= 0)
            throw new IllegalArgumentException();
        sample = new int[T];
        for(int i = 0; i < T; i++)
        {
            a = pf.make(N);
            while(!a.percolates())
            {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                a.open(row, col);
            }
            sample[i] = a.numberOfOpenSites();
        }
    }

    public double mean() {
        // sample mean of percolation threshold
        return StdStats.mean(sample);
    }

    public double stddev() {
        // sample standard deviation of percolation threshold
        return StdStats.stddev(sample);
    }

    public double confidenceLow() {
        // low endpoint of 95% confidence interval
        return mean() - 1.96 * stddev() / (double)Math.sqrt(sample.length);
    }

    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        return mean() + 1.96 * stddev() / (double)Math.sqrt(sample.length);
    }
}
