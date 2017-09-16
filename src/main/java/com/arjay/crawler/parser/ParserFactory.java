package com.arjay.crawler.parser;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.arjay.crawler.exception.ParamsException;
import com.arjay.crawler.parser.impl.InstitutionalInvestorParser;
import com.arjay.crawler.parser.impl.LargeAmountInvestorParser;

public class ParserFactory {

	private static OptionParser<?>[] parsers = new OptionParser[] { new InstitutionalInvestorParser(),
			new LargeAmountInvestorParser() };

	@SuppressWarnings("unchecked")
	public static <T> OptionParser<T> getParser(Class<T> parseTo) {
		for (OptionParser<?> parser : parsers) {
			final Type type = parser.getClass().getGenericInterfaces()[0];
			final ParameterizedType pType = (ParameterizedType) type;
			final Type[] params = pType.getActualTypeArguments();
			if (parseTo.equals(params[0])) {
				return (OptionParser<T>) parser;
			}
		}
		throw new ParamsException("並無該物件解析器，請確認所選物件");
	}
}
