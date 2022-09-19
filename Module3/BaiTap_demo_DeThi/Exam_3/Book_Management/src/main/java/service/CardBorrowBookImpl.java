package service;

import model.CardBorrowBook;
import repository.BorrowRepositoryImpl;
import repository.IBorrowRepo;

public class CardBorrowBookImpl implements ICardBorrowBookService {
    IBorrowRepo borrowRepo = new BorrowRepositoryImpl();

    @Override
    public CardBorrowBook selectCardBorrowBook(int id) {
        return borrowRepo.selectBorrowBook(id);
    }
}
