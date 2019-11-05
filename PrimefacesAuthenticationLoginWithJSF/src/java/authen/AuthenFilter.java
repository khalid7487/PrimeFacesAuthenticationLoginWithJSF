
package authen;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KHALID
 */
@WebFilter(filterName = "AuthenFilter", urlPatterns = {"*.xhtml"})
public class AuthenFilter implements Filter{

    public AuthenFilter(){
        
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            //check wheather session variable is set
            HttpServletRequest req=(HttpServletRequest)request;
            HttpServletResponse res=(HttpServletResponse)response;
            HttpSession ses=req.getSession(false);
           //  allow user to proccede if url is login.xhtml or user logged in or user is accessing any page in //public folder
            String reqURI = req.getRequestURI();
            if(reqURI.indexOf("/index.xhtml")>=0 ||(ses!=null && ses.getAttribute("username")!=null)
                    ||reqURI.indexOf("/public/")>=0||reqURI.contains("javax.faces.resource")){
                chain.doFilter(request, response);
            }else
                res.sendRedirect(req.getContextPath()+"/index.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void destroy(){
        
    }
    
}
