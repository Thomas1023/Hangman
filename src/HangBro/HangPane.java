package HangBro;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangPane implements KeyListener {
	static ArrayList<Character> used = new ArrayList<Character>();
	static ArrayList<String> ze = new ArrayList<String>();
	static String LE;
	static int Lives = 10;
	static String L = "";
	static String tempstr="";
		JFrame JF = new JFrame();
		JPanel JP = new JPanel();
		JLabel JL = new JLabel();
		JLabel man = new JLabel("웃");
		JLabel Life = new JLabel();
	public void HangMaker() {

		JF.add(JP);
		JP.add(man);
		JP.add(Life);
		JF.setSize(500, 300);
		JF.setVisible(true);
		int h = 2999;
		JP.add(man);
		JF.setTitle("HangMan");
		JP.add(JL);

		HangRead();
		man.setFont(new Font(man.getFont().getName(), man.getFont().getStyle(), 100));
		Life.setFont(new Font(man.getFont().getName(), man.getFont().getStyle(), 100));
		Random rand = new Random();
		int value = rand.nextInt(2999);
		LE = ze.get(value);
		System.out.println(ze.get(value));
		ze.remove(value);
		h--;
		for (int e1 = 0; e1 < LE.length(); e1++) {
			L = L + "_";
		}
		JL.setText(L);
		JF.addKeyListener(this);
		// JP.requestFocus();
		Life.setText("" + Lives);
	}

	public void HangRead() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/HangBro/dictionary.txt"));

			String line = br.readLine();
			while (line != null) {
				ze.add(line);
				System.out.println(line);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

		boolean gotit = false;
		char ch = e.getKeyChar();
		System.out.println(ch);

		for (int i = 0; i < LE.length(); i++) {
			if (LE.charAt(i) == ch) {
				gotit = true;

				for (int e1 = 0; e1 < LE.length(); e1++) {
					if (e1 == i) {
						L = L + ch + " ";

					} else {

					}

				}
			} else {

			}

		}
		if (gotit) {

			System.out.println("Corret");
			tempstr="";
			for (int e1 = 0; e1 < LE.length(); e1++) {
				
				System.err.println(ch+"="+LE.charAt(e1));
				
				if (LE.charAt(e1) == ch) {
					tempstr = tempstr + LE.charAt(e1);
					used.add(LE.charAt(e1));
				} else if(used.contains(LE.charAt(e1))) {
					tempstr = tempstr + LE.charAt(e1);
				}
				else {
					tempstr = tempstr + "_";
					System.out.println();
				}
				
				
				
				
			}
			L = tempstr;
			System.out.println(L);
			JL.setText(L);
		} else {
			Lives--;
			System.err.println("Wrong");

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
