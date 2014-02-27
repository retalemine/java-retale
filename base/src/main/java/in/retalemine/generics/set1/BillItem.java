package in.retalemine.generics.set1;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import org.jscience.economics.money.Money;
import org.jscience.physics.amount.Amount;

public class BillItem<Q extends Quantity> extends Item<Q> {

	private Measure<Double, Q> quantity;
	private Amount<Money> amount;

	public BillItem(String productName, Measure<Double, Q> productUnit,
			Amount<Money> unitPrice, Measure<Double, Q> quantity) {
		super(productName, productUnit, unitPrice);
		this.quantity = quantity;
		this.amount = unitPrice.times(quantity.to(productUnit.getUnit())
				.getValue() / productUnit.getValue());
	}

	public BillItem(Item<Q> item, Measure<Double, Q> quantity) {
		super(item.getProductName(), item.productUnit, item.unitPrice);
		this.quantity = quantity;
		this.amount = unitPrice.times(quantity.to(productUnit.getUnit())
				.getValue() / productUnit.getValue());
	}

	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder("{");
		toString.append(super.toString());
		toString.append(",qty:{value:" + quantity.getValue() + ",unit:"
				+ quantity.getUnit() + "}");
		toString.append(",amount:{value:"
				+ RoundedMoney.getRoundedMoney(amount) + ",unit:"
				+ amount.getUnit() + "}");
		toString.append("}");
		return toString.toString();
	}

}
