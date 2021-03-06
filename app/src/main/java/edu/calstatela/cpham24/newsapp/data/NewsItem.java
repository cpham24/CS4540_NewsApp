package edu.calstatela.cpham24.newsapp.data;

/**
 * Created by bill on 6/29/17.
 */

// moved this class into the data sub package because it's only used to load data into db now
public class NewsItem {
    public String title;
    public String author;
    public String description;
    public String url;
    public String imgurl;
    public String date;

    public NewsItem(String title, String author, String description, String date, String url, String imgurl) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.date = date;
        this.url = url;
        this.imgurl = imgurl;
    }
}
