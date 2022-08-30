package main;

public class PriceDiscountPurchase extends Purchase{
    private final Euro discount;
    public PriceDiscountPurchase(Product product, int purchasedUnits, Euro discount) {
        super(product,purchasedUnits);
        if(product.getPrice().compareTo(discount) <= 0)
            throw new IllegalArgumentException("Discount can't be bigger than price");
        if (discount.equals(new Euro(0)))
            throw new IllegalArgumentException("Discount can't be zero");
        this.discount = discount;
    }

    public PriceDiscountPurchase(String[] fields) {
        this((PriceDiscountPurchase) getValidPurchase(fields));
    }

    public PriceDiscountPurchase(PriceDiscountPurchase priceDiscountPurchase){
        this(priceDiscountPurchase.getProduct(), priceDiscountPurchase.getPurchasedUnits(), priceDiscountPurchase.discount);
    }

    private static Purchase getValidPurchase(String[] fields) {
        if(fields.length != PurchasesFactory.getDiscountPurchaseFieldsNumber()) {
            throw new ArrayIndexOutOfBoundsException("wrong args number");
        }
        return new PriceDiscountPurchase(new Product(fields[0], new Euro(fields[1])), Integer.parseInt(fields[2]), new Euro(fields[3]));
    }

    @Override
    protected Euro getFinalCost(Euro cost) {
        return super.getFinalCost(cost).sub(this.discount.mul(getPurchasedUnits()));
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + discount + ";" + getCost();
    }
}
