package stop.covid.project.cafein.main.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import stop.covid.project.cafein.main.dto.User;

public interface RetrofitService {
    @POST("/user/login/")
    Call<User> registerUser(@Body User user);
}
