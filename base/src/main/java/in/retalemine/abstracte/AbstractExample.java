package in.retalemine.abstracte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractExample {

	static final Logger logger = LoggerFactory.getLogger(AbstractExample.class);

	public String value = "abstract class";

	protected AbstractExample() {
		printValue();
	}

	private void printValue() {
		logger.info("Abstract class member value {}", value);
	}

}
