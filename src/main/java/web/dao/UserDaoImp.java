package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
//        List<User> list;
//        Session session = sessionFactory.getCurrentSession();
//        list = session.createQuery("from User ").list();
//        session.close();
//        return list;
        return sessionFactory.getCurrentSession().createQuery("from User ").list();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserById(int id) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where id=:id")
                .setParameter("id", id).uniqueResult();
    }
}
