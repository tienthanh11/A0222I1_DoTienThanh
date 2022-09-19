package service;

import model.Book;

import java.util.List;

public interface IBookService {
    List<Book> selectAllBook();

    List<Book> searchBook(String name);
}
