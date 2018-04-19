package QuartzTest;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@PersistJobDataAfterExecution
public class HelloQuartz implements Job{
	private Logger logger = LoggerFactory.getLogger(HelloQuartz.class);
	private static int helloQuartzCount =0;
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		JobDetail jd = arg0.getJobDetail();
		System.out.println("Time:"+arg0.getFireTime());
		System.out.println("NextTime:"+arg0.getNextFireTime());
		System.out.println(jd.getKey());
		try {
			System.out.println("µ÷¶ÈÆ÷×´Ì¬£º"+arg0.getScheduler().isStarted());
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		logger.info("Hello World");
		System.out.println("Hello World "+(++helloQuartzCount));
		int count = jd.getJobDataMap().getInt("count");
		System.out.println(count);
		count++;
		jd.getJobDataMap().put("count", count);
	}
	
}
