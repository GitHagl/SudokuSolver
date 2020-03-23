import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SolveKuulija implements ActionListener  {
	
	int x;
	int y;
	int i;
	int j;
	int lippu = 0;
	int lippuKohta = 0;
	int valiMahdo;
	
	JButton solver;
	Nappi napisto[][];
	Nappi kasa[];
	boolean mahdo[];
	boolean mahdoVert[];
	
	/*
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JLabel label9;
	*/

	public SolveKuulija(JButton sol, Nappi[][] nap){
		solver = sol;
		napisto = nap;
		
		/*
		label1 = lab1;
		label2 = lab2;
		label3 = lab3;
		label4 = lab4;
		label5 = lab5;
		label6 = lab6;
		label7 = lab7;
		label8 = lab8;
		label9 = lab9;
		*/
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		//K‰yd‰‰n yksitellen l‰pi jokainen yksitt‰inen ruutu
		for (y = 0; y < 9; y++){
	    	for (x = 0; x < 9; x++){
	  			
	    		//Vain ratkaisemattomat
	    		if(!napisto[y][x].getSolved()){
	    			
	    		
	    			//Poistetaan mahdollisuuksista kaikki...
	    			//1. samalla rivill‰ olevat numerot.
	    			for(i = 0; i < 9; i++){
	    				if(napisto[y][i].getSolved()){
	    					valiMahdo = napisto[y][i].getNumber();
	    					valiMahdo--;
	    					napisto[y][x].poistaMahdo(valiMahdo);
	    				}
	    			}
	    		
	    		
	    			//2. samalla sarakkeella olevat numerot.
	    			for(i = 0; i < 9; i++){
	    				if(napisto[i][x].getSolved()){
	    					valiMahdo = napisto[i][x].getNumber();
	    					valiMahdo--;
	    					napisto[y][x].poistaMahdo(valiMahdo);
	    				}
	    			}
	    		
	    		
	    			//3. samassa ruudukossa olevat numerot.
	    			kasa = napisto[y][x].getKasa();
	    			for(i = 0; i < 9; i++){
	    				if(kasa[i].getSolved()){
	    					valiMahdo = kasa[i].getNumber();
	    					valiMahdo--;
	    					napisto[y][x].poistaMahdo(valiMahdo);
	    				}
	    			}
	    		

	    			//Tarkastetaan onko ainoa mahdollisuus...
	    			//4. itsess‰‰n
	    			mahdo = napisto[y][x].getMahdo();
	    			for(i = 0; i < 9; i++){
	    				if(mahdo[i]){
	    					lippu++;
	    					lippuKohta = i;
	    				}
	    			}
	    			if(lippu == 1){
	    				lippuKohta++;
	    				napisto[y][x].setSolved(true, lippuKohta);
	    			}
	    			lippu = 0;
	    			lippuKohta = 0;
	    			
	    			//5. samalla rivill‰.
	    			if(!napisto[y][x].getSolved()){
	    				//v mit‰ mahdollisuuskohtaa tarkastellaan
	    				for(i = 0; i < 9; i++){
	    					//v mit‰ ruutua verrataan
	    					for(j = 0; j < 9; j++){
	    						if(j != x){
	    							mahdoVert = napisto[y][j].getMahdo();
	    							
	    							if(mahdo[i] && !mahdoVert[i]){
	    								lippu++;
	    							}
		    					}	
	    					}
	    					if(lippu == 8){
	    						napisto[y][x].setSolved(true, i+1);
	    					}
	    					lippu = 0;
		    			}	
	    			}
	    			
	    			//6. samalla sarakkeella.
	    			if(!napisto[y][x].getSolved()){
	    				//v mit‰ mahdollisuuskohtaa tarkastellaan
	    				for(i = 0; i < 9; i++){
	    					//v mit‰ ruutua verrataan
	    					for(j = 0; j < 9; j++){
	    						if(j != y){
	    							mahdoVert = napisto[j][x].getMahdo();
	    							
	    							if(mahdo[i] && !mahdoVert[i]){
	    								lippu++;
	    							}
		    					}	
	    					}
	    					if(lippu == 8){
	    						napisto[y][x].setSolved(true, i+1);
	    					}
	    					lippu = 0;
		    			}
	    			}
	    			
	    			/*
	    			//7. samassa ruudukossa.
	    			if(!napisto[y][x].getSolved()){
	    				if(!napisto[y][x].getSolved()){
		    				//v mit‰ mahdollisuuskohtaa tarkastellaan
		    				for(i = 0; i < 9; i++){
		    					//v mit‰ ruutua verrataan
		    					for(j = 0; j < 9; j++){
		    						if(j != y && i != x){
		    							mahdoVert = kasa[j].getMahdo();
		    							
		    							if(mahdo[i] && !mahdoVert[i]){
		    								lippu++;
		    							}
			    					}	
		    					}
		    					if(lippu == 8){
		    						napisto[y][x].setSolved(true, i+1);
		    					}
		    					lippu = 0;
			    			}
		    			}
	    			}
	    			*/
	    			
	    			/*
	    			mahdo = napisto[0][0].getMahdo();
	    			label1.setText("" + mahdo[0]);
	    			label2.setText("" + mahdo[1]);
	    			label3.setText("" + mahdo[2]);
	    			label4.setText("" + mahdo[3]);
	    			label5.setText("" + mahdo[4]);
	    			label6.setText("" + mahdo[5]);
	    			label7.setText("" + mahdo[6]);
	    			label8.setText("" + mahdo[7]);
		    		label9.setText("" + mahdo[8]);
		    		*/

	    		}
	    		
	  		}	
	  	}
	}
}
