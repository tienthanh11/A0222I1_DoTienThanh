package repository;

import model.CardBorrowBook;

public interface IBorrowRepo {
    CardBorrowBook selectBorrowBook(int id);
}
