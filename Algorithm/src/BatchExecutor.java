import java.io.*;

public class RunBatFile {
    public static void main(String[] args) {
        try {
            // Path to your .bat file
            String batFilePath = "C:\\path\\to\\yourScript.bat";

            // Main class arguments
            String fileName = "inputFile.csv";
            String cometJobName = "DailyJob";

            // VM options
            String vmOption1 = "-Dspring-config-profile=dev";
            String vmOption2 = "-DchannelConfigPath=abc";

            // Build the process command
            ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", batFilePath, vmOption1, vmOption2, fileName, cometJobName
            );

            builder.redirectErrorStream(true);

            // Start process
            Process process = builder.start();

            // Read console output from .bat execution
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Wait for process completion
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
