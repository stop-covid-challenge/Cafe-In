package stop.covid.project.cafein.main.comment;

import android.net.Uri;

import java.time.LocalDateTime;

public class CommentItem {

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

    public Uri getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Uri profile_image) {
        this.profile_image = profile_image;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    private String nickname;
    private String comment;
    private Uri profile_image;
    private Integer like;
    private LocalDateTime localDateTime;

}
