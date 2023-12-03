package carsale.controller;

import carsale.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Abramov Sergey
 */
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    /**
     * Method shows all car sales posts
     * @param model - HTML page is filled with this object
     * @return Path to page
     */
    @GetMapping({"/", "/list"})
    public String getAll(Model model) {
        model.addAttribute("posts", service.findAll());
        return "posts/all";
    }

    /**
     * Method show one car sale post
     * @param model - HTML page is filled with this object
     * @param id - Parameter from the address bar
     * @return Path to page
     */
    @GetMapping("/one/{id}")
    public String getPost(Model model, @PathVariable int id) {
        model.addAttribute("post", service.findById(id));
        return "posts/one";
    }

    /**
     * Method shows all car sales posts by car brand
     * @param model - HTML page is filled with this object
     * @param brand - Parameter from the address bar
     * @return Path to page
     */
    @GetMapping("/allByBrand/{brand}")
    public String getAllByCarBrand(Model model, @PathVariable String brand) {
        model.addAttribute("posts", service.findAllByCarBrand(brand));
        return "posts/all";
    }

    /**
     * Method shows all car sales posts by car type
     * @param model - HTML page is filled with this object
     * @param typeCar - Parameter from the address bar
     * @return Path to page
     */
    @GetMapping("/allByType/{typeCar}")
    public String getAllByCarTypeCar(Model model, @PathVariable String typeCar) {
        model.addAttribute("posts", service.findAllByCarType(typeCar));
        return "posts/all";
    }

    /**
     * Method shows all car sales posts by car body
     * @param model - HTML page is filled with this object
     * @param body - Parameter from the address bar
     * @return Path to page
     */
    @GetMapping("/allByBody/{body}")
    public String getAllByCarBody(Model model, @PathVariable String body) {
        model.addAttribute("posts", service.findAllByCarTypeBody(body));
        return "posts/all";
    }

    @GetMapping("/update/{id}")
    public String getUpdatePage(@PathVariable int id, Model model) {
        return "posts/update";
    }

    @GetMapping("/create")
    public String createString(Model model) {
        var postCreateDto = service.getPostCreateDto();
        model.addAttribute("bodies", postCreateDto.getBodies());
        model.addAttribute("engines", postCreateDto.getEngines());
        return "posts/create";
    }
}
