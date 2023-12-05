package test;

import model.Graph;
import model.Node;
import model.SocialMediaNetworkManagement;
import view.LoginPage;
import view.SocialMediaNetworkView;

public class Test {
    public static void main(String[] args) {
//        SocialMediaNetworkView socialMediaNetworkView = new SocialMediaNetworkView();
        LoginPage loginPage=new LoginPage();

        Graph graph=new Graph();
        Node node0=new Node("Rama",false,null);
        node0.setId(0);
        Node node1=new Node("Ella",false,null);
        node1.setId(1);
        Node node2=new Node("Bob",false,null);
        node2.setId(2);
        Node node3=new Node("Tom",false,null);
        node3.setId(3);
        Node node4=new Node("Lee",false,null);
        node4.setId(4);
        Node node5=new Node("Sam",false,null);
        node5.setId(5);
        Node node6=new Node("Katie",false,null);
        node6.setId(6);
        Node node7=new Node("Sam",false,null);
        node7.setId(7);
        Node node8=new Node("Zahir",false,null);
        node8.setId(8);
        Node node9=new Node("Arun",false,null);
        node9.setId(9);

        graph.addNode(node0);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);
        graph.addNode(node7);
        graph.addNode(node8);
        graph.addNode(node9);




        graph.addEdge(0,1);
        graph.addEdge(1,0);
        graph.addEdge(0,2);
        graph.addEdge(2,0);
        graph.addEdge(0,6);
        graph.addEdge(6,0);
        graph.addEdge(1,2);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(3,2);
        graph.addEdge(2,4);
        graph.addEdge(4,2);
        graph.addEdge(2,5);
        graph.addEdge(5,2);
        graph.addEdge(3,5);
        graph.addEdge(5,3);
        graph.addEdge(4,5);
        graph.addEdge(5,4);
        graph.addEdge(0,1);
        graph.addEdge(1,0);
        graph.addEdge(4,6);
        graph.addEdge(6,4);
        graph.addEdge(4,7);
        graph.addEdge(7,4);
        graph.addEdge(4,8);
        graph.addEdge(8,4);
        graph.addEdge(0,1);
        graph.addEdge(1,0);
        graph.addEdge(5,8);
        graph.addEdge(8,5);
        graph.addEdge(5,9);
        graph.addEdge(9,5);
        graph.addEdge(6,7);
        graph.addEdge(7,6);
        graph.addEdge(7,8);
        graph.addEdge(8,7);
        graph.addEdge(8,9);
        graph.addEdge(9,8);




        graph.breadthFirstSearch(0,2);
        graph.shortestPath(0);

//        SocialMediaNetworkManagement management=new SocialMediaNetworkManagement();
//        management.createUser(new Node("A",true,null));
//        management.createUser(new Node("B",true,null));
//        management.createUser(new Node("C",true,null));
//        management.createUser(new Node("D",true,null));
//        management.createUser(new Node("E",true,null));
//        management.createUser(new Node("F",true,null));
//
//        management.choiceUser(0);
//        management.addFriend(1);
//        management.addFriend(4);
//        management.addFriend(5);
//
//        management.choiceUser(1);
//        management.addFriend(2);
//
//        management.choiceUser(4);
//        management.addFriend(3);
//
//        management.choiceUser(5);
//        management.addFriend(3);
//
//        System.out.println(management.getSuggestFriend(0));

//        Graph graph=new Graph();
//        Node nodeA=new Node("A",true,null);
//        nodeA.setId(0);
//        Node nodeB=new Node("B",true,null);
//        nodeB.setId(1);
//        Node nodeC=new Node("C",true,null);
//        nodeC.setId(2);
//        Node nodeD=new Node("D",true,null);
//        nodeD.setId(3);
//        Node nodeE=new Node("E",true,null);
//        nodeE.setId(4);
//        Node nodeF=new Node("F",true,null);
//        nodeF.setId(5);
//        Node nodeG=new Node("G",true,null);
//        nodeG.setId(6);
//
//        graph.addNode(nodeA);
//        graph.addNode(nodeB);
//        graph.addNode(nodeC);
//        graph.addNode(nodeD);
//        graph.addNode(nodeE);
//        graph.addNode(nodeF);
//        graph.addNode(nodeG);
//
//        graph.addEdge(2,0);
//        graph.addEdge(2,5);
//        graph.addEdge(0,1);
//        graph.addEdge(0,3);
//        graph.addEdge(1,3);
//        graph.addEdge(1,4);
//        graph.addEdge(3,5);
//        graph.addEdge(3,6);
//        graph.addEdge(4,6);
//        graph.addEdge(6,5);
//
//        graph.shortestPath(2);
    }
}
