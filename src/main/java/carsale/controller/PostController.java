package carsale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("/all")
    public String getAll(Model model) {
        return "posts/all";
    }

    @GetMapping("/posts/one/{id}")
    public String getPost(Model model) {
        return "posts/all";
    }

    @GetMapping("/allByAttribute/{attr}")
    public String getAllByCarBrand(Model model) {
        return "posts/all";
    }
}
