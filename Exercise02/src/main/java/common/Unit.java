package common;

public enum Unit {
	TRAM("trăm"),
	NGAN("ngàn"),
	TRIEU("triệu"),
	TY("tỷ"),
	MOTS("mốt"),
	LAM("lăm"),
	MUOI("mười"),
	MUOIS("mươi"),
	LE("lẻ");
	
	
	private final String name;
	
	private Unit(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
