
package unisync.model;

import java.util.ArrayList;
import java.util.List;


public class StudentData {

    private List<Course> courses;
    private List<AcademicTask> tasks;
    private List<Commitment> commitments;

    public StudentData() {
        courses = new ArrayList<>();
        tasks = new ArrayList<>();
        commitments = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addTask(AcademicTask task) {
        tasks.add(task);
    }

    public void addCommitment(Commitment commitment) {
        commitments.add(commitment);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public List<AcademicTask> getTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Commitment> getCommitments() {
        return new ArrayList<>(commitments);
    }
}
