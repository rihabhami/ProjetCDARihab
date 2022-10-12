package fr.eql.ai111.projetcda.coindelice.ecommerce.controller;

import fr.eql.ai111.projetcda.coindelice.ecommerce.model.Category;
import fr.eql.ai111.projetcda.coindelice.ecommerce.serivce.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("size", categories.size());
        model.addAttribute("title", "Category");
        model.addAttribute("categoryNew", new Category());
        return "categories";
    }

    @PostMapping("/add-category")
    public String add(@ModelAttribute("categoryNew") Category category, RedirectAttributes attributes){
        try {
            categoryService.save(category);
            attributes.addFlashAttribute("success", "Ajouter avec succés");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Nom existe déjà");
        }
        catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Problème de serveur");
        }
        return "redirect:/categories";

    }

    @RequestMapping(value = "/findById", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public Category findById(Long id){
        return categoryService.findById(id);
    }

    @GetMapping("/update-category")
    public String update(Category category, RedirectAttributes attributes){
        try {
            categoryService.update(category);
            attributes.addFlashAttribute("success","Mis à jour avec succés");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Echec de mise à jour: nom existe déjà");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Problème de serveur");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/delete-category", method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Long id, RedirectAttributes attributes){
        try {
            categoryService.deleteById(id);
            attributes.addFlashAttribute("success", "Supprimer");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Echec de suppression ");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/enable-category", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enable(Long id, RedirectAttributes attributes){
        try {
            categoryService.enabledById(id);
            attributes.addFlashAttribute("success", "Activé avec succès");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Echec");
        }
        return "redirect:/categories";
    }





}

