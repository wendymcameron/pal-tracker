package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository{

    private static InMemoryTimeEntryRepository timeEntryRepository = null;

    private TimeEntry timeEntry;
    private List<TimeEntry> items = new ArrayList<>();

    public TimeEntry create(TimeEntry timeEntry) {
        this.items.add(timeEntry);
        return this.items.get(this.items.size() - 1);
    }

    @Override
    public TimeEntry find(Long id) {
            long resultId = 0;
            if (this.items.isEmpty() || id > this.items.size() - 1 ) {
                return null;
            } else {
                return this.items.get(id.intValue());
            }
    }

    @Override
    public List<TimeEntry> list() {

        return (List<TimeEntry>)  items;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry result = null;
        for (TimeEntry a : this.items) {
            if (a.getId() == id) {
                result = a;

            }
        }
        if (result != null) {
            this.items.remove(result);
            timeEntry.setId(id);
            items.add(timeEntry);
        }
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
        TimeEntry result = null;
        for (TimeEntry a : this.items) {
            if (a.getId() == id) {
                result = a;

            }
        }
        if (result != null){
            this.items.remove(result);
        }

    }

    public InMemoryTimeEntryRepository() {
        timeEntryRepository = this;
    }

    public static InMemoryTimeEntryRepository getInstance() {
        if (timeEntryRepository == null) {
            timeEntryRepository = new InMemoryTimeEntryRepository();
        }
        return timeEntryRepository;
    }
}
