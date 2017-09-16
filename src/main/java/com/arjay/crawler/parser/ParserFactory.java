package com.arjay.crawler.parser;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.arjay.crawler.exception.ParamsException;

@Component
public class ParserFactory {

	private static Set<OptionParser<?>> parsers = new HashSet<>();

	public static boolean addOptionParsers(Collection<OptionParser<?>> optionParsers) {
		return parsers.addAll(optionParsers);
	}

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
