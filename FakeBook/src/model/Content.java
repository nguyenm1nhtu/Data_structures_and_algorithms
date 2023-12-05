package model;

import java.util.LinkedList;
import java.util.List;

public class Content  {
    private Node user;
    private String title;
    private String data;
    private int id;
    private List<Node> like;
    private List<String> comment;
    private String timeStamp;


    public Content(Node user, String title, String data, int id, String timeStamp) {
        this.user = user;
        this.title = title;
        this.data = data;
        this.id = id;
        this.timeStamp = timeStamp;
        this.like = new LinkedList<>();
        this.comment = new LinkedList<>();
    }

    public Node getUser() {
        return user;
    }

    public List<Node> getLike() {
        return like;
    }

    public List<String> getComment() {
        return comment;
    }

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public int getId() {
        return id;
    }

    public void addLike(Node node) {
        this.like.add(node);
    }

    public void addComment(Node node, String comment) {
        this.comment.add(node.toString() + ": " + comment);
    }

    @Override
    public String toString() {
        return "Content{" +
                "title=" + title +
                ", data=" + data +
                ", like=" + like +
                ", comment=" + comment +
                '}';
    }

    public String getStrLike() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        for (int i = 0; i < this.like.size(); i++) {
            sb.append(this.like.get(i)).append("<br/>");
        }
        sb.append("<html>");
        return sb.toString();
    }

    public String getStrComment() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        for (int i = 0; i < this.comment.size(); i++) {
            sb.append(this.comment.get(i)).append("<br/>");
        }
        sb.append("<html>");
        return sb.toString();
    }
}
