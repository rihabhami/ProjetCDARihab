package fr.eql.ai111.projetcda.coindelice.ecommerce.repository;

import fr.eql.ai111.projetcda.coindelice.ecommerce.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByUsername(String username);
}
