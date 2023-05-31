package com.aplicaciones13.manifiesto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Objeto de llamado principal del sistema.
 *
 * @author omargo33@hotmail.com
 *
 */
@ComponentScan(
        {
            "com.aplicaciones13.manifiesto.http.request",
            "com.aplicaciones13.manifiesto.servicio",
            "com.aplicaciones13.manifiesto.scheduler"
        }
)
@EnableJpaRepositories("com.aplicaciones13.manifiesto.jpa.queries")
@EnableScheduling
@EntityScan("com.aplicaciones13.manifiesto.jpa.model")
@SpringBootApplication
public class ManifiestoAplicationMain extends SpringBootServletInitializer {

    /**
     * Sobrecarga configuracion del aplicativo.
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManifiestoAplicationMain.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ManifiestoAplicationMain.class, args);
    }
}
