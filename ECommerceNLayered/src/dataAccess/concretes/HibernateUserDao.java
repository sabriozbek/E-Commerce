package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	private List<User> users;
	
	

	public HibernateUserDao() {
		this.users=new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println("Kullanýcý veritabanýna eklendi.");
	}

	@Override
	public List<User> getAll() {
		
		
		return this.users;
	}

}
