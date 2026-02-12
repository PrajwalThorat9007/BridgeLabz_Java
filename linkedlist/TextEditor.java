package linkedlist;

/*
Problem Statement:
Design an undo/redo functionality for a text editor using a doubly linked list.
Each node represents a state of the text content.

Functionalities:
- Add a new text state at the end when user types or performs an action.
- Undo (move to previous state).
- Redo (move to next state after undo).
- Display current text state.
- Limit history to last 10 states.
*/

class TextEditor {

    // Node representing each text state
    static class State {
        String content;
        State prev;
        State next;

        State(String content) {
            this.content = content;
        }
    }

    private State head;
    private State tail;
    private State current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add new text state
    public void addState(String text) {

        State newState = new State(text);

        // If we undo and then type something new, remove forward history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
        }

        size++;

        // Limit history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! Welcome");
        editor.addState("Hello World! Welcome to Java");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello World! Welcome to Java Programming");
        editor.displayCurrentState();

        editor.redo(); // Should not redo after new state
    }
}

