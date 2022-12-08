import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class OtherPage extends JFrame{
    server sv = new server(1);
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

    public  JLabel nick;
    //public JList l1;

    public OtherPage(String email, int user_id){

        int go_to_page = sv.get_id(email);
        int following_number = sv.get_following_num(go_to_page);
        int follow_number = sv.getfollowNumber(go_to_page);

        nick = new JLabel(email);

        //  setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        setBounds(100,100,500,500);
        setLayout(new BorderLayout());
        first = new JPanel();
        first.setLayout(new BorderLayout());

        //p panel -> 인스타 그램 로고만 붙어있음 -> 로고 누르면 홈으로 가게 처리해야함
        p = new JPanel();
        p.setBounds(100,100,500,500);
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        app = new JLabel("instagram");
        p.add(app);


        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));

        //유저 테이블에 프로필 사진 저장해야할 수 있어야 함
        ImageIcon img_icon = new ImageIcon("/Users/parkjiwon/IdeaProjects/instagram/button image/default.png");
        Image img = img_icon.getImage();
        Image changeImg = img.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImg);
        JButton profile = new JButton(changeIcon);

        /*profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Gallery();
            }
        });*/

        p1_p1 = new JPanel(); //팔로우, 팔로워
        p1_p1.setLayout(new FlowLayout());

        p1_p1_1 = new JPanel();
        p1_p1_1.setLayout(new BorderLayout());
        p1_p1_1_1 = new JPanel();
        p1_p1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER));

        //follow 버튼 누르면 팔로우 한 사람 테이블 창 띄어야함
        JButton follow = new JButton("나를 팔로우한 사람");
        follow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server sv = new server();
                int count = 0;
                ResultSet result = sv.get_follow(go_to_page);
                String[] str = sv.get_NickNames(result);
                for(int i=0; str[i] != null; i++)
                {
                    count++;
                }
                String[] abc = new String[count];
                abc = str;
                new follow_list(abc);
            }
        });


        String fm = String.valueOf(following_number);


        JLabel follow2 = new JLabel(fm);


        p1_p1_1_1.add(follow2);
        p1_p1_1.add(follow, BorderLayout.CENTER);
        p1_p1_1.add(p1_p1_1_1, BorderLayout.SOUTH);

        p1_p1_2 = new JPanel();
        p1_p1_2.setLayout(new BorderLayout());
        JPanel p1_p1_2_1 = new JPanel();
        p1_p1_2_1.setLayout(new FlowLayout(FlowLayout.CENTER));

        //follower 버튼 누르면 나를 팔로잉 한 사람 테이블 창 띄어야함
        JButton follower = new JButton("내가 팔로우한 사람");
        follower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server sv = new server();
                int count = 0;
                ResultSet result = sv.get_follower(go_to_page);
                String[] str = sv.get_NickName(result);
                for(int i=0; str[i] != null; i++)
                {
                    count++;
                }
                String[] abc = new String[count];
                abc = str;
                new follow_list(abc);
            }
        });


        String fw = Integer.toString(follow_number);
        JLabel follower2 = new JLabel(fw);
        p1_p1_2_1.add(follower2);
        p1_p1_2.add(follower, BorderLayout.CENTER);
        p1_p1_2.add(p1_p1_2_1, BorderLayout.SOUTH);

        JButton do_follow = new JButton("팔로우하기");

        p1_p2 = new JPanel(); //change, cancel
        p1_p2.setLayout(new BorderLayout());

        JButton change = new JButton("Modify Profile");
        JButton cancel = new JButton("cancel");
        JButton upload = new JButton("upload text");
        //p1_p2.add(change, BorderLayout.CENTER);
        //p1_p2.add(cancel, BorderLayout.SOUTH);
        //p1_p2.add(upload, BorderLayout.WEST);

        p1.add(profile);
        p1.add(nick);
        p1.add(p1_p1_1);
        p1.add(p1_p1_2);
        //p1.add(do_follow);
        p1.add(p1_p2);

        first.add(p, BorderLayout.NORTH);
        first.add(p1, BorderLayout.CENTER);

        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        //p2.setSize(300,300);

        /*String[] post = sv.post(user_id);
        JList postlist = new JList(post);*/

        postList postList = new postList(go_to_page);

        /*for(int i = 0; post[i] != null; i++){
            System.out.println(post[i]);
        }*/

        p2.add(postList.scroll, BorderLayout.CENTER);
        //p2.add(mario.scroll, BorderLayout.CENTER);


        add(first, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setVisible(true);

    }

}