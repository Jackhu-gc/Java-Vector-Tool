package Canvas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

public class About extends JFrame {
    private JPanel contentPane;
    public About() {
        setTitle("About");
        setBounds(100, 100, 450, 300);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JEditorPane About = new JEditorPane();
        About.setEditable(false);
        About.setText("About Application:\r\nDesign by Levi Breakwell,\n Jack Hu, \nand Soo Bin Lee");
        contentPane.add(About, BorderLayout.CENTER);
    }

}
