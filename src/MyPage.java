import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyPage extends JFrame{
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
    //public JList l1;


    public MyPage(int user_id, int follow_number, int following_number){

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        first = new JPanel();
        first.setLayout(new BorderLayout());

        //p panel -> 인스타 그램 로고만 붙어있음 -> 로고 누르면 홈으로 가게 처리해야함
        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        app = new JLabel("instagram");
        p.add(app);


        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));

        //유저 테이블에 프로필 사진 저장해야할 수 있어야 함
        ImageIcon img_icon = new ImageIcon("image.png");
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
        JButton follow = new JButton("follow");
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
        JButton follower = new JButton("follower");

//        follower.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //버튼 누르면 팔로우 목록 보여주기
//               server ab = new server();
//                follow_number = ab.getNumber(user_id);
//                System.out.println(ab);
//            }
//        });


        // int count = sv.follower_cnt();

        String fw = Integer.toString(follow_number);
        JLabel follower2 = new JLabel(fw);
        p1_p1_2_1.add(follower2);
        p1_p1_2.add(follower, BorderLayout.CENTER);
        p1_p1_2.add(p1_p1_2_1, BorderLayout.SOUTH);

        JButton do_follow = new JButton("팔로우하기");

        /*do_follow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //로그인 버튼 액션 -> 메인 페이지
                sv.do_follow(user_id);
            }
        });*/

        p1_p2 = new JPanel(); //change, cancel
        p1_p2.setLayout(new BorderLayout());

        JButton change = new JButton("Modify Profile");
        JButton cancel = new JButton("cancel");

        p1_p2.add(change, BorderLayout.CENTER);
        p1_p2.add(cancel, BorderLayout.SOUTH);

        p1.add(profile);
        p1.add(p1_p1_1);
        p1.add(p1_p1_2);
        //p1.add(do_follow);
        p1.add(p1_p2);

        first.add(p, BorderLayout.NORTH);
        first.add(p1, BorderLayout.CENTER);

        p2 = new JPanel();
        /*p2.setLayout(new GridLayout(0,3,15,15));

        BorderLayout bl = new BorderLayout();
        JLabel[] jl = new JLabel[5];
        p2.setLayout(bl);

        for(int i=0; i<jl.length; i++)
        {
            jl[i] = new JLabel("ㅎㅇ");
            p2.add(jl[i]);
        }

        p2.add(jl[0],BorderLayout.NORTH);
        p2.add(jl[1],BorderLayout.EAST);
        p2.add(jl[2],BorderLayout.CENTER);
        p2.add(jl[3],BorderLayout.WEST);
        p2.add(jl[4],BorderLayout.SOUTH);*/

        MarioList mario = new MarioList();

        p2.add(mario.scroll);

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

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //회원가입 버튼 액션 -> 회원가입 -> 로그인
                new MainPage(user_id);
                setVisible(false);
            }
        });


        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //회원가입 버튼 액션 -> 회원가입 -> 로그인
                new server(user_id*-1);
                //setVisible(false);
            }
        });

        setVisible(true);
    }

}