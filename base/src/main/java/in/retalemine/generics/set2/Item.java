package in.retalemine.generics.set2;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import org.jscience.economics.money.Money;
import org.jscience.physics.amount.Amount;

public class Item {

	private String productName;
	protected Measure<Double, ? extends Quantity> productUnit;
	protected Amount<Money> unitPrice;
	protected String productDescription;

	public String getProductName() {
		return productName;
	}

	public Item(String productName,
			Measure<Double, ? extends Quantity> productUnit,
			Amount<Money> unitPrice) {
		super();
		this.productName = productName;
		this.productUnit = productUnit;
		this.unitPrice = unitPrice;
		this.productDescription = productName + " " + productUnit;
	}

	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder("{");
		toString.append("pName:" + productName);
		toString.append(",pUnit:{value:" + productUnit.getValue() + ",unit:"
				+ productUnit.getUnit() + "}");
		toString.append(",pDesc:" + productDescription);
		toString.append(",pPrice:{value:" + unitPrice.getEstimatedValue()
				+ ",unit:" + unitPrice.getUnit() + "}");
		toString.append("}");
		return toString.toString();
	}

}
