/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 *
 * SVN revision information:
 * @id      $Id: $
 * @version $Revision: $
 * @author  $Author: $
 * @date    $Date: $
 */
package com.fenby.day09;

// 员工基类
class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return firstName + " " + lastName;
    }
}

// 合同工
class Contractor extends Employee {

    public Contractor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getUsername() {
        return super.getUsername() + " [Contractor]";
    }
}

// 永久员工
class PermanentEmployee extends Employee {

    public PermanentEmployee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getUsername() {
        return super.getUsername() + " [PermanentEmployee]";
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {

        System.out.println("Java中的继承");

        // 创建三个员工对象
        Employee e1 = new Employee("Kevin", "Lee");
        Employee e2 = new Contractor("Frank", "Wu");
        Employee e3 = new PermanentEmployee("Macy", "Zhao");

        System.out.println("Username: " + e1.getUsername());
        System.out.println("Username: " + e2.getUsername());
        System.out.println("Username: " + e3.getUsername());
    }
}
