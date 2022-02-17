package stop.covid.project.cafein.main;

import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import stop.covid.project.cafein.R;
import stop.covid.project.cafein.main.subscribe.Post;
import stop.covid.project.cafein.main.subscribe.PostAdapter;

public class Fragment_subscribe extends Fragment {

    private ArrayList<Post> postList;
    private PostAdapter postAdapter;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_subscribe, container, false);
        //return inflater.inflate(R.layout.fragment_subscribe, container, false);

        //뷰페이저 테스트
        String[] imgList = new String[]{"https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg",
                "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg",
                "https://cdn.pixabay.com/photo/2020/03/08/21/41/landscape-4913841_1280.jpg",
                "https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg",
                "https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg"
        };
//        imgList.add("https://cdn.pixabay.com/photo/2018/01/15/08/34/woman-3083453_960_720.jpg");
//        imgList.add("https://cdn.pixabay.com/photo/2021/06/28/18/36/cereals-6372410_960_720.jpg");
//        imgList.add("https://cdn.pixabay.com/photo/2021/07/15/17/55/fishermans-bastion-6469128_960_720.jpg");
        //imgList.add(new BitmapDrawable(getResources(), String.valueOf(R.drawable.default_img)));

        postList = new ArrayList<Post>();
        postList.add(new Post(1, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "백종원", imgList, false, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));
        postList.add(new Post(2, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "백종원2", imgList, true, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));
        postList.add(new Post(3, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "백종원3", imgList, false, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));
        postList.add(new Post(3, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "백종원3", imgList, false, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));

        postAdapter = new PostAdapter(this.getContext(), R.layout.adapter_post, postList);
        listView = rootView.findViewById(R.id.lv_post);
        listView.setAdapter(postAdapter);

        return rootView;
    }
}
