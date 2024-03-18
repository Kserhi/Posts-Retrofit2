package org.example.app.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.app.entity.Posts;
import org.example.app.model.PostModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.PostView;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PostController {

    PostModel model;
    PostView view;

    public PostController(PostModel model, PostView view) {
        this.model = model;
        this.view = view;
    }

    public void getPosts() {
        view.getOutput(readPosts());
        AppStarter.startApp();
    }

    private String readPosts() {
        Optional<Response<List<Posts>>> optional = model.fetchPosts();
        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Gson gson = new Gson();
            List<Posts> posts = gson.fromJson(gson.toJson(optional.get().body()),
                    new TypeToken<List<Posts>>() {}.getType());

            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger cnt = new AtomicInteger(0);
            String str;



            for (Posts post : posts) {
                str = cnt.incrementAndGet() + ") Post: id " + post.getId() + ", "
                        + post.getTitle() + "\n";
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }
    }

}
