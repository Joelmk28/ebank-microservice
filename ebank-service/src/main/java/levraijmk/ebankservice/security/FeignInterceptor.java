package levraijmk.ebankservice.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        // 1. Récupérer l'authentification de l'utilisateur qui a appelé Ebank
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 2. Vérifier si c'est bien un Token JWT
        if (authentication instanceof JwtAuthenticationToken jwtToken) {
            // 3. Récupérer la valeur brute du texte (le badge)
            String tokenValue = jwtToken.getToken().getTokenValue();

            // 4. L'ajouter dans l'en-tête "Authorization" pour l'appel vers Customer
            template.header("Authorization", "Bearer " + tokenValue);
        }
    }
}