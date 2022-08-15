package main;

public class Euro implements Comparable<Euro> {
    private final int value;

    public Euro(int cents) {
        this.value = cents;
    }

    public Euro(int euros, int cents){
        this(euros*100 + cents);
    }

    public Euro(Euro euro){
        this(euro.value);
    }

    public int getCents() {
        return value;
    }

    public Euro add(Euro euro){
        return new Euro(this.value + euro.value);
    }

    public Euro sub(Euro euro){
        return new Euro(this.value - euro.value);
    }

    public Euro mul(int k){
        return new Euro(this.value * k);
    }

    public Euro mul(double x, RoundMethod roundMethod, int d){
        return new Euro(roundMethod.round(value * x, d));
    }
    public Euro round(RoundMethod roundMethod, int d){
        return new Euro(roundMethod.round(value, d));
    }

    @Override
    public int compareTo(Euro o) {
        return this.value - o.value;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Euro) || (obj == null)) {
            return false;
        }

        Euro other = (Euro) obj;

        return this.value == other.value;
    }

    @Override
    public String toString() {
        return value / 100 + "." + value % 100 / 10 + value % 10; // *.**
    }
}
