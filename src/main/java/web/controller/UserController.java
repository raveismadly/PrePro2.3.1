package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> printAllUsers(ModelMap model) {
        List<User> list = service.allUsers();
        model.addAttribute("allUsers", list);
        return list;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("addUser");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/users");
        service.addUser(user);
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUserPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("editUser");
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/users");
        service.updateUser(user);
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUserPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("deleteUser");
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteUser(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/users");
        service.deleteUser(user);
        return model;
    }
}
