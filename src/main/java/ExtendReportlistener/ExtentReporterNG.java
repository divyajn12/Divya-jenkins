package ExtendReportlistener;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG implements IReporter {

    private ExtentReports extent;
@Test
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Initialize the ExtentReports object
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(outputDirectory + "/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Loop through the test suites and generate the report
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> results = suite.getResults();

            for (ISuiteResult result : results.values()) {
                ITestContext context = result.getTestContext();
                ExtentTest suiteTest = extent.createTest(context.getSuite().getName());

                // Log information about the test suite
                suiteTest.info("Suite Name: " + context.getSuite().getName());
                suiteTest.info("Suite Start Time: " + context.getStartDate());
                suiteTest.info("Suite End Time: " + context.getEndDate());

                // Process passed tests
                for (ITestResult passedTest : context.getPassedTests().getAllResults()) {
                    ExtentTest test = suiteTest.createNode(passedTest.getMethod().getMethodName());
                    test.pass("Test Passed");
                    // You can add logs or screenshots here if needed
                }

                // Process failed tests
                for (ITestResult failedTest : context.getFailedTests().getAllResults()) {
                    ExtentTest test = suiteTest.createNode(failedTest.getMethod().getMethodName());
                    test.fail("Test Failed");
                    test.fail(failedTest.getThrowable()); // Attach the exception stack trace
                }

                // Process skipped tests
                for (ITestResult skippedTest : context.getSkippedTests().getAllResults()) {
                    ExtentTest test = suiteTest.createNode(skippedTest.getMethod().getMethodName());
                    test.skip("Test Skipped");
                }
            }
        }

        // Write the report
        extent.flush();
    }
}
