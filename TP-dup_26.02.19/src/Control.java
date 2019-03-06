import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/** Interface graphique du serveur. */
public class Control extends JFrame {
    private static final long serialVersionUID = 1L;
	
    public Control(LauncherImpl launcher) {
        final JButton gobutton=new JButton("Go");
        gobutton.addActionListener(event -> {
                    gobutton.setEnabled(false);
                    launcher.go();
        	});
        
        JButton printbutton=new JButton("Print");
        printbutton.addActionListener(event -> launcher.print());
        
        JButton exitbutton=new JButton("Exit");
        exitbutton.addActionListener(event -> System.exit(0));
        
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(gobutton);
        this.getContentPane().add(printbutton);
        this.getContentPane().add(exitbutton);
        this.setSize(350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
