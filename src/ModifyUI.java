import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public class ModifyUI extends JFrame{
    private JPanel loginPanel = new JPanel(new GridLayout(4, 2));
    private JLabel idLabel = new JLabel("아이디(이메일) ");
    private JLabel pwLabel = new JLabel("비밀번호 ");
    private JLabel nickLable = new JLabel("닉네임");
    private JTextField idText = new JTextField();
    private JTextField pwText = new JTextField();
    private  JTextField nnText = new JTextField();
    private JButton loginBtn = new JButton("정보변경");
    //private JButton joinBtn = new JButton("회원가입");
    //private JButton joinBtn = new JButton("회원가입");

   /* public boolean confirm = false;
    //public JTextField birthText;
    public JTextField pwText;
    //public JTextField NameText;
    public JTextField NickNameText;
    public JTextField EmailText;

    private JTextField textField;*/
    private int user_id;


    public ModifyUI(int user_id) {
        this.user_id = user_id;
        //super("로그인 창!");
        this.setContentPane(loginPanel);
        loginPanel.add(idLabel);
        loginPanel.add(idText);
        loginPanel.add(pwLabel);
        loginPanel.add(pwText);
        loginPanel.add(nickLable);
        loginPanel.add(nnText);
        loginPanel.add(loginBtn);

        idLabel.setHorizontalAlignment(NORMAL);
        pwLabel.setHorizontalAlignment(NORMAL);
        nickLable.setHorizontalAlignment(NORMAL);


        setSize(350,250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //로그인 UI->로그인 or 회원가입
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //로그인 버튼 액션 -> 메인 페이지
                String id = idText.getText().trim();
                String pw = pwText.getText().trim();
                String nn = nnText.getText().trim();

                System.out.println(id + " " + pw + " " + nn);


                if(id.length()==0 || pw.length() == 0 || nn.length() == 0) {
                    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호 또는 닉네임을 입력 하셔야 됩니다.", "정보 부족!", JOptionPane.DEFAULT_OPTION);
                    return;
                }
                new server(user_id, nn, pw, id);

                setVisible(false);
            }
        });
    }

}
