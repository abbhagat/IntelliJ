package gfg;

import java.util.Arrays;
import java.util.List;

public class FillingInData {

    public static void calcMissing(List<String> readings) {
        float[] data = getData(readings);
        for (int i = 0; i < data.length; i++) {
            if (data[i] == -1) {
                System.out.println(data[i]);
            }
        }
    }

    public static void main(String[] args) {
        List<String> readings = Arrays.asList("1/3/2012 16:00:00   Missing_1",
                "1/4/2012 16:00:00   27.47",
                "1/5/2012 16:00:00   27.728",
                "1/6/2012 16:00:00   28.19",
                "1/9/2012 16:00:00   28.1",
                "1/10/2012 16:00:00  28.15");
        float[] data = getData(readings);
        for (int i = 0; i < data.length; i++) {
            if (data[i] == -1) {
                System.out.println(data[i]);
            }
        }
    }

    private static float[] getData(List<String> readings) {
        float[] data = new float[readings.size()];
        for (int i = 0; i < readings.size(); i++) {
            String s = readings.get(i);
            String[] str = s.split(" ");
            data[i] = s.contains("Missing_") ? -1 : Float.parseFloat(str[str.length - 1]);
        }
        return data;
    }
}
