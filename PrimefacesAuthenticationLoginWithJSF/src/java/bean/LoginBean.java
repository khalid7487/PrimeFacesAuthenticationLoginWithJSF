
package bean;

import dao.*;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="loginBean")
@SessionScoped
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
    
    public String loginProject(){
        boolean result=UserDAO.login(uname, password);
        if(result){
            HttpSession session=Util.getSession();
            session.setAttribute("username", uname);
            return "home";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Login!",
                            "Please Try Again!"));
            return "login";
        }
    }
    public String logout(){
        HttpSession session=Util.getSession();
        session.invalidate();
        return "login";
    }
}
