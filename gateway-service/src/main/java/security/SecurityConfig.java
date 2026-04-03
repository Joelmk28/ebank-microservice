package security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .csrf(csrf -> csrf.disable()) // Indispensable pour les APIs
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/ACTUATOR/**").permitAll() // On laisse l'actuator libre
                        .anyExchange().authenticated() // On bloque TOUT le reste
                )
                // On configure la Gateway pour être UNIQUEMENT un serveur de ressources (Token)
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        // On désactive explicitement le formulaire de login et l'authentification basique
        //http.formLogin(ServerHttpSecurity.FormLoginSpec::disable);
        http.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable);

        return http.build();
    }
}