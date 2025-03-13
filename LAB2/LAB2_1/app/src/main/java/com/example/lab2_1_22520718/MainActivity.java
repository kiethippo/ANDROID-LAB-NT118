package com.example.lab2_1_22520718;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //khai báo biến giao diện
    ArrayList<String> myphone;
    ArrayAdapter<String> myadapter;
    ListView lv1;
    TextView txt_select;
    Button btnAdd;
    EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lv1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Ánh xạ id
        txt_select = findViewById(R.id.txt_select);
        lv1 = findViewById(R.id.lv1);
        edtName = (EditText) findViewById(R.id.edtName);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        myphone = new ArrayList<>();
        myphone.add("TÈO");
        myphone.add("TÝ");
        myphone.add("BIN");
        myphone.add("BO");

        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myphone);
        lv1.setAdapter(myadapter);

        // Setup nut click
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtName.getText().toString();
                myphone.add(ten);
                myadapter.notifyDataSetChanged();
            }
        });
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, " " + i, Toast.LENGTH_SHORT).show();
                String value = lv1.getItemAtPosition(i).toString();
                txt_select.setText("Vị Trí:" + i +" TÊN:" + value);

            }

        });

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                myphone.remove(i);
                myadapter.notifyDataSetChanged();
                return false;
            }
        });



    }
}