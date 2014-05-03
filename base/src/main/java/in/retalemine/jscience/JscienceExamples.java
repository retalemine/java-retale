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
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;
import javax.measure.quantity.Volume;
import javax.measure.unit.NonSI;
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
		ComputeAmoutViaUnitExa();
	}

	private void ComputeAmoutViaUnitExa() {
		logger.info("unit Quantity ->{}",
				Measure.valueOf(1.0, Unit.valueOf("kg")));
		logger.info("unit Price ->{}", Amount.valueOf(150.0, USD));
		logger.info("Quantity ->{}",
				Measure.valueOf(500.0, MILLI(Unit.valueOf("kg"))));
		logger.info("Amount ->{}", Amount.valueOf(75.0, USD));
		Measure<Double, ? extends Quantity> unitQuantity = Measure.valueOf(1.0,
				Unit.valueOf("kg"));
		Amount<Money> unitPrice = Amount.valueOf(150.0, USD);
		// Measure<Double, ? extends Quantity> quantity = Measure.valueOf(500.0,
		// MILLI(Unit.valueOf("kg")));
		Measure<Double, ? extends Quantity> quantity = Measure.valueOf(500.0,
				Unit.valueOf("g"));
		logger.info("unit Quantity ->{}", unitQuantity);
		logger.info("unit Price ->{}", unitPrice);
		logger.info("Quantity ->{}", quantity);
		logger.info("Unit Q dim {}", unitQuantity.getUnit().getDimension());
		logger.info("Unit Q std {}", unitQuantity.getUnit().getStandardUnit());
		logger.info("Unit Q inr {}", unitQuantity.getUnit().inverse());
		logger.info("Unit Q isstd {}", unitQuantity.getUnit().isStandardUnit());
		logger.info("Unit Q tostd {}", unitQuantity.getUnit().toStandardUnit());
		logger.info("Unit Q tostr {}", unitQuantity.getUnit().toString());

		logger.info("Qty Q dim {}", quantity.getUnit().getDimension());
		logger.info("Qty Q std {}", quantity.getUnit().getStandardUnit());
		logger.info("Qty Q inr {}", quantity.getUnit().inverse());
		logger.info("Qty Q isstd {}", quantity.getUnit().isStandardUnit());
		logger.info("Qty Q tostd {}", quantity.getUnit().toStandardUnit());
		logger.info("Qty Q tostr {}", quantity.getUnit().toString());

		// Unit<? extends Quantity> unit = Unit.valueOf("kg");
		// Measure<Double, ?> convertedQuantity = converterTemplate(
		// Measure.valueOf(1.0, unit),
		// Measure.valueOf(500.0, MILLI(Unit.valueOf("kg"))));
		// logger.info("Converted Quantity ->{}", convertedQuantity);

		// Amount<Money> amount =
		// unitPrice.times(quantity.to(unitQuantity.getUnit()).getValue() /
		// unitQuantity.getValue());

		// Amount<Money> amount = compute(unitPrice, unitQuantity, quantity);

		UnitConverter quantityToUnit = quantity.getUnit().getConverterTo(
				unitQuantity.getUnit());
		Double quantityVal = quantityToUnit.convert(quantity.getValue());
		logger.info("actual {}", quantity.getValue());
		logger.info("converted {}", quantityVal);
	}

	private <T extends Quantity> Amount<Money> compute(Amount<Money> unitPrice,
			Measure<Double, T> unitQuantity, Measure<Double, T> quantity) {
		return unitPrice.times(quantity.to(unitQuantity.getUnit()).getValue()
				/ unitQuantity.getValue());
	}

	private <T extends Quantity> Measure<Double, T> converterTemplate(
			Measure<Double, T> unitQuantity, Measure<Double, T> quantity) {
		return quantity.to(unitQuantity.getUnit());
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

		Measure<Double, Dimensionless> p0 = Measure
				.valueOf(50.0, NonSI.PERCENT);
		logger.info("Measure Dimensionless percent value {}",
				p0.doubleValue(NonSI.PERCENT));
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

		Measure<Double, Mass> productUnit = Measure.valueOf(1.0, KILOGRAM);
		logger.info("Unit validation - unit {}", productUnit.getUnit());

		SI si = SI.getInstance();
		if (si.getUnits().contains("kg")) {
			logger.info("contains kg");
		}

		Unit<?> kgunit = Unit.valueOf("kg");
		logger.info("unit value {}", kgunit.getClass());

		logger.info("unit of k {}", Unit.valueOf("k"));

	}

	private void compundExa() {
		Unit<Duration> HOUR_MINUTE_SECOND = HOUR.compound(MINUTE).compound(
				SECOND);
		Measure<Integer, Duration> d = Measure.valueOf(12345, SECOND);
		logger.info("Compound Duration value {}", d.to(HOUR_MINUTE_SECOND));
	}

	private void AmountExa() {
		Amount<?> oilPrice = Amount.valueOf(120, USD.divide(LITER));// 120 INR/L
		logger.info("Amont ? exact value {}", oilPrice.getExactValue());
		logger.info("Amont ? value {}", oilPrice);

		Amount<Money> price = Amount.valueOf(10.5, USD);
		logger.info("Amont Money value {}", price);
		logger.info("Amont Money abs value {}", price.abs());
		logger.info("Amont Money estimated value {}", price.getEstimatedValue());
		logger.info("Amont Money estimated value {}",
				(Double) price.getEstimatedValue());
		logger.info("Amont Money doubleValue {}",
				price.doubleValue(price.getUnit()));
		// logger.info("Amont Money exact value {}", price.getExactValue());

		Unit<Money> DOLLAR_CENT = USD.compound(CENTI(USD));
		Currency.setReferenceCurrency(USD);
		logger.info("Amont Money to compund Dollar_Cent {}",
				price.to(DOLLAR_CENT));

		Measure<Double, Dimensionless> percent = Measure.valueOf(25.0,
				NonSI.PERCENT);
		logger.info("Measure Dimensionless percent value {}",
				percent.doubleValue(NonSI.PERCENT));
		double percentprice = price.getEstimatedValue() * percent.getValue()
				/ 100;
		logger.info("Amount Dimensionless percent value {}", percentprice);

	}

}
