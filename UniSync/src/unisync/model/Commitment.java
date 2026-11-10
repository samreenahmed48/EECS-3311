
package unisync.model;

import java.time.LocalDateTime;

public class Commitment {

    private String title;
    private String category;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Commitment(String title, String category,
                      LocalDateTime startTime,
                      LocalDateTime endTime) {
        this.title = title;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return title + " (" + category + ")"
                + " | Start: " + startTime
                + " | End: " + endTime;
    }
}
