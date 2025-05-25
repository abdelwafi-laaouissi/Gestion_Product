package ma.enset.projet_web_spring_mvc.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ma.enset.projet_web_spring_mvc.entities.Product;
import ma.enset.projet_web_spring_mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }
    @GetMapping("/user/index")
    public String index(Model model,@RequestParam(name = "keyword",defaultValue ="") String keyword) {
        //List<Product> products = productRepository.findAll();
        List<Product> products = productRepository.findByNameContainsIgnoreCase(keyword);
        model.addAttribute("productList", products);
        model.addAttribute("keyword", keyword);
        return "products";
    }
    @GetMapping("/admin/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-Product";
    }
    @PostMapping("/admin/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "new-Product";
        productRepository.save(product);
        return "redirect:/user/index";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }
    @GetMapping("/noteAuthrized")
    public String noteAuthrized() {
        return "noteAuthrized";
    }
    @GetMapping("/admin/editProduct")
    public String editProduct(@RequestParam Long id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) return "redirect:/user/index";
        model.addAttribute("product", product);
        return "update-Product";
    }

    @PostMapping("/admin/updateProduct")
    public String updateProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-Product";
        }
        productRepository.save(product); // save = update si ID existe
        return "redirect:/user/index";
    }
    @GetMapping("/login")
    public String login() {return "login"; }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "logout";
    }
}
