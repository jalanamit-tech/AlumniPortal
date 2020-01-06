package com.example.singh.alumniportal.WebApi;
import com.example.singh.alumniportal.Model.UserModel.Users;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {

    @FormUrlEncoded
    @POST("register.php")
    Call<Users> signUpService(
            @Field("name") String name,
            @Field("email_id") String email_id,
            @Field("roll_no") String roll_no,
            @Field("batch") String batch,
            @Field("branches") String branches,
            @Field("phonenumber") String phonenumber,
            @Field("date_of_birth") String date_of_birth,
            @Field("password") String password,
            @Field("role") String role);

    @FormUrlEncoded
    @POST("login.php")
    Call<Users> signInService(
            @Field("email_id") String email_id,
            @Field("password") String password);
}
