package main;

public class GreaterThanConstantDiscountedPurchase extends AbstractPurchase {
    private final double discount;
    private final int exceedQuantity = 15;

    public GreaterThanConstantDiscountedPurchase(Product product, int purchasedUnits, double discount) {
        super(product, purchasedUnits);
        this.discount = discount;
    }

    @Override
    public Euro getFinalCost(Euro baseCost) {
        //quantity to exceed is 15
        if (purchasedUnits > exceedQuantity) {
            baseCost = baseCost.mul(1 - discount/100, RoundMethod.ROUND, 0);
        }
        return baseCost;
    }

    @Override
    protected String fieldsToString() {
        return this.getClass().getSimpleName() + ";" + product.toString() + ";" +  purchasedUnits + ";"
                + discount;
    }
}
