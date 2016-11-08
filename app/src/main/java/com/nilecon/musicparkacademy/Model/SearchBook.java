package com.nilecon.musicparkacademy.Model;

import java.util.List;

/**
 * Created by Maximus on 5/11/2559.
 */
public class SearchBook {
    /**
     * bid : 1
     * book_path : http://upic.me/i/tj/bb-609x1024.jpg
     * book_name : test
     * book_detail : test
     */

    private List<BookBean> Book;

    public List<BookBean> getBook() {
        return Book;
    }

    public void setBook(List<BookBean> Book) {
        this.Book = Book;
    }

    public static class BookBean {
        private String bid;
        private String book_path;
        private String book_name;
        private String book_detail;

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getBook_path() {
            return book_path;
        }

        public void setBook_path(String book_path) {
            this.book_path = book_path;
        }

        public String getBook_name() {
            return book_name;
        }

        public void setBook_name(String book_name) {
            this.book_name = book_name;
        }

        public String getBook_detail() {
            return book_detail;
        }

        public void setBook_detail(String book_detail) {
            this.book_detail = book_detail;
        }
    }
}
