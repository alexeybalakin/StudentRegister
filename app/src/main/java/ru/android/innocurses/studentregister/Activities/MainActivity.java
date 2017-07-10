package ru.android.innocurses.studentregister.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import ru.android.innocurses.studentregister.R;

public class MainActivity extends Activity {
    private Button regButton;
    private Button okButton;
    private EditText loginEditText;
    private EditText passEditText;
    private Context context;
    static Map<String, String> logins = new HashMap<>();
    static{
        logins = new HashMap<>();
        logins.put("admin","admin");
        logins.put("user","user");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.login_name);

        context = this;
        regButton = (Button) findViewById(R.id.regButton);
        okButton = (Button)  findViewById(R.id.okButton);
        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passEditText = (EditText) findViewById(R.id.passEditText);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getBoolean("save_login", false)){
            loginEditText.setText(sharedPreferences.getString("user_login", ""));
        }
        if(sharedPreferences.getBoolean("save_password", false)){
            passEditText.setText(sharedPreferences.getString("user_password", ""));
        }

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, RegistrationActivity.class));

            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!logins.containsKey(loginEditText.getText().toString())){
                    Toast.makeText(MainActivity.this,
                            "Пользователь с таким логином не существует", Toast.LENGTH_SHORT).show();
                }
                else if (!logins.get(loginEditText.getText().toString()).equals(passEditText.getText().toString())){
                    Toast.makeText(MainActivity.this,
                            "Не верный пароль", Toast.LENGTH_SHORT).show();
                }
                else {
                if(loginEditText.getText().toString().equals("admin") ){
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    if(sharedPreferences.getBoolean("save_login", false)){
                        sharedPreferences.edit().putString("user_login", loginEditText.getText().toString()).commit();
                    }
                    if(sharedPreferences.getBoolean("save_password", false)){
                        sharedPreferences.edit().putString("user_password", passEditText.getText().toString()).commit();
                    }
                    startActivity(new Intent(context,AdminActivity.class));

                }

                else startActivity(new Intent(context, StudentsActivity.class));
                }
            }
        });

    }


}
