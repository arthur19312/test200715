package entity;


public class User {

    private String userName;
    private String userPsw;

	public User() {
	}

	public User(String userName, String userPsw) {
		this.userName = userName;
		this.userPsw = userPsw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", userPsw='" + userPsw + '\'' +
				'}';
	}
}