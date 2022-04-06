package Pages;

public class Employee {

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getOffice() {
        return office;
    }

    private String name;
    private String position;
    private String office;

    public Employee(String name, String position, String office){
        this.name = name;
        this.position = position;
        this.office = office;
    }

    @Override
    public String toString() {
        return String.format("Employee{",
                "name='", name,'\'',
                ", position='",position, '\'',
                ", office='", office, '\'',
                '}');
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return name.equals(that.name) &&
                position.equals(that.position) &&
                office.equals(that.office);
    }
}