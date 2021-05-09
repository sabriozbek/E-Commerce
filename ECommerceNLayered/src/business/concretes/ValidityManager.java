package business.concretes;

import business.abstracts.ValidityService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class ValidityManager implements ValidityService{
	private UserDao userDao;
	

	public ValidityManager(UserDao userDao) {
		this.userDao = userDao;
	}




	
	@Override
	public boolean isUsed(String mail) {
		for(User user:userDao.getAll()) {
			if (mail.equals(user.getMail())) {
				System.out.println("mail adresi sisteme kayýtlýdýr.Baþka bir mail adresi deneyiniz.");
				return false;

			}
		}
		return true;

	}

}
