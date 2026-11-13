
package unisync;
import java.time.LocalDate;
import unisync.model.AcademicTask;
import java.time.LocalDateTime;
import unisync.model.Commitment;
import unisync.model.StudentData;
import unisync.planner.ConflictDetector;

import java.util.List;
import unisync.model.StudySession;
import unisync.planner.WeeklyScheduler;


import unisync.model.Course;

public class Main {

    public static void main(String[] args) {

        Course course1 = new Course("EECS3311", "Software Design");

        System.out.println("Welcome to UniSync!");
        System.out.println("My course: " + course1);

        course1.setCourseName("Software Design Patterns");

        System.out.println("Updated: " + course1);
        
        System.out.println("\nAcademic Task Test:");

        AcademicTask task1 = new AcademicTask(
            "Assignment 1",
            "Assignment",
            "EECS3311",
            LocalDate.of(2026, 11, 15),
            5);

        System.out.println(task1);

        task1.markCompleted();

        System.out.println("After completion:");
        System.out.println(task1);
        
        
        System.out.println("\nCommitment Test:");

        Commitment work = new Commitment(
            "Part-time Job",
            "Work",
            LocalDateTime.of(2026, 11, 16, 16, 0),
            LocalDateTime.of(2026, 11, 16, 20, 0));

        System.out.println(work);
        

		System.out.println("\nStudent Data Test:");
		
		StudentData studentData = new StudentData();
		
		studentData.addCourse(course1);
		studentData.addTask(task1);
		studentData.addCommitment(work);
		
		System.out.println("Courses: " + studentData.getCourses());
		System.out.println("Tasks: " + studentData.getTasks());
		System.out.println("Commitments: " + studentData.getCommitments());
		

		System.out.println("\nConflict Detection Test:");
		
		Commitment club = new Commitment(
		    "Club Meeting",
		    "Extracurricular",
		    LocalDateTime.of(2026, 11, 16, 17, 0),
		    LocalDateTime.of(2026, 11, 16, 19, 0));
		
		ConflictDetector detector = new ConflictDetector();
		
		System.out.println("Work and Club conflict: "
		        + detector.hasConflict(work, club));


		System.out.println("\nWeekly Study Schedule Test:");
		
		// Add an incomplete assignment to our existing student data.
		AcademicTask task2 = new AcademicTask(
		        "Assignment 2",
		        "Assignment",
		        "EECS3311",
		        LocalDate.of(2026, 11, 20),
		        5);
		
		studentData.addTask(task2);
		
		// Add the club meeting so the scheduler avoids it.
		studentData.addCommitment(club);
		
		// Generate a schedule for November 16–22.
		WeeklyScheduler scheduler = new WeeklyScheduler();
		
		List<StudySession> studyPlan = scheduler.generateSchedule(
		        studentData, LocalDate.of(2026, 11, 16));
		
		for (StudySession session : studyPlan) {
		    System.out.println(session);
		}


    }
}
