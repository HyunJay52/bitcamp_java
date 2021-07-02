package sys_base;

public class Login {
	
	public static String id;
	public static String pwd;
	public static int confirm; // loginConfirm의 결과값을 저장 할 멤버 변수 생성 
	
	public Login() {
		
	}
	//아이디 비밀번호 임의지정.. 1, 2로 가면 로그인 성공 
	public static int loginConfirm() {
			if(id.equals("user") && pwd.equals("1234")) {
				return 1;
			}else if(id.equals("master") && pwd.equals("1234")) {
				return 2;
			}else if(id == "" && pwd == ""){
				System.out.println("ID와 Password를 입력해주세요...");
				return 3;
			}else {
				System.out.println("Log in failed ...");
				return 3;
			}
	}

}
