import business.concretes.UserInfoControlManager;
import business.concretes.UserManager;
import core.concretes.GoogleUserManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
User user=new User();
user.setId(1);
user.setFirstName("Sabri");
user.setLastName("Özbek");
user.setMail("sabriozbekq@gmail.com");
user.setPassword("123456");


UserManager userManager=new UserManager(new UserInfoControlManager(), new HibernateUserDao(),new GoogleUserManagerAdapter());
userManager.register(user);


userManager.signIn(user.getMail(), "12345");//Þifre yanlýþ olma durumu onun yerine :user.getPassword()
	
	
	
	}

}
