/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int trial;
    private double threshold[];
    private double CONSTANT = 1.96;
    private double mean;
    private double standardDeviation;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        trial = trials;
        threshold = new double[trial];
        for (int i = 1; i <= trial; i++) {

            Percolation per = new Percolation(n);
            while (per.percolates() == false) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                per.open(row, col);
            }
            threshold[i - 1] = (double) per.numberOfOpenSites() / (n * n);

        }
        mean = StdStats.mean(threshold);
        standardDeviation = StdStats.stddev(threshold);


    }


    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return standardDeviation;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - CONSTANT * standardDeviation / Math.sqrt(trial);

    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + CONSTANT * standardDeviation / Math.sqrt(trial);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trail = Integer.parseInt(args[1]);

        PercolationStats perStat = new PercolationStats(n, trail);

        System.out.print("mean          =");
        System.out.println(perStat.mean());
        System.out.print("stddev         =");
        System.out.println(perStat.stddev());
        System.out.print("95% confidnece Interval = ");
        System.out.println(perStat.confidenceLo() + " , " + perStat.confidenceHi());


    }
}

