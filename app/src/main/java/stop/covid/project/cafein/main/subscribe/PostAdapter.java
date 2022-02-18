package stop.covid.project.cafein.main.subscribe;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import stop.covid.project.cafein.MainActivity;
import stop.covid.project.cafein.R;

public class PostAdapter extends BaseAdapter {
    private Context context;
    private int layout; //어댑터뷰에 대한 레이아웃
    private ArrayList<Post> postList;
    private LayoutInflater layoutInflater;  //inflater객체
    private boolean heart_state;    //db에서 상태값 가져와서 넣기 false-하트 안누름

    //뷰페이저 변수
    private ViewPager2 sliderViewPager;
    private LinearLayout indicator;

    public PostAdapter(Context context, int layout, ArrayList<Post> postList){
        this.context = context;
        this.layout = layout;
        this.postList = postList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //전체 원본데이터의 개수 반환
    @Override
    public int getCount() {
        return postList.size();
    }

    //특정 위치의 데이터 항목 반환
    @Override
    public Object getItem(int i) {
        return postList.get(i);
    }

    //특정 위치의 데이터 항목 식별자(id) 반환
    @Override
    public long getItemId(int i) {
        return postList.get(i).get_id();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        final int pos = i;
        Log.d("getView", "포지션 값: " + pos);

        if(convertView == null)
            convertView = layoutInflater.inflate(layout, viewGroup, false);

        /* 화면요소 준비 */
        CircleImageView circle_post_profile = convertView.findViewById(R.id.circle_my_profile);
        TextView tv_nickname = convertView.findViewById(R.id.tv_post_nickname);
        sliderViewPager = convertView.findViewById(R.id.viewPager_post);
        indicator = convertView.findViewById(R.id.indicator);
        ImageButton btn_like = convertView.findViewById(R.id.btn_like);
        ImageButton btn_comment = convertView.findViewById(R.id.btn_comment);
        CircleImageView circle_my_profile = convertView.findViewById(R.id.circle_my_profile);
        EditText et_comment = convertView.findViewById(R.id.et_my_comment);
        ImageButton btn_comment_send = convertView.findViewById(R.id.btn_comment_send);

        //버튼 뿐만 아니라 모든 view가 이벤트 처리 가능
        btn_comment_send.setFocusable(false);
        btn_comment.setFocusable(false);
        btn_like.setFocusable(false);

        /* 화면 + 데이터 결합 */
        // 프로필 이미지 바이트 처리 circle_post_profile.setImageDrawable();
        tv_nickname.setText(postList.get(pos).getNickname());
        Log.d("getView", "하트상태: " + postList.get(pos).isLike());
        if(postList.get(pos).isLike())
            btn_like.setImageResource(R.drawable.heart_fill);

        //뷰페이저 구현 자리
        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new PostSliderAdapter(context, postList.get(pos).getImgList()));
        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                System.out.println("이미지: " + position);
                System.out.println("onPageSeleted posigion값:" + position);
                setCurrentIndicator(position);
            }
        });
        System.out.println("indicator개수: " + postList.get(pos).getImgList().length);
        setupIndicators(postList.get(pos).getImgList().length);

        //하트클릭 시 하트모양 변경
        btn_like.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(!heart_state) {
                    btn_like.setImageResource(R.drawable.heart_fill);
                    heart_state = true;
                }else{
                    btn_like.setImageResource(R.drawable.heart_empty);
                    heart_state = false;
                }
            }
        });

        //말풍선 클릭 시 댓글창 넘어감
        btn_comment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                changeCommentFragment();
            }
        });

        //댓글 쓰고 보내기 버튼 누르면 comment db처리랑 액티비티 변경
        btn_comment_send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("TEST", "PostAdapter 온클릭");
                Toast.makeText(context, et_comment.getText().toString(), Toast.LENGTH_SHORT).show();
                changeCommentFragment();
            }
        });
        return convertView; //생성한 뷰 반환
    }

    //뷰페이저 처리 관련 함수들
    private void setupIndicators(int count){
        indicator.removeAllViews();
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(context);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.indicator_inactive));
            indicators[i].setLayoutParams(params);
            indicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position){
        int childCount = indicator.getChildCount();
        System.out.println("childCount: " + childCount);
        for(int k = 0; k < childCount; k++){
            ImageView iv = (ImageView) indicator.getChildAt(k);
            if(k == position)
                iv.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.indicator_active));
            else
                iv.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.indicator_inactive));
        }
    }

    //보내기 버튼 누를때 다음 프래그먼트로 전환
    public void changeCommentFragment(){
        ((MainActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new Fragment_comment()).commit();
        //((MainActivity)context).getFragmentManager();
    }
}
