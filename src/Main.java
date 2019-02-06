import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class Main {
	
	static Random randomNum=new Random();
	
	static JFrame frame;
	static JPanel panel;
	static JTextField nametf;
	static JButton start,kartal,bitir,restart;
	static JLabel inputnamelabel,isimlabel,elsonuc,sonucyazisi;
	static JTextArea kartlarr,sonuclarr;
	static String isim;
	static String[] kartlar= {"(Sinek) A","(Sinek) 2","(Sinek) 3","(Sinek) 4","(Sinek) 5","(Sinek) 6","(Sinek) 7","(Sinek) 8","(Sinek) 9","(Sinek) 10","(Sinek) J","(Sinek) O","(Sinek) K","(Maça) A","(Maça) 2","(Maça) 3","(Maça) 4","(Maça) 5","(Maça) 6","(Maça) 7","(Maça) 8","(Maça) 9","(Maça) 10","(Maça) J","(Maça) O","(Maça) K","(Karo) A","(Karo) 2","(Karo) 3","(Karo) 4","(Karo) 5","(Karo) 6","(Karo) 7","(Karo) 8","(Karo) 9","(Karo) 10","(Karo) J","(Karo) O","(Karo) K","(Kupa) A","(Kupa) 2","(Kupa) 3","(Kupa) 4","(Kupa) 5","(Kupa) 6","(Kupa) 7","(Kupa) 8","(Kupa) 9","(Kupa) 10","(Kupa) J","(Kupa) O","(Kupa) K"};
	static int[] kartdeger= {1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10};
	static String[] cikankartlar= {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	static String[] g1kartlar= {"","","","","","","","","",""};
	static String[] g2kartlar= {"","","","","","","","","",""};
	static String[] g3kartlar= {"","","","","","","","","",""};
	static String[] g4kartlar= {"","","","","","","","","",""};
	static int[] kartdegerleri= {0,0,0,0};
	static int[] sonuclar = {0,0,0,0};
	static int rastsayi;
	static int[] kacincikart= {0,0,0,0};
	public static void main(String[] args) {
		MainScreen();
	}
	
	public static void MainScreen() {
		frame=new JFrame("BlackJack");
		frame.setSize(1000, 1000);//frame boyutunu ayarlama
		frame.setVisible(true);//frame gosterme
		frame.setResizable(true);//framein boyutunu ayarlamayý negelliyor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//frame kapattýktan sonra arkada çalýþmayý durduruyor
		
		panel=new JPanel();
		panel.setSize(500,500);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		
		inputnamelabel=new JLabel("Ýsminiz:");
		inputnamelabel.setSize(75,50);
		inputnamelabel.setLocation(30,40);
		panel.add(inputnamelabel);
		
		nametf=new JTextField();
		nametf.setSize(100,30);
		nametf.setLocation(120,50);
		panel.add(nametf);
		
		start=new JButton("Baþla");
		start.setSize(200, 45);
		start.setLocation(200,300);
		start.addActionListener(new Action());
		panel.add(start);
		
		frame.add(panel);
		frame.repaint();
	}
	
	public static void start() {
		frame=new JFrame("BlackJack");
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setSize(500,500);
		panel.setLocation(0, 0);
		panel.setLayout(null);
	
		isimlabel=new JLabel(isim);
		isimlabel.setSize(200,50);
		isimlabel.setLocation(150,40);
		panel.add(isimlabel);
		
		kartlarr=new JTextArea(g4kartlar[0]+"\n"+g4kartlar[1]+"\n"+g4kartlar[2]+"\n"+g4kartlar[3]+"\n"+g4kartlar[4]+"\n"+g4kartlar[5]+"\n"+g4kartlar[6]+"\n"+g4kartlar[7]+"\n"+g4kartlar[8]+"\n"+g4kartlar[9]);
		kartlarr.setSize(75,250);
		kartlarr.setLocation(250,40);
		panel.add(kartlarr);
		
		elsonuc=new JLabel("kart degerleri= "+kartdegerleri[3]);
		elsonuc.setSize(200,50);
		elsonuc.setLocation(100,100);
		panel.add(elsonuc);
		
		kartal=new JButton("Kart Al");
		kartal.setSize(100, 45);
		kartal.setLocation(200,300);
		kartal.addActionListener(new Action());
		panel.add(kartal);
		
		bitir=new JButton("Bitir");
		bitir.setSize(100, 45);
		bitir.setLocation(100,300);
		bitir.addActionListener(new Action());
		panel.add(bitir);

		frame.add(panel);
		frame.repaint();
	}
	
	public static void sonuc() {
		frame=new JFrame("BlackJack");
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setSize(500,500);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		
		sonuclarr=new JTextArea("1="+kartdegerleri[0]+"\n"+"2="+kartdegerleri[1]+"\n"+"3="+kartdegerleri[2]+"\n"+isim+"="+kartdegerleri[3]);
		sonuclarr.setSize(75,250);
		sonuclarr.setLocation(250,40);
		panel.add(sonuclarr);
		
		restart=new JButton("Tekrar baþlat");
		restart.setSize(100, 45);
		restart.setLocation(100,300);
		restart.addActionListener(new Action());
		panel.add(restart);
		
		sonucyazisi=new JLabel();
		sonucyazisi.setSize(75,50);
		sonucyazisi.setLocation(30,40);
		panel.add(sonucyazisi);
		
		frame.add(panel);
		frame.repaint();
	}
	
	public static void kartsec(int i) {
		rastsayi=randomNum.nextInt(kartlar.length);
		
		if(cikankartlar[rastsayi].equals("")) {
			cikankartlar[rastsayi]="X";
			if(i==0) {
				g1kartlar[kacincikart[0]]=kartlar[rastsayi];
				kacincikart[0]++;
				kartdegerleri[0]=kartdeger[rastsayi]+kartdegerleri[0];
			}
			else if(i==1) {
				g2kartlar[kacincikart[1]]=kartlar[rastsayi];
				kacincikart[1]++;
				kartdegerleri[1]=kartdeger[rastsayi]+kartdegerleri[1];

			}
			else if(i==2) {
				g3kartlar[kacincikart[2]]=kartlar[rastsayi];
				kacincikart[2]++;
				kartdegerleri[2]=kartdeger[rastsayi]+kartdegerleri[2];

			}
			else if(i==3) {
				g4kartlar[kacincikart[3]]=kartlar[rastsayi];
				kacincikart[3]++;
				kartdegerleri[3]=kartdeger[rastsayi]+kartdegerleri[3];

			}
		}
		else {
			kartsec(i);
		}
		
		if(kartdegerleri[i]<15 && i!=3) {
			kartsec(i);
		}
		
	}
	
	static class Action implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==start){
				isim=nametf.getText();
				kartsec(0);
				kartsec(1);
				kartsec(2);
				kartsec(3);
				kartsec(3);
				if(kartdegerleri[0]==21 || kartdegerleri[1]==21 || kartdegerleri[2]==21) {
					sonuc();
				}
				
				frame.dispose();
				start();
			}
			else if(e.getSource()==kartal) {
				kartsec(3);
				
				if(kartdegerleri[3]>=21) {
					frame.dispose();
					sonuc();
				}
				else {
					frame.dispose();
					start();
				}
			}
			else if(e.getSource()==bitir) {
				frame.dispose();
				sonuc();
			}
			else if(e.getSource()==restart) {
				for(int i=0;i<cikankartlar.length;i++) {
					cikankartlar[i]="";
				}
				for(int i=0;i<g1kartlar.length;i++) {
					g1kartlar[i]="";
					g2kartlar[i]="";
					g3kartlar[i]="";
					g4kartlar[i]="";
				}
				for(int i=0;i<kartdegerleri.length;i++) {
					kartdegerleri[i]=0;
					sonuclar[i]=0;
					kacincikart[i]=0;

				}
				kartsec(0);
				kartsec(1);
				kartsec(2);
				kartsec(3);
				kartsec(3);
				if(kartdegerleri[0]==21 || kartdegerleri[1]==21 || kartdegerleri[2]==21) {
					sonuc();
				}
				frame.dispose();
				start();
			}
			
		}
		}

}
