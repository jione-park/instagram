import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.awt.*;

public class MainPage extends JFrame  implements ActionListener {



    private JButton button1;

    private JButton button2;

    private JButton button3;

    private  JLabel label1;

    private JPanel panel;
    int id;



    MainPage(int user_id)
    {
        id = user_id;
        this.setLocation(200,0);

        this.setTitle("이벤트");

        this.setSize(500, 500);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        panel = new JPanel();

        label1 = new JLabel("Instagram");

        button1 = new JButton("내 정보");
        button1.addActionListener(this);

        button2 = new JButton("다른 사용자");
        button2.addActionListener(this);

        button3 = new JButton("로그아웃");
        button3.addActionListener(this);

        JTextField cmd = new JTextField("댓글 남기기");

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        mainPost mainPost = new mainPost(user_id);
        panel2.add(mainPost);
        /*for(int i = 0; post[i] != null; i++){
            System.out.println(post[i]);
        }*/

        panel2.add(mainPost.scroll, BorderLayout.CENTER);

        panel.add(label1);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        this.add(panel, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(cmd, BorderLayout.SOUTH);

        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button1) {

            server ab = new server();
            int follow_number = ab.getfollowNumber(id);
            System.out.println("follow : " + follow_number);

            server abc = new server();
            int following_number = ab.getfollowingNumber(id);
            System.out.println("follow : " + following_number);

            new MyPage(id, follow_number, following_number);
            setVisible(false);
        }
        else if(e.getSource()==button2) {
            new userList(id);
            setVisible(true);
        }
        else if(e.getSource() == button3)
        {
            new Main();
            setVisible(false);
        }
    }

}