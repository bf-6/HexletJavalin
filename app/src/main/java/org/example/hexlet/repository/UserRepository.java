package org.example.hexlet.repository;

import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static List<User> entities = new ArrayList<User>();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<User> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getFirstName().startsWith(term))
                .toList();
        return users;
    }

    public static Optional<User> find(Long id) {
        var maybeUser = entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny();
        return maybeUser;
    }

    public static List<User> getEntities() {
        return entities;
    }
}
