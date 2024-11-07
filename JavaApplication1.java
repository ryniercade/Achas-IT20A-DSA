
package javaapplication1;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class JavaApplication1 {
 private LinkedList<String> todoList;
    private LinkedList<String> completedTasks;
    private Stack<String> undoStack;

    public JavaApplication1() {
        todoList = new LinkedList<>();
        completedTasks = new LinkedList<>();
        undoStack = new Stack<>();
    }

    
    public void showMenu() {
        String[] options = {"Add Task", "Mark Task as Done", "Undo", "View To-Do List", "View Completed Tasks", "Exit"};
        int choice = JOptionPane.showOptionDialog(null,
                "Choose an action", "To-Do List Manager",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                addTask();
                break;
            case 1:
                markTaskAsDone();
                break;
            case 2:
                undo();
                break;
            case 3:
                viewTodoList();
                break;
            case 4:
                viewCompletedTasks();
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Thankyou and Goodbye!");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    
    public void addTask() {
        String task = JOptionPane.showInputDialog("Enter the task to add:");
        if (task != null && !task.trim().isEmpty()) {
            todoList.add(task);
            undoStack.push("add:" + task);
            JOptionPane.showMessageDialog(null, "Task added: " + task);
        }
    }

    
    public void markTaskAsDone() {
        if (todoList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available to mark as done.");
            return;
        }

        StringBuilder taskList = new StringBuilder();
        for (int i = 0; i < todoList.size(); i++) {
            taskList.append((i + 1)).append(". ").append(todoList.get(i)).append("\n");
        }

        String taskChoice = JOptionPane.showInputDialog(null, "Select a task to mark as done:\n" + taskList);
        if (taskChoice != null && !taskChoice.trim().isEmpty()) {
            try {
                int taskIndex = Integer.parseInt(taskChoice.trim()) - 1;
                if (taskIndex >= 0 && taskIndex < todoList.size()) {
                    String task = todoList.remove(taskIndex);
                    completedTasks.add(task);
                    undoStack.push("done:" + task);
                    JOptionPane.showMessageDialog(null, "Task marked as done: " + task);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid task number.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

   
    public void undo() {
        if (undoStack.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No actions to undo.");
            return;
        }

        String lastAction = undoStack.pop();
        if (lastAction.startsWith("add:")) {
            String task = lastAction.substring(4);
            todoList.remove(task);
            JOptionPane.showMessageDialog(null, "Task undone: " + task);
        } else if (lastAction.startsWith("done:")) {
            String task = lastAction.substring(5);
            completedTasks.remove(task);
            todoList.add(task);
            JOptionPane.showMessageDialog(null, "Task undone: " + task);
        }
    }

    
    public void viewTodoList() {
        if (todoList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Your to-do list is empty.");
        } else {
            StringBuilder list = new StringBuilder("--- To-Do List ---\n");
            for (int i = 0; i < todoList.size(); i++) {
                list.append((i + 1)).append(". ").append(todoList.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, list.toString());
        }
    }

    
    public void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks have been completed yet.");
        } else {
            StringBuilder list = new StringBuilder("--- Completed Tasks ---\n");
            for (String task : completedTasks) {
                list.append("- ").append(task).append("\n");
            }
            JOptionPane.showMessageDialog(null, list.toString());
        }
    }

    
    public void run() {
        while (true) {
            showMenu();
        }
    }

    public static void main(String[] args) {
        JavaApplication1 manager  = new JavaApplication1();
        manager.run();
    }
}
    
    
