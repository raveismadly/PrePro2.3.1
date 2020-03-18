package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service){
        this.service = service;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> printAllUsers(ModelMap model){
        List<User> list = service.allUsers();
        model.addAttribute("allUsers",list);
        return list;
    }
}
