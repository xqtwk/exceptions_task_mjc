package main;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{
    protected Product product;
    protected int purchasedUnits;

    public AbstractPurchase() {}

    public AbstractPurchase(Product product, int purchasedUnits) {
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    protected abstract Euro getFinalCost(Euro baseCost);

    public Euro getCost(){
        Euro baseCost = product.getPrice().mul(purchasedUnits);
        Euro finalCost = getFinalCost(baseCost);
        return finalCost.round(RoundMethod.FLOOR, 2);
    }

    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" + product + ";" + purchasedUnits;
    }


    @Override
    public int compareTo(AbstractPurchase o) {
        return o.getCost().compareTo(getCost());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractPurchase) || (obj == null)) {
            return false;
        }

        AbstractPurchase another = (AbstractPurchase) obj;

        return this.product.equals(another.product) && purchasedUnits == another.purchasedUnits;
    }
}

