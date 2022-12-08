package join.model;

public class JoinDto {
	
	private int userId;

	private String pw,
				   nickName,
				   userName,
				   eMail,
				   telNumber;
	
	public JoinDto() {}
	
	public JoinDto(String pw, String nickName, String userName, String eMail, String telNumber) {

		this.pw = pw;
		this.nickName = nickName;
		this.userName = userName;
		this.eMail = eMail;
		this.telNumber = telNumber;
		
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
