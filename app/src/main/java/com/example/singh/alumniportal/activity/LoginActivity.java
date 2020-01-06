package com.example.singh.alumniportal.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.singh.alumniportal.Model.UserModel.User;
import com.example.singh.alumniportal.Model.UserModel.Users;
import com.example.singh.alumniportal.R;
import com.example.singh.alumniportal.RetrofitApiCall.ApiClient;
import com.example.singh.alumniportal.Utils.ProgressBarUtil;
import com.example.singh.alumniportal.WebApi.UserApi;
import com.example.singh.alumniportal.activity.DashBoard.HomeActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    private long backPressedTime;
    private UserApi mService;
    private ProgressBarUtil progressBarUtil;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        progressBarUtil = new ProgressBarUtil(this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userValidation();
            }
        });

        findViewById(R.id.textViewRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
            }
        });
    }

    private void userValidation() {
        final String email = editTextEmail.getText().toString();
        final String password = editTextPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter your email");
            editTextEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please enter your password");
            editTextPassword.requestFocus();
            return;
        }

        user = new User();
        user.setEmailId(email);
        user.setPassword(password);
        callSignInApi(user);
    }

    private void callSignInApi(User user) {
        progressBarUtil.showProgress();
        mService = ApiClient.getClient().create(UserApi.class);
        Call<Users> call = mService.signInService(user.getEmailId(),user.getPassword());
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                int statusCode = response.code();
                if(statusCode==200 && response.body()!=null){
                    if(response.body().getError()!=true && response.body().getUser()!=null){
                        progressBarUtil.hideProgress();
                        Users users = new Users();
                        Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_LONG).show();
                        users = response.body();
                        Gson gson = new Gson();
                        String json = gson.toJson(users);
                        System.out.println("Suree : "+json);
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }
                    else {
                        progressBarUtil.hideProgress();
                        Toast.makeText(LoginActivity.this, "Invalid UserName Password ", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Success"+statusCode,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                progressBarUtil.hideProgress();
                Toast.makeText(LoginActivity.this,"Failed",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (backPressedTime+2000>System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else{
            Toast.makeText(getBaseContext(),"Press Exit again to exit",Toast.LENGTH_SHORT).show();
        }
        backPressedTime=System.currentTimeMillis();
    }
}