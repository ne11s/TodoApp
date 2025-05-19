package org.example.service;

import org.example.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl implements TodoService{
    private static List<Todo> todoList= new ArrayList<>();
    @Override
    public List<Todo> getAll() {
        return todoList;
    }

    @Override
    public Todo getById(int id) {
        return todoList.get(id);
    }

    @Override
    public void add(String name, String description) {
        Todo todo = new Todo(name,description);
        todoList.add(todo);
    }

    @Override
    public void update(int id, String name, String description, boolean done) {

        for (int i = 1 ; i<todoList.size(); i++) {
            if (todoList.get(i).getId() == id) {
                Todo newtodo = todoList.get(i);
                newtodo.setName(name);
                newtodo.setDescription(description);
                newtodo.setDone(done);
                todoList.set(i, newtodo);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 1 ; i<todoList.size(); i++) {
            if (todoList.get(i).getId() == id) {
                todoList.remove(i);
            }
        }
    }

    @Override
    public void toggleDone(int id) {

        for (int i = 1 ; i<todoList.size(); i++) {
            if (todoList.get(i).getId() == id) {
                todoList.get(i).setDone(!todoList.get(i).isDone());
            }
        }
    }
}
