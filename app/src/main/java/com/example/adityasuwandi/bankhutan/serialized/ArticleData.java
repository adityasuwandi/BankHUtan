package com.example.adityasuwandi.bankhutan.serialized;

import java.io.Serializable;

/**
 * Created by root on 16/09/17.
 */

public class ArticleData implements Serializable {

    String title,article;

    public void setTitle(String title){ this.title = title}
    public String getTitle() { return this.title;}
    public void  setArticle(String article) { this.article = article}
    public String getArticle() { return this.article}

}
