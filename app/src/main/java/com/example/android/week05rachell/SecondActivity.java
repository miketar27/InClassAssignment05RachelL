package com.example.android.week05rachell;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intent = getIntent();
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        ArrayList<BlogPost> posts = (ArrayList<BlogPost>) intent.getSerializableExtra("BlogPosts");

        for (int index = 0; index < posts.size(); index++) {
            LinearLayout wrapper = new LinearLayout(this);
            wrapper.setOrientation(LinearLayout.VERTICAL);
            wrapper.setPadding(10, 10, 10, 10);

            wrapper.setBackgroundColor(Color.WHITE);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(0, 0, 0, 15);

            wrapper.setLayoutParams(layoutParams);

            TextView blogViewName = new TextView(this);
            TextView blogViewTitle = new TextView(this);
            TextView blogViewBody = new TextView(this);
            ImageView icon = new ImageView(this);

            wrapper.addView(icon);
            wrapper.addView(blogViewTitle);
            wrapper.addView(blogViewName);
            wrapper.addView(blogViewBody);

            blogViewName.setText("Author: " + posts.get(index).getName());
            blogViewTitle.setTextSize(30);
            blogViewTitle.setTypeface(Typeface.DEFAULT_BOLD);
            blogViewName.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            icon.setImageResource(R.drawable.batman);

            blogViewTitle.setText(posts.get(index).getTitle());
            blogViewBody.setText(posts.get(index).getBody());


            rootView.addView(wrapper);

        }
    }
}




