package com.example.jitu.reterofit_tutorial_jsonarray_jsonobject;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by jitu on 5/7/2017.
 */

public interface api1 {
    @GET("/HelloHelps/z_get_news_ent.php?page=1")
    Call<List<item>> getBooks();
}
