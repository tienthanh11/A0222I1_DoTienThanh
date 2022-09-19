package repository;

import model.Book;

import java.util.List;

public interface IBookRepo {
    List<Book> selectAllBook();

    List<Book> searchBook(String name);
}
