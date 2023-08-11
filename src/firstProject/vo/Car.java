package firstProject.vo;

public class Car {
	
	private String carname;// 이름
	private String size;// 크기
	private int cc;// 배기량
	private String brand;// 차량 브랜드
	private int price;// 차량 가격
	
	public Car() {}
	
	public Car(String carname, String size, int cc, String brand, int price) {
		super();
		this.carname = carname;
		this.size = size;
		this.cc = cc;
		this.brand = brand;
		this.price = price;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [ 차량명 = " + carname + 
				" , 차량 종류 = " + size + 
				" , 배기량 (cc) = " + cc + 
				"cc , 차량 브랜드 = " + brand + 
				" , 차량 가격 = " + price
				+ "만원 ]";
	}

	
	
	
	
	
	
	
	
	
}
