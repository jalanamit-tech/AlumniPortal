//package com.example.singh.alumniportal.activity.DashBoard.NavigationFragment;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import com.example.singh.alumniportal.EventAdaptor;
//import com.example.singh.alumniportal.Model.Events;
//import com.example.singh.alumniportal.R;
//import com.example.singh.alumniportal.RetrofitApiCall.ApiClient;
//import com.example.singh.alumniportal.WebApi.EventApi;
//
//import java.util.ArrayList;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class EventActivity extends AppCompatActivity {
//
//    private RecyclerView recyclerView;
//    private ArrayList<Events> arrayList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event);
//        recyclerView = findViewById(R.id.recyclerview);
//        getdata();
//
//    }
//
//    private void getdata() {
//        EventApi apicall = ApiClient.getClient().create(EventApi.class);
//        Call<ArrayList<Events>> call=apicall.getDataSet();
//        call.enqueue(new Callback<ArrayList<Events>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Events>> call, Response<ArrayList<Events>> response) {
//                int statuscode=response.code();
//                arrayList = new ArrayList<>();
//                if (statuscode==200|| statuscode==201|| statuscode==202){
//                    arrayList=response.body();
//                    EventAdaptor eventAdaptor= new EventAdaptor(EventActivity.this,arrayList);
//                    recyclerView.setAdapter(eventAdaptor);
//                    Toast.makeText(getApplicationContext(),"sucess"+statuscode,Toast.LENGTH_SHORT).show();
//                    System.out.println("sucess"+statuscode);
//
//                }
//                Toast.makeText(getApplicationContext(),"other"+statuscode,Toast.LENGTH_SHORT).show();
//                System.out.println("other"+statuscode);
//
//            }
//
//
//            @Override
//            public void onFailure(Call<ArrayList<Example>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),"error"+t.getMessage(),Toast.LENGTH_SHORT).show();
//                System.out.println("error"+t.getMessage());
//            }
//        });
//    }
//}
//
