package main;

import main.exceptions.CsvLineException;
import main.exceptions.MissingFileException;
import main.exceptions.NoArgumentException;
import main.exceptions.OutOfBoundArgumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class PurchaseList {
    private final List<Purchase> purchases;
    private final Comparator<Purchase> comparator;
    private boolean isSorted = false;

    public PurchaseList(String path, Comparator<Purchase> comparator) throws CsvLineException {
        this(new File(path), comparator);
    }

    public PurchaseList(Comparator<Purchase> comparator) throws CsvLineException {
        this("", comparator);
    }

    public PurchaseList(File fileName, Comparator<Purchase> comparator) {
        this.purchases = new ArrayList<>(0);
        this.comparator = comparator;
        try (Scanner scanner = new Scanner(new FileReader(fileName))){
            while(scanner.hasNextLine()){
                try {
                    Purchase purchase = PurchasesFactory.createPurchase(scanner.nextLine());
                    purchases.add(purchase);
                } catch (CsvLineException e) {
                    System.err.println(e);
                }
            }
            if (purchases.size() == 0) {
                throw new NoArgumentException("List is empty");
            }
        } catch (FileNotFoundException e) {
            isSorted = true;
        }
    }


    public int subList(int from, int to) throws IllegalArgumentException{
        if(from >= to) {
            return 0;
        }
        if (from < 0 ) {
            from = 0;
        } else if (from == to) {
            to = from+1;
        }else if (from > to) {
            throw new OutOfBoundArgumentException();
        } else if (to >= this.purchases.size()) {
            to = this.purchases.size();
        }
        purchases.subList(from, to).clear();
        return to - from;
    }

    public void insertPurchase(int index, Purchase purchase){
        if (index < 0 ) {
            index = 0;
        } else if (index >= purchases.size()) {
            index = purchases.size() - 1;
        }
        purchases.add(index, purchase);
        isSorted = false;
    }

    public void sort(){
        purchases.sort(comparator);
        isSorted = true;
    }

    public Euro getCost(){
        Euro cost = new Euro(0);
        for (Purchase purchase: this.purchases){
            cost = cost.add(purchase.getCost());
        }
        return cost;
    }

    public int search(Purchase purchase) {
        if (isSorted == false) {
            sort();
        }
        return Collections.binarySearch(this.purchases, purchase, this.comparator);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Purchase purchase: this.purchases){
            stringBuilder.append(purchase.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
