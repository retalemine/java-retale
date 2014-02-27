package in.retalemine.generics.set2;

import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.NonSI.LITRE;
import static javax.measure.unit.SI.GRAM;
import static javax.measure.unit.SI.KILOGRAM;
import static org.jscience.economics.money.Currency.USD;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.measure.Measure;
import org.jscience.physics.amount.Amount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Set2Example {

	private static final Logger logger = LoggerFactory
			.getLogger(Set2Example.class);

	public Set2Example() {
		printItem();
		logger.info("=====================================================");
		printBillItem();
		logger.info("=====================================================");
		printBill();
		logger.info("=====================================================");
	}

	private void printItem() {
		Item item = new Item("Sugar", Measure.valueOf(2.5, KILOGRAM),
				Amount.valueOf(100.75, USD));
		logger.info("Item value {}", item);

		Item item2 = new Item("Oil", Measure.valueOf(5.0, LITRE),
				Amount.valueOf(200.5, USD));
		logger.info("Item value {}", item2);
	}

	private void printBillItem() {
		Item item1 = new Item("Sugar", Measure.valueOf(2.5, KILOGRAM),
				Amount.valueOf(100.75, USD));
		logger.info("Item value {}", item1);

		Item item2 = new Item("Oil", Measure.valueOf(5.0, LITRE),
				Amount.valueOf(250.5, USD));
		logger.info("Item value {}", item2);

		BillItem bI1 = new BillItem(item1, Measure.valueOf(1000.0, GRAM));
		logger.info("Bill Item value {}", bI1);

		BillItem bI2 = new BillItem(item2, Measure.valueOf(1000.0,
				LITER.divide(1000)));
		logger.info("Bill Item value {}", bI2);

	}

	private void printBill() {

		Item item1 = new Item("Sugar", Measure.valueOf(2.5, KILOGRAM),
				Amount.valueOf(100.75, USD));
		logger.info("Item value {}", item1);

		Item item2 = new Item("Oil", Measure.valueOf(5.0, LITRE),
				Amount.valueOf(250.5, USD));
		logger.info("Item value {}", item2);

		BillItem bI1 = new BillItem(item1, Measure.valueOf(1000.0, GRAM));
		logger.info("Bill Item value {}", bI1);

		BillItem bI2 = new BillItem(item2, Measure.valueOf(1000.0,
				LITER.divide(1000)));
		logger.info("Bill Item value {}", bI2);

		List<BillItem> billItems = new ArrayList<BillItem>();
		billItems.add(bI1);
		billItems.add(bI2);
		Bill bill = new Bill(1, new Date(), billItems);
		logger.info("Bill {}", bill);
	}
}
