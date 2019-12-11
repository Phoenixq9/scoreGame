package com.example.score;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> levelArray;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listView);

levelArray=new ArrayList<>();
levelArray.add("Easy");
levelArray.add("Medium");
levelArray.add("Hard");
levelArray.add("Expert");

adapter=new ArrayAdapter(Main2Activity.this,android.R.layout.simple_list_item_1,levelArray);
listView.setAdapter(adapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0){
            Intent intent=new Intent(Main2Activity.this,MainActivity.class);
            intent.putExtra("easy",levelArray.get(position));
            startActivity(intent);


        }
        if(position==1){
            Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
            intent.putExtra("medium",levelArray.get(position));
            startActivity(intent);


        }
        if(position==2){
            Intent intent=new Intent(Main2Activity.this,Main4Activity.class);
            intent.putExtra("hard",levelArray.get(position));
            startActivity(intent);

        }
        if(position==3){
            Intent intent=new Intent(Main2Activity.this,Main5Activity.class);
            intent.putExtra("expert",levelArray.get(position));
            startActivity(intent);

        }
    }

});









    }

}

