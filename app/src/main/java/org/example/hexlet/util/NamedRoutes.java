package org.example.hexlet.util;

/* Этот класс возвращает с помощью своих методов, пути для обработчиков и для кода шаблонов jte*/
public class NamedRoutes {
    public static String coursesPath() {
        return "/all-courses";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/all-courses/" + id;
    }

    public static String buildCoursePath() {
        return "/all-courses/build";
    }

    public static String usersPath() {
        return "/users";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    public static String sessionsPath() {
        return "/sessions";
    }

    public static String buildSessionPath() {
        return "/sessions/build";
    }
}
