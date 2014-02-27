package in.retalemine.generics.set1;

import java.util.Date;
import java.util.List;
import javax.measure.quantity.Quantity;

public class Bill {

	private Integer billNo;
	private Date billDate;
	private List<BillItem<? extends Quantity>> billItems;

	public Bill(Integer billNo, Date billDate,
			List<BillItem<? extends Quantity>> billItems) {
		super();
		this.billNo = billNo;
		this.billDate = billDate;
		this.billItems = billItems;
	}

	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder("{");
		toString.append("BillNo:" + billNo);
		toString.append(",BillDate:" + billDate);
		toString.append(",BillItems : [");
		for (BillItem<? extends Quantity> bItem : billItems) {
			toString.append(bItem.toString());
			toString.append(",");
		}
		toString.append("]}");
		return toString.toString();
	}
}
