
package bean;

import java.io.Serializable;

public class LoginBean implements Serializable{
    private static final long serialVersionUID=1L;
    private String password;
    private String message,uname;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    
    
}
