package com.example.jakartafilrouge.dao;


import com.example.jakartafilrouge.model.User;
import com.example.jakartafilrouge.singleton.EMF;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserJpaDAO {


    public Optional<User> findByMail(String mail) {
        EntityManager em = EMF.getInstanceEmf().createEntityManager();

        try {
            String jpql = "SELECT user FROM User user WHERE user.mail = :mail";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("mail", mail);
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }



        public void save(User user) {
            EntityManager em = EMF.getInstanceEmf().createEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            try {
                em.persist(user);
                et.commit();
            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }
            } finally {
                em.close();
            }
        }


        public Optional<User> get(Long id) {
            Optional<User> result = Optional.empty();
            EntityManager em = EMF.getInstanceEmf().createEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            try {
                result = Optional.of(em.find(User.class, id));
                et.commit();
            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }
            } finally {
                em.close();
            }
            return result;
        }


        public List<User> findAll() {
            EntityManager em = EMF.getInstanceEmf().createEntityManager();
            EntityTransaction et = em.getTransaction();
            List<User> users = new ArrayList<>();
            et.begin();
            try {
                TypedQuery<User> gamesQuery = em.createQuery("SELECT user FROM User user", User.class);
                users = gamesQuery.getResultList();
                et.commit();
            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }
            } finally {
                em.close();
            }
            return users;
        }


        public void update(User user) {
            EntityManager em = EMF.getInstanceEmf().createEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            try {
                em.merge(user);
                et.commit();
            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }
            } finally {
                em.close();
            }
        }


        public void delete(User user) {
            EntityManager em = EMF.getInstanceEmf().createEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            try {
                em.remove(em.contains(user) ? user : em.merge(user));
                et.commit();
            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }
            } finally {
                em.close();
            }
        }


    }


