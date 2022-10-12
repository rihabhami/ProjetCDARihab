package fr.eql.ai111.projetcda.coindelice.ecommerce.serivce;

import fr.eql.ai111.projetcda.coindelice.ecommerce.dto.AdminDto;
import fr.eql.ai111.projetcda.coindelice.ecommerce.model.Admin;

public interface AdminService {

    Admin findByUsername (String username);
    Admin save(AdminDto adminDto);
}
