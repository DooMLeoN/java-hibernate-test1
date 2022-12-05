import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setLogin("Vova@");
        user.setPassword("123");
        userDao.save(user);

    }
}
