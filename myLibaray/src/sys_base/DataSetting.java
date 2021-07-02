package sys_base;

import java.util.HashMap;

public class DataSetting {

	public static HashMap<String, LibBookVo> bookList = new HashMap<String, LibBookVo>();
	public static HashMap<String, LibMemVo> memList = new HashMap<String, LibMemVo>();
	
	public DataSetting() {
		
	}
	
	public static void bookSet() {
		bookList.put("인간의 흑역사", new LibBookVo(01, "인간의 흑역사", "톰 필립스", "역사", "대출가능"));
		bookList.put("동물농장", new LibBookVo(02, "동물농장", "조지 오웰", "소설", "대출가능"));
		bookList.put("멋진 신세계", new LibBookVo(03, "멋진 신세계", "올더스 헉슬리", "소설", "대출가능"));
		bookList.put("소년이 온다", new LibBookVo(04, "소년이 온다", "한강", "소설", "대출가능"));
		bookList.put("우리가 빛의 속도로 갈 수 없다면", new LibBookVo(05, "우리가 빛의 속도로 갈 수 없다면", "\t김초엽", "소설", "대출가능"));
		
	}
	
	public static void memberSet() {
		memList.put("강감찬", new LibMemVo(01, "강감찬", "010.1234.5678", "서울시 강서구"));
		memList.put("이성계", new LibMemVo(02, "이성계", "010.1212.7878", "서울시 동작구"));
		memList.put("이순신", new LibMemVo(03, "이순신", "010.4321.7888", "서울시 은평구"));
		memList.put("나혜석", new LibMemVo(04, "나혜석", "010.3838.5656", "서울시 중구"));
		memList.put("유관순", new LibMemVo(05, "유관순", "010.0518.0301", "서울시 서초구"));
		
	}

}
