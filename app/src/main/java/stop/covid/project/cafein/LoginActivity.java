package stop.covid.project.cafein;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.tv.TvInputService;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;

import java.security.MessageDigest;

public class LoginActivity extends AppCompatActivity {

    private ISessionCallback mSessionCallback;  //로그인 관련 처리

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSessionCallback = new ISessionCallback() {
            @Override
            public void onSessionOpened() {
                Log.d("Login", "로그인 시도");

                //로그인 요청
                UserManagement.getInstance().me(new MeV2ResponseCallback() {
                    @Override
                    public void onSuccess(MeV2Response result) {
                        //로그인 성공 : result변수가 카카오에서 넘겨주는 유저 정보
                        Log.d("Login","onSuccess");
                        Intent intent = new Intent(LoginActivity.this, LoginRegisterActivity.class);
                        intent.putExtra("name", result.getKakaoAccount().getProfile().getNickname());
                        intent.putExtra("socialEmail", result.getKakaoAccount().getEmail());
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "환영합니다.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        //로그인 실패
                        Log.d("Login","onFailure");
                        Toast.makeText(LoginActivity.this, "로그인 도중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        //세션 닫힘
                        Log.d("Login","onSessionClosed");
                        Toast.makeText(LoginActivity.this, "세션이 닫혔습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                    }

                });
            }

            @Override
            public void onSessionOpenFailed(KakaoException exception) {

            }
        };
        Session.getCurrentSession().addCallback(mSessionCallback);
        Session.getCurrentSession().checkAndImplicitOpen();

        //getAppKeyHash();
    }

    //카카오 로그인 시 필요한 해시키
    private void getAppKeyHash(){
        try{
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for(Signature signature : info.signatures){
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.d("Hash Key", something);
            }
        } catch (Exception e){
            Log.e("name not found", e.toString());
        }
    }
}
