package com.amazonassignment.util;




import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			
			//To generate the report file name associated with time stamp
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			String reportPath = AmazonWebsiteConstants.REPORTS_PATH+fileName;
 
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}
}
