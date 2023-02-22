import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MyClock extends JFrame {
	private SimpleDateFormat timeFormat, dayFormat, dateFormat;  //Format and parse dates
	private JLabel timeLabel, dayLabel, dateLabel;
	private String time, day, date;
	public MyClock() {
		this.setTitle("Clock");
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setLayout(new GridLayout(3, 1));
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");  //Check oracle website for different formats
		dayFormat = new SimpleDateFormat("EEEE");  //Check oracle website for different formats
		dateFormat = new SimpleDateFormat("MM dd, yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setPreferredSize(new Dimension(400, 75));
		timeLabel.setBackground(Color.black);
		timeLabel.setFont(new Font("Verdana", Font.BOLD, 50));
		timeLabel.setForeground(Color.green);
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Verdana", Font.BOLD, 50));
		dayLabel.setForeground(Color.green);
		dayLabel.setHorizontalAlignment(JLabel.CENTER);
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Verdana", Font.BOLD, 50));
		dateLabel.setForeground(Color.green);
		dateLabel.setBackground(Color.black);
		dateLabel.setOpaque(true);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		this.setSize(415, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		setTime();
	}
	public void setTime() {
		while(true) { 
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
