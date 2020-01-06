package com.example.singh.alumniportal.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class RegistrationActivity extends AppCompatActivity {
    EditText editTextName, editTextEmail, editTextRoll,editTextBatch, editTextBranches,editTextPhoneNumber, editTextDob, editTextPassword;
    Button register;
    RadioGroup radioGroupRole;
    private UserApi mService;
    private ProgressBarUtil progressBarUtil;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();
    }

    private void initView() {
        progressBarUtil   =  new ProgressBarUtil(this);
        editTextName      =  findViewById(R.id.editTextname);
        editTextEmail     =  findViewById(R.id.editTextEmail);
        editTextRoll      =  findViewById(R.id.editTextRollno);
        editTextBatch     =  findViewById(R.id.editTextBatch);
        editTextBranches  =  findViewById(R.id.editTextBranches);
        editTextDob       =  findViewById(R.id.editTextDateofbirth);
        editTextPassword  =  findViewById(R.id.editTextPassword);
        editTextPhoneNumber  =  findViewById(R.id.editTextPhoneNumber);
        radioGroupRole    =  findViewById(R.id.radioRole);
        register          =  findViewById(R.id.buttonRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userValidation();
            }
        });

        findViewById(R.id.textViewLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });
    }

    private void userValidation() {
        final String username = editTextName.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String rollno = editTextRoll.getText().toString().trim();
        final String batch = editTextBatch.getText().toString().trim();
        final String branches = editTextBranches.getText().toString().trim();
        final String phonenumber = editTextPhoneNumber.getText().toString().trim();
        final String dob = editTextDob.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String role = ((RadioButton) findViewById(radioGroupRole.getCheckedRadioButtonId())).getText().toString();

        if (TextUtils.isEmpty(username)) {
            editTextName.setError("Please enter name");
            editTextName.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter your email");
            editTextEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(rollno)) {
            editTextRoll.setError("Please enter roll no");
            editTextRoll.requestFocus();
            return;
        }if (TextUtils.isEmpty(batch)) {
            editTextBatch.setError("Please enter batch");
            editTextBatch.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(branches)) {
            editTextBranches.setError("Please enter mothername");
            editTextBranches.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(phonenumber)) {
            editTextPhoneNumber.setError("Please enter mothername");
            editTextPhoneNumber.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(dob)) {
            editTextDob.setError("Please enter date of birth");
            editTextDob.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Enter a password");
            editTextPassword.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(role)) {
            editTextRoll.setError("Please enter User Role");
            editTextRoll.requestFocus();
            return;
        }
        user = new User();
        user.setName(username);
        user.setEmailId(email);
        user.setRollNo(rollno);
        user.setBatch(batch);
        user.setBranches(branches);
        user.setPhonenumber(phonenumber);
        user.setDateOfBirth(dob);
        user.setPassword(password);
        user.setRole(role);

        if(user!=null){
            CallSignupApi(user);
        }
    }

    private void CallSignupApi(User user) {
        progressBarUtil.showProgress();
        mService = ApiClient.getClient().create(UserApi.class);
        Call<Users> call = mService.signUpService(user.getName(), user.getEmailId(), user.getRollNo(), user.getBatch(), user.getBranches(), user.getPhonenumber(), user.getDateOfBirth(), user.getPassword(), user.getRole());
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                int statusCode = response.code();
                if (statusCode == 200 && response.body() != null) {
                    Users users = new Users();
                    if (response.body().getError() != true && response.body().getUser() != null) {
                        progressBarUtil.hideProgress();
                        Toast.makeText(RegistrationActivity.this, "Success", Toast.LENGTH_LONG).show();
                        users = response.body();
                        Gson gson = new Gson();
                        String json = gson.toJson(users);
                        System.out.println("Suree : " + json);
                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                    } else {
                        progressBarUtil.hideProgress();
                        Toast.makeText(RegistrationActivity.this, "User Already exist", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(RegistrationActivity.this, "Success" + statusCode, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                progressBarUtil.hideProgress();
                Toast.makeText(RegistrationActivity.this,"Failed",Toast.LENGTH_LONG).show();
            }
        });

    }
}

