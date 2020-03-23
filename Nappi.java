import javax.swing.JButton;

public class Nappi extends JButton {

	int number;
	int i;
	boolean solved = false;
	boolean mahdo[] = new boolean[9];
	Nappi[] kasa;
	
	
	public Nappi(){
		number = 0;
		for(i = 0; i < 9; i++){
			mahdo[i] = true;
		}
		
	}
	
	public void setKasa(Nappi[] kas){
		kasa = kas;
    }
	
	public void setSolved(boolean sol, int num){
    	solved = sol;
    	number = num;
    	if(!solved){
    		
    		for(i = 0; i < 9; i++){
        		mahdo[i] = true;
        	}
    		setText("");
    		
    	}else{
    		
    		for(i = 0; i < 9; i++){
        		mahdo[i] = false;
        	}
        	mahdo[number - 1] = true;
        	setText("" + number);
        	
    	}	
    }
	
	public void poistaMahdo(int k){
    	mahdo[k] = false;
    }
	
	public Nappi[] getKasa(){
		return kasa;
    }
	
	public int getNumber(){
		return number;
    }
	
	public boolean getSolved(){
    	return solved;
    }
	
	public boolean[] getMahdo(){
    	return mahdo;
    }

}
