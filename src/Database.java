import java.sql.*;
import java.io.IOException;
public class Database {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:mysql://127.0.0.1/dragonbrain?serverTimezone=UTC&&useSSL=false&user=root&password=9793";

    public Database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.url);
            this.stmt = this.con.createStatement();
            System.out.println("[Server] MySQL 서버 연동 성공");


        } catch (SQLException e) {
            System.out.println("[Server] 1MySQL 서버 연동 실패> ");
        } catch (ClassNotFoundException e) {
            System.out.println("[Server] 2MySQL 서버 연동 실패> ");
        }
    }

    public String loginCheck(String _i, String _p) {
        String nickname = "null";
        String id = _i;
        String pw = _p;

        try {

            String checkingStr = "SELECT user_password, user_nickname FROM user WHERE user_email='" + id + "'";
            ResultSet result = this.stmt.executeQuery(checkingStr);

            for(int var8 = 0; result.next(); ++var8) {
                if (pw.equals(result.getString("user_password"))) {
                    nickname = result.getString("user_nickname");
                    System.out.println("[Server] 로그인 성공");
                } else {
                    nickname = "null";
                    System.out.println("[Server] 로그인 실패");
                }
            }
        } catch (Exception var9) {
            nickname = "null";
            System.out.println("[Server] 로그인 실패 > " + var9.toString());
        }

        return nickname;
    }

    public boolean joinCheck(String _n, String _nn, String _p, String _e, String birth) {
        boolean flag = false;
        String na = _n;
        String nn = _nn;
        int id = -1;
        String pw = _p;
        String em = _e;
        String bd = birth;
        boolean check = this.overCheck(_nn, _p);
        if (!check) {
            try {
                //id 형성 부분 바꿔야함
                id = (int)(Math.random() * 10000);
                String insertStr = "INSERT INTO user VALUES(" + id + ",'" + na + "'," + "'" + em + "'," + "'" + pw + "'," + "sysdate()," + "'" + nn + "'," + "'" + bd + "')";
                this.stmt.executeUpdate(insertStr);
                flag = true;
                System.out.println("[Server] 회원가입 성공");
            } catch (Exception var14) {
                flag = false;
                System.out.println("[Server] 회원가입 실패 > " + var14.toString());
            }
        }

        return flag;
    }

    boolean overCheck(String _a, String _v) { //닉네임이랑 패스워드로 확인
        boolean flag = false;
        String att = _a;
        String val = _v;

        try {
            String selcectStr = "SELECT user_nickname FROM user WHERE user_nickname= '" + att + "'";
            ResultSet result = this.stmt.executeQuery(selcectStr);

            for(int var8 = 0; result.next(); ++var8) {
                if (!val.equals(result.getString(att))) {
                    flag = true;
                } else {
                    flag = false;
                }
            }

            System.out.println("[Server] 중복 확인 성공");
        } catch (Exception var9) {
            System.out.println("[Server] 중복 확인 실패 > " + var9.toString());
        }

        return flag;
    }

}
