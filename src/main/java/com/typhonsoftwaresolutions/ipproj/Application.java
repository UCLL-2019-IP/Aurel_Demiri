package com.typhonsoftwaresolutions.ipproj;

import com.typhonsoftwaresolutions.ipproj.model.DagMenu;
import com.typhonsoftwaresolutions.ipproj.model.Gerecht;
import com.typhonsoftwaresolutions.ipproj.repository.DagMenuRepository;
import com.typhonsoftwaresolutions.ipproj.repository.GerechtenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(GerechtenRepository gerechtenRepository, DagMenuRepository dagMenuRepository) {
        return args -> {
            gerechtenRepository.save(new Gerecht("Bloemkool soep", 1d, "SOEP"));
            gerechtenRepository.save(new Gerecht("Tomatensoep", 1d, "SOEP"));
            gerechtenRepository.save(new Gerecht("Pompoensoep", 1d, "SOEP"));
            gerechtenRepository.save(new Gerecht("Cordon Blue", 4.2d, "DAGSCHOTEL"));
            gerechtenRepository.save(new Gerecht("Konijn met pruimen", 4.2d, "DAGSCHOTEL"));
            gerechtenRepository.save(new Gerecht("Groentenlasange", 4d, "VEGGIE"));
            gerechtenRepository.save(new Gerecht("Veggie pasta", 4d, "VEGGIE"));
            gerechtenRepository.save(new Gerecht("Gerecht rm me", 10d, "DAGSCHOTEL"));

            dagMenuRepository.save(new DagMenu(LocalDate.of(2019, 2, 18), gerechtenRepository.findByBeschrijving("Bloemkool soep"), gerechtenRepository.findByBeschrijving("Cordon Blue"), gerechtenRepository.findByBeschrijving("Veggie pasta")));
            dagMenuRepository.save(new DagMenu(LocalDate.of(2019, 2, 19), gerechtenRepository.findByBeschrijving("Tomatensoep"), gerechtenRepository.findByBeschrijving("Konijn met pruimen"), gerechtenRepository.findByBeschrijving("Groentenlasange")));
        };
    }
}
