import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import sys_base.DataSetting;
import sys_base.LibBookVo;
import sys_base.LibMemVo;
import sys_base.Login;

public class LibMain {
	Scanner scan = new Scanner(System.in);

	public LibMain() {
		start();
	}
	
	public void start() {
		//데이터 호출
		DataSetting.bookSet();
		DataSetting.memberSet();
		
		Login.id=Input("ID");
		Login.pwd=Input("Password");
		
		Login.confirm = Login.loginConfirm();
		
		if(Login.confirm == 1) { // user
			System.out.println("Log in successed...");
			System.out.println("* * * * * * * * 서울시 도서관 접속 * * * * * * * *");
			do {
				String userMenu = Input("MENU [1. 도서목록 2.도서검색 3.도서대출예약 4.Log-out 5.종료]");
				if(userMenu.equals("1")) {
					bookPrint();
				}else if(userMenu.equals("2")) {
					browseBook();
				}else if(userMenu.equals("3")) {
					reserveBook();
				}else if(userMenu.equals("4")){
					start();
				}else if(userMenu.equals("5")){
					System.out.println("* * * * * * * * 서울시 도서관 접속 종료 * * * * * * * *");
					System.exit(0);
				}else {
					System.out.println("ddd");
				}
			}while(true);
			
		}else if(Login.confirm == 2) { // master
			System.out.println("Master successfully log in ... ");
			System.out.println("* * * * * * * * 관리자 페이지 접속 * * * * * * * *");
			
			do {
				String mstMenu = Input("MENU [1. 회원관리 2. 도서관리 3. Log-out]");
				if(mstMenu.equals("1")) {
					do {
						String memMenu = Input("MENU [1.회원목록 2.회원등록 3.회원수정 4.회원삭제 5.이전메뉴 6.Log-out 7.종료]");
						if(memMenu.equals("1")) {
							memPrint();
						}else if(memMenu.equals("2")) {
							memInsert();
						}else if(memMenu.equals("3")) {
							memEdit();
						}else if(memMenu.equals("4")) {
							memDelete();
						}else if(memMenu.equals("5")){
							break;
						}else if(memMenu.equals("6")) {
							start();
						}else if(memMenu.equals("7")){
							System.out.println("* * * * * * * * 관리자 페이지 접속 종료 * * * * * * * *");
							System.exit(0);
						}
					}while(true);
				}else if(mstMenu.equals("2")) {
					do {
						String bookMenu = Input("MENU [1.도서목록 2.도서등록 3.도서수정 4.도서삭제 5.이전메뉴 6.Log-out 7.종료]");
						if(bookMenu.equals("1")) {
							bookPrint();
						}else if(bookMenu.equals("2")) {
							bookInsert();
						}else if(bookMenu.equals("3")) {
							bookEdit();
						}else if(bookMenu.equals("4")) {
							bookDelete();
						}else if(bookMenu.equals("5")) {
							break; 
						}else if(bookMenu.equals("6")) {
							start();
						}else if(bookMenu.equals("7")){
							System.out.println("* * * * * * * * 관리자 페이지 접속 종료 * * * * * * * *");
							System.exit(0);
						}
					}while(true);	
				}else if(mstMenu.equals("3")) {
					start();
				}
				
			}while(true);
					
		}else if(Login.confirm == 3) {
			start();
		}
		
	}
	
	
//////////////////////////////////////////////////////////////////////////// 필요한 메소드 구성	
	////// Master option 부분
	// 회원관리 2. 회원등록
	// 아이디 비밀번호 추가..?
	public void memInsert() {
		int no = Integer.parseInt(Input("회원번호"));
		String name = Input("회원이름");
		String tel = Input("연락처");
		String addr = Input("주소");
		DataSetting.memList.put(name, new LibMemVo(no, name, tel, addr));
		memPrint();
	}
	
	// 회원관리 3. 회원수정
	public void memEdit() {
		String memName = Input("수정 할 회원명");
		LibMemVo memVo = DataSetting.memList.get(memName);
		if(memVo==null) {
			System.out.println("존재하지 않는 회원명입니다, 이전 메뉴로 돌아갑니다");
		}else {
			do {	
				String subMenu = Input("수정 할 필 선택 [1.회원번호 2.회원명 3.연락처 4.주소 5.수정완료]");
				if(subMenu.equals("1")) {
					int memNo = Integer.parseInt(Input("회원번호"));
					memVo.setMemNo(memNo);
				}else if(subMenu.equals("2")) {
					String name = Input("회원명");
					memVo.setName(name);
				}else if(subMenu.equals("3")) {
					String tel = Input("연락처");
					memVo.setTel(tel);
				}else if(subMenu.equals("4")) {
					String addr = Input("주소");
					memVo.setAddr(addr);
				}else if(subMenu.equals("5")){ 
					System.out.println("\t - 수정을 완료했습니다 -");
					break; 
				}
			}while(true);
			memPrint();
		}
	}
	//회원관리 4.회원삭제
	public void memDelete() {
		String name = Input("삭제 할 회원명");
		DataSetting.memList.remove(name);
		memPrint();
	}
	
	// 도서관리 2. 도서등록
	public void bookInsert() {
		int no = Integer.parseInt(Input("책번호"));
		String title = Input("책제목");
		String author = Input("작가");
		String genre = Input("장르");
		String avail = Input("대출가능여부 [1.대출가능 2.대출불가]");
			if(avail.equals("1")) {
				avail = "대출가능";
			}else if(avail.equals("2")) {
				avail = "대출불가";
			}else {
				System.out.println("check");
			}
		DataSetting.bookList.put(title, new LibBookVo(no, title, author, genre, avail));
		bookPrint();
	}
	// 도서관리 3. 도서수정
	public void bookEdit() {
		String bookTitle = Input("수정 할 도서명");
		LibBookVo bookVo = DataSetting.bookList.get(bookTitle); 
		if(bookTitle.equals("")) {
			System.out.println("책 제목을 다시 입력해주세요");
			bookEdit();
		}else {
			do {
				String subMenu = Input("수정 할 필드 선택 [1. 도서번호 2.도서명 3.작가명 4.장르 5.수정완료]");
				if(subMenu.equals("1")) {
					int bookNo = Integer.valueOf(Input("도서번호"));
					bookVo.setBookNo(bookNo);
				}else if(subMenu.equals("2")) {
					String title = Input("도서명");
					bookVo.setTitle(title);
				}else if(subMenu.equals("3")){
					String author = Input("작가");
					bookVo.setAuthor(author);
				}else if(subMenu.equals("4")) {
					String genre = Input("장르");
					bookVo.setGenre(genre);
				}else if(subMenu.equals("5")) {
					System.out.println("\t - 수정을 완료했습니다 -");
					//stopper = false;
					break;
				}
			}while(true);	
			bookPrint();
		}
		
	}
	//도서관 4. 도서삭제
	public void bookDelete() {
		String title = Input("삭제 할 도서명");
		DataSetting.bookList.remove(title);
		bookPrint();
	}
	
	//////User option 부분
	// 2. 도서검색
	public void browseBook() {
		String keyWord = Input("찾을 도서명");
		Set<String> keySet = DataSetting.bookList.keySet();
		Iterator<String> i = keySet.iterator();
		
		while(i.hasNext()) {
			LibBookVo bookVo = DataSetting.bookList.get(i.next());
			if(bookVo.getTitle().indexOf(keyWord)>=0) {
				System.out.printf("%d\t%s\t%s\t%s\t%s\n", bookVo.getBookNo(), bookVo.getTitle(), bookVo.getAuthor(), bookVo.getGenre(), bookVo.getAvail());
			}
		}
		if(!i.hasNext()) {
			System.out.println("다시 입력하세요");
			browseBook();
		}
	}
	// 3. 도서예약
	public void reserveBook() {
		String keyWord = Input("찾을 도서명");
		Set<String> keySet = DataSetting.bookList.keySet();
		Iterator<String> i = keySet.iterator();

		while(i.hasNext()) {
			LibBookVo bookVo = DataSetting.bookList.get(i.next());
			if(bookVo.getTitle().indexOf(keyWord)>=0) {
				System.out.printf("%d\t%s\t%s\t%s\t%s\n", bookVo.getBookNo(), bookVo.getTitle(), bookVo.getAuthor(), bookVo.getGenre(), bookVo.getAvail());
				String reserve = Input("예약을 원하시면 [1.대출예약 2.대출예약취소 3.이전메뉴]");
				if(reserve.equals("1")) {
					String notAvail = "대출불가";
					bookVo.setAvail(notAvail);
					bookPrint();
				}else if(reserve.equals("2")) {
					String reSet = "대출가능";
					bookVo.setAvail(reSet);
					bookPrint();
				}else if(reserve.equals("3")) {
					break;
				}
			}/*else {
				System.out.println("일치하는 도서가 없습니다 . . .");
				reserveBook();
			break;
			}*/
		}
		
		
	}
	
	
	//////////////////////////////// 기본 메소드
	//회원목록 볼 수 있는 메소드
	public void memPrint() {
		Set<String> memKeyList = DataSetting.memList.keySet();
		Iterator<String> memKey = memKeyList.iterator();
		while(memKey.hasNext()) {
			LibMemVo memVo = DataSetting.memList.get(memKey.next());
			System.out.printf("%d\t%s\t%s\t%s\n", memVo.getMemNo(), memVo.getName(), memVo.getTel(), memVo.getAddr());
		}
	}
	//도서목록 볼 수 있는 메소드
	public void bookPrint() {
		Set<String> bokList = DataSetting.bookList.keySet();
		Iterator<String> bookKey = bokList.iterator();
		while(bookKey.hasNext()) {
			LibBookVo bookVo = DataSetting.bookList.get(bookKey.next());
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", bookVo.getBookNo(), bookVo.getTitle(), bookVo.getAuthor(), bookVo.getGenre(), bookVo.getAvail());
		}
		
	}
	
	//콘솔로 입력받는 부분
	public String Input(String msg) {
		System.out.print(msg+" : ");
		return scan.nextLine();
	}

	public static void main(String[] args) {
		new LibMain();

	}

}
