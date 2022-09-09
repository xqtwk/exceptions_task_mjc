package main;

import main.exceptions.CsvLineException;

import java.lang.constant.Constable;
import java.text.ParseException;
import java.util.Collections;

public class PurchasesFactory {
    public static final int PURCHASE_FIELDS_NUMBER = 3;
    public static final int DISCOUNT_PURCHASE_FIELDS_NUMBER = 4;
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

    private static PurchaseKind getPurchaseKind(String[] fields)  throws CsvLineException {
        try {
            return PurchaseKind.values()[fields.length - PURCHASE_FIELDS_NUMBER];
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            throw new CsvLineException(fields, e);
        }
    }

    public static Purchase createPurchase(String line) throws CsvLineException {
        return createPurchase(line.split(";"));
    }

    public static Purchase createPurchase(String[] fields) throws CsvLineException{
        try{
            return getPurchaseKind(fields).getPurchase(fields);
        } catch (IllegalArgumentException e) {
            throw new CsvLineException(fields, e);
        }
    }

}
