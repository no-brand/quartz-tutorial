import job.DumbJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class Lesson3 {
    public static void main(String[] args) throws Exception {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        JobDetail job = newJob(DumbJob.class)
                .withIdentity("DUMP_JOB", "GROUP1")
                .usingJobData("JOB_SAYS", "Hello World")
                .usingJobData("MY_FLOAT_VALUE", 3.14f)
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
