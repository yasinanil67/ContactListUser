package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User{
	private String firstName;
	private String lastName;
	private Integer __v;
	private String _id;
	private String email;


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer get__v() {
		return __v;
	}

	public String get_id() {
		return _id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", __v=" + __v +
				", _id='" + _id + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
