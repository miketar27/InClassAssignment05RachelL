package com.example.android.week05rachell;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

        String key = getString(R.string.saved_username);

        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);

        String username = sharedPref.getString(key, getString(R.string.saved_username_default));

        TextView usernameDisplay = (TextView) findViewById(R.id.username_display);
        usernameDisplay.setText("Welcome, " + username + "!");
    }

    public void changeUsername(View view) {
        EditText editText = (EditText) findViewById(R.id.new_username);
        String newUsername = editText.getText().toString();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.saved_username), newUsername);
        editor.commit();

        editText.setText("");
        TextView usernameDisplay = (TextView) findViewById(R.id.username_display);
        usernameDisplay.setText("Welcome, " + newUsername + "!");
    }

    public void onAvatarClick(View view) {
        avatarChecked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
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

        RadioGroup maleGroup = (RadioGroup) findViewById(R.id.male_group);
        RadioButton maleCheckedRB = (RadioButton) findViewById(maleGroup.getCheckedRadioButtonId());
        maleCheckedRB.setChecked(false);

        RadioGroup femaleGroup = (RadioGroup) findViewById(R.id.female_group);
        RadioButton femaleCheckedRB = (RadioButton) findViewById(femaleGroup.getCheckedRadioButtonId());
        femaleCheckedRB.setChecked(false);

        Toast.makeText(this, "Your post: " + sTitle + " has been saved.", Toast.LENGTH_SHORT).show();
    }

    public void seeAll(View view) {
        intent = new Intent(this, SecondActivity.class);
        intent.putExtra("BlogPosts", blogPostArrayList);
        startActivity(intent);
    }
}
