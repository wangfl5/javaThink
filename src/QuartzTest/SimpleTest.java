package QuartzTest;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTest {
	private static Logger logger = LoggerFactory.getLogger(SimpleTest.class);
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		Date triggerStartTime = new Date();
		Scheduler sd = StdSchedulerFactory.getDefaultScheduler();//创建任务调度器
		JobDetail jd = JobBuilder.newJob(HelloQuartz.class)
						.withIdentity("helloworldJob", "DefaultGroup")
						.usingJobData("count", 0)
						.build();//创建job任务
		JobDetail jd2 = JobBuilder.newJob(HelloQuartz.class)
				.withIdentity("helloworldJob2", "DefaultGroup")
				.usingJobData("count", 100)
				.build();//创建job任务
		//SimpleTrigger
		Trigger st = TriggerBuilder.newTrigger().withIdentity("helloworldTrigger", "DefaultGroup")    ////创建触发器
		.startAt(triggerStartTime)
		.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(1)    //1s间隔
					.repeatForever()              //永久重复
					)
		.build();
		//CronTrigger
		Trigger st2 = TriggerBuilder.newTrigger().withIdentity("helloworldTrigger2", "DefaultGroup")    ////创建触发器
				.startAt(triggerStartTime)
				.withSchedule(CronScheduleBuilder.cronSchedule("0-20 * * * * ?"))
				.build();
		sd.getListenerManager().addJobListener(new ListenTest(), EverythingMatcher.allJobs());
		sd.scheduleJob(jd, st);
		sd.scheduleJob(jd2, st2);
		System.out.println("start scheduleJob");
		logger.info("start scheduleJob");
		sd.start();
		//Thread.sleep(10000);
		//sd.shutdown();
		//logger.info("stop scheduleJob");
		//System.out.println("stop scheduleJob");
	}

}
