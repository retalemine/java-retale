package in.retalemine.generics.set1;

import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.NonSI.LITRE;
import static javax.measure.unit.SI.GRAM;
import static javax.measure.unit.SI.KILOGRAM;
import static org.jscience.economics.money.Currency.USD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Quantity;
import javax.measure.quantity.Volume;

import org.jscience.physics.amount.Amount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Set1Example {

	private static final Logger logger = LoggerFactory
			.getLogger(Set1Example.class);

	public Set1Example() {
		printItem();
		logger.info("=====================================================");
		printBillItem();
		logger.info("=====================================================");
		printBill();
		logger.info("=====================================================");
	}

	private void printItem() {
		Item<Mass> item = new Item<Mass>("Sugar",
				Measure.valueOf(2.5, KILOGRAM), Amount.valueOf(100.75, USD));
		logger.info("Item value {}", item);

		Item<Volume> item2 = new Item<Volume>("Oil",
				Measure.valueOf(5.0, LITRE), Amount.valueOf(200.5, USD));
		logger.info("Item value {}", item2);
	}

	private void printBillItem() {
		Item<Mass> item1 = new Item<Mass>("Sugar", Measure.valueOf(2.5,
				KILOGRAM), Amount.valueOf(100.75, USD));
		logger.info("Item value {}", item1);

		Item<Volume> item2 = new Item<Volume>("Oil",
				Measure.valueOf(5.0, LITRE), Amount.valueOf(250.5, USD));
		logger.info("Item value {}", item2);

		BillItem<Mass> bI1 = new BillItem<Mass>(item1, Measure.valueOf(1000.0,
				GRAM));
		logger.info("Bill Item value {}", bI1);

		BillItem<Volume> bI2 = new BillItem<Volume>(item2, Measure.valueOf(
				1000.0, LITER.divide(1000)));
		logger.info("Bill Item value {}", bI2);

	}

	private void printBill() {

		Item<Mass> item1 = new Item<Mass>("Sugar", Measure.valueOf(2.5,
				KILOGRAM), Amount.valueOf(100.75, USD));
		logger.info("Item value {}", item1);

		Item<Volume> item2 = new Item<Volume>("Oil",
				Measure.valueOf(5.0, LITRE), Amount.valueOf(250.5, USD));
		logger.info("Item value {}", item2);

		BillItem<Mass> bI1 = new BillItem<Mass>(item1, Measure.valueOf(1000.0,
				GRAM));
		logger.info("Bill Item value {}", bI1);

		BillItem<Volume> bI2 = new BillItem<Volume>(item2, Measure.valueOf(
				1000.0, LITER.divide(1000)));
		logger.info("Bill Item value {}", bI2);

		List<BillItem<? extends Quantity>> billItems = new ArrayList<BillItem<? extends Quantity>>();
		billItems.add(bI1);
		billItems.add(bI2);
		Bill bill = new Bill(1, new Date(), billItems);
		logger.info("Bill {}", bill);
	}
}
