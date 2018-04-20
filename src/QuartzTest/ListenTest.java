package QuartzTest;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class ListenTest implements JobListener{

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext arg0) {
		JobDetail jd= arg0.getJobDetail();
		System.out.println(jd.getJobDataMap().getInt("count"));
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext arg0) {
		System.out.println(this.getName()+"job To Be Executed");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext arg0,
			JobExecutionException arg1) {
		System.out.println(arg0.getTrigger().getKey());
	}
	
}
