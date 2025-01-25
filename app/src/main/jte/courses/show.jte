@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<!-- Для наглядности мы не стали включать сюда основную структуру HTML -->
@template.layout.page(
content = @`
    <div>${page.getCourse().getName()} ---> ${page.getCourse().getDescription()}</div>
`
)
