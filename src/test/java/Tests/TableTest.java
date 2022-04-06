package Tests;

import Pages.Employee;
import Pages.EmployeeAll;
import Pages.TablePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

    public class TableTest extends BaseTest {

        @Test
        public void selectDataFromTable() {
            TablePage tablePage = new TablePage(driver);
            tablePage.goToUrl();
            tablePage.selectEntriesCount();
            List<EmployeeAll> allInfoAboutEmployee = tablePage.getInfoFromAllPages();
            List<Employee> selectedEmployees = tablePage.selectEmployeeByAgeAndSalary(allInfoAboutEmployee);
            List<Employee> expectedSelectedEmployee = new ArrayList<>();
            expectedSelectedEmployee.add(new Employee("A. Cox", "Junior Technical Author", "San Francisco"));
            expectedSelectedEmployee.add(new Employee("A. Satou", "Accountant", "Tokyo"));
            expectedSelectedEmployee.add(new Employee("B. Greer", "Software Engineer", "London"));
            expectedSelectedEmployee.add(new Employee("G. Joyce", "Developer", "Edinburgh"));
            expectedSelectedEmployee.add(new Employee("G. Winters", "Accountant", "Tokyo"));
            expectedSelectedEmployee.add(new Employee("H. Chandler", "Sales Assistant", "San Francisco"));
            expectedSelectedEmployee.add(new Employee("M. House", "Integration Specialist", "Sidney"));
            expectedSelectedEmployee.add(new Employee("M. Silva", "Marketing Designer", "London"));
            expectedSelectedEmployee.add(new Employee("S. Burks", "Developer", "London"));
            Assertions.assertEquals(expectedSelectedEmployee, selectedEmployees);
        }

    }


