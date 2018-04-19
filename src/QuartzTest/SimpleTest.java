package QuartzTest;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTest {
	private static Logger logger = LoggerFactory.getLogger(SimpleTest.class);
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		Scheduler sd = StdSchedulerFactory.getDefaultScheduler();//创建任务调度器
		JobDetail jd = JobBuilder.newJob(HelloQuartz.class)
						.withIdentity("helloworldJob", "DefaultGroup")
						.usingJobData("count", 0)
						.build();//创建job任务
		Trigger st = TriggerBuilder.newTrigger().withIdentity("helloworldTrigger", "DefaultGroup")    ////创建触发器
		.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(1)    //1s间隔
					.repeatForever()              //永久重复
					)
		.build();
		sd.scheduleJob(jd, st);
		System.out.println("start scheduleJob");
		logger.info("start scheduleJob");
		sd.start();
		Thread.sleep(10000);
		sd.shutdown();
		logger.info("stop scheduleJob");
		System.out.println("stop scheduleJob");
	}

}
