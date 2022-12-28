package job;

import org.quartz.*;

public class DumbJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("JOB_SAYS");
        float myFloatValue = dataMap.getFloatValue("MY_FLOAT_VALUE");

        System.out.println("Instance [" + key + "] of DumbJob says: " + jobSays + " & " + myFloatValue);
    }
}
