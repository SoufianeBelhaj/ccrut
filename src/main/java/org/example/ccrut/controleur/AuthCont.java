package org.example.ccrut.controleur;

import org.example.ccrut.model.Utilisateur;
import org.example.ccrut.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.regex.Pattern.matches;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/auth")
public class AuthCont {

    private final UtilisateurRepo utilisateurRepo;


    @Autowired
    public AuthCont(
            UtilisateurRepo utilisateurRepo
    ) {
        this.utilisateurRepo = utilisateurRepo;

    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Optional<Utilisateur> utilisateurOpt = utilisateurRepo.findByEmail(loginRequest.getEmail());

            if (utilisateurOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(createErrorResponse("Email non trouvé"));
            }

            Utilisateur utilisateur = utilisateurOpt.get();

            if (!matches(loginRequest.getMotDePasse(), utilisateur.getMotDePasse())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(createErrorResponse("Mot de passe incorrect"));
            }

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("id", utilisateur.getIdUtilisateur());
            response.put("role", utilisateur.getRole().name());
            response.put("nom", utilisateur.getNom());
            response.put("prenom", utilisateur.getPrenom());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createErrorResponse("Erreur serveur : " + e.getMessage()));
        }
    }

    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", message);
        return response;
    }

    // Classe interne pour la requête de login
    public static class LoginRequest {
        private String email;
        private String motDePasse;

        // Getters et Setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getMotDePasse() { return motDePasse; }
        public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    }
}