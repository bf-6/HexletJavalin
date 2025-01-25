package gg.jte.generated.ondemand.courses;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {1,1,2,3,3,3,5,5,9,9,11,11,12,12,13,13,13,14,14,15,15,17,17,19,19,19,19,19,19,19,19,19,34,37,37,37,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n<meta charset=\"utf-8\" />\n\n    ");
		if (page.getErrors() != null) {
			jteOutput.writeContent("\n        <ul>\n            ");
			for (var validator : page.getErrors().values()) {
				jteOutput.writeContent("\n                ");
				for (var error : validator) {
					jteOutput.writeContent("\n                    <li>");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(error.getMessage());
					jteOutput.writeContent("</li>\n                ");
				}
				jteOutput.writeContent("\n            ");
			}
			jteOutput.writeContent("\n        </ul>\n    ");
		}
		jteOutput.writeContent("\n\n    <form");
		var __jte_html_attribute_0 = NamedRoutes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\n        <div>\n            <label>\n                Название\n                <input type=\"text\" name=\"name\" />\n            </label>\n        </div>\n        <div>\n            <label>\n                Описание\n                <input type=\"text\" name=\"description\" />\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Зарегистрировать\" />\n    </form>\n");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
