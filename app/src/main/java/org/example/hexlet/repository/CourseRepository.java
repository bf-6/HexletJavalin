package org.example.hexlet.repository;

import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {
    private static List<Course> entities = new ArrayList<Course>();

    public static void save(Course course) {
        course.setId((long) entities.size() + 1);
        entities.add(course);
    }

    public static List<Course> search(String term) {
        var courses = entities.stream()
                .filter(course -> course.getName().toLowerCase().contains(term.toLowerCase()))
                .toList();
        return courses;
    }

    public static Optional<Course> find(Long id) {
        var maybeCourse = entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny();
        return maybeCourse;
    }

    public static List<Course> getEntities() {
        return entities;
    }
}
