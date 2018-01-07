package HangBro;
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

public class HangPane implements KeyListener{
	 static ArrayList<String> ze = new ArrayList<String>();
 public static void HangMaker() {
	 String L="";
	 JFrame JF = new JFrame();
	 JPanel JP = new JPanel();
	 JLabel JL = new JLabel();
	 JF.add(JP);
	 JF.setVisible(true);

	 JF.setTitle("weeeeeeeeeeeee");
	 JP.add(JL);
	 JF.pack();
	 HangRead();
	 Random rand = new Random(); 
	 int value = rand.nextInt(2999);
	 String LE = ze.get(value);
	 System.out.println(ze.get(value));
	 for(int i=0; i<LE.length();i++) {
		 L=L+"_ ";
	 }
	 JL.setText(L);
	 JF.addKeyListener();
	// JP.requestFocus();
 }
 public static void HangRead() {
	
	 try {
			BufferedReader br = new BufferedReader(new FileReader("src/HangBro/dictionary.txt"));
			
			String line = br.readLine();
			while(line != null){
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
	
	 char ch = e.getKeyChar();
	System.out.println(ch);
}
@Override
public void keyPressed(KeyEvent e) {
	 char ch = e.getKeyChar();
		System.out.println(ch);
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
