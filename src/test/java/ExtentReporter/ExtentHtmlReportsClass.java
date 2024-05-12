package ExtentReporter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentHtmlReportsClass implements ITestListener {
	ExtentSparkReporter html;
	ExtentReports report;
	ExtentTest test;
	public void configureReport() {
		html=new ExtentSparkReporter("ExtentReportUtillity.html");
		report=new ExtentReports();
		report.attachReporter(html);
		
		report.setSystemInfo("Machine","Personal");
		report.setSystemInfo("OS","Mac");
		report.setSystemInfo("Machine","Personal");
		report.setSystemInfo("Browser","Safari/Chrome");
		report.setSystemInfo("User","Amit kumar");
		
		html.config().setDocumentTitle("Extent Listener Report");
		html.config().setReportName("Checking Basic");
		html.config().setTheme(Theme.DARK);
		
	}
	
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("On Start Method...");
	}

	public void onTestFailure(ITestResult Result) {
	 test=	report.createTest(Result.getName());
	 test.log(Status.FAIL,MarkupHelper.createLabel("Name of test case failed" +Result.getName(), ExtentColor.RED));
		System.out.println("On Failure Method..." + Result.getName());
	}	
	public void onTestSkipped(ITestResult Result) {
		test=	report.createTest(Result.getName());
		 test.log(Status.SKIP,MarkupHelper.createLabel("Name of test case failed" +Result.getName(), ExtentColor.YELLOW));
		System.out.println("On Skipped Method..." +Result.getName());
									
	}
	public void onTestStart(ITestResult Result) {
		System.out.println("On Start Test Method..." +Result.getName());
	}
	public void onTestSuccess(ITestResult Result) {	
		test=	report.createTest(Result.getName());
		 test.log(Status.PASS,MarkupHelper.createLabel("Name of test case failed" +Result.getName(), ExtentColor.GREEN));
	System.out.println("On Test Success Method..." +Result.getName());
	}
	public void onFinish(ITestContext Result) {
		report.flush();
		System.out.println("On Finished Test Method..." +Result.getName());
	}

	

}
//