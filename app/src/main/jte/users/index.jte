<%-- Шаблон вывода всех пользователей --%>
@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage;
@param UsersPage page

<%-- Это форма поиска. Она отправляет get запрос по адресу /users.
с параметром "term", этот параметр также сохраняется как поле объекта UsersPage,
что позволяет сохранить текст запроса, после поиска--%>
<form action="${NamedRoutes.usersPath()}" method="get">
    <input type="search" required name="term" value="${page.getTerm()}">
    <input type="submit" value="Search">
</form>

<div><a href="${NamedRoutes.buildUserPath()}">Создать пользователя</a></div>

<%-- @template позволяет обращаться к другим шаблонам--%>
@template.layout.page(
content = @`
    <p>
        USERS:
    </p>
    @for(var user : page.getUsers())
        <div><a href="${NamedRoutes.userPath(user.getId())}">${user.getId()}</a> ${user.getFirstName()} ${user.getLastName()}   ${user.getEmail()}</div>
    @endfor
`
)