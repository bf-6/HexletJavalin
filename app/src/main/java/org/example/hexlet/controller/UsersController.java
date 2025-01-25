package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {

    public static void index(Context ctx) {
        var term = ctx.queryParam("term");
        var listUsers = UserRepository.getEntities();
        List<User> users;

//            Данный условный оператор создан для поиска с помощью поисковой формы в шаблоне users/index.jte
//            Тут мы фильтруем список пользователей USERS по имени (firstName), и если имя начинается или полностью
//            совпадает с параметром term, который мы передали с помощью поисковой формы <form>, то тогда этот элемент
//            добавляется в список users, а затем готовый список users передается в шаблон users/index.jte
        if (term != null) {
            users = UserRepository.search(term);
        } else {
            users = listUsers;
        }

        var page = new UsersPage(users, term);
        ctx.render("users/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var listUsers = UserRepository.getEntities();

        User user = listUsers.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst()
                .orElseThrow(() -> new NotFoundResponse("User not found"));

        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("users/build.jte");
    }

    public static void create(Context ctx) {
        var firstName = ctx.formParam("first-name").trim();
        var lastName = ctx.formParam("last-name").trim();
        var email = ctx.formParam("email").trim().toLowerCase();

        var user = new User(firstName, lastName, email);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

}
