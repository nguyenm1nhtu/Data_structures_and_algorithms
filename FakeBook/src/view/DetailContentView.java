package view;

import javax.swing.*;
import java.awt.*;

public class DetailContentView {
    private JFrame jFrame = new JFrame();
    private JLabel jLabelUser = new JLabel();
    private JLabel jLabelTitle = new JLabel();
    private JLabel jLabelContent = new JLabel();
    private JLabel jLabelLike = new JLabel();
    private JLabel jLabelComment = new JLabel();
    private JLabel jLabelTime = new JLabel();

    public DetailContentView(String user, String title, String content, String like, String comment, String time) {
        this.jLabelUser.setText(user);
        this.jLabelTitle.setText(title);
        this.jLabelContent.setText(content);
        this.jLabelLike.setText(like);
        this.jLabelComment.setText(comment);
        this.jLabelTime.setText(time);

        init();
    }

    private void init() {
        this.jFrame.setTitle("Detail content");
        this.jFrame.setSize(600, 600);
        this.jFrame.setLocationRelativeTo(null);
        this.jFrame.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(6, 2));

        jPanel.add(new JLabel("User"));
        jPanel.add(this.jLabelUser);

        jPanel.add(new JLabel("Title"));
        jPanel.add(this.jLabelTitle);

        jPanel.add(new JLabel("Content"));
        jPanel.add(new JScrollPane(this.jLabelContent));

        jPanel.add(new JLabel("Like"));
        jPanel.add(new JScrollPane(this.jLabelLike));

        jPanel.add(new JLabel("Comment"));
        jPanel.add(new JScrollPane(this.jLabelComment));

        jPanel.add(new JLabel("Time"));
        jPanel.add(this.jLabelTime);

        this.jFrame.add(jPanel, BorderLayout.CENTER);
        this.jFrame.setVisible(true);
    }
}
