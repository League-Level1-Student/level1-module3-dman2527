package _03_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
	private Icon loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return icon;
	}
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	Song comeAndGo = new Song("comeandgo.mp3");
	Song nascarRacer = new Song("nascarracer.mp3");
	public void run() {

		// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3

		// 3. Play the Song

		/*
		 * 4. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
    	JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	JLabel label = new JLabel();
    	JLabel labelbutton1 = new JLabel();
    	frame.add(panel);
    	panel.add(label);
    	panel.add(button1);
    	panel.add(button2);
    	label.setText("Song Player");
    	panel.add(labelbutton1);
    	button1.setIcon(loadImage("download.jpeg"));
    	button2.setIcon(loadImage("download1.jpeg"));
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	frame.pack();
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(button1 == e.getSource()) {
			System.out.println("come and go");
			nascarRacer.stop();
			comeAndGo.play();
		}
		if(button2 == e.getSource()) {
			comeAndGo.stop();
			nascarRacer.play();
			System.out.println("Nascar Racer");
		}
	}
    
    
	/* Use this method to add album covers to your Panel. */
	

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

