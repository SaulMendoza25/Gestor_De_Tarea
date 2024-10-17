package gestion_de_tareas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class ManagementView extends JFrame {
	private static final long serialVersionUID = -6182101146946429498L;
	private NorthView northView;
	private CenterView centerView;
	private WestView<Object> westView;

	/**
	 * This method returns the CenterView class.
	 * 
	 * @return
	 */
	public CenterView getCenterView() {
		return centerView;
	}

	/**
	 * This method return the NorthView class.
	 * 
	 * @return
	 */
	public NorthView getNorthView() {
		return northView;
	}

	/**
	 * THis method return the WestView class.
	 * 
	 * @return
	 */
	public WestView<Object> getWestView() {
		return westView;
	}

	/**
	 * This class is the main class about the management of the project GUI. Being
	 * this the frame, it initializes all the classes that are integrated with this
	 * class and gives a predetermined dimension depending on the size of the screen
	 * in which it is being executed. Using a layout type of BorderLayout we have
	 * three classes linked to this class.
	 */
	public ManagementView() {
		setLayout(new BorderLayout());
		setBounds(ScreenDefaultDesktop().width / 4, ScreenDefaultDesktop().height / 4, ScreenDefaultDesktop().width / 2,
				ScreenDefaultDesktop().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		northView = new NorthView();
		centerView = new CenterView();
		westView = new WestView<Object>();
		add(northView, BorderLayout.NORTH);
		add(westView, BorderLayout.WEST);
		add(centerView, BorderLayout.CENTER);

	}

	/**
	 * This method returns the dimensions of the screen where the application is
	 * executed to be able to give predetermined ones to this class that inherits
	 * from JFrame.
	 * 
	 * @return
	 */
	private Dimension ScreenDefaultDesktop() {
		Toolkit defaultToolDesktop = Toolkit.getDefaultToolkit();
		return defaultToolDesktop.getScreenSize();
	}

}
