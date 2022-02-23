package stop.covid.project.cafein.main.subscribe;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import stop.covid.project.cafein.R;
import stop.covid.project.cafein.main.dto.Comment;

public class CommentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommentAdapter adapter;
    private ImageButton btn_comment_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        btn_comment_back = findViewById(R.id.btn_comment_back);
        btn_comment_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        recyclerView = findViewById(R.id.recycler_comment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        //리사이클러뷰 테스트 데이터
        ArrayList<Comment> list = new ArrayList<>();
        list.add(new Comment(1, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "나연", "헐 너무 맛있어요", "30분 전", 3));
        list.add(new Comment(2, new BitmapDrawable(getResources(), String.valueOf(R.drawable.coffee_cup)), "나연2", "해먹어 봐야겠네요", "10분 전", 3));
        list.add(new Comment(3, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "나연3", "배고파요", "12분 전", 3));
        list.add(new Comment(4, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "나연4", "배고파요", "1시간 전", 10));
        list.add(new Comment(5, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "나연5", "배고파요", "12분 전", 3));
        list.add(new Comment(6, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "나연6", "배고파요", "12분 전", 3));
        list.add(new Comment(7, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "나연7", "맛있겠네요", "12분 전", 3));
        list.add(new Comment(8, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "나연8", "맛있겠네요", "12분 전", 3));

        adapter = new CommentAdapter();
        adapter.setCommentList(list);
        recyclerView.setAdapter(adapter);
    }

}
