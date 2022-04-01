package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.tests.Employee;
import selenium.tests.TablePage;

import java.util.List;

public class TableTest extends BaseTest {

    @DisplayName("Sort and Search test.")
    @Test
    void sortAndSearchTest() {
        TablePage tablePage = new TablePage(driver);
        tablePage.GoToURL();
        tablePage.selectEntriesCount(10);
        List<Employee> list = tablePage.selectEntries(20, 200000);

        Assertions.assertNotNull(list);

        for (Employee e : list) {
            System.out.println(e.toString());
        }

    }
}