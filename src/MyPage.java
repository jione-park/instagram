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
    public JList l1;


    public MyPage(int user_id){

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

        //follow 버튼 누르면 팔로우 한 사람 테이블 창 띄어야함
        JButton follow = new JButton("follow");
        int follow_num = sv.get_following_num(user_id);
        String fm = String.valueOf(follow_num);
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
        // int count = sv.follower_cnt();
        int following = sv.get_following_num(user_id);
        String fw = String.valueOf(following);
        JLabel follower2 = new JLabel(fw);
        p1_p1_2_1.add(follower2);
        p1_p1_2.add(follower, BorderLayout.CENTER);
        p1_p1_2.add(p1_p1_2_1, BorderLayout.SOUTH);

        //JButton do_follow = new JButton("팔로우하기");

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

        JButton upload = new JButton("upload");

        p1.add(profile);
        p1.add(p1_p1_1);
        p1.add(p1_p1_2);
        //p1.add(do_follow);
        p1.add(p1_p2);
        p1.add(upload);

        first.add(p, BorderLayout.NORTH);
        first.add(p1, BorderLayout.CENTER);

        p2 = new JPanel();
        p2.setBackground(Color.yellow);

        /*PostMedia[] postM;

        int post_num = sv.get_post_num(user_id);
        int i = 0;
        while (i <= post_num){
            postM[i] = new PostMedia();
            i++;
        }

        l1 = new JList(postM);*/

        add(first, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);


        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //회원가입 버튼 액션 -> 회원가입 -> 로그인
                new server(user_id*-1);
                //setVisible(false);
            }
        });

        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UploadUI();
                //1.upload 페이지로 이동
                //2.upload 페이지에서 유저로부터 text를 입력받고, 사진을 받음
                //3.데베에 해당 text와 사진을 보내줌
            }
        });

        setVisible(true);
    }

}