package com.example.sharebear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        data = (TextView) findViewById(R.id.textView);
    }

    public void saveData(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", user.getText().toString());
        editor.putString("password", pass.getText().toString());
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
        user.setText("");
        pass.setText("");
        data.setText("");
    }

    public void displayData(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String p1 = sharedPreferences.getString("username", "");
        String p2 = sharedPreferences.getString("password", "456");

        user.setText("");
        pass.setText("");
        data.setText(p1 + "\n" + p2);
    }
}
