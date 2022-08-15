package main;

public class EveryUnitDiscountedPurchase extends AbstractPurchase {
    private final Euro discount;

    public EveryUnitDiscountedPurchase(Product product, int purchasedUnits, Euro discount) {
        super(product, purchasedUnits);
        this.discount = discount;
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        return baseCost.sub(discount.mul(purchasedUnits));
    }

    @Override
    protected String fieldsToString() {
        return this.getClass().getSimpleName() + ";" + product.toString() + ";" +  purchasedUnits + ";"
                + discount;
    }
}
