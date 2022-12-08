import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class userList extends JFrame {

    //database로 가서 return을 가져오는게 힘들어서 다시 연결을 시도한다.
    Connection con = null;
    Statement stmt = null;
    int count ;
    Choice ch = new Choice();

    JButton abc = new JButton("팔로우하기");
    JButton go_to_page = new JButton("페이지 방문");
    JButton ca = new JButton("팔로우 취소하기");
    String url = "jdbc:mysql://127.0.0.1/dragonbrain?serverTimezone=UTC&&useSSL=false&user=root&password=9793";

    int my_id ;

    Dimension dim = new Dimension(200,100);
    TextField[] txt = new TextField[100];


    public userList(int user_id)
    {
        my_id = user_id;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.url);
            this.stmt = this.con.createStatement();
            System.out.println("[Server] MySQL 서버 연동 성공");

            get_list(user_id);

        } catch (SQLException e) {
            System.out.println("[Server] 1MySQL 서버 연동 실패> ");
        } catch (ClassNotFoundException e) {
            System.out.println("[Server] 2MySQL 서버 연동 실패> ");
        }
    }

    public void get_list(int id)
    {
        this.setSize(200,200);
        abc.setSize(30,30);

        try {
            abc.addActionListener(this::actionPerformed);
            go_to_page.addActionListener(this::actionPerformed);
            ca.addActionListener(this::actionPerformed);
            GridLayout grid = new GridLayout(4,4);
            this.setLayout(grid);
            String commandStr = "SELECT * from user where user_id != " +id;
            ResultSet result = this.stmt.executeQuery(commandStr);


            ch.setBounds(100,200,150,75);

            count = 1;
            String[] str = new String[100];
            while (result.next())
            {
                str[count] =  result.getString("user_email");
//                JButton[] btn = new JButton[100];
//                btn[count] = new JButton(str[count]);
//                this.add(btn[count]);
//                count++;
                ch.add(str[count]);
            }
            this.add(ch);
            this.add(abc);
            this.add(go_to_page);
            this.add(ca);
            this.setVisible(true);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actionPerformed (ActionEvent e)
    {
        String email = new String();
        email = ch.getSelectedItem();
        System.out.println(email);

        if(e.getSource() == abc) {
            new server(1, email, my_id);
        }
        else if(e.getSource() == go_to_page){
            new server(2, email, my_id);
        }
        else if(e.getSource() == ca)
        {
            new server(3,email,my_id);
        }
    }




}