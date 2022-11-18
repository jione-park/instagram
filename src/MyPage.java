import java.awt.*;
import javax.swing.*;

public class MyPage extends JFrame{

    public JPanel first;
    public JPanel p;
    public JLabel app;
    public JPanel p1;
    public JPanel p1_p1;
    public JPanel p1_p1_1;
    public JPanel p1_p1_1_1;
    public JPanel p1_p1_2;
    public JPanel p1_p2;
    public JPanel p2;
    //public JList l1;


    public MyPage(){


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        first = new JPanel();
        first.setLayout(new BorderLayout());

        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        app = new JLabel("instagram");
        p.add(app);

        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));

        //유저 데이터에서 사진 불러옴
        ImageIcon img_icon = new ImageIcon("/Users/parkjiwon/IdeaProjects/instagram/button image/default.png");
        Image img = img_icon.getImage();
        Image changeImg = img.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImg);
        JButton profile = new JButton(changeIcon);

        p1_p1 = new JPanel(); //팔로우, 팔로워
        p1_p1.setLayout(new FlowLayout());

        p1_p1_1 = new JPanel();
        p1_p1_1.setLayout(new BorderLayout());
        p1_p1_1_1 = new JPanel();
        p1_p1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton follow = new JButton("follow");
        JLabel follow2 = new JLabel("num");
        p1_p1_1_1.add(follow2);
        p1_p1_1.add(follow, BorderLayout.CENTER);
        p1_p1_1.add(p1_p1_1_1, BorderLayout.SOUTH);

        p1_p1_2 = new JPanel();
        p1_p1_2.setLayout(new BorderLayout());
        JPanel p1_p1_2_1 = new JPanel();
        p1_p1_2_1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton follower = new JButton("follower");
        JLabel follower2 = new JLabel("num");
        p1_p1_2_1.add(follower2);
        p1_p1_2.add(follower, BorderLayout.CENTER);
        p1_p1_2.add(p1_p1_2_1, BorderLayout.SOUTH);

        p1_p2 = new JPanel(); //change, cancle
        p1_p2.setLayout(new BorderLayout());

        JButton change = new JButton("Modify Profile");
        JButton cancle = new JButton("cancle");

        p1_p2.add(change, BorderLayout.CENTER);
        p1_p2.add(cancle, BorderLayout.SOUTH);

        p1.add(profile);
        p1.add(p1_p1_1);
        p1.add(p1_p1_2);
        p1.add(p1_p2);

        first.add(p, BorderLayout.NORTH);
        first.add(p1, BorderLayout.CENTER);

        p2 = new JPanel();
        p2.setBackground(Color.blue);

        //l1 = new JList(new DefaultListModel());
        //user id를 불러옴
        //while문으로 user id에 해당하는 post들을 불러와서 JList에 저장 - post table
        //post (text, created_at)
        // post media(content)
        // post_hashtag(hashtag id)
        // hashtag(hashtag)
        // comment(content, user_id, created_at)
        // post_like(user_id) -> count



        add(first, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setVisible(true);
    }

}