package com.example.jitu.reterofit_tutorial_jsonarray_jsonobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;

import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {
    public static final String ROOT_URL = "http://hellohelps.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retro();
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh");
    }


    public void retro() {
        System.out.println("ssssssssssssssssss");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        api1 service = retrofit.create(api1.class);

        Call<List<item>> call = service.getBooks();

        call.enqueue(new Callback<List<item>>() {

            @Override
            public void onResponse(Response<List<item>> response, Retrofit retrofit) {
                List<item> StudentData = response.body();

                for (int i = 0; i < StudentData.size(); i++) {
                    System.out.println(StudentData.get(i).getimagelink());
                    System.out.println(StudentData.get(i).getsorcename());
                    System.out.println(StudentData.get(i).gettitle());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

}
