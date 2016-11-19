package edu.tsinghua.gaoyong.java8;

import java.util.ArrayList;
import java.util.List;

public class Article {
	
	private  String title;
    private  String author;
    private  List<String> tags;
    
    public Article(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    public static void main(String[] args){
    	List<Article> articleList = new ArrayList<Article>();
    	for(int i =0 ;i < 5;i++){
    		Article article = new Article("title"+i,"author"+i);
    		articleList.add(article);
    	}
    	
//    	articleList.stream().findFirst();
    	
//    	articleList.stream()
//        .filter(article -> article.getTitle().contains("Java"))
//        .findFirst();
    }
    
}
