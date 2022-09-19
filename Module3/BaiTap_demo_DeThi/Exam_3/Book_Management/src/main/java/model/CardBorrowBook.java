package model;

public class CardBorrowBook {
    private String cardBorrowBookId;
    private int bookId;
    private int studentId;
    private int status;
    private String dateBorrow;
    private String dateTurn;

    public CardBorrowBook() {
    }

    public CardBorrowBook(String cardBorrowBookId, int bookId, int studentId, int status, String dateBorrow, String dateTurn) {
        this.cardBorrowBookId = cardBorrowBookId;
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.dateBorrow = dateBorrow;
        this.dateTurn = dateTurn;
    }

    public CardBorrowBook(int bookId, int studentId, int status, String dateBorrow, String dateTurn) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.dateBorrow = dateBorrow;
        this.dateTurn = dateTurn;
    }

    public String getCardBorrowBookId() {
        return cardBorrowBookId;
    }

    public void setCardBorrowBookId(String cardBorrowBookId) {
        this.cardBorrowBookId = cardBorrowBookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public String getDateTurn() {
        return dateTurn;
    }

    public void setDateTurn(String dateTurn) {
        this.dateTurn = dateTurn;
    }
}
