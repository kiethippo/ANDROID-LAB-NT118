package com.example.a22520718_lab4_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    private Button button2;
    private void findViewsByIds() {
        button2 = (Button) findViewById(R.id.button2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewsByIds();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                //startActivity(intent);
                finish();
                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_move);
            }
        });
    }
}