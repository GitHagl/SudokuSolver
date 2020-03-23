import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NappiKuulija implements ActionListener {
	
	Nappi nappi;
	int numero;
	 
	
	public NappiKuulija (Nappi but){
		nappi = but;
		nappi.setFont(new Font("Arial", Font.BOLD, 22));
	}


	public void actionPerformed(ActionEvent arg0) {
		
		if(nappi.getNumber() < 9){
			numero = nappi.getNumber();
			numero++;
			nappi.setSolved(true, numero);
		}else{
			nappi.setSolved(false, 0);
		}
		
		
	}
	
}
