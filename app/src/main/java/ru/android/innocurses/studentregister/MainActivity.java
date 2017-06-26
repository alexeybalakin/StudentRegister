package ru.android.innocurses.studentregister;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import ru.android.innocurses.studentregister.Managers.ManagerGroups;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class MainActivity extends Activity {
    private Button regButton;
    private Button okButton;
    private EditText loginEditText;
    private EditText passEditText;
    private Context context;
    static Map<String, String> logins = new HashMap<>();

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

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, RegistrationActivity.class));

            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginEditText.getText().toString().equals("admin") && passEditText.getText().toString().equals("admin")){
                    startActivity(new Intent(context,AdminActivity.class));
                }

                else startActivity(new Intent(context, GroupsActivity.class));

//                if(!logins.containsKey(loginEditText.getText().toString())){
//                    Toast.makeText(MainActivity.this,
//                            "Пользователь с таким логином не существует", Toast.LENGTH_SHORT).show();
//                }
//                else if (!logins.get(loginEditText.getText().toString()).equals(passEditText.getText().toString())){
//                    Toast.makeText(MainActivity.this,
//                            "Не верный пароль", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    startActivity(new Intent(context, ProfileActivity.class));
//                }
            }
        });

    }


}
