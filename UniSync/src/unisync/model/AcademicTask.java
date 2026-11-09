
package unisync.model;

import java.time.LocalDate;

public class AcademicTask {

    private String title;
    private String type;
    private String courseCode;
    private LocalDate dueDate;
    private int estimatedHours;
    private boolean completed;

    public AcademicTask(String title, String type,
                        String courseCode, LocalDate dueDate,
                        int estimatedHours) {
        this.title = title;
        this.type = type;
        this.courseCode = courseCode;
        this.dueDate = dueDate;
        this.estimatedHours = estimatedHours;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return title + " (" + type + ") - " + courseCode
                + " | Due: " + dueDate
                + " | Estimated: " + estimatedHours + " hours"
                + " | Completed: " + completed;
    }
}
