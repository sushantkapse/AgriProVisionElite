package com.example.agriprovisionelite.comman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agriprovisionelite.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;
import java.util.List;

public class News2 extends AppCompatActivity  implements View.OnClickListener{


    RecyclerView  recyclerView;
    List<Article> articleList=new ArrayList<>();
    newsRecyclerAdapter adapter;
    LinearProgressIndicator progressIndicator;
    Button b1,b2,b3,b4,b5,b6,b7;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news2);
        recyclerView=findViewById(R.id.recycler_view);
        progressIndicator=findViewById(R.id.progresss_bar);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);

        searchView=findViewById(R.id.search_view);




        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getNews("GENERAL",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



        getNews("GENERAL",null);
        setUpRecyclerView();

    }



    void changeInProgress(boolean status){
        if(status){
            progressIndicator.setVisibility(View.VISIBLE);
        }
        else{
            progressIndicator.setVisibility(View.INVISIBLE);
        }
    }

    void setUpRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new newsRecyclerAdapter(articleList);
        recyclerView.setAdapter(adapter);
    }




    void getNews(String category,String query){
changeInProgress(true);
        NewsApiClient newsApiClient=new NewsApiClient("1664224815e84af98837c3b1ca9fce12");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder().category(category).q(query)
                .language("en").build(),new NewsApiClient.ArticlesResponseCallback(){

                    @Override
                    public void onSuccess(ArticleResponse response) {
      runOnUiThread(()->{
          changeInProgress(false);
          articleList=response.getArticles();
          adapter.updateData(articleList);
          adapter.notifyDataSetChanged();

      }
      );


                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        Button bu= (Button) v;
        String category=bu.getText().toString();
        getNews(category,null);


    }
}