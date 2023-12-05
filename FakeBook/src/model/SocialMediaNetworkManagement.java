package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SocialMediaNetworkManagement {
    private LinkedList<Node> listUser;
    private Graph graphFriend;
    private Graph graphRequest;
    private int id;
    private Node currentUser;

    public SocialMediaNetworkManagement() {
        this.listUser = new LinkedList<>();
        this.graphFriend = new Graph();
        this.graphRequest = new Graph();
        this.id = 0;
        this.currentUser = null;
    }


    public Node getCurrentUser() {
        return currentUser;
    }

    public LinkedList<Node> getListUser() {
        return listUser;
    }

    public void createUser(Node user) {
        user.setId(id);
        this.graphFriend.addNode(user);
        this.graphRequest.addNode(user);
        this.listUser.add(user);
        this.id++;
    }

    public void choiceUser(int id) {
        this.currentUser = this.listUser.get(id);
//        this.currentUser = this.graphFriend.getAlist().get(id).get(0);
    }

    public void addFriend(int idDst) {
        this.graphFriend.addEdge(this.currentUser.getId(), idDst);
        this.graphFriend.addEdge(idDst, this.currentUser.getId());
    }

    public List<Node> getListFriend() {
        List<Node> listFriend = this.graphFriend.getAlist().get(this.currentUser.getId());
        return listFriend.subList(1, listFriend.size());
    }

    public void addRequest(int id) {
        if (this.graphFriend.checkEdge(id, this.currentUser.getId()) ||
                this.graphRequest.checkEdge(id, this.currentUser.getId()) ||
                this.graphRequest.checkEdge(this.currentUser.getId(), id)) {
            return;
        }
        this.graphRequest.addEdge(id, this.currentUser.getId());
    }

    public List<Node> getListRequest() {
        List<Node> request = this.graphRequest.getAlist().get(this.currentUser.getId());
        request = request.subList(1, request.size());
        Collections.reverse(request);
        return request;
    }

    public void removeRequest(int id) {
        this.graphRequest.removeEdge(this.currentUser.getId(), id);
    }

    public void addContent(Content content) {
        this.currentUser.getContentList().add(content);
//        System.out.println(this.currentUser.getContentList());
    }

    public void removeFriend(int idDst) {
        this.graphFriend.removeEdge(this.currentUser.getId(), idDst);
        this.graphFriend.removeEdge(idDst, this.currentUser.getId());
    }

    public List<Content> getListContent() {
//        List<Content> contentList = new LinkedList<>();
//        for (int i = 0; i < this.currentUser.getContentList().size(); i++) {
//            contentList.add(this.currentUser.getContentList().get(i));
//        }
//        for (int i = 0; i < listFriend.size(); i++) {
//            for (int j = 0; j < listFriend.get(i).getContentList().size(); j++) {
//                contentList.add(listFriend.get(i).getContentList().get(j));
//            }
//        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Content> contentList = new LinkedList<>(this.currentUser.getContentList());
        List<Node> listFriend = this.getListFriend();
        for (Node node : listFriend) {
            contentList.addAll(node.getContentList());
        }

        contentList.sort((o1, o2) -> {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(o1.getTimeStamp());
                date2 = dateFormat.parse(o2.getTimeStamp());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return date1.compareTo(date2);
        });
        return contentList;
    }

    public List<Node> getMutualFriends(int idUser1, int idUser2) {
        List<Node> friendsUser1 = this.graphFriend.getAlist().get(idUser1);
        List<Node> friendsUser2 = this.graphFriend.getAlist().get(idUser2);
        List<Node> mutualFriend = new ArrayList<>(friendsUser1);
        mutualFriend.retainAll(friendsUser2);
        mutualFriend.remove(this.listUser.get(idUser1));
        mutualFriend.remove(this.listUser.get(idUser2));
        System.out.println("mutual friend " + idUser1 + " " + idUser2 + " " + mutualFriend);
        return mutualFriend;
    }

    private class priorityNode implements Comparable<priorityNode> {
        Node user;
        int priority;

        public priorityNode(Node user, int priority) {
            this.user = user;
            this.priority = priority;
        }


        @Override
        public int compareTo(priorityNode o) {
            return o.priority - this.priority;
        }
    }

    public ArrayList<Node> getSuggestFriend(int src) {
        Queue<Node> queue = this.graphFriend.breadthFirstSearch(src, 2);
        System.out.println(queue);

        Queue<priorityNode> priorityNodeQueue = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Node user = queue.poll();
            priorityNodeQueue.offer(new priorityNode(user, getMutualFriends(src, user.getId()).size()));
        }

        ArrayList<Node> list = new ArrayList<>();
        while (!priorityNodeQueue.isEmpty()) {
            list.add(priorityNodeQueue.poll().user);
        }
        System.out.println(list);
        return list;
    }

    public ArrayList<Node> getSearchFriend(String name) {
        int[] distance = this.graphFriend.shortestPath(this.currentUser.getId());

        Queue<priorityNode> priorityNodeQueue = new PriorityQueue<>();
        for (int i = 0; i < this.listUser.size(); i++) {
            if (this.listUser.get(i).getData().indexOf(name) >= 0) {
                priorityNodeQueue.offer(new priorityNode(
                        this.listUser.get(i), distance[this.listUser.get(i).getId()]));
            }
        }

        ArrayList<Node> listSearch = new ArrayList<>();
        while (!priorityNodeQueue.isEmpty()) {
            listSearch.add(priorityNodeQueue.poll().user);
        }

        return listSearch;
    }
}
