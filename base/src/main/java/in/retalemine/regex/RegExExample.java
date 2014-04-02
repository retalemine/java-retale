package in.retalemine.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegExExample {

	private static final Logger logger = LoggerFactory
			.getLogger(RegExExample.class);

	public RegExExample() {
		splitProductNameUnit("Sugar - 1kg");
		splitProductNameUnit("suGar    -   1kG");
		splitProductNameUnit("sugar-1kg");
		splitProductNameUnit("Sugar1KG");
		splitProductNameUnit("Sugar 1KG");
		splitProductNameUnit("s   -   1KG");

	}

	private void splitProductNameUnit(String input) {
		StringBuffer camelCasePName = new StringBuffer();
		Matcher camelCaseMatcher = Pattern.compile("([a-z])([a-z]*)",
				Pattern.CASE_INSENSITIVE).matcher(
				input.trim().replaceAll("\\s+", " ")
						.replaceAll("\\s*-\\s*", " - "));
		while (camelCaseMatcher.find()) {
			camelCaseMatcher.appendReplacement(camelCasePName, camelCaseMatcher
					.group(1).toUpperCase()
					+ camelCaseMatcher.group(2).toLowerCase());
			// logger.info("loop -{}",camelCasePName);
		}
		camelCaseMatcher.appendTail(camelCasePName);
		logger.info("initial value -{}", input);
		logger.info("final value -{}", camelCasePName.toString());

		Matcher unitSplit = Pattern.compile("(.*)(([0-9])(.*))").matcher(
				camelCasePName.toString());
		logger.info("groupCount -{}", unitSplit.groupCount());
		logger.info("matches -{}", unitSplit.matches());

		String pName = unitSplit.group(1);
		String pUnit = unitSplit.group(2);
		logger.info("pName-${}$", pName);
		logger.info("pUnit-${}$", pUnit);
		logger.info("val-${}$", unitSplit.group(3));
		logger.info("unit-${}$", unitSplit.group(4));

		pName = pName.endsWith(" - ") ? pName.substring(0, pName.length() - 3)
				: pName.trim();
		logger.info("pName-${}$", pName);
		logger.info("End");
	}

}
