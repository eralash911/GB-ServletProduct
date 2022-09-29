package controller;


import entities.Prod;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ServiceProduct;

@Controller
@RequestMapping("/student")
public class ProductController {
    private ServiceProduct serviceProduct;

    @Autowired
    public void setStudentsService(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    @RequestMapping("/showStudent")
    public String hello(Model uiModel) {
//, @ModelAttribute("student")Student student
        Product[] products = new Product[2];
        products[0] = serviceProduct.getProductById(10);
        products[1] = serviceProduct.getProductById(20);

        Prod productsList = new Prod();
        productsList.setProducts(products);

        uiModel.addAttribute("products", productsList);
//        System.out.println(student.getFirstName() + " " + student.getLastName());
        return "products";
    }

    //
    @RequestMapping(path = "/showStudentById", method = RequestMethod.GET)
    @ResponseBody
    public Product showStudentById(Model uiModel, @RequestParam int id) {
        Product product = serviceProduct.getProductById(id);
        return product;
    }
    //
    @RequestMapping(path = "/showStudentById/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public Product showStudentById(@PathVariable("sid") int id) {
        Product product = serviceProduct.getProductById(id);
        return product;
    }
    //
    @RequestMapping(path = "/setStudentById", method = RequestMethod.POST)
    public void setStudent(@RequestBody Product product) {
        System.out.println(product.getCost() + " " + product.getTitle() + " " + product.getId());
    }
    //
    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Product student) {
        return "student-form-result";
    }


}


