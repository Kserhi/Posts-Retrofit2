package org.example.app.network;

import org.example.app.entity.Posts;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

    @GET("posts")
    Call<List<Posts>> getPosts();
    @GET("posts/{id}")
    Call<Posts> getPostById(@Path("id") int id);
}
