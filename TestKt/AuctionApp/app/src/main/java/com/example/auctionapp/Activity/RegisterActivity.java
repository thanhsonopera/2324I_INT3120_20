package com.example.auctionapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.example.auctionapp.Fragment.Register.Step1;
import com.example.auctionapp.Fragment.Register.Step2;
import com.example.auctionapp.Fragment.Register.Step3;
import com.example.auctionapp.Interface.OnItemClickListener;
import com.example.auctionapp.R;
import com.example.auctionapp.databinding.ActivityRegisterBindingImpl;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity  implements OnItemClickListener {

    private ActivityRegisterBindingImpl mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRegister = DataBindingUtil.setContentView(this, R.layout.activity_register);
        setContentView(mRegister.getRoot());
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setReorderingAllowed(true);
            Fragment step1 = new Step1();
            ((Step1) step1).setOnItemClickListener(this);
            transaction.add(R.id.frame_register, step1);
            transaction.commit();
        }
    }
    @Override
    public void onItemClick(int i, Bundle bundle) {
        if (i == 2) {
            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
            Fragment step2 = new Step2();
            ((Step2) step2).setOnItemClickListener(this);
            transaction2.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
            transaction2.replace(R.id.frame_register, step2);
            transaction2.commit();
        }
        if (i == 3) {
            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
            Fragment step3 = new Step3();
            ((Step3) step3).setOnItemClickListener(this);
            transaction2.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
            transaction2.replace(R.id.frame_register, step3);
            transaction2.commit();
        }
        //Xử lý đăng ký thành công
//        checkRegisterSuccess();
    }

    public static boolean checkRegister(String password, String uid) {
        String passAuth = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(passAuth);
        return pattern.matcher(password).matches();
    }
}