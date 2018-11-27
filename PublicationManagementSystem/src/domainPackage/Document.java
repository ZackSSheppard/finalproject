package domainPackage;

import java.util.ArrayList;
import java.util.Date;

public class Document {
    private String title;
    private boolean onSale;
    private double price;
    private String author;
    private String type;
    private String genre;
    private String publisher;
    private int quantity;

    public Document(String title,  boolean sale, double price, 
    		String publisher, String type, String genre, String author){
        this.title=title;
        this.onSale = sale;
        this.price=price;
        this.publisher=publisher;
        this.type=type;
        this.genre=genre;
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getType() {
        return type;
    }

    public String getGenre() {
        return genre;
    }


    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }


    public boolean isOnSale() {
        return onSale;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void soldOne(){
        quantity--;
    }

    public String toString(){
        String doc = this.title + " " + this.type + " " + this.price + " " + this.author;
        return doc;
    }
}
