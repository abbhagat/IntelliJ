import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BatchExecutor {

    public static void main(String[] args) {
        // Path to your BAT file (update this)
        String batFilePath = "C:\\path\\to\\runApp.bat";

        // JVM options (example)
        String jvmOption1 = "-Dspring-config-profile=dev";
        String jvmOption2 = "-DchannelConfigPath=abc";
        String jvmOption3 = "-Dlogging.level=DEBUG";

        // Main class arguments (example)
        String mainArg1 = "MyMainClass";
        String mainArg2 = "cometJobName";
        String mainArg3 = "extraParam";

        executeBatFile(batFilePath, jvmOption1, jvmOption2, jvmOption3, mainArg1, mainArg2, mainArg3);
    }

    public static void executeBatFile(String batFilePath,
                                      String jvmOption1, String jvmOption2, String jvmOption3,
                                      String mainArg1, String mainArg2, String mainArg3) {
        try {
            // Combine JVM options and class arguments
            String jvmOptions = String.join(" ", jvmOption1, jvmOption2, jvmOption3);
            String mainArgs = String.join(" ", mainArg1, mainArg2, mainArg3);

            // Full command to execute the .bat script
            String command = String.format("\"%s\" %s %s", batFilePath, jvmOptions, mainArgs);

            System.out.println("Executing command: " + command);

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
            builder.redirectErrorStream(true);

            Process process = builder.start();

            // Capture and print output from the BAT file
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("BAT file executed with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
