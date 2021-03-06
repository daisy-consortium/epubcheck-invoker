package org.daisy.validation.epubcheck;

import java.util.regex.Pattern;

final class Patterns {

	static final Pattern ANY = Pattern.compile(".*");
	static final Pattern CAUSED_BY = Pattern.compile("^Caused by:");
	static final Pattern CLASS_NOT_FOUND = Pattern
			.compile(".*java.lang.NoClassDefFoundError: (.*)");
	static final Pattern EXCEPTION = Pattern
			.compile(".*java.lang.[^\\s]*Exception: (.*)");
	static final Pattern FILE_NOT_FOUND = Pattern
			.compile(".*File not found: '(.*)'.*");
	static final Pattern INDENTED = Pattern.compile("^\\s+.*");
	static final Pattern IRRELEVANT = Pattern
			.compile("^\\s*$"
					+ "|Check finished with errors"
					+ "|Check finished with warnings"
					+ "|EPUBCheck v\\S+"
					+ "|No errors or warnings detected."
					+ "|EPUBCheck completed"
					+ "|Messages: (\\d+) fatal / (\\d+) errors / (\\d+) warnings / (\\d+) info",
					Pattern.CASE_INSENSITIVE);
	static final Pattern ISSUE = Pattern
			.compile("^(FATAL|ERROR|WARNING|INFO|USAGE)\\(\\S+\\): (.*?)(?:\\((-?\\d+)(,(-?\\d+))?\\))?: (.*)");
	static final Pattern EPUB_VERSION = Pattern
			.compile("Validating using EPUB version (\\S+) rules.");
	static final Pattern EPUBCHECK_VERSION = Pattern.compile("EPUBCheck v(.*)", Pattern.CASE_INSENSITIVE);

}