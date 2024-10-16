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
	public CenterView getCenterView() {
		return centerView;
	}
	public NorthView getNorthView() {
		return northView;
	}
	public WestView<Object> getWestView() {
		return westView;
	}
	public ManagementView() {
		
		setLayout(new BorderLayout());
		setBounds(ScreenDefaultDesktop().width / 4, ScreenDefaultDesktop().height / 4, ScreenDefaultDesktop().width / 2,
				ScreenDefaultDesktop().height / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		northView = new NorthView();
		centerView = new CenterView();
		westView =new WestView<Object>();
		add(northView, BorderLayout.NORTH);
		add(westView, BorderLayout.WEST);
		add(centerView, BorderLayout.CENTER);

	}


	private Dimension ScreenDefaultDesktop() {
		Toolkit defaultToolDesktop = Toolkit.getDefaultToolkit();
		return defaultToolDesktop.getScreenSize();
	}

}
