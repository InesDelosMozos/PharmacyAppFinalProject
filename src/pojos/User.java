/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "users")
/**
 *
 * @author agarc
 */
public class User implements Serializable{
    
    private static final long serialVersionUID = 8245386723645005777L;
    @Id
    @GeneratedValue(generator = "users")
    @TableGenerator(name = "users", table="sqlite_sequence", pkColumnName= "name", valueColumnName="seq", pkColumnValue="users")
    private Integer id;
    String email;
    @Lob
    private byte[] password;
    
    public User(String email, byte[] password){
        super();
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + Arrays.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Arrays.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
}
    
    
    
    
    
