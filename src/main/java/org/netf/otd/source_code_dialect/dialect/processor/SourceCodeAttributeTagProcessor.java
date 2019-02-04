package org.netf.otd.source_code_dialect.dialect.processor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.exceptions.TemplateInputException;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

public class SourceCodeAttributeTagProcessor extends AbstractStandardExpressionAttributeTagProcessor {

	private static final String ATTR_NAME = "path";
	private static final int PRECEDENCE = 1200;

	public SourceCodeAttributeTagProcessor(final String dialectPrefix) {
		super(TemplateMode.HTML,
				dialectPrefix,
				ATTR_NAME,
				PRECEDENCE,
				false,
				false);
	}

	@Override
	protected void doProcess(ITemplateContext context,
			IProcessableElementTag tag,
			AttributeName attributeName,
			String attributeValue,
			Object expressionResult,
			IElementTagStructureHandler structureHandler) {

		String encoding = getDefaultEncoding(tag);
		File file = new File(expressionResult.toString());

		try {
			String content = FileUtils.readFileToString(file, encoding);
			structureHandler.removeAttribute(attributeName);
			structureHandler.setBody(StringEscapeUtils.escapeHtml4(content), false);
		} catch (IOException e) {
			throw new TemplateInputException(e.getMessage());
		}

	}

	private String getDefaultEncoding(IProcessableElementTag tag) {

		String defaultEncoding = "utf-8";

		IAttribute[] attributes = tag.getAllAttributes();

		for (IAttribute attribute : attributes) {
			if (StringUtils.equals(attribute.getAttributeCompleteName(), "source-code:encode")) {
				defaultEncoding = attribute.getValue();
			}
		}

		return defaultEncoding;
	}

}
