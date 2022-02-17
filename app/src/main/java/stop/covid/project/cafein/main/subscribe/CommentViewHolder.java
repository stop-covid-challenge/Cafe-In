package stop.covid.project.cafein.main.subscribe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import stop.covid.project.cafein.R;

public class CommentViewHolder extends RecyclerView.ViewHolder{
    public CircleImageView img_user_profile;
    public TextView tv_comment_user_nickname;
    public TextView tv_user_comment;
    public TextView tv_comment_time;
    public TextView tv_comment_like_num;
    public ImageView iv_comment_heart;

    CommentViewHolder(Context context, View itemView){
        super(itemView);
        img_user_profile = itemView.findViewById(R.id.img_user_profile);
        tv_comment_user_nickname = itemView.findViewById(R.id.tv_comment_user_nickname);
        tv_user_comment = itemView.findViewById(R.id.tv_user_comment);
        tv_comment_time = itemView.findViewById(R.id.tv_comment_time);
        tv_comment_like_num = itemView.findViewById(R.id.tv_comment_like_num);
        iv_comment_heart = itemView.findViewById(R.id.iv_comment_heart);
        iv_comment_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "하트클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
