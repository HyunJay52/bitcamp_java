package sys_base;

public class LibMemVo {

	private int memNo;
	private String name;
	private String tel;
	private String addr;
	private String myLib; //대여 중인 책 목록
	
	public LibMemVo() {
		
	}
	
	public LibMemVo(int memNo, String name, String tel, String addr) {
		this.memNo = memNo;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		// 중복번호 막기
		this.memNo = memNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	

}
