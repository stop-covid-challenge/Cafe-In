package stop.covid.project.cafein.main.subscribe;

import android.graphics.drawable.BitmapDrawable;
import android.media.Image;

import java.util.ArrayList;

import stop.covid.project.cafein.R;

//임시 dto -> 서버에서 바로 값 받아와서 dto필요없으려나...아니야 있어야 할듯?
public class Post {
    private int _id;
    private BitmapDrawable post_profile;
    private String nickname;
    private String[] imgList;
    private boolean like;
    private BitmapDrawable my_profile;

    public Post(int _id, BitmapDrawable post_profile, String nickname, String[] imgList, boolean like, BitmapDrawable my_profile) {
        this._id = _id;
        this.post_profile = post_profile;
        this.nickname = nickname;
        this.imgList = imgList;
        this.like = like;
        this.my_profile = my_profile;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public BitmapDrawable getPost_profile() {
        return post_profile;
    }

    public void setPost_profile(BitmapDrawable post_profile) {
        this.post_profile = post_profile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String[] getImgList() {
        return imgList;
    }

    public void setImgList(String[] imgList) {
        this.imgList = imgList;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public BitmapDrawable getMy_profile() {
        return my_profile;
    }

    public void setMy_profile(BitmapDrawable my_profile) {
        this.my_profile = my_profile;
    }
}
