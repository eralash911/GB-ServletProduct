package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeConrol {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String hello(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "index";
    }
}
