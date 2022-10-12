package fr.eql.ai111.projetcda.coindelice.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private Long numberOfProduct;
}
