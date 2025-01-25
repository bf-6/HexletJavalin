package gg.jte.generated.ondemand.layout;
import org.example.hexlet.dto.BasePage /*Импортируем базовый класс*/;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {1,1,2,3,3,3,20,20,20,21,21,21,22,22,23,23,23,30,30,30,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <title>Welcome page</title>\n    <title>/users</title>\n    <title>/</title>\n</head>\n<h1 class=\"text-body-emphasis\">Привет, Хекслет!</h1>\n<ul>\n    <li><a href=\"/\">Главная</a></li>\n</ul>\n<body>\n");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\n    <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("</p>\n");
		}
		jteOutput.writeContent("\n");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n<footer style=\"color: red; font-size: 14px;\">\n    <br>\n    <hr>\n    <a href=\"https://github.com/bf-6\">Мой Гитхаб</a>\n</footer>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.getOrDefault("page", null /*Если не передали, то игнорируем*/);
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
