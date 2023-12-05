import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JAVA SWING");// tạo thể hiện của JFrame

        JPanel panel = new JPanel();

        JButton b = new JButton("click");// tạo thể hiện của JButton
        b.setBounds(130, 50, 100, 40);

        panel.add(b);// thêm button vào JFrame

        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);// thiết lập kích thước cho của sổ
        frame.setLayout(null);// không sử dụng trình quản lý bố cục
        frame.setVisible(true);// hiển thị cửa sổ
    }
}
