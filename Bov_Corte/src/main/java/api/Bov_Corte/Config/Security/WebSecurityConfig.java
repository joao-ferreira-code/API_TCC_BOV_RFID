package api.Bov_Corte.Config.Security;

import api.Bov_Corte.Config.Security.Autenticacao.jwt.JwtAuthenticationEntryPoint;
import api.Bov_Corte.Config.Security.Autenticacao.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private Environment env;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

//====================================================================================================================//

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//====================================================================================================================//

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

//====================================================================================================================//

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
            // Não cheque essas requisições
            .authorizeRequests()
            .antMatchers( "/usuario/ola",

                "/usuario/autenticar",
                "/usuario/create",
                "/usuario/autenticar",
                "/usuario/validarToken/**",
                "/usuario/isEmailValido/**",
                "/usuario/reiviarEmailValidacao/**",

                "/recuperarSenha/**",
                "/cidade/**",
                "/estado/**",
                "/nivelAcesso/**",
                "/raca/**",
                "/bov-docs/**",
                "/swagger-ui/**",
                "/teste/pulic/**"

            ).permitAll().

            // Qualquer outra requisição deve ser checada
            anyRequest().authenticated().and().exceptionHandling()
            .authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

}

/*
// ---------------- Privado ----------------
    "/usuario/editarDadosUsuario",
    "/usuario/editarSenha",
    "/usuario/buscarUsuario",

    "/fotoUsuario/**",
    "/fotoFazenda/**",
    "/vacina/**",
    "/loteTagRFID/**",
    "/bovino/**",

    "/bovinoFazenda/**",
    "/descarteBovino/**",
    "/pesagemBovino/**",
    "/vacinacaoBovino/**",
    "/compraBovino/**",
    "/colaboradorFazenda/**",

    "/fazenda/**",
*/