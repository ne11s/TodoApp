package org.example.service;

import org.example.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoServiceImpl implements TodoService{
    private static Map<Integer,Todo> todoList= new HashMap<>();
    @Override
    public List<Todo> getAll() {
        return todoList.values().stream().toList();
    }

    @Override
    public Todo getById(int id) {
        return todoList.get(id);
    }

    @Override
    public void add(String name, String description) {
        Todo todo = new Todo(name,description);
        todoList.put(todo.getId(),todo);
    }

    @Override
    public void update(int id, String name, String description, boolean done) {
        todoList.get(id).setDone(done);
        todoList.get(id).setDescription(description);
        todoList.get(id).setName(name);
    }

    @Override
    public void remove(int id) {
        todoList.remove(id);
    }

    @Override
    public void toggleDone(int id) {
        todoList.get(id).setDone(!todoList.get(id).isDone());
    }
    public List<Todo> justNotDone(){
        List<Todo> todoListNotDone = new ArrayList<>();
        for (Todo t : todoList.values()) {
            if (!t.isDone()) {
                 todoListNotDone.add(t);
            }
        }
        return todoListNotDone;
    }

}
