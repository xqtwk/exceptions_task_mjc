package main;

public class Purchase extends AbstractPurchase{
    public Purchase(Product product, int purchasedUnits) {
        super(product, purchasedUnits);
    }

    @Override
    protected Euro getFinalCost(Euro cost) {
        return cost;
    }
}
