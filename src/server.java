import javax.swing.*;

public class server {

    Database db = new Database();

    private User user;
    private int user_id;
    //인자: id, password -> 로그인 함수 실행
    public server(String i, String p){

        this.login(i, p);


    }

    //인자: 아무것도 x -> 회원가입 함수 실행
    public server(int i){
        if (i == 0) {
            this.join();
        }
        else if (i < 0){ //user id
            this.modify(i*-1);
        }

    }

    //joinUI 클래스에서 실행됨! 인자: 회원가입에 필요한 정보 -> 멤버 함수 실행
    public server(String n, String nn, String pw, String em, String birth){
        this.member(n, nn, pw, em, birth);
    }

    //modifyUI 클래서에서 실행됨! -> 정보 변경 함수 실행
    public server(int user_id, String nn, String pw, String em){
        this.member_modify(user_id, nn, pw, em);
    }

    //인자: 아이디, 패스워드 -> 해당 정보를 가지고 로그인 실행 -> 데이터베이스 참조 -> 로그인 성공시 마이페이지 오픈
    private void login(String id, String pw) {
        int inputValue = 0;
        if(!db.loginCheck(id,pw).equals("null")){
            //로그인 성공 ->  main page
            user_id = db.get_id(id);
            //System.out.println(user_id);
            new MyPage(user_id);
        }
        else
        {
            JFrame f = new JFrame("경고");
            JLabel a = new JLabel("아이디 , 비밀번호가 틀렸습니다.");
            f.add(a);
            f.setSize(500,500);
            f.setVisible(true);
            new Main();
        }

    }

    //joinUI 클래스 실행
    private void join(){
        new joinUI();
    }
    private void modify(int user_id){
        new ModifyUI(user_id);
    }

    //인자로 받은 정보를 데이터베이스로 보내 회원가입 실행 -> 회원 가입 성공 후 마이페이지 오픈
    //(String _n, String _nn, String _p, String _e, String birth)
    private void member(String name,String Nname, String pw, String email, String birth) {
        User newUser = new User();
        newUser.setPw(pw);
        newUser.setNickName(Nname);
        newUser.setName(name);
        newUser.setEmail(email);

        boolean flag = db.joinCheck(name,Nname,pw,email,birth);

        if (flag==true) {
            //회원가입 성공

            user_id = db.get_id(email);
            new MyPage(user_id);

        } else {

        }
    }

    private void member_modify(int user_id,String Nname, String pw, String email) {
        /*User newUser = new User();
        newUser.setPw(pw);
        newUser.setNickName(Nname);
        newUser.setName(name);
        newUser.setEmail(email);*/

        boolean flag = db.modiCheck(user_id, Nname, pw, email);

        if (flag==true) {
            //정보변경 성공

            user_id = db.get_id(email);
            //new MyPage(user_id);

        } else {

        }
    }
    public int get_following_num(int user_id){
        int cnt = db.get_following_num(user_id);
        return cnt;
    }
    public int get_follwer_num(int user_id){
        int cnt = db.get_follower_num(user_id);
        return cnt;
    }
    public void do_follow(int user_id){
        db.do_follow(user_id);
    }

    public int get_post_num(int user_id){
        int cnt = db.get_post_num(user_id);
        return  cnt;
    }
}