package core.concretes;



import GoogleAuthorization.GoogleUserManager;
import core.abstracts.OtherService;

public class GoogleUserManagerAdapter implements OtherService{

	
	
	@Override
	public void RegisterwithOtherService() {
GoogleUserManager gum=new GoogleUserManager();
gum.RegisterWithGoogle();

	}

}
