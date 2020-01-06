package com.example.singh.alumniportal.WebApi;

import com.example.singh.alumniportal.Model.Gallery;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GallaryApi {

    @GET("api/org_user_data.php")
    Call<ArrayList<Gallery>> getDataSet();
}
