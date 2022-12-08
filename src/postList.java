import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class postList extends Component{

    server sv = new server();
    JScrollPane scroll;


    //text content, 좋아요
    // 기능, 개수, 댓글 가져오는 거

    postList(String email){

        //text content
        String[] post = sv.post1(email);

        ArrayList<String>post2 = new ArrayList<String>();

        int i = 0;

        while(post[i] != null){
            post2.add(post[i]);
            //System.out.println(post[i]);
            i++;
        }

        String[] post3 = new String[post2.size()];

        int size=0;

        for(String temp : post2){
            post3[size++] = temp;
        }

        JList list = new JList(post3);


        list.setCellRenderer(new PostRenderer());

        scroll = new JScrollPane(list);

        scroll.setPreferredSize(new Dimension(300, 400));


        //좋아요 하기

        //좋아요 개수

    }
    postList(int user_id){

        //text content
        String[] post = sv.post(user_id);

        ArrayList<String>post2 = new ArrayList<String>();

        int i = 0;

        while(post[i] != null){
            post2.add(post[i]);
            //System.out.println(post[i]);
            i++;
        }

        String[] post3 = new String[post2.size()];

        int size=0;

        for(String temp : post2){
            post3[size++] = temp;
        }

        JList list = new JList(post3);


        list.setCellRenderer(new PostRenderer());

        scroll = new JScrollPane(list);

        scroll.setPreferredSize(new Dimension(300, 400));


        //좋아요 하기

        //좋아요 개수

    }
    public class PostRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvetica", Font.BOLD, 24);

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2,2));

            JButton like_button = new JButton("LIKE");
            JLabel like_num = new JLabel("like_num");

            JLabel label = (JLabel) super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus);
            label.setFont(font);

            JLabel space = new JLabel("");

            panel.add(label);
            panel.add(space);
            panel.add(like_button);
            panel.add(like_num);

            return panel;
        }
    }

}