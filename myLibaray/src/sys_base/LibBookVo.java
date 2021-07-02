package sys_base;

public class LibBookVo {

	private int bookNo;
	private String title;
	private String author;
	private String genre;
	private String avail;
	
	public LibBookVo() {
		
	}
	
	public LibBookVo(int bookNo, String title, String author, String genre, String avail) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.avail = avail;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAvail() {
		return avail;
	}

	public void setAvail(String avail) {
		this.avail = avail;
	}
	
	
}
