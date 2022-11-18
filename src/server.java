public class server {

    Database db = new Database();

    private User user;
    public server(String i, String p){

        this.login(i, p);
    }
    public server(){
        this.join();

    }
    public server(String n, String nn, String pw, String em, String birth){
        this.member(n, nn, pw, em, birth);
    }

    private void login(String id, String pw) {
        int inputValue = 0;
        if(!db.loginCheck(id,pw).equals("null")){
            //로그인 성공 ->  main page

        }
    }

    private void join(){
        new joinUI();
    }
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

        } else {

        }
    }
}
