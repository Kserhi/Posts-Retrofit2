package org.example.app.model;

import org.example.app.controller.PostsByIdController;
import org.example.app.controller.PostController;
import org.example.app.view.PostByIdView;
import org.example.app.view.PostView;

public class AppModel {

    public void readPosts() {
        PostModel model = new PostModel();
        PostView view = new PostView();
        PostController controller = new PostController(model, view);
        controller.getPosts();
    }

    public void readPostById() {
        PostModel model = new PostModel();
        PostByIdView view = new PostByIdView();
        PostsByIdController controller = new PostsByIdController(model, view);
        controller.getPostById();
    }
}
