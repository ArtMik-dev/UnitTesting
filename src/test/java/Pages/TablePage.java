package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {

    private final String url = "https://demo.seleniumeasy.com/table-sort-search-demo.html";

    @FindBy(css = "select[name = 'example_length']")
    WebElement selectEntriesCountElement;

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> tableRowElements;

    @FindBy(xpath = "//a[@class = 'paginate_button next']")
    WebElement nextButton;

    private final String tableElementFormat = "//table/tbody/tr[%s]/%s";

    public TablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return url;
    }

    public void selectEntriesCount() {
        By showEntries = By.cssSelector("select[name = 'example_length']");
        Select numberOfRowsDropdown = new Select(driver.findElement(showEntries));
        numberOfRowsDropdown.selectByValue("10");
    }

    public List<WebElement> tableRowElements() {
        List<WebElement> allInfo = driver.findElements(By.xpath(".//tbody//tr"));
        return allInfo;
    }

    public List<EmployeeAll> getEmployeeInfo(List<WebElement> allInfo) {
        List<EmployeeAll> employeeAllInfo = new ArrayList<>();
        for (WebElement employeeInfo : allInfo) {
            String name = employeeInfo.findElement(By.xpath("./td[1]")).getText();
            String position = employeeInfo.findElement(By.xpath("./td[2]")).getText();
            String office = employeeInfo.findElement(By.xpath("./td[3]")).getText();
            int age = Integer.parseInt(employeeInfo.findElement(By.xpath("./td[4]")).getText());
            String startDate = employeeInfo.findElement(By.xpath("./td[5]")).getText();
            String salaryString = employeeInfo.findElement(By.xpath("./td[6]")).getText();
            salaryString = salaryString.substring(1, salaryString.length() - 2).replaceAll(",", "");
            int salary = Integer.parseInt(salaryString);
            employeeAllInfo.add(new EmployeeAll(name, position, office, age, startDate, salary));
        }
        return employeeAllInfo;
    }

    public List<Employee> selectEmployeeByAgeAndSalary(List<EmployeeAll> employeeAllInfo) {
        List<Employee> selectedEmployees = new ArrayList<>();
        for (EmployeeAll employee : employeeAllInfo) {
            if (employee.getAge() > 30 && employee.getSalary() < 200000) {
                selectedEmployees.add(new Employee(employee.getName(), employee.getPosition(), employee.getOffice()));
            }
        }
        return selectedEmployees;
    }

    public List<EmployeeAll> getInfoFromAllPages() {
        TablePage tablePage = new TablePage(driver);
        List<EmployeeAll> allInfoAboutEmployee = new ArrayList<>();
        while (true) {
            List<WebElement> rows = tablePage.tableRowElements();
            List<EmployeeAll> employeeInfoFromOnePage = tablePage.getEmployeeInfo(rows);
            allInfoAboutEmployee.addAll(employeeInfoFromOnePage);
            if ((!driver.findElement(By.id("example_next")).getAttribute("class").contains("disabled"))) {
                driver.findElement(By.id("example_next")).click();
            } else break;
        }
        return allInfoAboutEmployee;
    }
}

