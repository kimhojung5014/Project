package reply.model;

public class ReplyDto {

	private int writeNum,//글 번호 외래키
				commentNum,//댓글 번호 외래키
				parentNum;
	
	private String userId,
				   nickName,
				   content,
				   commentDate;
	
	public ReplyDto() {}
	
	public int getParentNum() {
		return parentNum;
	}

	public void setParentNum(int parentNum) {
		this.parentNum = parentNum;
	}
	//댓글 불러오기때 사용
	public ReplyDto(int commentNum, String userId, String nickName, String content, String commentDate) {
		this.commentNum = commentNum;
		this.userId = userId;
		this.nickName = nickName;
		this.content = content;
		this.commentDate = commentDate;
	}
	//대대댓글 불러오기시 사용
	public ReplyDto( String nickName, String userId, int parentNum, int commentNum , String content, String commentDate ) {
		this.nickName = nickName;
		this.userId = userId;
		this.parentNum = parentNum;
		this.commentNum = commentNum;
		this.content = content;
		this.commentDate = commentDate;
	}
	
	//일반 댓글 작성 시 컨트롤러에서 폼에서 받은 정보로 객체를 만들어 주고받는 용도
	public ReplyDto(int writeNum,int  commentNum, int parentNum,
			String userId, String nickName, 
			String content) {

			this.writeNum = writeNum;
			this.commentNum = commentNum;
			this.parentNum = parentNum;
			this.userId = userId;
			this.nickName = nickName;
			this.content = content;
			}	
	
	public ReplyDto(int writeNum,int  commentNum, int parentNum,
					String userId, String nickName, 
					String content,String commentDate) {
		
		this.writeNum = writeNum;
		this.commentNum = commentNum;
		this.parentNum = parentNum;
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
