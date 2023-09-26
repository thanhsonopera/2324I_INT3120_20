package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button login_google, login_facebook, submit;
    EditText Password;
    AutoCompleteTextView Account;
    List<String> DataListAccount = new ArrayList<>();
    List<String> DataListPassword = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        Account = findViewById(R.id.account);
        Password = findViewById(R.id.password);

        SharedPreferences sharedPreferences = getSharedPreferences("Accounts", Context.MODE_PRIVATE);
        Type type = new TypeToken<List<String>>() {}.getType();

        Gson gson = new Gson();

        String savedJsonValueListA = sharedPreferences.getString("account", "");

        DataListAccount = (gson.fromJson(savedJsonValueListA, type) == null)? DataListAccount : gson.fromJson(savedJsonValueListA, type);

        String savedJsonValueListP = sharedPreferences.getString("password", "");

        DataListPassword = (gson.fromJson(savedJsonValueListP, type) == null)? DataListPassword: gson.fromJson(savedJsonValueListP, type);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, DataListAccount);
        Account.setAdapter(adapter);

        Account.setOnItemClickListener(((adapterView, view, i, l) -> {
            for (int position = 0; position < DataListAccount.size(); ++ position)
                if (DataListAccount.get(position).equals(adapterView.getItemAtPosition(i).toString())) {
                    Password.setText(DataListPassword.get(position));
                    break;
                }
        }));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Account.getText().toString().isEmpty()) {
                    Toast toast = new Toast(getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View toastView = inflater.inflate(R.layout.toast_1, null);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.setView(toastView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                } else if (Password.getText().toString().isEmpty()) {
                    Toast toast = new Toast(getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View toastView = inflater.inflate(R.layout.toast_2, null);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.setView(toastView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    //Context.MODE_MULTI_PROCESS thay thế bằng Content Providers -> chia sẻ nhiều app
                    //Context.MODE_WORLD_READABLE, Context.MODE_WORLD_WRITEABLE

                    checkI(Account.getText().toString(), Password.getText().toString());

                    Gson gson = new Gson();
                    String jsonValueListAccount = gson.toJson(DataListAccount);
                    String jsonValueListPassword = gson.toJson(DataListPassword);

                    SharedPreferences sharedPreferences = getSharedPreferences("Accounts", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("account", jsonValueListAccount);
                    editor.putString("password", jsonValueListPassword);

                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void checkI(String A, String P) {

        if (DataListAccount != null) {
            if (!DataListAccount.contains(A)) {
                DataListAccount.add(A);
                DataListPassword.add(P);
            } else {
                //Check password
            }
        }
    }

}