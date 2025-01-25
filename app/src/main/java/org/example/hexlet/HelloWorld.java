package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

import java.util.Collections;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

//    На самом деле в константу COURSES передается список пользователей,
//    но я так же использую этих пользователей для заполнения списка курсов,
//    генерируются они с помощью класса Data
    private static final List<Course> COURSES = Data.getCourses();
    private static final List<User> USERS = Data.getUsers();

    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

//        Описываем, что загрузится по адресу "/"
//        app.get("/", ctx -> ctx.result("Hello World"));
        /**/
//        По адресу / загрузится шаблон index.jte, его содержимое отобразит
//        метод .render()
        app.get("/", ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited")); // ЭТО ДЛЯ КУКИ
            var page = new MainPage(visited, ctx.sessionAttribute("currentUser")); // ЗДЕСЬ КУКА И СЕССИЯ
            ctx.render("index.jte", model("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });


        // При GET запросе на адрес /users на странице отобразиться текст "GET /users"
        // потому что тут используется метод .get
//        app.get("/users", ctx -> ctx.result("GET /users"));

        // тут используется метот .post, поэтому при POST запросе на адрес /users ответ будет
        // "POST /users"
//        app.post("/users", ctx -> ctx.result("POST /users"));

        // При GET запросе на адрес /hello ответ будет "Hello, World!", если мы не укажем параметр name
        // Если мы укажем параметр, например, Nikita, указав его в запросе /hello?name=Nikita, то результат будет
        // "Hello, Nikita!"
//        app.get("/hello", ctx -> {
//            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
//            ctx.result("Hello, " + name + "!");
//        });

        // Динамический маршрут с двумя параметрами courseId и id. Они передаются в переменные courseId и lessonId
        // с помощью метода .pathParam()
//        app.get("/courses/{courseId}/lessons/{id}", ctx -> {
//            var courseId = ctx.pathParam("courseId");
//            var lessonId =  ctx.pathParam("id");
//            ctx.result("Course ID: " + courseId + " Lesson ID: " + lessonId);
//        });

//        // Динамический маршрут с двумя параметрами id и postId. Они передаются в переменные userId и postId
//        // с помощью метода .pathParam()
//        app.get("/users/{id}/post/{postId}", ctx -> {
//            var userId = ctx.pathParam("id");
//            var postId = ctx.pathParam("postId");
//            ctx.result("User: " + userId + " Post: " + postId);
//        });

/**/

//        этот обработчик создания нового курса, здесь используется шаблон courses/build.jte
        app.get(NamedRoutes.buildCoursePath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
        });
//        В данном обработчике также используется шаблон courses/index.jte,
//        в него мы передаем аргумент в методе model(), в переменной page мы передаем сам объект,
//        эту переменную можно назвать как удобно. Аргумент "page" - это то как объект будет
//        называться в шаблоне index.jte, то есть в шаблоне добавление объекта page будет
//        такое @param CoursesPage page - где page должен называться
//        как аргумент "page". Сам обработчик выводит список всех курсов
        app.get(NamedRoutes.coursesPath(), ctx -> {
            //var courses = COURSES;
            var header = "Курсы по программированию";
            var term = ctx.queryParam("term");
            var listCourses = CourseRepository.getEntities();
            List <Course> courses;

            if (term != null) {
                courses = CourseRepository.search(term);
            } else {
                courses = listCourses;
            }

            var page = new CoursesPage(courses, term);

            page.setFlash(ctx.consumeSessionAttribute("flash")); // ОТРАБОТКА ФЛЕШ СООБЩЕНИЙ
            ctx.render("courses/index.jte", model("page", page));
        });

//        В данном обработчике реализовано отображение одного курса по его id
//        Здесь используется шаблон courses/show.jte
//        В отличие от предыдущего обработчика в этом используется метод Collections.singletonMap()
//        в нем мы передали объект page и указали что в шаблоне имя для объекта будет "course"
//        upd. Изменил имя объекта для шаблона с "course" на "page" для удобства
        app.get(NamedRoutes.coursePath("id"), ctx -> {
            var id = ctx.pathParam("id");
            var listCourses = CourseRepository.getEntities();

            var u = listCourses.stream()
                    .filter(course -> course.getId() == Integer.parseInt(id))
                    .findFirst();

            if (u.isEmpty()) {
                throw new NotFoundResponse("Course not found");
            }

            CoursePage page = new CoursePage(u.get());

            ctx.render("courses/show.jte", Collections.singletonMap("page", page));

        });

//        этот обработчик обрабатывает POST запросы на путь /all-courses
//        в данном случае обработчик служит для создания нового курса
//        он получает наименование и описание курса с помощью параметров name и description
//        создает новый объект класс Course и затем сохраняет его в общем списке курсов CourseRepository.save(course)
        app.post(NamedRoutes.coursesPath(), ctx -> {
            var description = ctx.formParam("description");

//            Так реализована проверка введенных данных пользователем при создании нового курса
//            Если длина названия курса меньше двух символов, то курс не запишется и нам выдаст ошибку
//            "Длина названия курса должна быть больше 2 символов"
            try {
                var name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2,
                                "Длина названия курса должна быть больше 2 символов")
                        .get();
//                var description = ctx.formParamAsClass("description", String.class)
//                        .check(value -> value.length() > 10,
//                                "Длина описания курса должна быть больше 10 символов")
//                        .get();
                var course = new Course(name, description);
                CourseRepository.save(course);
                // Добавляем сообщение в сессию
                // Ключ может иметь любое название, здесь мы выбрали flash
                ctx.sessionAttribute("flash", "Создан новый курс!"); // ФЛЕШЬ СООБЩЕНИЕ ПОСЛЕ СОЗДАНИЯ НОВОГО КУРСА
                ctx.redirect(NamedRoutes.coursesPath());
            } catch (ValidationException e) {
                var page = new BuildCoursePage(e.getErrors());
                ctx.render("courses/build.jte", model("page", page));
            }

        });

//        обработчик действует так же как обработчик app.get("/all-courses/build") для курсов
        app.get(NamedRoutes.buildUserPath(), UsersController::build);

//        В данном обработчике реализовано отображение одного пользователя по его id
//        Здесь используется шаблон users/show.jte
        app.get(NamedRoutes.userPath("id"), UsersController::show);

        //        В данном обработчике также используется шаблон users/index.jte,
//        в него мы передаем аргумент в методе model(), в переменной page мы передаем сам объект,
//        эту переменную можно назвать как удобно. Аргумент "page" - это то как объект будет
//        называться в шаблоне index.jte, то есть в шаблоне добавление объекта page будет
//        такое @param UsersPage page - где page должен называться
//        как аргумент "page". Сам обработчик выводит список всех курсов
        app.get(NamedRoutes.usersPath(), UsersController::index);

//        обрабатывает POST запросы на путь /users, в данном случае используется для создания нового пользователя
//        действует так же как и обработчик для создания курсов
        app.post(NamedRoutes.usersPath(), UsersController::create);

        // Отображение формы логина
        app.get("/sessions/build", SessionsController::build);
// Процесс логина
        app.post("/sessions", SessionsController::create);
// Процесс выхода из аккаунта
        app.delete("/sessions", SessionsController::destroy);

        //Collections.singletonMap
        app.start(7070); // Стартуем веб-сервер
    }
}
