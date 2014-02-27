package in.retalemine.generics.set2;

import java.util.Date;
import java.util.List;

public class Bill {

	private Integer billNo;
	private Date billDate;
	private List<BillItem> billItems;

	public Bill(Integer billNo, Date billDate, List<BillItem> billItems) {
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
		for (BillItem bItem : billItems) {
			toString.append(bItem.toString());
			toString.append(",");
		}
		toString.append("]}");
		return toString.toString();
	}
}
