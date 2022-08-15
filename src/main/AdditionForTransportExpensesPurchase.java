package main;

public class AdditionForTransportExpensesPurchase extends AbstractPurchase {
    private final Euro fee;

    public AdditionForTransportExpensesPurchase(Product product, int purchasedUnits, Euro fee) {
        super(product, purchasedUnits);
        this.fee = fee;
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        return baseCost.add(fee);
    }

    @Override
    protected String fieldsToString() {
        return this.getClass().getSimpleName() + ";" + product.toString() + ";" +  purchasedUnits + ";"
                + fee;
    }
}
