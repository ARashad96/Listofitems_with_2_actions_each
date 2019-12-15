package com.ARashad96.androidbeginnerdeveloperkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listofitems extends AppCompatActivity {
    Button github;
    Button info;
    ListView items;
    ArrayList arrayList_for_the_items = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_listofitems);

        items = findViewById(R.id.list_item);
        //put all the items needed
        arrayList_for_the_items.add("First item");
        arrayList_for_the_items.add("Second item");
        arrayList_for_the_items.add("Third item");
        arrayList_for_the_items.add("Forth item");
        arrayList_for_the_items.add("Fifth item");
        arrayList_for_the_items.add("Sixth item");
        arrayList_for_the_items.add("Seventh item");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList_for_the_items);
        items.setAdapter(adapter);
        //on one click
        items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //give an action for each one of them is pressed
                Toast.makeText(Listofitems.this, "You have pressed me the "+ arrayList_for_the_items.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //on long click
        items.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int pos, long id) {
                //give an action for each one of them is being pressed for long time
                Toast.makeText(Listofitems.this, "You are hurting me stop it said the "+ arrayList_for_the_items.get(pos).toString() + " to the user", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ARashad96/Listofitems_with_2_actions_each"));
                startActivity(intent);
            }
        });
        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(Listofitems.this)
                        .setIcon(R.drawable.profile)
                        .setTitle("App info")
                        .setMessage("This app is showing how to list items and give them 2 different actions on click and on long click using listview, toast and linearlayout.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }
}
