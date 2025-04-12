package Heaps;

class PairMin implements Comparable<PairMin> {
    int first;
    int second;

    public PairMin(int val1, int val2) {
        this.first = val1;
        this.second = val2;
    }

    @Override
    public int compareTo(PairMin other) {
        // Primary: Compare by diff
        // Secondary: Compare by val in case of a tie
        int diffComparison = Integer.compare(this.first, other.first);
        if (diffComparison == 0) {
            return Integer.compare(this.second, other.second); // Min-heap by value in case of tie in diff
        }
        return diffComparison;
    }
}
