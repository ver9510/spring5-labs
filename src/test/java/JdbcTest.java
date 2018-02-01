import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:jdbc.xml")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JdbcTest {

    @Autowired
    private CountryDao countryDao;

    private List<Country> expectedCountryList = new ArrayList<Country>();
    private List<Country> expectedCountryListStartsWithA = new ArrayList<Country>();
    private Country countryWithChangedName = new SimpleCountry(
            8,
            "Russia",
            "RU");

    @BeforeAll
    void setUp() throws Exception {
        initExpectedCountryLists();
    }

    @BeforeEach
    void setUpDao() throws Exception {
        countryDao.loadCountries();
    }


    @Test
    @DirtiesContext
    void testCountryList() {
        List<Country> countryList = countryDao.getCountryList();
        assertNotNull(countryList);
        assertEquals(expectedCountryList.size(), countryList.size());
        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }

    @Test
    @DirtiesContext
    void testCountryListStartsWithA() {
        List<Country> countryList = countryDao.getCountryListStartWith("A");
        assertNotNull(countryList);
        assertEquals(expectedCountryListStartsWithA.size(), countryList.size());
        for (int i = 0; i < expectedCountryListStartsWithA.size(); i++) {
            assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
        }
    }

    @Test
    @DirtiesContext
    void testCountryChange() {
        countryDao.updateCountryName("RU", "Russia");
        Country ru = countryDao.getCountryByCodeName("RU");
        assertEquals(countryWithChangedName, ru);
    }

    private void initExpectedCountryLists() {
        for (int i = 0; i < CountryDao.COUNTRY_INIT_DATA.length; i++) {
            String[] countryInitData = CountryDao.COUNTRY_INIT_DATA[i];
            Country country = new SimpleCountry(i + 1, countryInitData[0], countryInitData[1]);
            expectedCountryList.add(country);
            if (country.getName().startsWith("A")) {
                expectedCountryListStartsWithA.add(country);
            }
        }
    }
}