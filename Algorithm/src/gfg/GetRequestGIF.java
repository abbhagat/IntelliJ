package gfg;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GetRequestGIF {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();
        OutputStream os = null;
        String data = readFile(filename);
        String resultFileName = "gifs_" + filename;
        try {
            os = new FileOutputStream(new File(resultFileName), true);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            System.out.println("Exception occurred with " + e.getMessage());
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                System.out.println("Exception occurred with " + e.getMessage());
            }
        }
    }

    private static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        Set<String> set = new HashSet<>();
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(" ");
                String tempRes = temp[6];
                String lastWord = tempRes.substring(tempRes.lastIndexOf("/") + 1);
                if ((lastWord.contains(".gif") || lastWord.contains(".GIF")) && temp[8].equals("200")) {
                    set.add(lastWord);
                }
                line = br.readLine();
            }
            for (String s : set) {
                sb.append(s);
                sb.append("\n");
            }
            System.out.println(sb);
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
