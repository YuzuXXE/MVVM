package com.example.mvvm_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvm_demo.databinding.ActivityMainBinding;
import com.example.mvvm_demo.model.User;
import com.example.mvvm_demo.viewmodels.MainViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    private TextInputEditText mEdtAccount;
    private TextInputEditText mEdtPwd;
    private TextView mTvAccount;
    private TextView mTvPwd;

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // 数据绑定视图
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // 设置数据 直接显示在xml上
        mUser = new User("admin", "123456");
        activityMainBinding.setUser(mUser);

        activityMainBinding.btnLogin.setOnClickListener(view -> {
            // 通过手动更改数据源的方式，将更改的数据通知到xml上
            mUser.setAccount(activityMainBinding.etAccount.getText().toString().trim());
            mUser.setPwd(activityMainBinding.etPwd.getText().toString().trim());
        });

//        // 将MainActivity和MainViewModel绑定
//        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
//
//        mEdtAccount = findViewById(R.id.et_account);
//        mEdtPwd = findViewById(R.id.et_pwd);
//        mTvAccount = findViewById(R.id.tv_account);
//        mTvPwd = findViewById(R.id.tv_pwd);
//
//        findViewById(R.id.btn_login).setOnClickListener(view -> {
//            mainViewModel.account.setValue(mEdtAccount.getText().toString().trim());
//            mainViewModel.pwd.setValue(mEdtPwd.getText().toString().trim());
//            if (mainViewModel.account.getValue().isEmpty()) {
//                Toast.makeText(this, "请输入账号", Toast.LENGTH_LONG).show();
//                return;
//            }
//            if (mainViewModel.pwd.getValue().isEmpty()) {
//                Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
//            }
//            Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
//        });
//        mainViewModel.account.observe(this, account -> mTvAccount.setText("账号：" + account));
//        mainViewModel.pwd.observe(this, pwd -> mTvPwd.setText("密码：" + pwd));
    }
}