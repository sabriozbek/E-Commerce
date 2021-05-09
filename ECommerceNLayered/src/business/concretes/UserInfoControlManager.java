package business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserInfoControlService;

public class UserInfoControlManager implements UserInfoControlService{

	

	
	@Override
	public boolean mailCheck(String mail) {
		String regexString="^(.+)@(\\S+)$";
		Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(mail);
        if (matcher.matches()) {
			return true;
		}else {
			
			System.out.println("Lütfen geçerli bir mail adresi giriniz.");
			return false;
		}
		
		
	}

	@Override
	public boolean firstNameCheck(String firstName) {
		if (firstName.length()>2) {
			return true;
		}else {
			
			System.out.println("Ýsminiz iki karakterden küçük olamaz.");
			return false;
		}		
	}

	@Override
	public boolean lastnamecheck(String lastName) {
		if (lastName.length()>2) {
			return true;
		}else {
			
			System.out.println("Soyadýnýz iki karakterden küçük olamaz.");
			return false;
		}
		
	}

	@Override
	public boolean passwordcheck(String password) {
		if (password.length()<6) {
			System.out.println("Þifre 6 karakterden uzun olmalýdýr.");
			return false;

		}
		return true;

	}

}
