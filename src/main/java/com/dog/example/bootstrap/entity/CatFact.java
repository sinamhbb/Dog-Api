package com.dog.example.bootstrap.entity;

public class CatFact {
    private String _id;
    private String text;

    public CatFact(String _id, String text) {
        this._id = _id;
        this.text = text;
    }

    public CatFact() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "catFact{" +
                "id=" + _id +
                ", text='" + text + '\'' +
                '}';
    }
}
