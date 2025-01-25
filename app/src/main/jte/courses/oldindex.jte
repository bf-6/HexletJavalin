@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<%-- С помощью @import мы импортировали в шаблон класс CoursesPage--%>
<%-- @param указывает, на переданные данные в методе model().
Доступ к данным внутри шаблона идет через это имя. Имя должно совпадать с аргументом в кавычках, например,
 "page" --%>
<%-- Для подстановки данных внутрь HTML используется конструкция ${}.
Например, <h1>${page.getHeader()}</h1> --%>

<%-- в шаблонах часто используются условные конструкции и циклы

//Условная конструкция
@if(условие)
    <p>Какой-то текст</p>
@else
    <p>Какой-то другой текст</p>
@endif

// Цикл
@for(здесь счетчик)
    какой-то html
@endfor

--%>

<html>
<head>
    <title>Хекслет</title>
</head>
<body>
<h1>${page.getHeader()}</h1>
@if(page.getCourses().isEmpty())
    <p>Пока не добавлено ни одного курса</p>
@else
    @for(var course : page.getCourses())
        <div>
            <h2><a href="/all-courses/${course.getId()}">${course.getName()}</a></h2>
            <p>${course.getDescription()}</p>
        </div>
    @endfor
@endif
</body>
</html>