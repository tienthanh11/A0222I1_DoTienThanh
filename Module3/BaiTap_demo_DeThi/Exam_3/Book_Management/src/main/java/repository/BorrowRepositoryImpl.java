package repository;

import model.CardBorrowBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowRepositoryImpl implements IBorrowRepo {

    public final static String SELECT_CARD_BORROW = "select * from card_borrow_book where book_id = ? ";


    @Override
    public CardBorrowBook selectBorrowBook(int id) {
        CardBorrowBook cardBorrowBook = null;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARD_BORROW);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String cardId = rs.getString("card_borrow_book_id");
                int bookId = rs.getInt("book_id");
                int studentId = rs.getInt("student_id");
                int status = rs.getInt("status");
                String dateBorrow = rs.getString("date_borrow");
                String dateReturn = rs.getString("date_turn");

                cardBorrowBook = new CardBorrowBook(cardId, bookId, studentId, status, dateBorrow, dateReturn);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return cardBorrowBook;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
