package _07_cow_timer;

import javax.swing.JOptionPane;

public class CowTimerRunner {
	public static void main(String[] args) throws InterruptedException {
		/* Make a CowTimer, set its time and start it.
		 * Use a short delay (seconds) when testing, then try with longer delays */
CowTimer cowtimer = new CowTimer(3);
String minutesstring = JOptionPane.showInputDialog("How many minutes should the timer be set to?");
int minutes = Integer.parseInt(minutesstring);
cowtimer.setTime(minutes);
cowtimer.start();
	}
}
