package Tools.TaskScheduling;

import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: TaskScheduling
 * Description:
 * Author Inamikanju
 * Create 2023/11/15 16:49
 * Version 1.0
 */
class Task {
    int id;           // 任务标识符
    int deadline;     // 截止时间
    int penalty;      // 惩罚值

    Task(int id, int deadline, int penalty) {
        this.id = id;
        this.deadline = deadline;
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "a" + id;
    }
}

public class TaskScheduling {
    public static void taskScheduling(List<Task> tasks) {
        //根据惩罚值降序对任务进行排序
        tasks.sort((task1, task2) -> task2.penalty - task1.penalty);

        //找到所有任务中的最大截止时间
        int maxDeadline = 0;
        for (Task task : tasks) {
            maxDeadline = Math.max(maxDeadline, task.deadline);
        }

        //taskList[i]用来存储deadline<=i的任务
        List<Task>[] taskList = new ArrayList[maxDeadline + 1];
        for (int i = 1; i <= maxDeadline; i++) {
            taskList[i] = new ArrayList<Task>();
        }

        List<Task> scheduleTask = new ArrayList<>();
        List<Task> delayTask = new ArrayList<>();
        int totalPenalty = 0;

        //安排任务
        for (Task task : tasks) {
            boolean flag = true;
            for (int i = task.deadline; i <= maxDeadline; i++) {
                taskList[i].add(task);
                if (taskList[i].size() > i) {
                    //如果拒绝，则将其标记为延迟，并更新惩罚值
                    flag = false;
                    delayTask.add(task);
                    totalPenalty += task.penalty;
                    break;
                }
            }
            //如果任务延迟，将修改过的taskList[i]改回原状
            if (!flag) {
                for (int i = task.deadline; i <= maxDeadline; i++) {
                    taskList[i].remove(task);
                }
            } else {
                //如果任务安排成功，将其添加到已安排任务列表中
                scheduleTask.add(task);
            }
        }

        System.out.print("提前任务：");
        System.out.println(scheduleTask);
        System.out.print("延迟任务：");
        System.out.print(delayTask);
        System.out.println(" 总惩罚为：" + totalPenalty);

        scheduleTask.addAll(delayTask);
        System.out.print("最优调度为：");
        System.out.println(scheduleTask);
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 4, 0));
        tasks.add(new Task(2, 2, 10));
        tasks.add(new Task(3, 4, 20));
        tasks.add(new Task(4, 3, 30));
        tasks.add(new Task(5, 1, 40));
        tasks.add(new Task(6, 4, 50));
        tasks.add(new Task(7, 6, 60));

        taskScheduling(tasks);
    }
}
