package com.example.android.week05rachell;

import java.io.Serializable;

/**
 * Created by Rachel Lockerman on 2/22/2017.
 */

public class BlogPost implements Serializable {
    String name;
    String title;
    String body;
    String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public BlogPost(String name, String title, String body, String avatar) {
        this.name = name;
        this.title = title;
        this.body = body;
        this.avatar=avatar;
    }
}
