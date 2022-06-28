package lesson7.hard.task2;

import java.util.ArrayList;
import java.util.Collections;

public class Shop {
    ArrayList<Employee> employees = new ArrayList<>();

    public Shop(Employee... employees) {
        for (Employee employee : employees) {
            Collections.addAll(this.employees, employees);
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
