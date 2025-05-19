package org.example.model;

public class PriorityTodo extends Todo {
    private Priority priority;
    public PriorityTodo(String name, String description, Priority priority ) {
        super(name, description);
        this.priority = priority;
    }
    public Priority getPriority(){
        return priority;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", done=" + (super.isDone() ? "fait" :"a faire") +
                ", priorité=" + priority +
                '}';
    }
}
