package common;

public enum Number {
	KHONG("không"),
	MOT("một"),
	HAI("hai"),
	BA("ba"),
	BON("bốn"),
	NAM("năm"),
	SAU("sáu"),
	BAY("bảy"),
	TAM("tám"),
	CHIN("chín");
	
	private final String name;
			
	private  Number(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	

}
