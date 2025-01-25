@import org.example.hexlet.util.NamedRoutes

<!-- sessions/build.jte -->
<!-- Нужно не забыть добавить маршрут в NamedRoutes -->
<form action="${NamedRoutes.sessionsPath()}" method="post">
    <input type="text" placeholder="Nickname" name="nickname" />
    <input type="submit" />
</form>