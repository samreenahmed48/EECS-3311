
package unisync.model;

import java.time.LocalDateTime;

public class StudySession {

    private String taskTitle;
    private String courseCode;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public StudySession(String taskTitle, String courseCode,
                        LocalDateTime startTime, LocalDateTime endTime) {
        this.taskTitle = taskTitle;
        this.courseCode = courseCode;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return taskTitle + " (" + courseCode + ")"
                + " | Start: " + startTime
                + " | End: " + endTime;
    }
}
