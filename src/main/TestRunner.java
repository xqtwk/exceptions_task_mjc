package main;


public class TestRunner {
    public static void main(String[] args) {

        /*PurchaseArray products = new PurchaseArray(new AbstractPurchase[]{
            new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)),50, new Euro(40)),
            new GreaterThanConstantDiscountedPurchase(new Product("pineapple", new Euro(997)),50, 8.75),
            new AdditionForTransportExpensesPurchase(new Product("carrot", new Euro(666)),50, new Euro(12)),
            new EveryUnitDiscountedPurchase(new Product("pear", new Euro(1482)),10, new Euro(2)),
            new GreaterThanConstantDiscountedPurchase(new Product("ice cream", new Euro(1111)),12, 9.39),
            new AdditionForTransportExpensesPurchase(new Product("meat", new Euro(111155)),3, new Euro(1))

        });

        // PURCHASE;NAME;UNIT_PRICE;AMOUNT;DISCOUNT||FEE;TOTAL COST
        products.printArr();
        System.out.println();
        products.sort();
        products.printArr();
        System.out.println(products.getMinimalCost());
        int cost = 33300;
        int index = products.search(cost);
        if (index < 0) {
            System.out.println("Purchase not found");
        } else {
            products.printByIndex(index);
        }*/
    }
}
