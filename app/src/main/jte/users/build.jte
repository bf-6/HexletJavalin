<%-- Шаблон создания нового пользователя --%>
@import org.example.hexlet.util.NamedRoutes
@template.layout.page(
content = @`
    <form action="${NamedRoutes.usersPath()}" method="post">
        <div>
            <label>
                Имя
                <input type="text" name="first-name" />
            </label>
        </div>
        <div>
            <label>
                Фамилия
                <input type="text" name="last-name" />
            </label>
        </div>
        <div>
            <label>
                Email
                <input type="email" required name="email" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
)