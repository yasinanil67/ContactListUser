package pojos;

public class UserResponsePojo{
	private User user;
	private String token;

	public User getUser(){
		return user;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"UserResponsePojo{" + 
			"user = '" + user + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
