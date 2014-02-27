package in.retalemine.enume;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumTest {

	private static final Logger logger = LoggerFactory
			.getLogger(EnumTest.class);

	public EnumTest() {
		// logger.info("Enum valueOf {}",EnumExample.valueOf("cheque"));
		logger.info("Enum valueOf {}", EnumExample.valueOf("CHEQUE"));
		logger.info("Enum valueOf {}", Arrays.asList(EnumExample.values()));
		for (EnumExample en : EnumExample.values()) {
			logger.info("Enum value {}", en.getValue());
		}
		accessEnum(EnumExample.CASH);
	}

	private void accessEnum(EnumExample en) {
		logger.info("Enum value {}", en.getValue());
		logger.info("Enum name {}", en.name());
		logger.info("Enum ordinal {}", en.ordinal());
		logger.info("Enum toString {}", en.toString());
	}
}
