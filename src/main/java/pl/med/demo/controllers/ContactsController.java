package pl.med.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping
@RequiredArgsConstructor
public class ContactsController {

    @GetMapping(value = "/contacts")
    String contacts() {
        return "forward:/index.html";
    }
}
