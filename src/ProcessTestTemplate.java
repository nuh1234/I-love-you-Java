
public class ProcessTestTemplate {

    public static void main(String[] args) {
        System.out.println("Testing");
        Process p = new Process("test1", 0L, 1000L);
        ProcessQueue tasks = new ProcessQueue();
        report(0, tasks.size(), ".size() should be 0 after instantiation");
        tasks.add(p);
        report(1, tasks.size(), ".size() should be 1 after adding process");
        report(false, tasks.kill(p.name), ".kill() should return false if only one process in queue");
        report(1, tasks.size(), ".size() should be 1 after adding process");
        p = new Process("test2", 0L, 1000L);
        tasks.add(p);
        report(2, tasks.size(), ".size() should be 2 after adding process");
        report("test1", tasks.current().name, "current task should be task1");
        tasks.change();
        report("test2", tasks.current().name, "current task should be task2 after change()");
        tasks.change();
        report("test1", tasks.current().name, "current task should be task1 after change()");
        boolean didKill = tasks.kill("test2");
        report(true, didKill, ".kill() should return true after killing test2");
        tasks.add(p);
        report("test1", tasks.current().name, "current task should be task1 after adding test2");
        didKill = tasks.kill("test1");
        report(true, didKill, ".kill() should return true after killing test1");
        report("test2", tasks.current().name, "current task should be test2 after killing test1");
        tasks.change();
        report("test2", tasks.current().name, "current task should still be test2 after killing test1");
        
        
    }

    public static void report(int a, int b, String message) {
        if (a == b) {
            System.out.println("Passed:  " + message);
        } else {
            System.out.println("Failed:  " + message + " not " + b);
        }
    }

    public static void report(boolean a, boolean b, String message) {
        if (a == b) {
            System.out.println("Passed:  " + message);
        } else {
            System.out.println("Failed:  " + message + " not " + b);
        }
    }

    public static void report(String a, String b, String message) {
        if (a.equals(b)) {
            System.out.println("Passed:  " + message);
        } else {
            System.out.println("Failed:  " + message + " not " + b);
        }
    }
}

