package main;

import java.lang.constant.Constable;
import java.text.ParseException;
import java.util.Collections;

public class PurchasesFactory {
    private static final int PURCHASE_FIELDS_NUMBER = 3;
    private static final int DISCOUNT_PURCHASE_FIELDS_NUMBER = 4;
    private enum PurchaseKind {
        PURCHASE {
            @Override
            protected Purchase getPurchase(String[] fields) {
                return new Purchase(fields);
            }
        },
        PRICE_PURCHASE {
            @Override
            protected Purchase getPurchase(String[] fields) {
                return new PriceDiscountPurchase(fields);
            }
        };
        protected abstract Purchase getPurchase(String[] fields);
    }

    public static int getDiscountPurchaseFieldsNumber() {
        return DISCOUNT_PURCHASE_FIELDS_NUMBER;
    }
    public static int getPurchaseFieldsNumber() {
        return PURCHASE_FIELDS_NUMBER;
    }

    private static PurchaseKind getPurchaseKind(String[] fields) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        try {
            return PurchaseKind.values()[fields.length - PURCHASE_FIELDS_NUMBER];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Purchase createPurchase(String line){
        return createPurchase(line.split(";"));
    }

    public static Purchase createPurchase(String[] fields) throws IllegalArgumentException{
        try{
            return getPurchaseKind(fields).getPurchase(fields);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("AAA");
        }
    }

}
