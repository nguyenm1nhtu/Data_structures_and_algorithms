package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Node {
    private String data;
    private int id;
    private boolean gender;
    private Date dateOfBirth;
    private List<Content> contentList;

    private List<String> favorite;

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Node(String data, boolean gender, Date dateOfBirth) {
        this.data = data;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.id = 0;
        this.contentList = new LinkedList<>();
        this.favorite = new LinkedList<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public List<String> getFavorite() {
        return favorite;
    }

    public String getGender() {
        if (this.gender) {
            return "Male";
        } else {
            return "Female";
        }
    }

    public String getDateOfBirth() {
        return this.dateFormat.format(this.dateOfBirth);
    }

    @Override
    public String toString() {
        return this.data + " - " + this.id;
    }
}
