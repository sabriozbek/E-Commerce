package business.abstracts;

public interface UserInfoControlService {
	boolean mailCheck(String mail);
	boolean firstNameCheck(String firstName);
	boolean lastnamecheck(String lastName);
	boolean passwordcheck(String password);

}
