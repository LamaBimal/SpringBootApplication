package com.test.rest.controller;

/**
 * Created by bimal on 11/4/17.
 */
import java.util.concurrent.atomic.AtomicLong;
import com.test.rest.domain.Greeting;
import com.test.rest.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/greeting")
public class GreetingController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    /*@RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",defaultValue = "world") String name,Model model) {
        model.addAttribute("name",name);
        return "greeting";
    }*/
    @GetMapping("/add")
    public String greetingForm(Model model){
        model.addAttribute("greeting",new Greeting());
        return "greeting";
    }

    @PostMapping("/save")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {

        Greeting greeting1 = new Greeting();
        greeting1.setId(greeting.getId());
        greeting1.setContent(greeting.getContent());
        greetingRepository.save(greeting1);
        return "result";
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<Greeting> getAll(){
        return greetingRepository.findAll();
    }
}
