package cn.z.domain;

import java.util.Date;

public class Book {

    private Integer book_code;
    private String book_isbn; //出版号
    private String book_name;
    private String book_press;//出版社
    private Double book_price;
    private String book_img;
    private String author;
    private String book_date;//出版日期
    private String book_type;//类型
    private String book_content;//书的内容简介

    public Integer getBook_code() {
        return book_code;
    }

    public void setBook_code(Integer book_code) {
        this.book_code = book_code;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_press() {
        return book_press;
    }

    public void setBook_press(String book_press) {
        this.book_press = book_press;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_date() {
        return book_date;
    }

    public void setBook_date(String book_date) {
        this.book_date = book_date;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getBook_content() {
        return book_content;
    }

    public void setBook_content(String book_content) {
        this.book_content = book_content;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_code=" + book_code +
                ", book_isbn='" + book_isbn + '\'' +
                ", book_name='" + book_name + '\'' +
                ", book_press='" + book_press + '\'' +
                ", book_price=" + book_price +
                ", book_img='" + book_img + '\'' +
                ", author='" + author + '\'' +
                ", book_date='" + book_date + '\'' +
                ", book_type='" + book_type + '\'' +
                ", book_content='" + book_content + '\'' +
                '}';
    }
}
