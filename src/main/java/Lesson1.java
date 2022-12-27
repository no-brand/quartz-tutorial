import job.HelloJob;
import org.quartz.*;
;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class Lesson1 {
    public static void main(String[] args) throws Exception {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        JobDetail job = newJob(HelloJob.class)
                .withIdentity("HELLO_JOB", "GROUP1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("TRIGGER", "GROUP1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(30)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
    }
}
