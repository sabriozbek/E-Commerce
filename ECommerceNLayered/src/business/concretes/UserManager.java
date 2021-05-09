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
			System.out.println(user.getFirstName()+" "+user.getLastName()+", üyeliðiniz baþarýyla oluþturulmuþtur.");
			System.out.println(user.getMail()+" mail adresinize hesabýnýzý doðrulamak için bir mail gönderdik.");
			
			
			
		}
			
			
		
		
	}

	@Override
	public void signIn(String mail, String password) {
		for (int i = 0; i < userDao.getAll().size(); i++) {
		if (!userDao.getAll().get(i).getMail().equals(mail)) {
			System.out.println("Mail adresi yanlýþ girildi.");
		}
		else if (!userDao.getAll().get(i).getPassword().equals(password)) {
			System.out.println("Þifre yanlýþ girildi.");
		}
		else {
			System.out.println("Baþarýyla sisteme giriþ yapýlmýþtýr.");
		}
		}
		
		
		
		

	
		
	}

}
