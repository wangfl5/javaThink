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
		Scheduler sd = StdSchedulerFactory.getDefaultScheduler();//�������������
		JobDetail jd = JobBuilder.newJob(HelloQuartz.class)
						.withIdentity("helloworldJob", "DefaultGroup")
						.usingJobData("count", 0)
						.build();//����job����
		Trigger st = TriggerBuilder.newTrigger().withIdentity("helloworldTrigger", "DefaultGroup")    ////����������
		.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(1)    //1s���
					.repeatForever()              //�����ظ�
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
