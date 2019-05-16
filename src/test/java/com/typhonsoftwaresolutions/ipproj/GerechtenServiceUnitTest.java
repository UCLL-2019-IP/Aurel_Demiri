package com.typhonsoftwaresolutions.ipproj;

import com.typhonsoftwaresolutions.ipproj.model.Gerecht;
import com.typhonsoftwaresolutions.ipproj.model.GerechtenService;
import com.typhonsoftwaresolutions.ipproj.repository.GerechtenRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GerechtenServiceUnitTest {

    // Prevents commandlinerunner in Application.class to run
    @MockBean
    private CommandLineRunner runner;

    @Autowired
    private GerechtenService gerechtenService;

    @MockBean
    private GerechtenRepository gerechtenRepository;

    @Before
    public void setUp() {
    }

    @Test
    public void testGetGerechtbyBeschrijving() {
        Gerecht gerecht = new Gerecht("Kaas", 5d, "DAGSCHOTEL");
        Mockito.when(gerechtenRepository.findByBeschrijving(gerecht.getBeschrijving())).thenReturn(gerecht);
        assertThat(gerechtenService.findGerechtByBeschrijving(gerecht.getBeschrijving())).isEqualTo(gerecht);
    }
}
