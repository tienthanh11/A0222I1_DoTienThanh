package model;

public class Object {
    private String id_object;
    private String id_patience;
    private String name_patience; // name of patience
    private String date_in;
    private String date_out;
    private String reason;

    public Object() {
    }

    public Object(String id_object, String id_patience, String name_patience, String date_in, String date_out, String reason) {
        this.id_object = id_object;
        this.id_patience = id_patience;
        this.name_patience = name_patience;
        this.date_in = date_in;
        this.date_out = date_out;
        this.reason = reason;
    }

    public String getId_object() {
        return id_object;
    }

    public void setId_object(String id_object) {
        this.id_object = id_object;
    }

    public String getId_patience() {
        return id_patience;
    }

    public void setId_patience(String id_patience) {
        this.id_patience = id_patience;
    }

    public String getName_patience() {
        return name_patience;
    }

    public void setName_patience(String name_patience) {
        this.name_patience = name_patience;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
