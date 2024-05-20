package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class VorlesungController {

    private Map<Integer, Vorlesung> vorlesungen = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.vorlesungen.put(1, new Vorlesung(1, "Software Engineering", "Lernen Sie, wie man qualitativ hochwertige Software entwickelt", "Prof. Dr. Müller"));
        this.vorlesungen.put(2, new Vorlesung(2, "Netzwerke", "Einführung in die Grundlagen von Netzwerken", "Prof. Dr. Schmidt"));
    }

    @GetMapping("/services/vorlesung")
    public List<PathListEntry<Integer>> vorlesung() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var vorlesung : this.vorlesungen.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(vorlesung.getId(), "vorlesungKey");
            entry.setName(vorlesung.getName());
            entry.setDozent(vorlesung.getDozent());
            entry.getDetails().add(vorlesung.getDescription());
            entry.setTooltip(vorlesung.getDescription());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/vorlesung/{key}")
    public Vorlesung getVorlesung(@PathVariable Integer key) {
        return this.vorlesungen.get(key);
    }

    @PostMapping("/services/vorlesung")
    public void createVorlesung(@RequestBody Vorlesung vorlesung) {
        int newId = this.vorlesungen.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        vorlesung.setId(newId);
        this.vorlesungen.put(newId, vorlesung);
    }

    @PutMapping("/services/vorlesung/{id}")
    public void createVorlesung(@PathVariable Integer id, @RequestBody Vorlesung vorlesung) {
        vorlesung.setId(id);
        this.vorlesungen.put(id, vorlesung);
    }

    @DeleteMapping("/services/vorlesung/{id}")
    public Vorlesung deleteVorlesung(@PathVariable Integer id) {
        return this.vorlesungen.remove(id);
    }
}
