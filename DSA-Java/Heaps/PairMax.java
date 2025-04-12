package Heaps;

public class PairMax implements Comparable<PairMax> {
    int first;
    int second;

    public PairMax(int val1, int val2) {
        this.first = val1;
        this.second = val2;
    }

    @Override
    public int compareTo(PairMax other) {
        // Primary: Compare by first in descending order
        int firstComparison = Integer.compare(other.first, this.first);
        if (firstComparison == 0) {
            // Secondary: Compare by second in descending order in case of tie
            return Integer.compare(other.second, this.second);
        }
        return firstComparison;
    }
}
