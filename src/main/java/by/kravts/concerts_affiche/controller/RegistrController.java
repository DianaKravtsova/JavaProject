package by.kravts.concerts_affiche.controller;

import by.kravts.concerts_affiche.form.UserForm;
import by.kravts.concerts_affiche.model.Users;
import by.kravts.concerts_affiche.repositories.IUsersRepository;
import by.kravts.concerts_affiche.services.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RegistrController {

    private UsersService usersService;
    @Autowired
    private IUsersRepository usersRepository;

    @RequestMapping(value = {"/registr"}, method = RequestMethod.GET)
    public ModelAndView showAddPersonPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("registr");
        UserForm userForm = new UserForm();
        model.addAttribute("userform", userForm);
     //   log.info("/addgames was called(GET)");
        return modelAndView;
    }

    // @PostMapping("/addgame")
//GetMapping("/")
    @RequestMapping(value = {"/registr"}, method = RequestMethod.POST)
    public ModelAndView savePerson(Model model, @ModelAttribute("userform") UserForm userForm) {

        String mes;

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userlist");
        String login = userForm.getLogin();
        String password = userForm.getPassword();
        if (login != null && login.length() > 0 //
                && password != null) {
            if(( usersService.findByLogin(login) != null)){

             log.info("неа");
            }
            Users newUser = new Users(login, password, (short)0);
            usersRepository.save(newUser);

            log.info("зарегав");
            return modelAndView;

        }
        modelAndView.setViewName("registr");

        //log.info("/addgames was called(POST)");
        return modelAndView;
    }

}
