package org.example.app.model;

import org.example.app.entity.Posts;
import org.example.app.network.ApiClient;
import org.example.app.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;

public class PostModel {

public Optional<Response<List<Posts>>> fetchPosts() {
    ApiClient client = new ApiClient();
    ApiService service = client.getApiService();
    Call<List<Posts>> call = service.getPosts();
    Optional<Response<List<Posts>>> optional;

    try {
        optional = Optional.of(call.execute());
    } catch (Exception ex) {
        optional = Optional.empty();
    }

    return optional;
}


    public Optional<Response<Posts>> fetchPostById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<Posts> call = service.getPostById(id);
        Optional<Response<Posts>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception ex) {
            optional = Optional.empty();
        }
        return optional;
    }

}
