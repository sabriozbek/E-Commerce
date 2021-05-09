package business.concretes;

import java.util.Iterator;

import business.abstracts.UserInfoControlService;
import business.abstracts.UserService;
import business.abstracts.ValidityService;
import core.abstracts.OtherService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;


public class UserManager implements UserService {
UserInfoControlService userCheckService;
UserDao userDao;
OtherService OtherService;

public UserManager(UserInfoControlService userCheckService, UserDao userDao,
		OtherService otherService) {
	
	this.userCheckService = userCheckService;
	this.userDao = userDao;
	OtherService = otherService;
}

public UserManager(UserInfoControlService userCheckService, UserDao userDao) {
	
	this.userCheckService = userCheckService;
	this.userDao = userDao;
	
}


	
	
	@Override
	public void register(User user) {
		
		ValidityService validityService=new ValidityManager(userDao);
		if (validityService.isUsed(user.getMail())
				&&userCheckService.mailCheck(user.getMail())&&
				userCheckService.passwordcheck(user.getPassword())&&
				userCheckService.firstNameCheck(user.getFirstName())&&
				userCheckService.lastnamecheck(user.getLastName())) {
			
			userDao.add(user);
			OtherService.RegisterwithOtherService();
			System.out.println(user.getFirstName()+" "+user.getLastName()+", �yeli�iniz ba�ar�yla olu�turulmu�tur.");
			System.out.println(user.getMail()+" mail adresinize hesab�n�z� do�rulamak i�in bir mail g�nderdik.");
			
			
			
		}
			
			
		
		
	}

	@Override
	public void signIn(String mail, String password) {
		for (int i = 0; i < userDao.getAll().size(); i++) {
		if (!userDao.getAll().get(i).getMail().equals(mail)) {
			System.out.println("Mail adresi yanl�� girildi.");
		}
		else if (!userDao.getAll().get(i).getPassword().equals(password)) {
			System.out.println("�ifre yanl�� girildi.");
		}
		else {
			System.out.println("Ba�ar�yla sisteme giri� yap�lm��t�r.");
		}
		}
		
		
		
		

	
		
	}

}
