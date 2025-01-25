<%-- Шаблон создания нового курса --%>
@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

<%--@template.layout.page(
content = @`--%>
<meta charset="utf-8" />

    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="${NamedRoutes.coursesPath()}" method="post">
        <div>
            <label>
                Название
                <input type="text" name="name" />
            </label>
        </div>
        <div>
            <label>
                Описание
                <input type="text" name="description" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
<%--
`
)--%>
