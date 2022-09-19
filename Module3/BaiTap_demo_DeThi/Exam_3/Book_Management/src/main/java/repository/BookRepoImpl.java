package repository;

import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepoImpl implements IBookRepo {
    public final static String SELECT_ALL_BOOK = "select * from book ;";
    public final static String SEARCH_BOOK = "select * from book where `name` like ?;";


    @Override
    public List<Book> selectAllBook() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                Book book = new Book(bookId, name, author, description, quantity);
                bookList.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> searchBook(String nameSearch) {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BOOK);
            preparedStatement.setString(1, "%" + nameSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                Book book = new Book(bookId, name, author, description, quantity);
                bookList.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }
}
