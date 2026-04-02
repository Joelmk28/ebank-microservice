package levraijmk.ebankservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // <--- Permet de rafraîchir la valeur sans redémarrer (optionnel)
public class TestConfigController {

    @Value("${global.params.message}") // Récupère la valeur du Config Server
    private String message;

    @GetMapping("/test-config")
    public String test() {
        return "Message reçu : " + message;
    }
}