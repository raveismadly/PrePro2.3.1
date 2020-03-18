package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping(value = "/users")
    public List<User> printAllUsers(ModelMap model) {
        List<User> list = service.allUsers();
        model.addAttribute("allUsers", list);
        return list;
    }

//    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @GetMapping(value = "/add")
    public ModelAndView addUserPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("addUser");
        return model;
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PostMapping(value = "/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/users");
        service.addUser(user);
        return model;
    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/edit/{id}")
    public ModelAndView editUserPage(@PathVariable("id")int id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("editUser");
        model.addObject("user",service.getUserById(id));
        return model;
    }

//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @PostMapping(value = "/edit")
    public ModelAndView editFilm(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        service.updateUser(user);
        return modelAndView;
    }

//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute("user") User user) {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("redirect:/users");
//        service.updateUser(user);
//        return model;
//    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUserPage(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/users");
        User user = service.getUserById(id);
        service.deleteUser(user);
        return model;
    }

}
