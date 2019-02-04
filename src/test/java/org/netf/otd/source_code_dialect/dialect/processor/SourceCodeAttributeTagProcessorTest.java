package org.netf.otd.source_code_dialect.dialect.processor;

import java.io.File;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.netf.otd.source_code_dialect.dialect.SourceCodeDialect;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

public class SourceCodeAttributeTagProcessorTest {

	@Test
	public void testDialect() throws Exception {

		File inDir = new File(this.getClass().getResource("./").toURI());

		TemplateEngine templateEngine = new TemplateEngine();

		templateEngine.addDialect(new SourceCodeDialect());
		templateEngine.addTemplateResolver(textTemplateResolver(inDir));

		Context context = new Context(Locale.getDefault());
		context.setVariable("currentPath", inDir.getAbsolutePath());

		String actual = templateEngine.process("main-contains.html", context);
		String expected = FileUtils.readFileToString(new File(inDir, "expected.html"), "utf-8");

		Assert.assertEquals(expected, actual);
	}

	private ITemplateResolver textTemplateResolver(File inDir) {

		FileTemplateResolver templateResolver = new FileTemplateResolver();

		templateResolver.setOrder(Integer.valueOf(1));
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("utf-8");
		templateResolver.setCacheable(false);
		templateResolver.setPrefix(inDir.getAbsolutePath() + File.separatorChar);
		templateResolver.setSuffix(".html");

		return templateResolver;

	}

}
