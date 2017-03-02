package com.example.android.week05rachell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    String avatar;
    boolean avatarChecked;
    ArrayList<BlogPost> blogPostArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blogPostArrayList = new ArrayList<BlogPost>();

    }

    public void onAvatarClick(View view) {
        avatarChecked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.batman:
                if (avatarChecked) {
                    avatar = "batman";
                }
                break;
            case R.id.superman:
                if (avatarChecked) {
                    avatar = "superman";
                }
                break;
            case R.id.gandolf:
                if (avatarChecked) {
                    avatar = "gandolf";
                }
                break;
            case R.id.bart:
                if (avatarChecked) {
                    avatar = "bart";
                }
                break;
            case R.id.lara:
                if (avatarChecked) {
                    avatar = "lara";
                }
                break;
            case R.id.harley:
                if (avatarChecked) {
                    avatar = "harley";
                }
                break;
            case R.id.minnie:
                if (avatarChecked) {
                    avatar = "minnie";
                }
                break;
            case R.id.lisa:
                if (avatarChecked) {
                    avatar = "lisa";
                }
                break;
        }
    }


    public void savePosts(View view) {
        EditText name = ((EditText) findViewById(R.id.name));
        EditText title = ((EditText) findViewById(R.id.title));
        EditText body = ((EditText) findViewById(R.id.body));

        String sName = name.getText().toString();
        String sTitle = title.getText().toString();
        String sbody = body.getText().toString();

        BlogPost blog = new BlogPost(sName, sTitle, sbody, avatar);
        blogPostArrayList.add(blog);
        name.setText("");
        title.setText("");
        body.setText("");

        Toast.makeText(this, "Your post: " + sTitle + " has been saved.", Toast.LENGTH_SHORT).show();

    }

    public void seeAll(View view) {

        intent = new Intent(this, SecondActivity.class);
        intent.putExtra("avatar", avatar);
        intent.putExtra("BlogPosts", blogPostArrayList);
        startActivity(intent);


    }



}
