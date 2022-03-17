package stop.covid.project.cafein;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stop.covid.project.cafein.main.api.ApiClient;
import stop.covid.project.cafein.main.api.RetrofitService;
import stop.covid.project.cafein.main.dto.User;

public class LoginRegisterActivity extends AppCompatActivity {

    RetrofitService retrofitService;
    RadioGroup radioGroup;
    LinearLayout radioChecked;
    EditText name, introduce, address, detail_address;
    ImageButton ib_mainProfile, ib_backProfile;
    Button btn_setting_finish;

    private static final int REQUEST_CODE = 0;  //사진 업로드 요청코드

    //로그인 정보 받아와서
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registraion);
        Toast.makeText(this, getIntent().getStringExtra("name"), Toast.LENGTH_SHORT).show();

        radioGroup = findViewById(R.id.radio_group);
        radioChecked = findViewById(R.id.radioChecked);
        name = findViewById(R.id.et_profile_name);
        ib_mainProfile = findViewById(R.id.ib_mainProfile);
        ib_backProfile = findViewById(R.id.ib_backProfile);
        introduce = findViewById(R.id.et_profile_introduce);
        btn_setting_finish = findViewById(R.id.btn_setting_finish);
        address = findViewById(R.id.et_address);
        detail_address = findViewById(R.id.et_detail_address);

        //라디오 버튼 클릭에 따라 주소표시
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radio_corp){
                    radioChecked.setVisibility(View.VISIBLE);
                }
                if(i == R.id.radio_personal){
                    radioChecked.setVisibility(View.GONE);
                }
            }
        });

        // 프로필사진 등록
        ib_mainProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        //배경사진 등록
       ib_backProfile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               intent.setType("image/*");
               intent.setAction(Intent.ACTION_GET_CONTENT);
               startActivityForResult(intent, REQUEST_CODE);
           }
       });

        //프로필 설정 완료
       btn_setting_finish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(LoginRegisterActivity.this, MainActivity.class);
               String socialId = getIntent().getStringExtra("socialEmail");
               String testImage = "https://i.ytimg.com/vi/Kg-fFW3bxhc/hq720.jpg";
               User user = new User(
                       socialId, name.getText().toString(), socialId, introduce.getText().toString(),
                       testImage, testImage, address.getText().toString() + detail_address.getText().toString());
               sendUser(user);
               startActivity(intent);
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                try {
                    Uri uri = data.getData();
                    Glide.with(getApplicationContext()).load(uri).into(ib_mainProfile);
                    /*InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    ib_mainProfile.setImageBitmap(img);*/
                } catch (Exception e) { }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //유저 정보 서버로 보내기
    private void sendUser(User user){
        retrofitService = ApiClient.getApiClient().create(RetrofitService.class);
        Call<User> call = retrofitService.setUserBody(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //서버에서 응답 받아옴
                if(response.isSuccessful() && response.body() != null){
                    String success = response.body().toString();
                    Log.d("LoginRegisterActivity", "서버에서 받은 거: " + success);
                }
                //응답을 못 받아옴
                else{
                    Log.d("LoginRegisterActivity", "따로 넘겨주는 값없음");
                }
            }

            //통신 실패
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("LoginRegisterActivity", "통신 실패");
            }
        });
    }
}
