package fr.eql.ai111.projetcda.coindelice.ecommerce.serivce;


import fr.eql.ai111.projetcda.coindelice.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {

    /*Partie Admin*/
    List<Category> findAll();
    Category save(Category category);
    Category findById(Long id);
    Category update(Category category);
    void deleteById(Long id);
    void enabledById(Long id);
    List<Category> findAllByActivated();

}
