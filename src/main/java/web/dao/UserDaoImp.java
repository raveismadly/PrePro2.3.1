package web.dao;

import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<User> allUsers() {
       return sessionFactory.getCurrentSession().createQuery("from User ").list();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
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
        return (User)sessionFactory.getCurrentSession().createQuery("from User where id=:id")
                .setParameter("id",id).uniqueResult();
    }
}
