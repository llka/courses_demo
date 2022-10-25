package ru.ilka.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {

    String title;
    Date startDate;
    EventRealm realm;
    List<Attendee> attendees;

    @Override
    public String toString() {
        return "Event{" +
            "title='" + title + '\'' +
            ", startDate=" + startDate +
            ", realm=" + realm +
            ", attendees=" + attendees.stream().map(Attendee::toString).collect(Collectors.joining("\n")) +
            '}';
    }
}
