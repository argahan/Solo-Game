import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	static JFrame frame;
	static JPanel panel;
	static JLabel adimlabel,kalanlabel;
	static JTextArea resultta;
	static JButton finish,restart;
	static String[][] deger;
	static JButton  btn11,btn12,btn13,btn14,btn15,btn16,btn17,
					btn21,btn22,btn23,btn24,btn25,btn26,btn27,
					btn31,btn32,btn33,btn34,btn35,btn36,btn37,
					btn41,btn42,btn43,btn44,btn45,btn46,btn47,
					btn51,btn52,btn53,btn54,btn55,btn56,btn57,
					btn61,btn62,btn63,btn64,btn65,btn66,btn67,
					btn71,btn72,btn73,btn74,btn75,btn76,btn77;
	static JButton[][] btn= {
			{btn11,btn12,btn13,btn14,btn15,btn16,btn17},
			{btn21,btn22,btn23,btn24,btn25,btn26,btn27},
			{btn31,btn32,btn33,btn34,btn35,btn36,btn37},
			{btn41,btn42,btn43,btn44,btn45,btn46,btn47},
			{btn51,btn52,btn53,btn54,btn55,btn56,btn57},
			{btn61,btn62,btn63,btn64,btn65,btn66,btn67},
			{btn71,btn72,btn73,btn74,btn75,btn76,btn77},
	};
	static int kalan,adim;
	static int boyut=100;
	static String secilenTas="";
	
	public static void main(String[] args) {
		startingvalues();
		startmain();
	}
	
	public static void startingvalues() {
		deger=new String[][] {
				{"O","O","X","X","X","O","O"},
				{"O","O","X","X","X","O","O"},
				{"X","X","X","X","X","X","X"},
				{"X","X","X","Z","X","X","X"},
				{"X","X","X","X","X","X","X"},
				{"O","O","X","X","X","O","O"},
				{"O","O","X","X","X","O","O"},
		};
		adim=0;
		kalan=0;
		secilenTas="";
	}
	
	public static void startmain() {
		frame=new JFrame("Solo Game");
		frame.setSize(900, 750);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setSize(900,750);
		panel.setLocation(0, 0);
		panel.setLayout(null);

		adimlabel=new JLabel("Adým Sayýsý: "+adim);
		adimlabel.setSize(100,50);
		adimlabel.setLocation(750,50);
		panel.add(adimlabel);
		
		finish=new JButton("Bitir");
		finish.setSize(100, 45);
		finish.setLocation(750,300);
		finish.addActionListener(new Action());
		panel.add(finish);
		
		btn_tanim();
		buton_check();
		
		frame.add(panel);
		frame.repaint();
	}
	
	public static void finishmain() {
		frame=new JFrame("Solo Game");
		frame.setSize(900, 750);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setSize(900,750);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		
		kalanhesaplama();
		
		adimlabel=new JLabel("Adým Sayýsý: "+adim);
		adimlabel.setSize(200,50);
		adimlabel.setLocation(150,50);
		panel.add(adimlabel);
		
		adimlabel=new JLabel("Kalan Piyon Sayýsý: "+kalan);
		adimlabel.setSize(200,150);
		adimlabel.setLocation(150,50);
		panel.add(adimlabel);

		resultta=new JTextArea("1 PÝYON => BÝLGÝN \n "
				+ "2 PÝYON => ZEKÝ \n "
				+ "3 PÝYON => KURNAZ \n "
				+ "4 PÝYON => BAÞARILI \n "
				+ "5 PÝYON => NORMAL \n "
				+ "6 PÝYON => TECRÜBESÝZ \n "
				+ "7 PÝYON => APTAL \n "
				+ "8 PÝYON => GERÝZEKALI \n "
				+ "9 PÝYON => BEYÝNSÝZ \n "
				+ "9+ PÝYON => DÝYECEK SÖZ BULAMIYORUM");
		resultta.setSize(300,200);
		resultta.setLocation(350,50);
		panel.add(resultta);

		restart=new JButton("Yeniden Baþlat");
		restart.setSize(400, 45);
		restart.setLocation(400,500);
		restart.addActionListener(new Action());
		panel.add(restart);
		
		frame.add(panel);
		frame.repaint();
		
	}
	
	public static void kalanhesaplama() {
		for(int i=0;i<btn.length;i++) {
			for(int j=0;j<btn[0].length;j++) {
				if(deger[i][j].equals("X")) {
					kalan++;
				}
			}
		}
	}
	
	public static void btn_tanim() {
		int x=10,y=10;
		for(int i=0;i<btn.length;i++) {
			for(int j=0;j<btn[0].length;j++) {
				if(deger[i][j].equals("O")) {
					btn[i][j]=new JButton();
					btn[i][j].setSize(boyut,boyut);
					btn[i][j].setLocation(x,y);
					btn[i][j].addActionListener(new Action());
					panel.add(btn[i][j]);
				}else if(deger[i][j].equals("X")) {
					btn[i][j]=new JButton();
					btn[i][j].setSize(boyut,boyut);
					btn[i][j].setLocation(x,y);
					btn[i][j].addActionListener(new Action());
					panel.add(btn[i][j]);
				}else if(deger[i][j].equals("Z")) {
					btn[i][j]=new JButton();
					btn[i][j].setSize(boyut,boyut);
					btn[i][j].setLocation(x,y);
					btn[i][j].addActionListener(new Action());
					panel.add(btn[i][j]);
				}
				x+=boyut;
			}
			x=10;
			y+=boyut;
		}
	}
	
	public static void buton_check() {
		for(int i=0;i<btn.length;i++) {
			for(int j=0;j<btn[0].length;j++) {
				if(deger[i][j].equals("O")) {
					btn[i][j].setBackground(Color.BLACK);
				}else if(deger[i][j].equals("X")) {
					btn[i][j].setBackground(Color.BLUE);
				}else if(deger[i][j].equals("Z")) {
					btn[i][j].setBackground(Color.GRAY);
				}
				
				if(secilenTas.equals(Integer.toString(i)+Integer.toString(j))) {
					btn[i][j].setBackground(Color.RED);
				}
			}
		}
	}
	
	public static void hamle_check(int i,int j) {
		if(i==Integer.parseInt(String.valueOf(secilenTas.charAt(0)))+2 && j==Integer.parseInt(String.valueOf(secilenTas.charAt(1)))){
			deger[i][j]="X";
			deger[i-1][j]="Z";
			deger[i-2][j]="Z";
			secilenTas="";
			adim++;
			adimlabel.setText(("Adým Sayýsý: "+String.valueOf(adim)));
			buton_check();
		}
		else if(i==Integer.parseInt(String.valueOf(secilenTas.charAt(0)))-2 && j==Integer.parseInt(String.valueOf(secilenTas.charAt(1)))) {
			deger[i][j]="X";
			deger[i+1][j]="Z";
			deger[i+2][j]="Z";
			secilenTas="";
			adim++;
			adimlabel.setText(("Adým Sayýsý: "+String.valueOf(adim)));
			buton_check();
		}
		else if(j==Integer.parseInt(String.valueOf(secilenTas.charAt(1)))+2 && i==Integer.parseInt(String.valueOf(secilenTas.charAt(0)))) {
			deger[i][j]="X";
			deger[i][j-1]="Z";
			deger[i][j-2]="Z";
			secilenTas="";
			adim++;
			adimlabel.setText(("Adým Sayýsý: "+String.valueOf(adim)));
			buton_check();
		}		
		else if(j==Integer.parseInt(String.valueOf(secilenTas.charAt(1)))-2 && i==Integer.parseInt(String.valueOf(secilenTas.charAt(0)))) {
			deger[i][j]="X";
			deger[i][j+1]="Z";
			deger[i][j+2]="Z";
			secilenTas="";
			adim++;
			adimlabel.setText(("Adým Sayýsý: "+String.valueOf(adim)));
			buton_check();
		}
	}
	
	static class Action implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<btn.length;i++) {
				for(int j=0;j<btn[0].length;j++) {
					if(e.getSource()==btn[i][j]){
						if(deger[i][j].charAt(0)=='X') {
							if(secilenTas.equals("")) {
								secilenTas=Integer.toString(i)+Integer.toString(j);
								btn[i][j].setBackground(Color.RED);
							}else {
								if((Integer.toString(i)+Integer.toString(j)).equals(secilenTas)) {
									secilenTas="";
									btn[i][j].setBackground(Color.BLUE);
								}
							}
						}
						else if(deger[i][j].charAt(0)=='Z') {
							if(!secilenTas.equals("")) {
								hamle_check(i,j);
							}
						}
					}
				}
			}	
			if(e.getSource()==finish) {
				frame.dispose();
				finishmain();
			}
			if(e.getSource()==restart) {
				frame.dispose();
				startingvalues();
				startmain();
			}
		}
	}
}
