import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class follow_list {
    follow_list(String[] str)
    {
        JFrame frm = new JFrame("follower list");
        frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JList list = new JList(str);
        Container ct = frm.getContentPane();
        ct.add(list);
        frm.setSize(300,300);
        frm.setVisible(true);
    }
}