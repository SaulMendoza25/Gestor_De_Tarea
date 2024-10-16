package gestion_de_tareas.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class NorthView extends JPanel {

	private static final long serialVersionUID = -8148038196496605218L;
	public NorthView() {
		setLayout(new BorderLayout());
//		setPreferredSize(new Dimension(0,24));
		menuBar = new JMenuBar();
		menuBar.add(elementsFile());
		menuBar.add(elementsTool());
		menuBar.setBackground(new Color(81, 86, 88));
		add(menuBar,BorderLayout.NORTH);
		add(getOptions(),BorderLayout.CENTER);

	}

	private JMenu elementsFile() {
		file = new JMenu("Files");
		file.setBorder(BorderFactory.createEmptyBorder());
		file.setForeground(Color.white);
		JMenuItem open = new JMenuItem("Open");
		open.setBorder(BorderFactory.createEmptyBorder());
		JMenuItem save = new JMenuItem("Save");
		file.add(open);
		file.add(save);
		
		return file;
	}
	private JMenu elementsTool() {
		tool = new JMenu("Tools");
		tool.setForeground(Color.white);
		JMenu fonts = new JMenu("Fonts");
		tool.add(fonts);
		return tool;
	}
	private JToolBar getOptions() {
		JToolBar options = new JToolBar();
		
		options.add(Box.createHorizontalStrut(5));
		options.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.GRAY));
		options.setBackground(new Color(81, 86, 88));
		
		save = new JButton();
		save.setBackground(new Color(81, 86, 88));
		
		save.setIcon(new ImageIcon("resources/images/icons/save.png"));
		
		options.add(save);
		options.add(Box.createVerticalStrut(30));
		save.setBorder(BorderFactory.createEmptyBorder());
		return  options;
	}
	public JButton getSave() {
		return save;
	}
	private JMenuBar menuBar;
	private JMenu file, tool;
	private JButton save;

}
