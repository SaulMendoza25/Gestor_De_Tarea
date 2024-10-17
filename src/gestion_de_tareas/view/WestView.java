package gestion_de_tareas.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import gestion_de_tareas.model.Tasks;

public class WestView<E> extends JPanel {
	private static final long serialVersionUID = 6953222767190867283L;
	public WestView() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(50, 0));
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
		setBackground(new Color(81, 86, 88));

		add(geRadiohead(), BorderLayout.WEST);

	}

	private JPanel geRadiohead() {
		panelIcons = new JPanel();
		panelIcons.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
		panelIcons.setBackground(new Color(81, 86, 88));
		listTasks = new JButton();
		listTasks.addActionListener(new EventPanelIcons());
		listTasks.setBorder(BorderFactory.createEmptyBorder());
		listTasks.setIcon(new ImageIcon("resources/images/icons/tasks.png"));
		panelIcons.add(listTasks);
		return panelIcons;
	}

	private Box getCenter(ArrayList<JComponent> Compo) {
		Box verticalBoxList = Box.createVerticalBox();
		BoxCenter = Box.createVerticalBox();
		setPreferredSize(new Dimension(200, 0));
		remove(BoxCenter);

		for (JComponent jComponent : Compo) {
			Box generateHorizontalBox = Box.createHorizontalBox();
			generateHorizontalBox.add(jComponent);
			BoxCenter.add(generateHorizontalBox);
			
		}
		
		
		verticalBoxList.add(BoxCenter);
		verticalBoxList.add(Box.createHorizontalGlue());
		SwingUtilities.updateComponentTreeUI(this);
		return verticalBoxList;
	}

	private class EventPanelIcons implements ActionListener {
		private int counter = 1;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			add(getCenter(listTask()), BorderLayout.CENTER);
			
			if (counter % 2 == 0) {
				BoxCenter.setVisible(false);
				setPreferredSize(new Dimension(50, 0));
			} else {
			
				BoxCenter.setVisible(true);

			}
			counter++;

		}
	}

	private ArrayList<JComponent> listTask() {
		ArrayList<JComponent> generatorButton = new ArrayList<JComponent>();
		for (Tasks task : Tasks.getTasks()) {
			JButton generatorTask = new JButton(task.getName());
			generatorTask.setForeground(new Color(238, 236, 121));
			generatorTask.setBorderPainted(false);
			generatorTask.setFocusPainted(false);
			generatorTask.setContentAreaFilled(false);

			generatorTask.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					generatorTask.setContentAreaFilled(true);
					generatorTask.setBackground(Color.GRAY);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					generatorTask.setContentAreaFilled(false);
				}
			});
			generatorTask.addActionListener(new ShowInformation(task));
			generatorButton.add(generatorTask);
		}
		return generatorButton;
	}

	private class ShowInformation implements ActionListener {
		public ShowInformation(Tasks task) {
			this.task = task;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (frameInformation == null) {
				frameInformation = new JFrame() ;
				
				frameInformation.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						frameInformation = null;
					}
				});
				frameInformation.setBounds(0, 0, 300, 300);
				
				frameInformation.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frameInformation.setVisible(true);
				panelInformation = new JPanel();
				panelInformation.setLayout(new BorderLayout());
				panelInformation.add(boxInformationAndPanelInformation(), BorderLayout.NORTH);
				panelInformation.add(getDescriptionLabel(), BorderLayout.CENTER);
				panelInformation.setBackground(new Color(81, 86, 88));
				frameInformation.add(panelInformation);

			}

		}

		private Box boxInformationAndPanelInformation() {
			Box verticalBox = Box.createVerticalBox();
//			verticalBox.add(Box.createGlue());
			Object[] taskInformation = { task.getName(), task.getDate() };
			for (int i = 0; i < 2; i++) {
				Box horizontalBox = Box.createHorizontalBox();
				switch (i) {
				case 0: {
					JLabel textName = new JLabel("Name: ");
					textName.setForeground(new Color(238, 236, 121));
					JLabel taskName = new JLabel(taskInformation[i] + "");
					taskName.setForeground(new Color(91, 189, 62));
					;
					horizontalBox.add(textName);
					horizontalBox.add(Box.createHorizontalStrut(10));
					horizontalBox.add(taskName);
					JLabel textDate = new JLabel("Date: ");
					textDate.setForeground(new Color(238, 236, 121));
					JLabel taskDate = new JLabel(taskInformation[i + 1] + "");
					taskDate.setForeground(new Color(91, 189, 62));
					horizontalBox.add(Box.createHorizontalStrut(10));
					horizontalBox.add(textDate);
					horizontalBox.add(Box.createHorizontalStrut(10));
					horizontalBox.add(taskDate);
					break;
				}
				case 1: {
					JLabel textDescription = new JLabel("Description: ");
					textDescription.setForeground(new Color(238, 236, 121));
					horizontalBox.add(textDescription);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + taskInformation);
				}
				verticalBox.add(horizontalBox);
			}
			return verticalBox;
		}

		private JTextPane getDescriptionLabel() {
			JTextPane descriptionLabel = new JTextPane();
			descriptionLabel.setBackground(new Color(81, 86, 88));
			descriptionLabel.setForeground(new Color(91, 189, 62));
			descriptionLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
			descriptionLabel.setText(task.getDescription());
			descriptionLabel.setEditable(false);
			return descriptionLabel;
		}

		private JFrame frameInformation;
		private JPanel panelInformation;
		private Tasks task;
	}

	private Box BoxCenter;
	private JPanel panelIcons;
	private JButton listTasks;
}
