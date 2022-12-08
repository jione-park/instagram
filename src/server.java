import javax.swing.*;
import java.sql.ResultSet;

public class server {

    Database db = new Database();

    private User user;
    private int user_id;
    //인자: id, password -> 로그인 함수 실행
    public server(String i, String p){

        this.login(i, p);
        //new Mainpage();

    }

    //인자: 아무것도 x -> 회원가입 함수 실행
    public server(int i){
        if (i == 0) {
            this.join();
        }
        else if (i < 0){ //user id
            this.modify(i*-1);
        }
        else if(i == 1)
        {
            this.list();
        }

    }

    public server(int i, String email, int id) //팔로우하기,
    {
        Database db = new Database();

        if(i == 1){//팔로우하기
            System.out.println("팔로우하기");
            db.follow(email, id);
        }
        else if(i == 2){//페이지 방문
            System.out.println("페이지 방문하기");
            new OtherPage(email, id);
        }
        else if(i == 3) //팔로우취소하기
        {
            System.out.println("팔로우 취소하기");
            db.follow_cancel(email, id);
        }
    }

    public server()
    {
        //아무것도 안하고 객체만들려고 만듦.
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
            //new MyPage(user_id);
            new MainPage(user_id);
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

    public server(int user_id, String uploadTxt){
        // text 업로드 하기
        this.uploadText(user_id,uploadTxt);
    }

    private void uploadText(int user_id , String upload){
        db.uploadText(user_id, upload);
    }


    //joinUI 클래스 실행
    private void join(){
        new joinUI();
    }
    private void modify(int user_id){
        new ModifyUI(user_id);
    }

    /*
         public String get_follow_info(int user_id){
            info = db.get_follow_num(user_id);
            return info;
        }
        */
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
            //new Mainpage();
            user_id = db.get_id(email);
            new MyPage(user_id,0, 0);

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
            //new Mainpage();
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

    public void follower_list(int user_id){

    }

    public String[] list()
    {
        String result[] = db.get_List();

        return result;
    }


    public int getfollowNumber(int id)
    {
        //Database db = new Database();
        int count = db.getNumber(id);
        System.out.println("[sever] : " + count);
        return count;
    }

    public int getfollowingNumber(int id)
    {
        //Database db = new Database();
        int count = db.getNumbers(id);
        System.out.println("[sever] : " + count);
        return count;
    }

    public int get_id(String email){
        int user_id = 0;

        user_id = db.get_id(email);

        return user_id;
    }



    //내가 팔로우하는 사람들의 id가져오기
    public ResultSet get_follower(int id)
    {
        ResultSet result = db.get_follower(id);
        return result;
    }

    //나를 팔로우하는 사람들의 id가져오기
    public ResultSet get_follow(int id)
    {
        ResultSet result = db.get_follow(id);
        return result;
    }



    //내가 팔로우하는 사람들의 nickname가져오기
    public String[] get_NickName(ResultSet rs)
    {
        String result[] = db.get_NickName(rs);
        return result;
    }



    //나를 팔로우하는 사람들의 nickname가져오기
    public String[] get_NickNames(ResultSet rs)
    {
        String result[] = db.get_NickNames(rs);
        return result;
    }


    public String[] post(int user_id){
        String post[] = db.get_Post(user_id);

        return post;
    }
    public String[] post1(String email){
        String post[] = db.get_Post(email);

        return post;
    }
    public String[] mainpost(int user_id){
        String mainp[] = db.get_main_Post(user_id);

        return mainp;
    }



}