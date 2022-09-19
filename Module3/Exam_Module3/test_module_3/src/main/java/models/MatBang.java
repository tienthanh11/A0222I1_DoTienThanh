package models;

import java.sql.Date;

public class MatBang {
    String id;
    int area;
    int status;
    int stage;
    int typeStage;
    String textStage;
    int price;
    Date dateIn;
    Date dateOut;

    public MatBang(String id, int area, int status, int stage, int typeStage, String textStage, int price, Date dateIn, Date dateOut) {
        this.id = id;
        this.area = area;
        this.status = status;
        this.stage = stage;
        this.typeStage = typeStage;
        this.textStage = textStage;
        this.price = price;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public MatBang() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(int typeStage) {
        this.typeStage = typeStage;
    }

    public String getTextStage() {
        return textStage;
    }

    public void setTextStage(String textStage) {
        this.textStage = textStage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }
}
