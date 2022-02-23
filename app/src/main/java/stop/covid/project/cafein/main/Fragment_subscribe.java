package stop.covid.project.cafein.main;

import android.graphics.drawable.BitmapDrawable;
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

        System.out.println("Fragment_subscribe onCreateView");
        //뷰페이저 테스트
        String[] imgList = new String[]{"https://i.ytimg.com/vi/ptW7zemegL8/hq720.jpg",
                "https://i.ytimg.com/vi/3LO8L4Dyx8Y/hq720.jpg",
                "https://i.ytimg.com/vi/orC1NOEJ_OQ/hq720.jpg",
                "https://i.ytimg.com/vi/3LO8L4Dyx8Y/hq720.jpg",
                "https://i.ytimg.com/vi/-C6C2nA1oCM/hq720.jpg"
        };

        postList = new ArrayList<Post>();
        postList.add(new Post(1, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "백종원", imgList, false, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));
        postList.add(new Post(2, new BitmapDrawable(getResources(), String.valueOf(R.drawable.plus)), "백종원2", imgList, true, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));
        postList.add(new Post(3, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "백종원3", imgList, false, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));
        postList.add(new Post(4, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "백종원4", imgList, false, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));
        postList.add(new Post(5, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user)), "백종원5", imgList, false, new BitmapDrawable(getResources(), String.valueOf(R.drawable.user))));

        postAdapter = new PostAdapter(rootView.getContext(), R.layout.adapter_post, postList);
        listView = rootView.findViewById(R.id.lv_post);
        listView.setAdapter(postAdapter);

        return rootView;
    }
}
