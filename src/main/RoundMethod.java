package main;

public enum RoundMethod {
    FLOOR {
        public double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    ROUND{
        public double roundFunction(double d) {
            return Math.round(d);
        }
    };
    public abstract double roundFunction(double value);

    public int round(double roundedValue, int d) {
        int[] tenPow = {1, 10, 100,1000, 10000, 100000, 1000000, 10000000, 100000000};
        int result = (int) (this.roundFunction(roundedValue / tenPow[d])) * tenPow[d];
        return result;
    }


}
