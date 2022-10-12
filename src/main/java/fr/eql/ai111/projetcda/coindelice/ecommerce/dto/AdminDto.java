package fr.eql.ai111.projetcda.coindelice.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    @Size(min = 3, max = 15, message = "Prénom invalide (3 lettres minimum) ! ")
    private String firstName;
    @Size(min = 3, max = 15, message = "Nom invalide (3 lettres minimum)!")
    private String lastName;

    private String username;

    @Size(min = 5, max = 15, message = "Mot de passe invalide (5 lettres minimum)!")
    private String password;

    private String repeatPassword;
}
