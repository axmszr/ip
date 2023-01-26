package cbot.task;

import cbot.time.TimeStuff;

import java.time.LocalDateTime;

/**
 * Task with a start and end time. Stores the description of the task, whether it has been completed or not,
 * and the start and end.
 *
 * @see Task
 * @see Deadline
 */
public class Event extends Task {
    private final LocalDateTime fromTime;
    private final LocalDateTime toTime;
    
    public static final String EVENT_SYMBOL = "E";

    /**
     * Constructs a task with the given description, completion status, start datetime, and end datetime.
     *
     * @param desc The task description.
     * @param isDone Whether the task is done.
     * @param fromTime The start datetime.
     * @param toTime The end datetime.
     */
    public Event(String desc, boolean isDone, LocalDateTime fromTime, LocalDateTime toTime) {
        super(desc, isDone);
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    /**
     * Constructs a not-yet-done task with the given description, start datetime, and end datetime.
     *
     * @param desc The task description.
     * @param fromTime The start datetime.
     * @param toTime The end datetime.
     */
    public Event(String desc, LocalDateTime fromTime, LocalDateTime toTime) {
        super(desc);
        this.fromTime = fromTime;
        this.toTime = toTime;
    }
    
    public String getSymbol() {
        return EVENT_SYMBOL;
    }
    
    @Override
    public boolean hasTime() {
        return true;
    }
    
    @Override
    public LocalDateTime getTime() {
        return this.fromTime;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s - %s)",
                super.toString(), TimeStuff.text(this.fromTime), TimeStuff.text(this.toTime));
    }
    
    @Override
    public String makeFileFriendly() {
        return String.format("%s%s%s%s%s",
                super.makeFileFriendly(), SEP, this.fromTime, SEP, this.toTime);
    }
}