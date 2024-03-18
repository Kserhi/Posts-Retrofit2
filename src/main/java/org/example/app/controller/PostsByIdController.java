package org.example.app.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.app.entity.Posts;
import org.example.app.model.PostModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.PostByIdView;
import retrofit2.Response;

import java.util.Optional;

public class PostsByIdController {

    PostModel model;
    PostByIdView view;

    public PostsByIdController(PostModel model, PostByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getPostById() {
        view.getOutput(readPostById(
                Integer.parseInt(view.getData())
        ));
        AppStarter.startApp();
    }

    private String readPostById(int id) {
        Optional<Response<Posts>> optional = model.fetchPostById(id);

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Gson gson = new Gson();
            Posts posts = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<Posts>() {}.getType());

            return "Post: id " + posts.getId() + ", " + posts.getTitle();
        }
    }
}
