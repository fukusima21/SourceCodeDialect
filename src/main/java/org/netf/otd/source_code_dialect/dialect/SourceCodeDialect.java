package org.netf.otd.source_code_dialect.dialect;

import java.util.HashSet;
import java.util.Set;

import org.netf.otd.source_code_dialect.dialect.processor.SourceCodeAttributeTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

public class SourceCodeDialect extends AbstractProcessorDialect {

	public SourceCodeDialect() {
		super("source-code-dialect", "source-code", 1200);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
		processors.add(new SourceCodeAttributeTagProcessor(dialectPrefix));
		return processors;
	}

}
