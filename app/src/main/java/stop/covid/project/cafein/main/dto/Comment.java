package stop.covid.project.cafein.main.dto;

import android.graphics.drawable.BitmapDrawable;

//테스트용 dto
public class Comment {
    private int _id;
    private BitmapDrawable profile;
    private String nickname;
    private String comment;
    private String time;    //int?
    private int likeNum;

    public Comment(int _id, BitmapDrawable profile, String nickname, String comment, String time, int likeNum) {
        this._id = _id;
        this.profile = profile;
        this.nickname = nickname;
        this.comment = comment;
        this.time = time;
        this.likeNum = likeNum;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public BitmapDrawable getProfile() {
        return profile;
    }

    public void setProfile(BitmapDrawable profile) {
        this.profile = profile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}

