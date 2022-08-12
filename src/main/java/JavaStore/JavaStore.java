package JavaStore;

import java.util.ArrayList;

public class JavaStore {
    public static void main(String[] args){
        System.out.println("Hello World");
        Product p0 = new Product("Shoes", "Nike Air Max", 10000.0, 25.0F,false);
        Product p1 = new Product("Laptop", "Hp Insporone", 750.0, 25.0F,false);
        Product p2 = new Product("Dress", "Blue Dress", 400.0, 65.0F,false);
        Product p3 = new Product("Dress", "Red Dress", 200.0, 50.0F,false);
        Store store= new Store();
        store.add(p0);
        store.add(p1);
        store.add(p2);
        store.add(p3);
        System.out.println(store);
        store.enableSales(300D, 0.20F);
        System.out.println(store);
        store.disableSales();
        System.out.println(store);


    }
}
