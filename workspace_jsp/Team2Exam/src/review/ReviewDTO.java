package review;

import java.io.Serializable;

public class ReviewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private String title;
	private String content;
	private String id;
	private String category;
	private String writeday;
	private int readcnt;
	private int starpoint;
	
	public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(int num, String title, String content, String id, String category, String writeday, int readcnt,
			int starpoint) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.id = id;
		this.category = category;
		this.writeday = writeday;
		this.readcnt = readcnt;
		this.starpoint = starpoint;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getStarpoint() {
		return starpoint;
	}

	public void setStarpoint(int starpoint) {
		this.starpoint = starpoint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewDTO other = (ReviewDTO) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReviewDTO [num=" + num + ", title=" + title + ", content=" + content + ", id=" + id + ", category="
				+ category + ", writeday=" + writeday + ", readcnt=" + readcnt + ", starpoint=" + starpoint + "]";
	}
	
	
}
