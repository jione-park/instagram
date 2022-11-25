import javax.swing.*;

public class PostMedia {
    //l1 = new JList(new DefaultListModel());
    //user id를 불러옴
    //while문으로 user id에 해당하는 post들을 불러와서 JList에 저장 - post table
    //post (text, created_at)
    // post media(content)--여러 사진 가능
    // post_hashtag(hashtag id)
    // hashtag(hashtag)
    // comment(content, user_id, created_at)
    // post_like(user_id) -> count

    String text;
    String created;
    ImageIcon[] img_icon;
    int like_num;
    int comment_num;
}
