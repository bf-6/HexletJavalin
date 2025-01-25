@import org.example.hexlet.dto.MainPage
@param MainPage page

<!-- Изменения HTML в шаблоне не требуют перезапуска сервера -->

@template.layout.page(
content = @`
    <body>
    <div class="col-lg-8 mx-auto p-4 py-md-5">
        <main>
            <p>Javalin + jte</p>
            <a href="/users">Пользователи</a>
            <a href="/all-courses">Курсы</a>
            @if(!page.isVisited())
                Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки
            @endif
        </main>
    </div>
    </body>
    @if(page.getCurrentUser() != null)
        Welcome, ${page.getCurrentUser()}. Чтобы разлогиниться, удалите куку JSESSIONID из браузера
    @endif
    `
)
<%--
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<div class="col-lg-8 mx-auto p-4 py-md-5">
    <main>
        <h1 class="text-body-emphasis">Привет, Хекслет!</h1>
        <p>Javalin + jte</p>
        <a href="/users">Пользователи</a>
        <p></p>
        <a href="/all-courses">Курсы</a>
    </main>
</div>
</body>
</html>--%>
