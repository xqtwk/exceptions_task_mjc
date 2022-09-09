package main;

import main.exceptions.NegativeArgumentException;
import main.exceptions.NoArgumentException;
import main.exceptions.ZeroArgumentException;

public class Product {
    private final String name;
    private final Euro price;

    public Product(String name, Euro price) {
        if (name.isEmpty())
            throw new NoArgumentException("name is required");
        if (price.equals(new Euro(0))) {
            throw new ZeroArgumentException("price can't be zero");
        }
        if (price.getCents() < 0) {
            throw new NegativeArgumentException("price can't be negative");
        }
        this.name = name;
        this.price = price;
    }

    public Euro getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ";" + price;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product) || (obj == null)) {
            return false;
        }

        Product other = (Product) obj;

        return this.price.equals(other.price) && this.name.equals(other.name);
    }

}
