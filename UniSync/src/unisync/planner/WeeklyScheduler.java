
package unisync.planner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import unisync.model.AcademicTask;
import unisync.model.Commitment;
import unisync.model.StudentData;
import unisync.model.StudySession;

public class WeeklyScheduler {

    public List<StudySession> generateSchedule(
            StudentData data, LocalDate weekStart) {

        List<StudySession> sessions = new ArrayList<>();
        List<AcademicTask> tasks = data.getTasks();

        // Schedule assignments with earlier deadlines first.
        tasks.sort(Comparator.comparing(AcademicTask::getDueDate));

        LocalDate weekEnd = weekStart.plusDays(6);

        for (AcademicTask task : tasks) {

            if (task.isCompleted()) {
                continue;
            }

            int hoursRemaining = task.getEstimatedHours();

            for (LocalDate day = weekStart;
                    !day.isAfter(weekEnd)
                    && !day.isAfter(task.getDueDate())
                    && hoursRemaining > 0;
                    day = day.plusDays(1)) {

                for (int hour = 9;
                        hour < 21 && hoursRemaining > 0;
                        hour++) {

                    LocalDateTime start = LocalDateTime.of(
                            day, LocalTime.of(hour, 0));
                    LocalDateTime end = start.plusHours(1);

                    if (!hasConflict(start, end,
                            data.getCommitments(), sessions)) {

                        sessions.add(new StudySession(
                                task.getTitle(),
                                task.getCourseCode(),
                                start, end));

                        hoursRemaining--;
                    }
                }
            }
        }

        return sessions;
    }

    private boolean hasConflict(
            LocalDateTime start,
            LocalDateTime end,
            List<Commitment> commitments,
            List<StudySession> sessions) {

        for (Commitment commitment : commitments) {

            if (start.isBefore(commitment.getEndTime())
                    && commitment.getStartTime().isBefore(end)) {
                return true;
            }
        }

        for (StudySession session : sessions) {

            if (start.isBefore(session.getEndTime())
                    && session.getStartTime().isBefore(end)) {
                return true;
            }
        }

        return false;
    }
}
