package shop;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private String firstName;
    private String lastName;

    public void requestToBuy() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        Book book3 = new BookBuilder().chooseBook("Potter 3").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        // 3. Checkout
        // TODO :: checkout process
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 24, discountPrice 24 - 10%
    }
}

class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        int maxDiscount = DiscountCalculator.get(basket, netPrice);
        int totalPrice = netPrice - maxDiscount;

        basket.setNetPrice(netPrice);
        basket.setDiscountPrice(maxDiscount);

        // TODO
    }
}

class PriceCalculator {

    public static int get(Basket basket) {
        // Logic
        int price = 0;
        for (Book book : basket.getBooks()) {
            price += book.getPrice();
        }
        return price;
    }
}

class DiscountCalculator {

    public static int get(Basket basket, int netPrice) {
        // Logic
        double discount = 0;
        List<Book> books = basket.getBooks();
        if(books.size() == 2) {
            discount = (double)netPrice - ( (double)netPrice * 5 / 100 );
        }
        if(books.size() == 3) {
            discount = (double)netPrice - ( (double)netPrice * 10 / 100 );
        }
        return (int)(discount * 100);
    }
}

class Basket {
    private List<Book> books = new ArrayList<Book>();
    private int netPrice;
    private int discountPrice;

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getNetPrice() {
        return netPrice * 100;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}

class BookBuilder {
    private Book book;

    public BookBuilder() {
        book = new Book();
    }

    public BookBuilder chooseBook(String name) {
        book.setName(name);
        book.setPrice(8);
        return this;
    }

    public Book build() {
        return book;
    }
}

class Book {
    private String name;
    private int price;
    private int qty;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public Book() {
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}