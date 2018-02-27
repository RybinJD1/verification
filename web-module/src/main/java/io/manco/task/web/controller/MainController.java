package io.manco.task.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getUser(Model model) {

        return "index";
    }
}
