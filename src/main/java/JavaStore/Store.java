package JavaStore;

import java.util.*;
import java.util.stream.Collectors;

public class Store {
    private ArrayList<Product> products;

    public Store(){
        this.products = new ArrayList<>();
    }
    public Store(ArrayList<Product> products){
        this.products = products;
    }
    public Optional<Product> get(Integer index){
        try {
            return Optional.of(this.products.get(index));
        } catch (IndexOutOfBoundsException exception){
            return Optional.empty();
        }

    }
    public void add(Product product){
        this.products.add(product);
    }
    public void remove(UUID id){
        this.products = new ArrayList<>(this.products.stream().filter(p -> {
            return p.getId() != id;
        }).collect(Collectors.toList()));
    }
    public void replace(UUID id , Product newproduct){
        this.remove(id);
        this.add(newproduct);
    }
    public float mean(Boolean mode){
        float total = 0F;
        for (Product p: this.products) {

            total += mode? p.getPrice() : p.getCurrentPrice();
        }
        return total / this.products.size();


    }
    public Double median(Boolean mode){
        List<Double> newlist = this.products.stream().map(product -> {
            return mode ? product.getPrice(): product.getCurrentPrice();
        }).collect(Collectors.toList());
        Collections.sort(newlist);
        int index;
        Double result;
        if (products.size() % 2 ==0 ){
            index = products.size() / 2 -1 ;
            result = (newlist.get(index) + newlist.get(index+1)) /2;
        }else {
            index = (int) Math.floor(products.size() / 2 ) ;
            result = (newlist.get(index)) ;

        }
        return result;
    }

    public Store getProductOver(Double price){
        return new Store(new ArrayList<>(this.products.stream().filter((product)->{
            return product.getPrice() > price;
        }).collect(Collectors.toList())));

    }
    public Store getProductUnder(Double price){
        return new Store(new ArrayList<>(this.products.stream().filter((product)->{
            return product.getPrice() < price;
        }).collect(Collectors.toList())));

    }
    public void disableSales(){
        for (Product p: this.products ) {
            p.on_sale = false;
        }
    }
    public void enableSales(Double price, Float sale_percent){
        for (Product p: this.products ) {
            if(p.getPrice() > price){
                p.on_sale =true;
                p.setSale_percent(sale_percent);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ID Name CurrentPrice NormalPrice\n");
        for (Product product: this.products) {
            result.append(product+ "\n");
        }
        return result.toString();
    }
}
