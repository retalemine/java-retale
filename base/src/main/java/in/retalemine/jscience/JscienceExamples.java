package in.retalemine.jscience;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;
import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Volume;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JscienceExamples {

	static final Logger logger = LoggerFactory
			.getLogger(JscienceExamples.class);

	public JscienceExamples() {
		measureExa();
		unitExa();
		compundExa();
	}

	private void measureExa() {
		Measure<Double, Volume> v = Measure.valueOf(7.2, LITER);
		logger.info("Measure volume value {}", v.getValue());
		logger.info("Measure volume unit {}", v.getUnit());

		Measure<Double, Volume> v2 = Measure.valueOf(2.0, LITRE);
		logger.info("Measure volume compareTo {}", v.compareTo(v2));

		Measure<Integer, Duration> d = Measure.valueOf(24, HOUR);

		Measure<Double, Mass> m = Measure.valueOf(5.0, KILOGRAM);
		logger.info("Measure Mass compareTo {}",
				m.compareTo(Measure.valueOf(5000, GRAM)));
		logger.info("Measure Mass gram value {}", m.doubleValue(GRAM));
		logger.info("Measure Mass milligram value {}",
				m.doubleValue(MILLI(GRAM)));
	}

	private void unitExa() {
		Unit<Length> inch = CENTI(METER).times(2.5);
		logger.info("Unit Length Dimension {}", inch.getDimension());
		logger.info("Unit Length standard unit {}", inch.getStandardUnit());

		Unit<Power> WATT = JOULE.divide(SECOND).asType(Power.class);
		logger.info("Unit Power Dimension {}", WATT.getDimension());

		Unit<?> kelvinPerSec = KELVIN.divide(SECOND);
		logger.info("Unit ? Dimension {}", kelvinPerSec.getDimension());

		logger.info("Unit validation {}",
				Unit.valueOf("ft").equals(SI.METER.times(3048).divide(10000)));
		logger.info("Unit validation {}",
				Unit.valueOf("ft").equals(SI.METER.times(0.3048)));

	}

	private void compundExa() {
		Unit<Duration> HOUR_MINUTE_SECOND = HOUR.compound(MINUTE).compound(
				SECOND);
		Measure<Integer, Duration> d = Measure.valueOf(12345, SECOND);
		logger.info("Compound Duration value {}", d.to(HOUR_MINUTE_SECOND));
	}
}
