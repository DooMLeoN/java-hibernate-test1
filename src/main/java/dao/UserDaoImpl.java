package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public User save(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can not add user to db: " + user);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public Optional<User> get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return Optional.ofNullable(user);
    }
}
