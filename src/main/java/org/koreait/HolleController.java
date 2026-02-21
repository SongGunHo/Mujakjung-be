package org.koreait;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolleController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
