package comment.model;

public class CommentDto {

	private int writeNum,commentNum;
	
	private String userId,
				   nickName,
				   content,
				   commentDate;
	
	public CommentDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentDto(int commentNum, String nickName, String content, String commentDate) {
		this.commentNum = commentNum;
		this.nickName = nickName;
		this.content = content;
		this.commentDate = commentDate;
	}

	public CommentDto(int writeNum,int commentNum,String userId, String nickName, String content, String commentDate) {
		this.writeNum = writeNum;
		this.commentNum = commentNum;
		this.userId = userId;
		this.nickName = nickName;
		this.content = content;
		this.commentDate = commentDate;
		
	}

	public int getWriteNum() {
		return writeNum;
	}
	public void setWriteNum(int writeNum) {
		this.writeNum = writeNum;
	}
	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
	
	
	
}
