<%--  Макет сайта --%>
@import org.example.hexlet.dto.BasePage /*Импортируем базовый класс*/
@import gg.jte.Content
@param Content content
@param BasePage page = null /*Если не передали, то игнорируем*/

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Welcome page</title>
    <title>/users</title>
    <title>/</title>
</head>
<h1 class="text-body-emphasis">Привет, Хекслет!</h1>
<ul>
    <li><a href="/">Главная</a></li>
</ul>
<body>
@if(page != null && page.getFlash() != null)
    <p>${page.getFlash()}</p>
@endif
${content}
<footer style="color: red; font-size: 14px;">
    <br>
    <hr>
    <a href="https://github.com/bf-6">Мой Гитхаб</a>
</footer>
</body>
</html>