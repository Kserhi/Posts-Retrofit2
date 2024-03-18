package org.example.app.model;

import org.example.app.entity.User;
import org.example.app.network.ApiClient;
import org.example.app.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;

public class UserModel {

public Optional<Response<List<User>>> fetchUsers() {
    ApiClient client = new ApiClient();
    ApiService service = client.getApiService();
    Call<List<User>> call = service.getUsers();
    Optional<Response<List<User>>> optional;

    try {
        optional = Optional.of(call.execute());
    } catch (Exception ex) {
        optional = Optional.empty();
    }

    return optional;
}


    public Optional<Response<User>> fetchUserById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<User> call = service.getUserById(id);
        Optional<Response<User>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception ex) {
            optional = Optional.empty();
        }
        return optional;
    }

}
