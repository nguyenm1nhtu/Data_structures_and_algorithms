package Bai6.P33;

public class Books {

    private String name;
    private String author;
    private int price;

    public Books(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {return name;}
    public String getAuthor() {return author;}
    public int getPrice() {return price;}

    @Override
    public String toString() {
        return name + ", " + author + ", " + price + "(vnd)";
    }
}
