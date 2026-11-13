package unisync.planner;

import unisync.model.Commitment;

public class ConflictDetector {

    public boolean hasConflict(Commitment first,
                               Commitment second) {

        return first.getStartTime().isBefore(second.getEndTime())
            && second.getStartTime().isBefore(first.getEndTime());
    }
}