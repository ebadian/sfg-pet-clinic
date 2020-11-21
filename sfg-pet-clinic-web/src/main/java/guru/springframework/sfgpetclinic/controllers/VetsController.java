package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

    @RequestMapping({"/vets","/vets.html", "/vets/index", "/vets/index.html"})
    public String listVets() {
        return "vets/index";
    }
}
