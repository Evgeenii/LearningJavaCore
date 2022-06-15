package lesson3.hard;

public class Employee {
    private String employeeName;
    private int destroyedBottles;

    public Employee(String employee, int destroyedBottles) {
        this.employeeName = employee;
        this.destroyedBottles = destroyedBottles;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getDestroyedBottles() {
        return destroyedBottles;
    }

    public void setDestroyedBottles() {
        this.destroyedBottles = destroyedBottles + 1;
    }

}


