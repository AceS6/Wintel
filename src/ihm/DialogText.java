package ihm;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import controller.*;

/**
*	Class DialogText
*	@author : Quentin Pitalier / Antoine Sauray 
*   @version : 1.0
*	DialogText is the help window
**/
public class DialogText extends JDialog{

	private JLabel text;
	private ImageIcon aide;
	private JLabel aidelabel;
	private JCheckBox box;

	private JPanel pan;

	/**
	*	Constructor
	**/
	public DialogText(){

		this.setSize(410, 550);
		this.setTitle("Aide de Wintel");
		this.setResizable(true);
		this.setModal(true);
		pan = new JPanel();
		pan.setBackground(new Color(0x003542));
		pan.setLayout(new BorderLayout());

		aide = new ImageIcon(new ImageIcon("../data/Aide.png").getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH));
		aidelabel = new JLabel();
		aidelabel.setIcon(aide);

		boolean state=false;

		try {
 			BufferedReader br = new BufferedReader(new FileReader("../data/config.cfg"));
 
			if(br.readLine().equals("showHelpOnStartup=true")){
				state=true;
			}

			br.close();
 
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
	

		box = new JCheckBox("Afficher l'aide au démarrage de Wintel", state);
		box.setFont(new Font("Calibri", Font.PLAIN, 14));
		//box.setForeground(Color.white);  
		box.addActionListener(new EcouteurDemarrageAide(this));

		pan.add(aidelabel,BorderLayout.NORTH);
		pan.add(box,BorderLayout.SOUTH);

		this.add(pan);


		this.setVisible(true);

	}
	public boolean getBoxState(){
		return box.isSelected();
	}

}