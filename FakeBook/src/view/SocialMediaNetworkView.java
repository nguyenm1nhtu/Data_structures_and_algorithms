package view;

import controller.SocialMediaNetworkController;
import model.Content;
import model.Node;
import model.SocialMediaNetworkManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Queue;

public class SocialMediaNetworkView extends JFrame {
    private SocialMediaNetworkManagement management;

    private JPanel jPanelAbove;
    private JPanel jPanelManagement;
    private JTextField jTextFieldName;
    private JComboBox jComboBoxListUser;
    private JPanel jPanelOperation;
    private JLabel jLabelCurrentUser;
    private JComboBox jComboBoxListFriend;
    private JTextField jTextFieldID;
    private JComboBox jComboBoxRequest;


    private JLabel jLabelUser;
    private JTextField jTextFieldComment;
    private JCheckBox jCheckBoxLike;
    private JPanel jPanelBoard;
    private JPanel jPanelBelow;
    private JTextArea jTextAreaContent;
    private JPanel jPanelNewContent;
    private JTable jTableNews;
    private JLabel jLabelNewContentUser;
    private JPanel jPanelInteract;
    private JComboBox jComboBoxTitle;
    private JTextField jTextFieldSearchFriend;
    private JPanel jPanelMain;
    private JTable jTableUser;
    private SocialMediaNetworkController actionListener;
    private JPanel jPanelSearch;
    private LoginPage loginPage;
    private JPanel jPanelSuggest;
    private boolean isCancel = false;


    public SocialMediaNetworkView(LoginPage loginPage) {
        this.loginPage = loginPage;
        this.management = new SocialMediaNetworkManagement();
        init();
    }

    private void init() {
        this.setTitle("Social Media Network");
        this.setSize(800, 700);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Image Icon
        ImageIcon icon = new ImageIcon("src\\view\\Java-icon.png");
        this.setIconImage(icon.getImage());

        // Color of background
        this.getContentPane().setBackground(new Color(123, 50, 250));

        // ActionListener - Controller
        actionListener = new SocialMediaNetworkController(this);

        // JPanel Above -> this: North
        this.jPanelAbove = new JPanel();
        this.jPanelAbove.setLayout(new BorderLayout(10, 10));
        this.jPanelAbove.add(new JLabel("Management"), BorderLayout.NORTH);

        // JPanel Management -> JPanel Above: Center
        this.jPanelManagement = new JPanel();
        this.jPanelManagement.setLayout(new GridLayout(1, 3));
        this.jPanelManagement.add(new JLabel());
        this.jPanelManagement.add(new JLabel());

        JButton jButtonLogOut = new JButton("Log out");
        jButtonLogOut.addActionListener(actionListener);
        this.jPanelManagement.add(jButtonLogOut);
//
//        this.jPanelManagement.add(new JLabel("Create user"));
//
//        this.jTextFieldName = new JTextField();
//        this.jPanelManagement.add(this.jTextFieldName);
//
//        JButton jButtonOK = new JButton("OK");
//        jButtonOK.addActionListener(actionListener);
//        this.jPanelManagement.add(jButtonOK);
//
//        //
//        jButtonOK.setFocusable(false);
//        //
//        jButtonOK.setEnabled(true);
//
//        this.jPanelManagement.add(new JLabel("List user"));
//
//        this.jComboBoxListUser = new JComboBox();
//        this.jComboBoxListUser.addItem("");
//        this.jPanelManagement.add(this.jComboBoxListUser);
//
//        JButton jButtonChangeUser = new JButton("Change");
//        jButtonChangeUser.addActionListener(actionListener);
//        this.jPanelManagement.add(jButtonChangeUser);
//
        this.jPanelAbove.add(this.jPanelManagement, BorderLayout.CENTER);

        // JPanel Operation -> JPanel Above: South
        this.jPanelOperation = new JPanel();
        this.jPanelOperation.setLayout(new GridLayout(3, 5));

        this.jLabelCurrentUser = new JLabel("Current user: ");
        this.jPanelOperation.add(this.jLabelCurrentUser);

        this.jPanelOperation.add(new JLabel("List Friend"));

        this.jComboBoxListFriend = new JComboBox();
        this.jPanelOperation.add(this.jComboBoxListFriend);

        JButton jButtonRemoveFriend = new JButton("Remove Friend");
        jButtonRemoveFriend.addActionListener(actionListener);
        this.jPanelOperation.add(jButtonRemoveFriend);

        JButton jButtonSuggestFriend = new JButton("Suggest friend");
        jButtonSuggestFriend.addActionListener(actionListener);
        this.jPanelOperation.add(jButtonSuggestFriend);

        this.jPanelOperation.add(new JLabel(""));

        this.jPanelOperation.add(new JLabel("Search Friend"));

        jTextFieldSearchFriend = new JTextField();
        jPanelOperation.add(jTextFieldSearchFriend);

        JButton jButtonFind = new JButton("Find");
        jButtonFind.addActionListener(actionListener);
        jPanelOperation.add(jButtonFind);

        JButton jButtonCancel = new JButton("Cancel");
        jButtonCancel.addActionListener(actionListener);
        this.jPanelOperation.add(jButtonCancel);

//        this.jPanelOperation.add(new JLabel(""));

//        this.jPanelOperation.add(new JLabel("Add Friend"));
//
//        this.jTextFieldID = new JTextField();
//        this.jPanelOperation.add(this.jTextFieldID);
//
//        JButton jButtonAdd = new JButton("Add");
//        jButtonAdd.addActionListener(actionListener);
//        this.jPanelOperation.add(jButtonAdd);

//        this.jPanelOperation.add(new JLabel(""));
        this.jPanelOperation.add(new JLabel(""));

        this.jPanelOperation.add(new JLabel("Request"));

        this.jComboBoxRequest = new JComboBox();
        this.jPanelOperation.add(this.jComboBoxRequest);

        JButton jButtonAccept = new JButton("Accept");
        jButtonAccept.addActionListener(actionListener);
        this.jPanelOperation.add(jButtonAccept);

        JButton jButtonRefuse = new JButton("Refuse");
        jButtonRefuse.addActionListener(actionListener);
        this.jPanelOperation.add(jButtonRefuse);

        // JPanel Operation -> JPanel Above: South
        this.jPanelAbove.add(this.jPanelOperation, BorderLayout.SOUTH);

        // Add JPanel Above -> this: North
        this.add(this.jPanelAbove, BorderLayout.NORTH);


        // JPanel Main -> this: Center
        jPanelMain = new JPanel();
        jPanelMain.setLayout(new BorderLayout());

        // JLable News -> JPanel Main: North
        JLabel jLabelNews = new JLabel("News");
        jLabelNews.setForeground(Color.RED);
        jLabelNews.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jLabelNews.setBackground(Color.CYAN);
        jLabelNews.setOpaque(true);
        jLabelNews.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        jLabelNews.setVerticalAlignment(JLabel.CENTER);
        jLabelNews.setHorizontalAlignment(JLabel.CENTER);
        jPanelMain.add(jLabelNews, BorderLayout.NORTH);

        // JTable News -> JPanel Main: Center
        jTableNews = new JTable();
        jTableNews.setModel(new DefaultTableModel(
                new Object[][]{
                }, new String[]{
                "User", "Title", "Content", "Like", "Comment", "Time"
        }
        ));
        JScrollPane jScrollPane = new JScrollPane(jTableNews);
        jPanelMain.add(jScrollPane, BorderLayout.CENTER);


        // JPanel Main -> this: Center
        this.add(jPanelMain, BorderLayout.CENTER);


        // JPanel Below -> this: North
        jPanelBelow = new JPanel();
        jPanelBelow.setLayout(new BorderLayout());

        jPanelBelow.add(new JLabel("Detail"), BorderLayout.NORTH);

        // JPanel Board -> JPanel Below: Center
//        jPanelBoard = new JPanel();
//        jPanelBoard.setLayout(new GridLayout(5, 2));
//
//        jPanelBoard.add(new JLabel("User"));
//
//        jLabelUser = new JLabel();
//        jPanelBoard.add(jLabelUser);
//
//        jPanelBoard.add(new JLabel("Title"));
//
//        jTextFieldTitle = new JTextField();
//        jPanelBoard.add(jTextFieldTitle);
//
//        jPanelBoard.add(new JLabel("Content"));
////        JTextField jTextFieldContent=new JTextField();
////        jPanelBoard.add(jTextFieldContent);
//
//        jTextAreaContent = new JTextArea();
//        jPanelBoard.add(jTextAreaContent);
//
//        jPanelBoard.add(new JLabel("Like"));
//
//        jCheckBoxLike = new JCheckBox("Like");
//        jPanelBoard.add(jCheckBoxLike);
//
//        jPanelBoard.add(new JLabel("Comment"));
//
//        jTextFieldComment = new JTextField();
//        jPanelBoard.add(jTextFieldComment);

//        jPanelBelow.add(jPanelBoard, BorderLayout.CENTER);


        // JPanel Content -> JPanel Below: North
        JPanel jPanelContent = new JPanel();
        jPanelContent.setLayout(new GridLayout(1, 5));

        JButton jButtonDetailContent = new JButton("Detail content");
        jButtonDetailContent.addActionListener(actionListener);
        jPanelContent.add(jButtonDetailContent);

        JButton jButtonNewContent = new JButton("New content");
        jButtonNewContent.addActionListener(actionListener);
        jPanelContent.add(jButtonNewContent);

        JButton jButtonAddContent = new JButton("Add content");
        jButtonAddContent.addActionListener(actionListener);
        jPanelContent.add(jButtonAddContent);

        JButton jButtonInteract = new JButton("Interact");
        jButtonInteract.addActionListener(actionListener);
        jPanelContent.add(jButtonInteract);

        JButton jButtonSaveInteract = new JButton("Save interact");
        jButtonSaveInteract.addActionListener(actionListener);
        jPanelContent.add(jButtonSaveInteract);

        // JPanel Content -> JPanel Below: South
        jPanelBelow.add(jPanelContent, BorderLayout.SOUTH);


        // JPanel Below -> this: South
        this.add(jPanelBelow, BorderLayout.SOUTH);

        // Visible
//        this.setVisible(false);
    }

    public void setVisibleView(boolean status) {
        this.setVisible(status);
    }

//        public void addUser() {
//        String name = this.jTextFieldName.getText();
//        Node user = new Node(name);
//        this.management.createUser(user);
////        this.management.printUser();
//        updateListUser(user);
//    }

//    public void addUser(String name) {
//        Node user = new Node(name);
//        this.management.createUser(user);
//    }

    public void addUser(Node user) {
        //Node user = new Node(name);
        this.management.createUser(user);
    }

    private void updateListUser(Node user) {
        this.jComboBoxListUser.addItem(user.toString());
    }

    //    public void changeUser() {
//        String[] user = this.jComboBoxListUser.getSelectedItem().toString().split(" - ");
//        this.jLabelCurrentUser.setText("Current user: " + user[0]);
//        this.management.choiceUser(Integer.parseInt(user[user.length - 1]));
//
//        updateRequest();
//        updateFriend();
//
//        updateNews();
////        this.management.printCurrentUser();
//    }
    public void changeUser(int userId, String username) {
        this.jLabelCurrentUser.setText("Current user: " + username);
        this.management.choiceUser(userId);

        updateRequest();
        updateFriend();

        updateNews();
    }

    private void updateNews() {
        DefaultTableModel model = (DefaultTableModel) jTableNews.getModel();
        model.setRowCount(0);

        List<Content> listContent = this.management.getListContent();
        for (int i = 0; i < listContent.size(); i++) {
            this.addContentIntoTable(listContent.get(i));
        }
    }

    public void cancel() {
        this.remove(jPanelSearch);
        this.add(jPanelMain, BorderLayout.CENTER);
        this.add(jPanelBelow, BorderLayout.SOUTH);
        this.setVisible(false);
        this.setVisible(true);
        isCancel = false;
    }

    public void getIdFriend() {
//        int id = Integer.parseInt(this.jTextFieldID.getText());
        DefaultTableModel model = (DefaultTableModel) this.jTableUser.getModel();
        int selectRow = jTableUser.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectRow, 0).toString().split(" - ")[1]);
        System.out.println(id);
        this.management.addRequest(id);
    }

    public void updateRequest() {
        this.jComboBoxRequest.removeAllItems();
        this.jComboBoxRequest.addItem("");
        for (Node node : this.management.getListRequest()) {
            this.jComboBoxRequest.addItem(node.toString());
        }
    }

    public void acceptFriend() {
        String[] user = this.jComboBoxRequest.getSelectedItem().toString().split(" - ");
        int id = Integer.parseInt(user[user.length - 1]);
        this.management.addFriend(id);
        this.management.removeRequest(id);

        updateRequest();
        updateFriend();
        updateNews();
    }

    public void updateFriend() {
        this.jComboBoxListFriend.removeAllItems();
        this.jComboBoxListFriend.addItem("");
        for (Node node : this.management.getListFriend()) {
            this.jComboBoxListFriend.addItem(node.toString());
        }
    }

    public void refuseFriend() {
        String[] user = this.jComboBoxRequest.getSelectedItem().toString().split(" - ");
        int id = Integer.parseInt(user[user.length - 1]);
        this.management.removeRequest(id);
        updateRequest();
    }

    public void newContent() {
        jPanelNewContent = new JPanel();
        jPanelNewContent.setLayout(new GridLayout(3, 2));

        jPanelNewContent.add(new JLabel("User"));

        jLabelNewContentUser = new JLabel();
        jLabelNewContentUser.setText(this.management.getCurrentUser().toString() + " - "
                + this.management.getCurrentUser().getContentList().size());
        jPanelNewContent.add(jLabelNewContentUser);

        jPanelNewContent.add(new JLabel("Title"));

        jComboBoxTitle = new JComboBox();
        jComboBoxTitle.addItem("");
        jComboBoxTitle.addItem("Game");
        jComboBoxTitle.addItem("Wibu");
        jComboBoxTitle.addItem("Code");

        jPanelNewContent.add(jComboBoxTitle);

        jPanelNewContent.add(new JLabel("Content"));

        jTextAreaContent = new JTextArea();
        jPanelNewContent.add(jTextAreaContent);

        this.jPanelBelow.add(jPanelNewContent, BorderLayout.CENTER);
        this.setVisible(false);
        this.setVisible(true);
        //jPanelNewContent.setVisible(true);


//        this.jLabelUser.setText(this.management.getCurrentUser().toString() + " - "
//                + this.management.getCurrentUser().getContentList().size());
//        this.jTextFieldTitle.setText("");
//        this.jTextAreaContent.setText("");
//        this.jCheckBoxLike.setSelected(false);
//        this.jTextFieldComment.setText("");
    }

    public void addContent() {
        String title = this.jComboBoxTitle.getSelectedItem().toString();
        String data = this.jTextAreaContent.getText();

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        int idContent = this.management.getCurrentUser().getContentList().size();
        Content content = new Content(this.management.getCurrentUser(), title, data, idContent, timeStamp);

        this.management.addContent(content);

        this.addContentIntoTable(content);

        this.jPanelBelow.remove(jPanelNewContent);
        this.setVisible(false);
        this.setVisible(true);
    }

    private void addContentIntoTable(Content content) {
//        int idContent = this.management.getCurrentUser().getContentList().size() - 1;
//        int idContent = user.getContentList().size()-1;
        DefaultTableModel model = (DefaultTableModel) this.jTableNews.getModel();
        model.addRow(
                new Object[]{
                        content.getUser().toString() + " - " + content.getId(),
                        content.getTitle(),
                        content.getData(),
                        content.getLike().size(),
                        content.getComment().size(),
                        content.getTimeStamp()
                });
    }

    public void interact() {
        String[] data = this.getContentFromTable();

        jPanelInteract = new JPanel();
        jPanelInteract.setLayout(new GridLayout(3, 2));

        jPanelInteract.add(new JLabel("User"));

        JLabel jLabelInteractUser = new JLabel();
        jLabelInteractUser.setText(data[0]);
        jPanelInteract.add(jLabelInteractUser);

        jPanelInteract.add(new JLabel("Like"));

        jCheckBoxLike = new JCheckBox("Like");
        jPanelInteract.add(jCheckBoxLike);

        jPanelInteract.add(new JLabel("Comment"));

        jTextFieldComment = new JTextField();
        jPanelInteract.add(jTextFieldComment);

        this.jPanelBelow.add(jPanelInteract, BorderLayout.CENTER);
        this.setVisible(false);
        this.setVisible(true);
    }

    public String[] getContentFromTable() {
        DefaultTableModel model = (DefaultTableModel) this.jTableNews.getModel();
        int selectRow = jTableNews.getSelectedRow();

        String[] data = new String[6];
        data[0] = model.getValueAt(selectRow, 0).toString();
        data[1] = model.getValueAt(selectRow, 1).toString();
        data[2] = model.getValueAt(selectRow, 2).toString();
        data[3] = model.getValueAt(selectRow, 3).toString();
        data[4] = model.getValueAt(selectRow, 4).toString();
        data[5] = model.getValueAt(selectRow, 5).toString();

        return data;
    }

    public void removeFriend() {
        String[] user = this.jComboBoxListFriend.getSelectedItem().toString().split(" - ");
        int id = Integer.parseInt(user[user.length - 1]);
        this.management.removeFriend(id);
    }


    public void saveInteract() {
        String[] data = this.getContentFromTable();
        int idUser = Integer.parseInt(data[0].split(" - ")[1]);
        int idContent = Integer.parseInt(data[0].split(" - ")[2]);
        String title = data[1];

        if (this.jCheckBoxLike.isSelected()) {
            this.management.getListUser().get(idUser).getContentList().get(idContent)
                    .addLike(this.management.getCurrentUser());
            this.management.getCurrentUser().getFavorite().add(title);
        }
        if (!this.jTextFieldComment.getText().equals("")) {
            this.management.getListUser().get(idUser).getContentList().get(idContent)
                    .addComment(this.management.getCurrentUser(), this.jTextFieldComment.getText());
        }

        this.jPanelBelow.remove(jPanelInteract);
        this.setVisible(false);
        this.setVisible(true);
    }

    public void newWindowDetail() {
        String[] data = this.getContentFromTable();
        int idUser = Integer.parseInt(data[0].split(" - ")[1]);
        int idContent = Integer.parseInt(data[0].split(" - ")[2]);

        Content content = this.management.getListUser().get(idUser).getContentList().get(idContent);
        DetailContentView detailContentView = new DetailContentView(data[0], content.getTitle(),
                content.getData(), content.getStrLike(), content.getStrComment(), content.getTimeStamp());
    }

//    public void showProfile() {
//        int idUser1 = Integer.parseInt(this.management.getCurrentUser().toString().split(" - ")[1]);
//        int idUser2 = Integer.parseInt(this.jComboBoxListFriend.getSelectedItem().toString().split(" - ")[1]);
//
//        this.management.getMutualFriends(idUser1, idUser2);
//        Node user = this.management.getListUser().get(idUser2);
//        ProfileView profileView = new ProfileView(user);
//    }

    public void showSearchFriend() {
        String name = this.jTextFieldSearchFriend.getText();
        ArrayList<Node> listSearch = this.management.getSearchFriend(name);


        jPanelSearch = new JPanel();
        jPanelSearch.setLayout(new BorderLayout());

        jPanelSearch.add(new JLabel("Result search"), BorderLayout.NORTH);

        jTableUser = new JTable();
        jTableUser.setModel(new DefaultTableModel(
                new Object[][]{
                }, new String[]{
                "User", "Gender", "Date of birth", "Mutual friend"
        }
        ));

        for (int i = 0; i < listSearch.size(); i++) {
            addUserIntoTable(listSearch.get(i),
                    this.management.getMutualFriends(
                            this.management.getCurrentUser().getId(), listSearch.get(i).getId()).size());
        }

        JScrollPane jScrollPane = new JScrollPane(jTableUser);
        jPanelSearch.add(jScrollPane, BorderLayout.CENTER);

        JButton jButtonAdd = new JButton("Add friend");
        jButtonAdd.addActionListener(actionListener);
        jPanelSearch.add(jButtonAdd, BorderLayout.SOUTH);

        if (isCancel == false) {
            this.remove(jPanelMain);
            this.remove(jPanelBelow);
            this.add(jPanelSearch, BorderLayout.CENTER);
            isCancel = true;
        }

        this.setVisible(false);
        this.setVisible(true);
    }

    private void addUserIntoTable(Node user, int mutualFriend) {
        DefaultTableModel model = (DefaultTableModel) this.jTableUser.getModel();
        model.addRow(
                new Object[]{
                        user.toString(),
                        user.getGender(),
                        user.getDateOfBirth(),
                        mutualFriend
                }
        );
    }

    public void logOut() {
        this.setVisible(false);
        this.loginPage.setVisibleView(true);
    }

    public void showSuggestFriend() {
        ArrayList<Node> list = this.management.getSuggestFriend(this.management.getCurrentUser().getId());
        this.remove(jPanelMain);
        this.remove(jPanelBelow);

        jPanelSuggest = new JPanel();
        jPanelSuggest.setLayout(new BorderLayout());

        jPanelSuggest.add(new JLabel("Result suggest"), BorderLayout.NORTH);

        jTableUser = new JTable();
        jTableUser.setModel(new DefaultTableModel(
                new Object[][]{
                }, new String[]{
                "User", "Gender", "Date of birth", "Mutual friend"
        }
        ));


        for (int i = 0; i < list.size(); i++) {
            addUserIntoTable(list.get(i),
                    this.management.getMutualFriends(
                            this.management.getCurrentUser().getId(), list.get(i).getId()).size());
        }

        JScrollPane jScrollPane = new JScrollPane(jTableUser);
        jPanelSuggest.add(jScrollPane, BorderLayout.CENTER);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new GridLayout(1, 2));

        JButton jButtonAdd = new JButton("Add friend");
        jButtonAdd.addActionListener(actionListener);
        jPanelButton.add(jButtonAdd);

        JButton jButtonBack = new JButton("Back");
        jButtonBack.addActionListener(actionListener);
        jPanelButton.add(jButtonBack);

        jPanelSuggest.add(jPanelButton, BorderLayout.SOUTH);

        this.add(jPanelSuggest, BorderLayout.CENTER);
        this.setVisible(false);
        this.setVisible(true);
    }

    public void backHome() {
        this.remove(jPanelSuggest);
        this.add(jPanelMain, BorderLayout.CENTER);
        this.add(jPanelBelow, BorderLayout.SOUTH);
        this.setVisible(false);
        this.setVisible(true);
    }
}
