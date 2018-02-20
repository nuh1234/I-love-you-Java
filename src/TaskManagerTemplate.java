
import static java.lang.Thread.sleep;

import java.util.*;
import java.util.Queue;

public class TaskManagerTemplate {

    public static Queue<String> taskNames = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        ProcessQueue processes = new ProcessQueue();
        Process task = makeRandomTask();
        taskNames.add(task.name);
        processes.add(task);
        processes.add(new Process("Task2", (long) (Math.random() * 100000L), 2000L));
        processes.add(new Process("Task3", (long) (Math.random() * 100000L), 1000L));
        processes.add(new Process("Task4", (long) (Math.random() * 100000L), 500L));
        processes.add(new Process("Task5", (long) (Math.random() * 100000L), 500L));
        processes.add(new Process("Task6", (long) (Math.random() * 100000L), 1000L));
        processes.add(new Process("Task7", (long) (Math.random() * 100000L), 1500L));
        
        manageTasks(processes, 30000);
    }

    public static void manageTasks(ProcessQueue processes, int msecs) throws InterruptedException {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < msecs) {
            runProcess(processes.current());
            processes.change();
            maybeAddOrKill(processes);
        }
    }

    public static void maybeAddOrKill(ProcessQueue processes) {
        //System.out.println(processes.size() + " before: " + processes);
        double rnd = Math.random();
        if (rnd > 0.5) {
            Process newTask = makeRandomTask();
            System.out.println("Adding task " + newTask.name);
            processes.add(newTask);
            taskNames.add(newTask.name);
        } else if (rnd < 0.3) {
            String taskName = taskNames.peek();
            if (processes.kill(taskName)) {
                System.out.println("Killed " + taskName);
                taskNames.remove();
            } else {
                System.out.println("Did not kill " + taskName);
            }

        }
        //System.out.println(processes.size() + " after: " + processes);
    }

    public static Process makeRandomTask() {
        String taskName = "Task" + (int) (Math.random() * 100);
        return new Process(taskName, (long) (Math.random() * 100000L), (long) (Math.random() * 5 + 1) * 250L);
    }

    public static void runProcess(Process task) throws InterruptedException {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < task.duration) {
            System.out.println(task.name + ":" + task.duration + "   " + (System.currentTimeMillis() - start));
            sleep(250);
        }

    }
}

