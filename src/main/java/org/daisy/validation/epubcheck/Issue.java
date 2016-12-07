package org.daisy.validation.epubcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public final class Issue {

	private static final Logger LOG = LoggerFactory.getLogger(Issue.class);

	public static enum Type {
		FATAL, WARNING, ERROR, USAGE, INFO, EPUB_VERSION, INTERNAL_ERROR, EPUBCHECK_VERSION;

		public static Type safeValueOf(String name) {
			Preconditions.checkNotNull(name);
			try {
				return valueOf(name);
			} catch (IllegalArgumentException e) {
				LOG.warn("Illegal argument in Type#sageValueOf: {}", name);
				return INTERNAL_ERROR;
			}
		}

		@Override
		public String toString() {
			return name().replace('_', ' ');
		}

	}

	public final Type type;
	public final String file;
	public final int lineNo;
	public final int colNo;
	public final String txt;

	public Issue(Type type, String file, int lineNo, int colNo, String txt) {
		Preconditions.checkNotNull(type);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(txt),
				"Issue message must not be empty.");
		this.type = type;
		this.file = file;
		this.lineNo = lineNo;
		this.colNo = colNo;
		this.txt = txt;
	}

	public Issue(Type type, String file, String txt) {
		this(type, file, -1, -1, txt);
	}

	public Issue(Type type, String txt) {
		this(type, null, -1, -1, txt);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[').append(type).append(']');
		sb.append(txt);
		if (!Strings.isNullOrEmpty(file)) {
			sb.append(" - ").append(file);
			if (lineNo > -1) {
				sb.append(" (").append(lineNo);
				if (colNo > -1) {
					sb.append(':').append(colNo);
				}
				sb.append(')');
			}
		}
		return sb.toString();
	}
}