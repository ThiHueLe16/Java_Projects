package pgdp.calendar;

public class EventList {
    private Event event;
    private EventList next;

    public EventList(Event event) {
        this.event = event;
    }

    protected EventList(Event termin, EventList next) {
        this.event = termin;
        this.next = next;
    }

    public Event getEvent() {
        return event;
    }

    public EventList getNext() {
        return next;
    }

    public EventList add(Event termin) {
        return new EventList(termin, this);
    }
}
