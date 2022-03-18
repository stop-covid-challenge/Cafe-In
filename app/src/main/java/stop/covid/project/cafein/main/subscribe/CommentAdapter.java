package stop.covid.project.cafein.main.subscribe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import stop.covid.project.cafein.R;
import stop.covid.project.cafein.main.dto.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {
    private ArrayList<Comment> list;

    public CommentAdapter(){
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_comment, parent, false);
        CommentViewHolder viewHolder = new CommentViewHolder(context, view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        /*
        holder.img_user_profile.setImageDrawable(list.get(position).getProfile());
        holder.tv_comment_user_nickname.setText(list.get(position).getNickname());
        holder.tv_user_comment.setText(list.get(position).getComment());
        holder.tv_comment_time.setText(list.get(position).getTime());
        holder.tv_comment_like_num.setText("좋아요 " + list.get(position).getLikeNum() + "개");*/
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    //데이터 받아오기
    public void setCommentList(ArrayList<Comment> data){
        for(int i = 0; i < data.size(); i++)
            list.add(data.get(i));
    }
}
