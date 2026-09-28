package utilities;

public class ReportUtil {

    public static void logStep(String message) {

        System.out.println("[STEP] " + message);

        if (TestListener.getExtentTest() != null) {
            TestListener.getExtentTest().info(message);
        } else {
            System.out.println("[WARNING] ExtentTest is NULL");
        }
    }
}