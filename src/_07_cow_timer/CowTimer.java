package _07_cow_timer;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.applet.AudioClip;
import java.io.IOException;
import javax.swing.JApplet;

public class CowTimer {

	/*
	 * 1. Make a constructor for the CowTimer class that initializes the minutes
	 * variable
		
	 */
	public CowTimer(int minutes1) {
		this.minutes = minutes1;
	}

	/* 4. Complete the main method of the CowTimerRunner class */

	private int minutes;

	public void setTime(int minutes) {
		this.minutes = minutes;
		System.out.println("Cow time set to " + minutes + " minutes.");
	}

	public void start() throws InterruptedException {
		/*
		 * 2. Count down the minutes, print the current minute then sleep for the number
		 * of minutes using Thread.sleep(int milliseconds).
		 */System.out.println("Minutes Left:"+minutes+":00");
		   Thread.sleep(1000);
			for(int m=0;m<minutes;m++) {
				for(int s=59;s>-1;s--) {
					System.out.println("Minutes Left:"+((minutes-1)-m)+":"+String.format("%02d", s)); 
					Thread.sleep(1000);
			}
			
		 }
		 System.out.println("Timer Has Finished!");
		 playSound("moo.wav");

		/*
		 * 3. When the timer is finished, use the playSound method to play a moo sound.
		 * You can use the .wav file in the default package, or you can download one
		 * from freesound.org, then drag it intothe default package.
		 */

	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	static void speak(String words) {
		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
