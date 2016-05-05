/**
 * 	    Control Work 			17.02.2015
 *
 * 	    POJO (Java Been) User
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package pojos;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 23L;

	private int id; 	 	// Users ID
	private int role; 	 	// Rules users (1-admin, 2-user)
	private String name; 	// Users Name
	private String fam;  	// Users Surname
	private String email; 	// Users E-Mail
	private String password;// Users password
		
	public User() {}  //Constructor without param

    /**
     * Constructor with param
     */
	public User(int id, int role, String name, String fam, String email, String password) {
		setId(id);		// Users ID
		setRole(role);	// Rules users (1-admin, 2-user)
		setName(name);	// Users Name
		setFam(fam);	// Users Surname
		setEmail(email);		// Users E-Mail
		setPassword(password);	// Users password
	}  
	
	/**
	 * GET Users ID
	 */	
	public int getId() {
		return id;
	}
	
	/**
	 * SET Users ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * GET  Rules users (1-admin, 2-user)
	 */	
	public int getRole() {
		return role;
	}

	/**
	 * SET  Rules users (1-admin, 2-user)
	 */	
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * GET  Users Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * SET  Users Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * GET  Users Surname
	 */
	public String getFam() {
		return fam;
	}

	/**
	 * SET  Users Surname
	 */
	public void setFam(String fam) {
		this.fam = fam;
	}

	/**
	 * GET  Users E-Mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * SET  Users E-Mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * GET  Users password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * SET  Users password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (fam == null) {
            if (other.fam != null)
                return false;
        } else if (!fam.equals(other.fam))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (role != other.role)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((fam == null) ? 0 : fam.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result + role;
        return result;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", role=" + role + ", name=" + name
                + ", fam=" + fam + ", email=" + email + ", password="
                + password + "]";
    }
}