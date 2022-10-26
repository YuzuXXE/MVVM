package com.example.mvvm_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm_demo.viewmodels.MainViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    private TextInputEditText mEdtAccount;
    private TextInputEditText mEdtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 将MainActivity和MainViewModel绑定
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mEdtAccount = findViewById(R.id.et_account);
        mEdtPwd = findViewById(R.id.et_pwd);
        findViewById(R.id.btn_login).setOnClickListener(view -> {
            mainViewModel.account = mEdtAccount.getText().toString().trim();
            mainViewModel.pwd = mEdtPwd.getText().toString().trim();
            if (mainViewModel.account.isEmpty()) {
                Toast.makeText(this, "请输入账号", Toast.LENGTH_LONG).show();
                return;
            }
            if (mainViewModel.pwd.isEmpty()) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
            }
            Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
        });
    }
}