package in.retalemine.enume;

public enum EnumExample {
	CASH("cash"), CHEQUE("cheque");
	
	private String value;

	private EnumExample(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

//	public EnumExample setValue(String value) {
//		return value;
//	}
}
