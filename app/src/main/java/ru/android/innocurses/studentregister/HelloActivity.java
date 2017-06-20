package ru.android.innocurses.studentregister;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by admin on 20.06.2017.
 */

public class HelloActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        setTitle("Hello");
    }
}
