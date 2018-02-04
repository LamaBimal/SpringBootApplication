package com.test.rest.controller;

/**
 * Created by bimal on 11/4/17.
 */
import java.util.concurrent.atomic.AtomicLong;
import com.test.rest.pojo.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",defaultValue = "world") String name,Model model) {
        model.addAttribute("name",name);
        return "greeting";
    }
}
