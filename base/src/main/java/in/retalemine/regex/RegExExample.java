package in.retalemine.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegExExample {

	private static final Logger logger = LoggerFactory
			.getLogger(RegExExample.class);

	public RegExExample() {
		// splitCall();
		// camelCaseStrings();
		resolveAmount();
	}

	private void resolveAmount() {
		printAmountValue("500 INR");
	}

	private void printAmountValue(String input) {
		logger.info("Amount {}",input.replaceAll("[^0-9]", ""));
		logger.info("Amount Unit {}",input.replaceAll("[0-9]", ""));
	}

	private void camelCaseStrings() {
		getCamelCaseString("Sugar - 1kg");
		getCamelCaseString("suGar    -   1kG");
		getCamelCaseString("sugar-1kg");
		getCamelCaseString("Sugar1KG");
		getCamelCaseString("Sugar 1KG");
		getCamelCaseString("s   -   1KG");
		getCamelCaseString("sugar500g");
		getCamelCaseString("sugar  500  g");
		getCamelCaseString("axe360  500  g");
		getCamelCaseString("bar1soap  500  g");
		getCamelCaseString("bar1soap500g");
		getCamelCaseString("bar1soap");
		getCamelCaseString("bar1");
		getCamelCaseString("sugar");
	}

	private void splitCall() {
		splitProductNameUnit("Sugar - 1kg");
		splitProductNameUnit("suGar    -   1kG");
		splitProductNameUnit("sugar-1kg");
		splitProductNameUnit("Sugar1KG");
		splitProductNameUnit("Sugar 1KG");
		splitProductNameUnit("s   -   1KG");
		splitProductNameUnit("sugar500g");
		splitProductNameUnit("sugar  500  g");
		splitProductNameUnit("axe360  500  g");
		splitProductNameUnit("bar1soap  500  g");
		splitProductNameUnit("bar1soap500g");
		splitProductNameUnit("bar1soap");
		splitProductNameUnit("bar1");
		splitProductNameUnit("sugar");
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

		StringBuffer productName = new StringBuffer();
		Matcher productNameUnitMatcher = Pattern.compile(
				"([0-9]+)[\\s]*([a-z]+)$", Pattern.CASE_INSENSITIVE).matcher(
				camelCasePName.toString().trim());
		if (productNameUnitMatcher.find()) {
			logger.info("{}", productNameUnitMatcher.group());
			productNameUnitMatcher.appendReplacement(productName, "");
		} else {
			productName.append(camelCasePName);
		}
		logger.info("{}", productName);
	}

	protected String[] resolveProductUnit(String camelCasePName) {
		String[] result = null;
		StringBuffer productName;
		Matcher productNameUnitMatcher = Pattern.compile(
				"([0-9]+)[\\s]*([a-z]+)$", Pattern.CASE_INSENSITIVE).matcher(
				camelCasePName.trim().replaceAll("\\s*-\\s*", " - "));
		if (productNameUnitMatcher.find()) {
			result = new String[3];
			productName = new StringBuffer();
			result[0] = productNameUnitMatcher.group(1);
			result[1] = productNameUnitMatcher.group(2);
			productNameUnitMatcher.appendReplacement(productName, "");
			result[2] = productName.toString();
			result[2] = result[2].endsWith(" - ") ? result[2].substring(0,
					result[2].length() - 3) : result[2].trim();
		}
		return result;
	}

	protected void getCamelCaseString(String input) {
		StringBuffer camelCaseOutput = new StringBuffer();
		Matcher camelCaseMatcher = Pattern.compile("([a-z])([a-z]*)",
				Pattern.CASE_INSENSITIVE).matcher(
				input.trim().replaceAll("\\s+", " "));
		while (camelCaseMatcher.find()) {
			camelCaseMatcher.appendReplacement(camelCaseOutput,
					camelCaseMatcher.group(1).toUpperCase()
							+ camelCaseMatcher.group(2).toLowerCase());
		}
		camelCaseMatcher.appendTail(camelCaseOutput);
		logger.info("CamelCaseString {}", camelCaseOutput);
		String[] result = resolveProductUnit(camelCaseOutput.toString());
		if (null != result) {
			logger.info("${}$", result[0]);
			logger.info("${}$", result[1]);
			logger.info("${}$", result[2]);
		} else {
			logger.info("Null returned");
		}
		logger.info("End");
	}
}
