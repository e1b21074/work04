package oit.is.apple.work04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sample4")
public class Sample41Controller {


    @GetMapping("step1")
    public String sample41() {
        return "sample41.html";
    }
}
