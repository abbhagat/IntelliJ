import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BatchExecutor {

    public static void main(String[] args) {
        String batFilePath = "C:\\path\\to\\your\\script.bat"; // Replace with your .bat file path
        String param1 = "Value1";
        String param2 = "Another Value"; // Example with a parameter containing spaces

        try {
            // Construct the command array
            List<String> command = new ArrayList<>();
            command.add("cmd.exe"); // The command interpreter
            command.add("/c");     // Flag to execute the command and then terminate
            command.add(batFilePath);
            command.add(param1);
            command.add(param2);

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // Read output from the batch file
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("BAT Output: " + line);
            }

            // Read error output from the batch file (if any)
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println("BAT Error: " + line);
            }

            // Wait for the process to complete and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Batch file exited with code: " + exitCode);

        } catch (IOException e) {
            System.err.println("Error executing batch file: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Batch file execution interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }
}
