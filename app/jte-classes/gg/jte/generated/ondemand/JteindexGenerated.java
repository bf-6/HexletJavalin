package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,7,7,14,14,16,16,20,20,21,21,21,22,22,23,23,23,24,44,44,44,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <body>\n    <div class=\"col-lg-8 mx-auto p-4 py-md-5\">\n        <main>\n            <p>Javalin + jte</p>\n            <a href=\"/users\">Пользователи</a>\n            <a href=\"/all-courses\">Курсы</a>\n            ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\n                Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки\n            ");
				}
				jteOutput.writeContent("\n        </main>\n    </div>\n    </body>\n    ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n        Welcome, ");
					jteOutput.setContext("html", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(". Чтобы разлогиниться, удалите куку JSESSIONID из браузера\n    ");
				}
				jteOutput.writeContent("\n    ");
			}
		}, null /*Если не передали, то игнорируем*/);
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
