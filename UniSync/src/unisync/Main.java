
package unisync;

import unisync.model.Course;

public class Main {

    public static void main(String[] args) {

        Course course1 = new Course("EECS3311", "Software Design");

        System.out.println("Welcome to UniSync!");
        System.out.println("My course: " + course1);

        course1.setCourseName("Software Design Patterns");

        System.out.println("Updated: " + course1);
    }
}
