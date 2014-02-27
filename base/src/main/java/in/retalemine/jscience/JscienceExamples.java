package in.retalemine.jscience;

import static javax.measure.unit.NonSI.HOUR;
import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.NonSI.LITRE;
import static javax.measure.unit.NonSI.MINUTE;
import static javax.measure.unit.SI.CENTI;
import static javax.measure.unit.SI.GRAM;
import static javax.measure.unit.SI.JOULE;
import static javax.measure.unit.SI.KELVIN;
import static javax.measure.unit.SI.KILOGRAM;
import static javax.measure.unit.SI.METER;
import static javax.measure.unit.SI.MILLI;
import static javax.measure.unit.SI.SECOND;
import static org.jscience.economics.money.Currency.USD;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Volume;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.jscience.economics.money.Currency;
import org.jscience.economics.money.Money;
import org.jscience.physics.amount.Amount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JscienceExamples {

	private static final Logger logger = LoggerFactory
			.getLogger(JscienceExamples.class);

	public JscienceExamples() {
		measureExa();
		unitExa();
		compundExa();
		AmountExa();
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

	private void AmountExa() {
		Amount<?> oilPrice = Amount.valueOf(120, USD.divide(LITER)); // 120
																		// INR/L
		logger.info("Amont ? exact value {}", oilPrice.getExactValue());
		logger.info("Amont ? value {}", oilPrice);
		Amount<Money> price = Amount.valueOf(1.20, USD);
		logger.info("Amont Money value {}", price);
		logger.info("Amont Money abs value {}", price.abs());
		logger.info("Amont Money estimated value {}", price.getEstimatedValue());
		logger.info("Amont Money estimated value {}", (Double)price.getEstimatedValue());
		logger.info("Amont Money doubleValue {}",
				price.doubleValue(price.getUnit()));
		// logger.info("Amont Money exact value {}", price.getExactValue());
		Unit<Money> DOLLAR_CENT = USD.compound(CENTI(USD));
		Currency.setReferenceCurrency(USD);
		logger.info("Amont Money to compund Dollar_Cent {}",
				price.to(DOLLAR_CENT));

	}

}
