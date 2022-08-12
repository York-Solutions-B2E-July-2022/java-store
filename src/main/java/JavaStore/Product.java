package JavaStore;

import java.util.UUID;
public class Product {
    private UUID id = UUID.randomUUID();
    private String product_name;
    public String display_name;
    private Double price;
    private Float sale_percent; // 0.00 -- 1.00
    public Boolean on_sale;

    public Product(String product_name, String display_name, Double price, Float sale_percent, Boolean on_sale) {
        this.setProduct_name( product_name);
        this.display_name = display_name;
        this.price = price;
        this.setSale_percent(sale_percent);
        this.on_sale = on_sale;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        product_name = product_name
                .replaceAll("\\s","")
                .toLowerCase();

        this.product_name = product_name;
    }

    public Double getPrice() {
        return price;
    }
    public Double getCurrentPrice(){
        if(!this.on_sale) {
            return this.price ;
        } else {
            return this.price - (this.price * this.sale_percent);
        }
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Float getSale_percent() {
        return sale_percent;
    }

    public void setSale_percent(Float sale_percent) {
        sale_percent = Math.abs(sale_percent);
        if(sale_percent > 1) {
            this.sale_percent = sale_percent / 100;
            return;
        }
        this.sale_percent = sale_percent;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f",
                this.id,
                this.display_name,
                this.getCurrentPrice(),
                this.price);
    }
}
