package stop.covid.project.cafein.main.dto;

import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("socialId") //서버랑 이름 같아서 생략 가능
    private String socialId;
    private String nickname;
    private String email;
    private String introduce;
    private String profileImage;
    private String backgroundImage;
    private String address;

    @NonNull
    @Override
    public String toString() {
        return "UserResult{" +
                "socialId: " + socialId +
                "nickname: " + nickname +
                "email: " + email +
                "introduce: " + introduce +
                "profileImage: " + profileImage +
                "backgroundImage: " + backgroundImage +
                "address: " + address +
                "}";
    }

    public User(){ }

    //기업용 생성자(주소 있음)
    public User(String socialId, String nickname, String email, String introduce, String profileImage, String backProfileImage, String address) {
        this.socialId = socialId;
        this.nickname = nickname;
        this.email = email;
        this.introduce = introduce;
        this.profileImage = profileImage;
        this.backgroundImage = backgroundImage;
        this.address = address;
    }

    //개인 회원용 생성자
    public User(String socialId, String nickname, String email, String introduce, String profileImage, String backProfileImage) {
        this.socialId = socialId;
        this.nickname = nickname;
        this.email = email;
        this.introduce = introduce;
        this.profileImage = profileImage;
        this.backgroundImage = backProfileImage;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backProfileImage) {
        this.backgroundImage = backProfileImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
