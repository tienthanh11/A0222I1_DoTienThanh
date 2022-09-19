package service;

import model.Book;
import repository.BookRepoImpl;
import repository.IBookRepo;

import java.util.List;

public class BookServiceImpl implements IBookService {
    IBookRepo bookRepo = new BookRepoImpl();

    @Override
    public List<Book> selectAllBook() {
        return bookRepo.selectAllBook();
    }

    @Override
    public List<Book> searchBook(String name) {
        return bookRepo.searchBook(name);
    }
}
