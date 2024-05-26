package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ToDoControllerTest {
    
    @Test
    void testCreate() {
        ToDoController controller = new ToDoController();
        var todo = new ToDo(1, "t", "d");
        controller.createTodo(todo);
        assertEquals(1, controller.count());
        var responseEntity = controller.todo();
        assertNotNull(responseEntity);
        var todos = responseEntity.getBody();
        assertNotNull(todos);
        
        assertEquals(1, todos.size());

    }

}
