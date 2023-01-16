package property;

import java.util.ArrayList;

public class Product {

    private String title;
    private int forexBuy;
    private int price;
    private int star;
    private ArrayList<String> images;

    public Product() { }

    public Product(String title, int forexBuy, int price, int star) {
        this.title = title;
        this.forexBuy = forexBuy;
        this.price = price;
        this.star = star;
    }

    public Product(String title, int forexBuy, int price, int star, ArrayList<String> images) {
        this.title = title;
        this.forexBuy = forexBuy;
        this.price = price;
        this.star = star;
        this.images = images;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getForexBuy() {
        return forexBuy;
    }

    public void setForexBuy(int forexBuy) {
        this.forexBuy = forexBuy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }


    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", forexBuy=" + forexBuy +
                ", price=" + price +
                ", star=" + star +
                ", images=" + images +
                '}';
    }

}
