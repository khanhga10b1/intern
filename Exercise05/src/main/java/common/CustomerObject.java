package common;

public enum CustomerObject {
	CHILDEN(1,"Trẻ em"), ADULT(2,"Người lớn"), ELDER(3,"Người già");

	private String name;
	private int code;
	private CustomerObject(int code,String name) {
		this.code=code;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public int getCode() {
		return code;
	}
	public static CustomerObject getCustomer(int code) {
		for(CustomerObject o:CustomerObject.values()) {
			if(o.getCode()==code) {
				return o;
			}
		}
		return null;
	}
}
