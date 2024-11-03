package api.Bov_Corte.Config.Swagger;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name = "jwt-authentication",
        scheme = "Bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER)
public class OpenAPIConfig {

    @Bean
    public OpenAPI springSalesOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("API - Bovinocultura.")
                .description(
                        "API para o controle das atividades gerencias, produtivas e documentais da bovinocultura de corte.")
                .version("versão 1.0.0"));
    }

}
