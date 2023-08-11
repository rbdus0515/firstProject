package firstProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import firstProject.vo.Car;

public class CarService {
	
	Scanner sc = new Scanner(System.in);
	
	private List<Car> carList = new ArrayList<Car>();
	private List<Car> favList = new ArrayList<Car>();
	
	
	public CarService() {
		
		carList.add( new Car ("싼타페", "대형 SUV", 2497, "현대", 5000) );
		carList.add( new Car ("시에라", "풀사이즈 픽업트럭", 6162, "GMC", 9500) );
		
	}

	 
	
	/**
	 * 메뉴 선택 화면 코드
	 */
	public void displayMenu() {
		
		try {
			
			int menuNum = 0;
			do {
				System.out.println( "===== 차량 정보 저장,검색 프로그램 =====" );
				System.out.println("1. 차량 등록");
				System.out.println("2. 차량 정보 전체 조회");
				System.out.println("3. 차량 정보 수정");
				System.out.println("4. 차량 정보 삭제");
				System.out.println("5. 관심 차량 등록");
				System.out.println("6. 관심 차량 삭제");
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n 메뉴 선택 : ");
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : System.out.println( carAdd() ); break;
				case 2 : allCarList(carList); break;
				case 3 : System.out.println( modifyCarList() ); break;
				case 4 : System.out.println( delCar() ); break;
				case 5 : System.out.println( FCA() ); break;
				case 6 : System.out.println( DFC() ); break;
				case 0 : System.out.println("프로그램 종료"); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}
				
				
			} while (menuNum != 0);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 1번 차량 등록용 메서드
	 */
	public String carAdd() {
		
		sc.nextLine();
		System.out.println("===== 차량 등록 =====");
		
		System.out.print("차량 이름 = ");
		String carname = sc.nextLine();
		
		System.out.print("차량 크기 = ");
		String size = sc.nextLine();
		
		System.out.print("차 배기량 = ");
		int cc = sc.nextInt();
		sc.nextLine();
		
		System.out.print("차량 브랜드 = ");
		String brand = sc.nextLine();
		
		System.out.print("차량 가격 = ");
		int price = sc.nextInt();
		
		Car newCar = new Car(carname, size, cc, brand, price);
		
		carList.add(newCar);
		
		return "등록완료!";
		
	}
	
	/**
	 * 2번 차량 전체 조회 메서드
	 */
	public void allCarList(List<Car> carList) {
		
		System.out.println("===== 등록된 차량 정보 전체 조회 =====");
		
		if(carList.isEmpty()) {
			System.out.println("등록된 차량 정보가 없습니다. 차량을 먼저 등록해주세요.");
		} else {
			for(Car temp : carList) {
				System.out.println(temp);
			}
		}
		
		
	}
	
	/**
	 * 3번 차량 정보 수정 메서드
	 */
	public String modifyCarList() {
		
		allCarList(carList);
		
		int modifyMenu = 0;
		
		sc.nextLine();
		System.out.println("===== 차량 정보 수정 =====");
		
		System.out.print("수정할 차량 이름 입력 : ");
		String searchCarname = sc.nextLine();
		
		boolean flag = true;
		
		for(Car temp : carList) {
			
			if(temp.getCarname().equals(searchCarname)) {
				flag = false;
				
				System.out.println("1. 차량명");
				System.out.println("2. 차량 종류");
				System.out.println("3. 배기량 (cc)");
				System.out.println("4. 차량 브랜드");
				System.out.println("5. 가격");
				System.out.println("0. 이전으로 돌아가기");
				System.out.println("어떤 정보를 수정하시겠습니까?");
				
				modifyMenu = sc.nextInt();
				sc.nextLine();
				
				switch(modifyMenu) {
				
				case 1 : System.out.println("=== 차량명 수정 ===");
				System.out.print("수정할 차량명을 입력하세요 : ");
				String carname = sc.nextLine();
				temp.setCarname(carname);
				break;
				
				case 2 : System.out.println("=== 차량 종류 수정 ===");
				System.out.print("수정할 차량 종류를 입력하세요 : ");
				String size = sc.nextLine();
				temp.setSize(size);
				break;
				
				case 3 : System.out.println("=== 배기량 (cc) 수정 ===");
				System.out.print("수정할 배기량 (cc)를 입력하세요 : ");
				int cc = sc.nextInt();
				temp.setCc(cc);
				break;
				
				case 4 : System.out.println("=== 차량 브랜드 수정 ===");
				System.out.print("수정할 차량 브랜드를 입력하세요 : ");
				String brand = sc.nextLine();
				temp.setBrand(brand);
				break;
				
				case 5 : System.out.println("=== 차량 가격 수정 ===");
				System.out.print("수정할 차량 가격를 입력하세요 : ");
				int price = sc.nextInt();
				temp.setPrice(price);
				break;
				
				case 0 : System.out.println("종료합니다."); break;
				
				default : System.out.println("잘못 입력하셨습니다."); break;
				}
			}
			
			if(flag) {
				return "일치하는 차량명이 없습니다.";
			}
		}
		return "수정 완료!";
	}
	
	/**
	 * 4번 차량 정보 삭제 메서드
	 */
	public String delCar() {
		
		System.out.println("===== 차량 정보 삭제 =====");
		
		allCarList(carList);
		
		sc.nextLine();
		System.out.print("제거할 차량명 입력 : ");
		String delCarname = sc.nextLine();
		
		for(Car temp : carList) {
			if(temp.getCarname().equals(delCarname)) {
				int index = carList.indexOf(temp);
				
				System.out.print("정말 삭제 하시겠습니까? ( Y / N ) : ");
				
				char ch = sc.next().toUpperCase().charAt(0);
				
				if(ch == 'Y') {
					carList.remove(temp); break;
				} else {
					return "삭제를 진행하지 않습니다.";
				}
			}
		}
		
		return "삭제 완료!";
		
	}
	
	/**
	 * 5번 관심 차량 등록 메서드
	 */
	public String FCA() {
		
		System.out.println("===== 관심 차량 등록 =====");
		
		sc.nextLine();
		System.out.print("관심 차량 목록에 등록할 차량명 입력 : ");
		String input = sc.nextLine();
		
		boolean flag = true;
		
		for(Car temp : carList) {
			if(temp.getCarname().equals(input)) {
				favList.add(temp);
				flag = false;
			}
		}
		if(flag) {
			return "일치하는 차량명이 없습니다.";
		} else {
			return "등록 성공";
		}
	}
	
	/**
	 * 6번 관심 차량 삭제 메서드
	 */
	public String DFC() {
		
		allCarList(favList);
		
		sc.nextLine();
		System.out.println("===== 관심 차량 삭제 =====");
		
		System.out.print("관심 차량에서 삭제할 차량명 입력 : ");
		String input = sc.nextLine();
		
		boolean flag = true;
		
		for( Car temp : carList ) {
			if(temp.getCarname().equals(input)) {
				int index = favList.indexOf(temp);
				System.out.println("정말 삭제 하시겠습니까? ( Y / N ) : ");
				
				char ch = sc.next().toUpperCase().charAt(0);
				
				if(ch == 'Y') {
					favList.remove(index);
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			return "등록된 차량이 없습니다.";
		} else {
			return "삭제 성공!";
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




