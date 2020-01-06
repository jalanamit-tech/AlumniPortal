package com.example.singh.alumniportal.activity.DashBoard.NavigationFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.singh.alumniportal.GalleryDataAdaptor;
import com.example.singh.alumniportal.Model.Gallery;
import com.example.singh.alumniportal.R;
import com.example.singh.alumniportal.RetrofitApiCall.ApiClient;
import com.example.singh.alumniportal.WebApi.GallaryApi;
import com.example.singh.alumniportal.WebApi.UserApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Gallery> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        recyclerView = findViewById(R.id.recyclerview);
        getdata();

    }

    private void getdata() {

        GallaryApi apicall = ApiClient.getClient().create(GallaryApi.class);
        Call<ArrayList<Gallery>> call=apicall.getDataSet();
        call.enqueue(new Callback<ArrayList<Gallery>>() {
            @Override
            public void onResponse(Call<ArrayList<Gallery>> call, Response<ArrayList<Gallery>> response) {
                int statuscode=response.code();
                arrayList = new ArrayList<>();
                if (statuscode==200|| statuscode==201|| statuscode==202){
                    arrayList=response.body();
                    GalleryDataAdaptor dataAdaptor= new GalleryDataAdaptor(GalleryActivity.this,arrayList);
                    recyclerView.setAdapter(dataAdaptor);
                    Toast.makeText(getApplicationContext(),"sucess"+statuscode,Toast.LENGTH_SHORT).show();
                    System.out.println("sucess"+statuscode);

                }
                Toast.makeText(getApplicationContext(),"other"+statuscode,Toast.LENGTH_SHORT).show();
                System.out.println("other"+statuscode);

            }


            @Override
            public void onFailure(Call<ArrayList<Gallery>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"error"+t.getMessage(),Toast.LENGTH_SHORT).show();
                System.out.println("error"+t.getMessage());
            }
        });
    }
}
// isme delkho na error kya aarhai hai basss mujhe image show karwa na hia card view me