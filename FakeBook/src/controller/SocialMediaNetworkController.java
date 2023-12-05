package controller;

import view.SocialMediaNetworkView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SocialMediaNetworkController implements ActionListener {
    private SocialMediaNetworkView view;

    public SocialMediaNetworkController(SocialMediaNetworkView view) {
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        JOptionPane.showMessageDialog(view, actionCommand);

        if (actionCommand.equals("Cancel")) {
            this.view.cancel();
        } else if (actionCommand.equals("Find")) {
            this.view.showSearchFriend();
        } else if (actionCommand.equals("Add friend")) {
            this.view.getIdFriend();
        } else if (actionCommand.equals("Accept")) {
            this.view.acceptFriend();
        } else if (actionCommand.equals("Refuse")) {
            this.view.refuseFriend();
        } else if (actionCommand.equals("Remove Friend")) {
            this.view.removeFriend();
        } else if (actionCommand.equals("Suggest friend")) {
            this.view.showSuggestFriend();
        } else if (actionCommand.equals("Back")) {
            this.view.backHome();
        } else if (actionCommand.equals("New content")) {
            this.view.newContent();
        } else if (actionCommand.equals("Add content")) {
            this.view.addContent();
        } else if (actionCommand.equals("Interact")) {
            this.view.interact();
        } else if (actionCommand.equals("Save interact")) {
            this.view.saveInteract();
        } else if (actionCommand.equals("Detail content")) {
            this.view.newWindowDetail();
        } else if (actionCommand.equals("Log out")) {
            this.view.logOut();
        }
    }
}
