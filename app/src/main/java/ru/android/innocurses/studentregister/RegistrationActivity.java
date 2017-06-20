package ru.android.innocurses.studentregister;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by admin on 20.06.2017.
 */

public class RegistrationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        setTitle("Registration");
    }
}
