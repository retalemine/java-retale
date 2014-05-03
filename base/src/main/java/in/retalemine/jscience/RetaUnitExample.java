package in.retalemine.jscience;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.BaseUnit;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetaUnitExample {

	private static final Logger logger = LoggerFactory
			.getLogger(RetaUnitExample.class);

	public RetaUnitExample() {
		siUnits();
	}

	private void siUnits() {
		logger.info("valueof mtd {}", Unit.valueOf("kg"));
		logger.info("Static mem {}", SI.KILOGRAM);
		logger.info("valueof mtd {}", Unit.valueOf("g"));
		logger.info("Static mem  {}", SI.GRAM);
		try {
			logger.info("valueof mtd {}", Unit.valueOf("dz"));
		} catch (Exception e) {
			logger.error("unit dz is not recognized");
		}
		logger.info("Static mem {}", RetaSI.DOZEN);
		logger.info("valueof mtd {}", Unit.valueOf("dz"));
		logger.info("Dozen {}", Measure.valueOf(.5, RetaSI.DOZEN));
		logger.info("valueof mtd {}", Unit.valueOf("pcs"));
		logger.info("Dozen {}",
				Measure.valueOf(.5, RetaSI.DOZEN).to(RetaSI.PIECE));

		for (Unit<? extends Quantity> unit : RetaSI.getInstance().getUnits()) {
			logger.info("Reta unit {}", unit);
		}

		for (Unit<? extends Quantity> unit : SI.getInstance().getUnits()) {
			if (unit instanceof BaseUnit<?>) {
				logger.info("SI unit -Base- {}", unit);
			}
		}

		for (Unit<?> unit : NonSI.getInstance().getUnits()) {
			if (unit instanceof BaseUnit<?>) {
				logger.info("NonSI unit -Base-{}", unit);
			}
		}
	}

}
