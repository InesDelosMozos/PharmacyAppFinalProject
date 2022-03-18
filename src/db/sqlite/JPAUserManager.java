/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sqlite;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.*;

import pojos.User;
import db.interfaces.UserManager;
/**
 *
 * @author agarc
 */
public class JPAUserManager {
    private EntityManager em;
    
    public JPAUserManager(){
        super();
        this.connect();
    }
    
     public void connect() {
	em = Persistence.createEntityManagerFactory("user-provider").createEntityManager();
	em.getTransaction().begin();
	em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
	em.getTransaction().commit();
      }
     
    
     public void disconnect() {
		em.close();
	}
     
     public void newUser(User u){
         em.getTransaction().begin();
	 em.persist(u);
	 em.getTransaction().commit();
     }
     
     public User getUser(String email){
         Query q = em.createNativeQuery("SELECT * FROM users WHERE email = ?", User.class);
	 q.setParameter(1, email);
	 return (User) q.getSingleResult();
     }
     
     public boolean userNameTaken(String username ){
         Query q = em.createNativeQuery("SELECT * FROM users WHERE email = ?", User.class);
	 q.setParameter(1, username);
	 List<User> userList= (List) q.getResultList();
	 if(userList.isEmpty()) {
		return false;
	}
	else {
		return true;
	}
     }
     
     public User checkPassword(String email, String password){
         Query q=null;
		
	try {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] hash = md.digest();
	    q = em.createNativeQuery("SELECT * FROM users WHERE email = ? AND password = ?", User.class);
	    q.setParameter(1, email);
	    q.setParameter(2, hash);
			
	 return (User) q.getSingleResult();
	}catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	} catch (NoResultException nre) {
		return null;
	}
		
	return (User) q.getSingleResult();
     }
     
        
        

     
}
      
