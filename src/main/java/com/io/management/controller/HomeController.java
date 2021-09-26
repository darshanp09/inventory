package com.io.management.controller;

import com.io.management.dao.ProductDao;
import com.io.management.model.Pro;
import com.io.management.model.Product;
import com.io.management.service.HelperUtil;
import com.io.management.service.WriteDataToCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String getProducts(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {

        Product product = productDao.getProductById(productId);
        model.addAttribute(product);

        return "viewProduct";
    }

    /*@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product) {
        productDao.addProduct(product);

        return "redirect:/";
    }*/

    @RequestMapping("/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("new");
        product.setPrice(300);

        model.addAttribute("product", new Product());

        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product) {
        productDao.addProduct(product);

        return "redirect:/";
    }

    @RequestMapping(value = "/addQuantity", method = RequestMethod.POST)
    public String addProductQuantity(@ModelAttribute("product") Product product) {
        Product products = productDao.getProductById(product.getProductId());
        String day = HelperUtil.getDayInWeek();

/*        if(product.getDayOfWeek().equals("sunday")){
            products.setSunday(products.getSunday()!=0 ? product.getQuantity()+products.getSunday() : product.getQuantity());
        }else if(product.getDayOfWeek().equals("monday")){
            products.setMonday(product.getQuantity());
        }else if(product.getDayOfWeek().equals("tuesday")){
            products.setTuesday(product.getQuantity());
        }else if(product.getDayOfWeek().equals("wednesday")){
            products.setWednesday(product.getQuantity());
        }else if(product.getDayOfWeek().equals("thursday")){
            products.setThursday(product.getQuantity());
        }else if(product.getDayOfWeek().equals("friday")){
            products.setFriday(product.getQuantity());
        }else if(product.getDayOfWeek().equals("saturday")){
            products.setSaturday(product.getQuantity());
        }*/

        products.setQuantitySold(products.getQuantityLeft() - product.getQuantity() > 0 ? HelperUtil.getTotalQuantity(products, product) : product.getQuantitySold());
        products.setQuantityLeft(products.getQuantityLeft() - product.getQuantity() > 0 ? products.getQuantityLeft() - product.getQuantity() : product.getQuantityLeft());
        products.setTotalProductSale(products.getPrice() * products.getQuantitySold());
        productDao.addProduct(products);

        return "redirect:/";
    }


    @RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
    public String viewProduct(@RequestParam("search") String productName, Model model) throws IOException {
        String productSearchName = productName;
        List<Product> products = productDao.getProductBySearch(productSearchName);
        model.addAttribute("products",products);
        return "searchProduct";
    }

    @RequestMapping("/getReport")
    public String getReport(){
        WriteDataToCsv writeDataToCsv = new WriteDataToCsv();
        List<Pro> productList = productDao.getAllReportProduct();
        try {
            List<Product> saveDatBack = writeDataToCsv.writeDataToCsv(productList);

            productDao.truncateData();

            for(int i = 0 ; i< saveDatBack.size();i++){
                Product product = saveDatBack.get(i);
                productDao.addProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
