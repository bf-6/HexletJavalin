<%-- Шаблон вывода списка всех курсов --%>
@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<%-- Это форма поиска. Она отправляет get запрос по адресу /all-courses.
с параметром "term", этот параметр также сохраняется как поле объекта CoursesPage,
что позволяет сохранить текст запроса, после поиска--%>
<form action="${NamedRoutes.coursesPath()}" method="get">
    <input type="search" required name="term" value="${page.getTerm()}">
    <input type="submit" value="Search">
</form>

<div><a href="${NamedRoutes.buildCoursePath()}">Новый курс</a></div>

<%-- @template позволяет обращаться к другим шаблонам--%>
@template.layout.page(
page = page,
content = @`
    <p>
        COURSES:
    </p>
    @for(var course : page.getCourses())
        <div>
            <a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a> ${course.getDescription()}
        </div>
    @endfor
`
)
