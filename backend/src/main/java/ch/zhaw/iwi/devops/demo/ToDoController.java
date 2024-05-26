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
class ToDoController {

    private Map<Integer, ToDo> todos = new HashMap<Integer, ToDo>();

    @EventListener(ApplicationReadyEvent.class)
    void init() {
        this.todos.put(1,new ToDo(1, "Neuer Job", "5 DevOps Engineers einstellen"));
        this.todos.put(2,new ToDo(2, "Geschäftsleitung", "Mit Präsentation von DevOps überzeugen"));
        this.todos.put(3,new ToDo(3, "Unit Tests", "Neues Projekt mit Unit Tests starten"));
        this.todos.put(4,new ToDo(4, "Deployment", "Jede Woche!"));
        this.todos.put(5,new ToDo(5, "Organigramm", "Löschen"));
        System.out.println("Init Data");
    }

    @GetMapping("/test")
    String test() {
        return "ToDo app is up and running!";
    }

    @GetMapping("/services/ping")
    String ping() {
        String languageCode = "de";
        return "{ \"status\": \"ok\", \"userId\": \"admin"+ "\", \"languageCode\": \"" + languageCode + "\",\"version\": \"0.0.1" + "\"}";
    }

    @GetMapping("/count")
    int count() {
        return this.todos.size();
    }

    @GetMapping(value = "/services/todo", produces = "application/json")
    List<PathListEntry<Integer>> todo() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var todo : this.todos.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(todo.getId(), "todoKey");
            entry.setName(todo.getTitle());
            entry.getDetails().add(todo.getDescription());
            entry.setTooltip(todo.getDescription());
            result.add(entry);
        }
        return result;
    }

    @GetMapping(value = "/services/todo/{key}", produces = "application/json")
    ToDo getTodo(@PathVariable Integer key) {
        return this.todos.get(key);
    }

    @PostMapping(value = "/services/todo", consumes = "application/json", produces = "application/json")
    void createTodo(@RequestBody ToDo todo) {
        var newId = this.todos.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        todo.setId(newId);
        this.todos.put(newId, todo);
    }

    @PutMapping(value = "/services/todo/{id}", consumes = "application/json", produces = "application/json")
    void createTodo(@PathVariable Integer id, @RequestBody ToDo todo) {
        todo.setId(id);
        this.todos.put(id, todo);
    }

    @DeleteMapping(value = "/services/todo/{key}", produces = "application/json")
    ToDo deleteTodo(@PathVariable Integer key) {
        return this.todos.remove(key);
    }


}
