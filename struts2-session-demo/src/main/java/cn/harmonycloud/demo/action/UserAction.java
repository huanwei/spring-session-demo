package cn.harmonycloud.demo.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cyan on 2019/4/24 .
 */
public class UserAction extends ActionSupport {
    private Map<String, Object> jsonResult = new HashMap<String, Object>();

    private String username;
    private String password;
    private String info;

    public String login() {
        HttpSession session = ServletActionContext.getRequest().getSession();

        if (null != session.getAttribute("username") && !"".equals(session.getAttribute("username"))) {
            // 已经登录逻辑
            jsonResult.put("msg", "不要重复登录");
            return SUCCESS;
        }

        // 未登录逻辑
        session.setAttribute("username", username);
        session.setAttribute("info", info);

        System.out.println("info : " + session.getAttribute("info"));

        jsonResult.put("msg", "登录成功");
        return SUCCESS;
    }

    public String info() {
        HttpSession session = ServletActionContext.getRequest().getSession();

        if (null != session.getAttribute("username") && !"".equals(session.getAttribute("username"))) {
            // 已经登录逻辑
            jsonResult.put("username", session.getAttribute("username").toString());
            jsonResult.put("info", session.getAttribute("info").toString());
            return SUCCESS;
        }
        jsonResult.put("msg", "暂未登录");
        return SUCCESS;
    }

    public Map<String, Object> getJsonResult() {
        return jsonResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
