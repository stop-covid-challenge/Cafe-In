package stop.covid.project.cafein.main.comment;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.util.ArrayList;

import stop.covid.project.cafein.R;

public class CommentAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CommentItem> commentItems = new ArrayList<CommentItem>();

    public CommentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // item.xml 레이아웃을 inflate해서 참조획득
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.like_comment_item, viewGroup, false);
        }

        // item.xml 의 참조 획득
        TextView nickname = (TextView) view.findViewById(R.id.nickname);
        TextView comment = (TextView) view.findViewById(R.id.comment);
        ImageView imageView = (ImageView) view.findViewById(R.id.profile_image);
        TextView localDateTime = (TextView) view.findViewById(R.id.time);
        TextView like = (TextView) view.findViewById(R.id.like);

        // 가져온 데이터를 텍스트뷰에 입력
        CommentItem commentItem = commentItems.get(i);
        nickname.setText(commentItem.getNickname());
        comment.setText(commentItem.getComment());
        imageView.setImageURI(commentItem.getProfile_image());
//        localDateTime.setText(commentItem.getLocalDateTime());
        like.setText(commentItem.getLike());

        // 리스트 아이템 삭제
//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listItems.remove(position);
//                notifyDataSetChanged();
//            }
//        });

        return view;
    }

    public void addItem(String nickname, String comment, Uri profile_image, Integer like){
//        LocalDateTime currentDateTime = LocalDateTime.parse(LocalDateTime.now()).toString();
        CommentItem commentItem = new CommentItem();
        commentItem.setNickname(nickname);
        commentItem.setComment(comment);
        commentItem.setProfile_image(profile_image);
        commentItem.setLike(like);
//        commentItem.setLocalDateTime(currentDateTime);
        commentItems.add(commentItem);
    }

}
