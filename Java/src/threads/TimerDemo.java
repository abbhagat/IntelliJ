package threads;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerDemo {

    public static void main(String[] args) throws InterruptedException {
        Timer timer;
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println(ae);
            }
        };
        timer = new Timer(100, System.out::println);
        timer.start();
        Thread.sleep(1000);
        timer.stop();
    }
}
