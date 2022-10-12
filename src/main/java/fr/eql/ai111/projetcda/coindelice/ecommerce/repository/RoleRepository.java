package fr.eql.ai111.projetcda.coindelice.ecommerce.repository;

import fr.eql.ai111.projetcda.coindelice.ecommerce.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
