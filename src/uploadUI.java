import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public class uploadUI extends JFrame{
    private JPanel uploadPanel = new JPanel(new GridLayout(4, 2));
    private JLabel idLabel = new JLabel("글쓰기");
    //  private JLabel pwLabel = new JLabel("비밀번호 ");
    //  private JLabel nickLable = new JLabel("닉네임");
    private JTextField idText = new JTextField();
    //    private JTextField pwText = new JTextField();
    //   private  JTextField nnText = new JTextField();
    private JButton uploadBtn = new JButton("UPLOAD");
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


    public uploadUI(int user_id) {
        this.user_id = user_id;
        //super("로그인 창!");
        this.setContentPane(uploadPanel);
        uploadPanel.add(idLabel);
        uploadPanel.add(idText);
        uploadPanel.add(uploadBtn);
/*

        loginPanel.add(pwLabel);
        loginPanel.add(pwText);
        loginPanel.add(nickLable);
        loginPanel.add(nnText);

 */

        idLabel.setHorizontalAlignment(NORMAL);
        //    pwLabel.setHorizontalAlignment(NORMAL);
        //   nickLable.setHorizontalAlignment(NORMAL);


        setSize(350,250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //로그인 UI->로그인 or 회원가입
        uploadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //로그인 버튼 액션 -> 메인 페이지
                String uploadTxt = idText.getText().trim();
                //  String pw = pwText.getText().trim();
                //  String nn = nnText.getText().trim();

                System.out.println(uploadTxt);


                if(uploadTxt.length()==0) {
                    JOptionPane.showMessageDialog(null, "업로드할 텍스트를 입력해주세요!", "정보 부족!", JOptionPane.DEFAULT_OPTION);
                    return;
                }
                new server(user_id, uploadTxt);

                setVisible(false);
            }
        });

    }

}