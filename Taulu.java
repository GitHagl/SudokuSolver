import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Taulu {

	Dimension koko = new Dimension(50, 50);
	
	JFrame fraami = new JFrame("Sudoku Molester v. 0.1");
	
	JPanel sudokuPanel = new JPanel(new GridBagLayout());
    JPanel solvePanel = new JPanel(new GridBagLayout());
    JPanel superPanel = new JPanel(new GridBagLayout());
    
    Nappi napisto[][] = new Nappi[9][9];
    NappiKuulija kuulijat[][] = new NappiKuulija[9][9];
    
	JButton solve = new JButton("SOLVE");
	
	/*
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	JLabel label9 = new JLabel();
	*/
	
	public Taulu(){
		
		fraami.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fraami.setSize(800, 800);
        fraami.setMinimumSize(new Dimension(800, 800));
        fraami.setVisible(true);
        fraami.setLocationRelativeTo(null);
        
		solve.setPreferredSize(new Dimension(100, 50));
		
		int x;
		int y;
		
	    for (y = 0; y < 9; y++){
	    	for (x = 0; x < 9; x++){
	  			napisto[y][x] = new Nappi();
	  		}	
	  	};
	          
		for (y = 0; y < 9; y++){
			for (x = 0; x < 9; x++){
				napisto[y][x].setPreferredSize(koko);
			}	
		};
		
		for (y = 0; y < 9; y++){
			for (x = 0; x < 9; x++){
				napisto[y][x].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			}
		};
		
		for (y = 0; y < 9; y++){
			for (x = 0; x < 9; x++){
				napisto[y][x].setBackground(Color.WHITE);
			}
		};
		
		Nappi[] napistoO = {napisto[0][2], napisto[0][5], napisto[1][2], napisto[1][5], napisto[4][2], napisto[4][5], napisto[7][2], napisto[7][5], napisto[8][2], napisto[8][5]};
		Nappi[] napistoV = {napisto[0][3], napisto[0][6], napisto[1][3], napisto[1][6], napisto[4][3], napisto[4][6], napisto[7][3], napisto[7][6], napisto[8][3], napisto[8][6]};
		Nappi[] napistoA = {napisto[2][0], napisto[2][1], napisto[2][4], napisto[2][7], napisto[2][8], napisto[5][0], napisto[5][1], napisto[5][4], napisto[5][7], napisto[5][8]};
		Nappi[] napistoY = {napisto[3][0], napisto[3][1], napisto[3][4], napisto[3][7], napisto[3][8], napisto[6][0], napisto[6][1], napisto[6][4], napisto[6][7], napisto[6][8]};
		Nappi[] napistoOA = {napisto[2][2], napisto[2][5], napisto[5][2], napisto[5][5]};
		Nappi[] napistoOY = {napisto[3][2], napisto[3][5], napisto[6][2], napisto[6][5]};
		Nappi[] napistoVA = {napisto[2][3], napisto[2][6], napisto[5][3], napisto[5][6]};
		Nappi[] napistoVY = {napisto[3][3], napisto[3][6], napisto[6][3], napisto[6][6]};
		
		for (x = 0; x < 10; x++){
			napistoO[x].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 3, Color.BLACK));
		};
		for (x = 0; x < 10; x++){
			napistoV[x].setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, Color.BLACK));
		};
		for (x = 0; x < 10; x++){
			napistoA[x].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.BLACK));
		};
		for (x = 0; x < 10; x++){
			napistoY[x].setBorder(BorderFactory.createMatteBorder(3, 1, 1, 1, Color.BLACK));
		};
		
		
		for (x = 0; x < 4; x++){
			napistoOA[x].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.BLACK));
		};
		for (x = 0; x < 4; x++){
			napistoOY[x].setBorder(BorderFactory.createMatteBorder(3, 1, 1, 3, Color.BLACK));
		};
		for (x = 0; x < 4; x++){
			napistoVA[x].setBorder(BorderFactory.createMatteBorder(1, 3, 3, 1, Color.BLACK));
		};
		for (x = 0; x < 4; x++){
			napistoVY[x].setBorder(BorderFactory.createMatteBorder(3, 3, 1, 1, Color.BLACK));
		};
		
		Nappi[] kasaVY = {napisto[0][0], napisto[0][1], napisto[0][2], napisto[1][0], napisto[1][1], napisto[1][2], napisto[2][0], napisto[2][1], napisto[2][2]};
		Nappi[] kasaKY = {napisto[0][3], napisto[0][4], napisto[0][5], napisto[1][3], napisto[1][4], napisto[1][5], napisto[2][3], napisto[2][4], napisto[2][5]};
		Nappi[] kasaOY = {napisto[0][6], napisto[0][7], napisto[0][8], napisto[1][6], napisto[1][7], napisto[1][8], napisto[2][6], napisto[2][7], napisto[2][8]};
		Nappi[] kasaVK = {napisto[3][0], napisto[3][1], napisto[3][2], napisto[4][0], napisto[4][1], napisto[4][2], napisto[5][0], napisto[5][1], napisto[5][2]};
		Nappi[] kasaKK = {napisto[3][3], napisto[3][4], napisto[3][5], napisto[4][3], napisto[4][4], napisto[4][5], napisto[5][3], napisto[5][4], napisto[5][5]};
		Nappi[] kasaOK = {napisto[3][6], napisto[3][7], napisto[3][8], napisto[4][6], napisto[4][7], napisto[4][8], napisto[5][6], napisto[5][7], napisto[5][8]};
		Nappi[] kasaVA = {napisto[6][0], napisto[6][1], napisto[6][2], napisto[7][0], napisto[7][1], napisto[7][2], napisto[8][0], napisto[8][1], napisto[8][2]};
		Nappi[] kasaKA = {napisto[6][3], napisto[6][4], napisto[6][5], napisto[7][3], napisto[7][4], napisto[7][5], napisto[8][3], napisto[8][4], napisto[8][5]};
		Nappi[] kasaOA = {napisto[6][6], napisto[6][7], napisto[6][8], napisto[7][6], napisto[7][7], napisto[7][8], napisto[8][6], napisto[8][7], napisto[8][8]};
		
		for (y = 0; y < 9; y++){
	    	kasaVY[y].setKasa(kasaVY);
	    	kasaKY[y].setKasa(kasaKY);
	    	kasaOY[y].setKasa(kasaOY);
	    	kasaVK[y].setKasa(kasaVK);
	    	kasaKK[y].setKasa(kasaKK);
	    	kasaOK[y].setKasa(kasaOK);
	    	kasaVA[y].setKasa(kasaVA);
	    	kasaKA[y].setKasa(kasaKA);
	    	kasaOA[y].setKasa(kasaOA);
	  	};
		
		for (y = 0; y < 9; y++){
	    	for (x = 0; x < 9; x++){
	  			kuulijat[y][x] = new NappiKuulija(napisto[y][x]);
	  		}	
	  	};
	  	
	  	for (y = 0; y < 9; y++){
	    	for (x = 0; x < 9; x++){
	  			napisto[y][x].addActionListener(kuulijat[y][x]);
	  		}	
	  	};
	  	
	  	SolveKuulija solveKorva = new SolveKuulija(solve, napisto);
	  	solve.addActionListener(solveKorva);
	  	
		
		GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        for (y = 0; y < 9; y++){
			for (x = 0; x < 9; x++){
				sudokuPanel.add(napisto[y][x], c);
				c.gridx++;
			}
			c.gridy++;
			c.gridx = 0;
		};
        
		
        c.gridx = 0;
        c.gridy = 0;
        
        
        
        solvePanel.add(solve, c);
        c.gridy++;
        
        /*
        solvePanel.add(label1, c);
        c.gridy++;
        solvePanel.add(label2, c);
        c.gridy++;
        solvePanel.add(label3, c);
        c.gridy++;
        solvePanel.add(label4, c);
        c.gridy++;
        solvePanel.add(label5, c);
        c.gridy++;
        solvePanel.add(label6, c);
        c.gridy++;
        solvePanel.add(label7, c);
        c.gridy++;
        solvePanel.add(label8, c);
        c.gridy++;
        solvePanel.add(label9, c);
        */
        
        
        superPanel.add(sudokuPanel, c);
        c.gridy++;
        superPanel.add(solvePanel, c);
        fraami.add(superPanel);

		
	}
	
	public static void main(String[] args){
        
        Taulu sudoku = new Taulu();
     
    }
}
