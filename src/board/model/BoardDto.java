package board.model;

public class BoardDto {
	
	private String catagory,
				   title,
				   writer,
				   writingTime,
				   content;
	private int writeNum, views;
	
	public BoardDto() {}
	
	public BoardDto(String catagory, String title, String writer, String writingTime, int writeNum, int views, String content) {
		
		this.catagory = catagory;
		this.title = title;
		this.writer = writer;
		this.writingTime = writingTime;
		this.writeNum = writeNum;
		this.views = views;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWritingTime() {
		return writingTime;
	}

	public void setWritingTime(String writingTime) {
		this.writingTime = writingTime;
	}

	public int getWriteNum() {
		return writeNum;
	}

	public void setWriteNum(int writeNum) {
		this.writeNum = writeNum;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
}
