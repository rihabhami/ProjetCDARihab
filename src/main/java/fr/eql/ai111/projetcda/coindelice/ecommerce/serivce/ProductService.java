package fr.eql.ai111.projetcda.coindelice.ecommerce.serivce;

import fr.eql.ai111.projetcda.coindelice.ecommerce.dto.ProductDto;
import fr.eql.ai111.projetcda.coindelice.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    /*Admin*/
    List<ProductDto> findAll();
    Product save(MultipartFile imageProduct, ProductDto productDto);
    Product update(MultipartFile imageProduct, ProductDto productDto);
    void deleteById(Long id);
    void enableById(Long id);

    ProductDto getById(Long id);

    Page<ProductDto> pageProducts(int pageNo);

    Page<ProductDto> searchProducts(int pageNo, String keyword);
}
