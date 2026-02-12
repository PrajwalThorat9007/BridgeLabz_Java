package linkedlist;

/*
Problem Statement:
Implement a round-robin CPU scheduling algorithm using a circular linked list.
Each node represents a process with Process ID, Burst Time, and Priority.

Functionalities:
- Add a new process at the end of the circular list.
- Remove a process by Process ID after execution.
- Simulate round-robin scheduling with fixed time quantum.
- Display the circular queue after each round.
- Calculate and display average waiting time and turnaround time.
*/

class RoundRobinScheduler {

    // Node class representing a process
    static class Process {
        int processId;
        int burstTime;
        int remainingTime;
        int priority;
        int waitingTime = 0;
        int turnaroundTime = 0;
        Process next;

        Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
        }
    }

    private Process tail = null;

    // Add process at end of circular list
    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);

        if (tail == null) {
            tail = newProcess;
            tail.next = tail;
        } else {
            newProcess.next = tail.next;
            tail.next = newProcess;
            tail = newProcess;
        }
    }

    // Remove process by ID
    private void removeProcess(Process prev, Process current) {
        if (current == tail && current == tail.next) {
            tail = null;
        } else {
            prev.next = current.next;
            if (current == tail) {
                tail = prev;
            }
        }
    }

    // Display circular queue
    public void displayQueue() {
        if (tail == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Process temp = tail.next;
        do {
            System.out.print("[P" + temp.processId +
                    " BT:" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println();
    }

    // Simulate Round Robin Scheduling
    public void simulate(int timeQuantum) {

        if (tail == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        Process current = tail.next;

        while (tail != null) {

            Process prev = tail;
            current = tail.next;

            do {
                if (current.remainingTime > 0) {

                    if (current.remainingTime > timeQuantum) {
                        current.remainingTime -= timeQuantum;
                        currentTime += timeQuantum;
                    } else {
                        currentTime += current.remainingTime;
                        current.remainingTime = 0;
                        current.turnaroundTime = currentTime;
                        current.waitingTime =
                                current.turnaroundTime - current.burstTime;

                        totalWaitingTime += current.waitingTime;
                        totalTurnaroundTime += current.turnaroundTime;
                        processCount++;

                        removeProcess(prev, current);
                        if (tail == null) break;
                        current = prev.next;
                        continue;
                    }
                }

                prev = current;
                current = current.next;

            } while (current != tail.next && tail != null);

            displayQueue();
        }

        System.out.println("Average Waiting Time: " +
                (double) totalWaitingTime / processCount);

        System.out.println("Average Turnaround Time: " +
                (double) totalTurnaroundTime / processCount);
    }

    // Main method
    public static void main(String[] args) {

        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        System.out.println("Initial Queue:");
        scheduler.displayQueue();

        int timeQuantum = 3;
        System.out.println("Simulating Round Robin with Time Quantum = " + timeQuantum);

        scheduler.simulate(timeQuantum);
    }
}

