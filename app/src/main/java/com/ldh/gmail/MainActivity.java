package com.ldh.gmail;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
   // private  Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    ImageView imageView_menu;
    NavigationView navigationView;
    private ListView listView;
    private static ArrayList<String> title_items;
    private static ArrayList<String> content_items;
    private static ListViewAdapter adapter;
    private EditText editText;
    private String [] str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
      //  toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        imageView_menu = (ImageView) findViewById(R.id.imageView_menu);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(navigationView);

            }
        });
        createListMail();
        editText = (EditText) findViewById(R.id.search);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                  if (position == 0)
                  {
                      Intent intent = new Intent(view.getContext(),Email_0.class);
                      startActivity(intent);
                  }
                Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void createListMail()
    {
        Messages messages = new Messages();
        listView = (ListView) findViewById(R.id.listMail);
        title_items = new ArrayList<>();
        str = messages.getStr();
        for (int i=0;i<str.length;i++)
        {
            title_items.add(str[i]);
        }
        adapter = new ListViewAdapter(getApplicationContext(), title_items);
        listView.setAdapter(adapter);
    }
}