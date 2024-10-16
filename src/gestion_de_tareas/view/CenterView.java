package gestion_de_tareas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.util.Date;
import java.time.ZoneId;

public class CenterView extends JPanel {
	private static final long serialVersionUID = 8350901500097621175L;

	public CenterView() {
		setLayout(new BorderLayout());
		add(getVerticalPanelBox(), BorderLayout.NORTH);
		setBackground(new Color(81, 86, 88));
		descriptionPane = new JTextPane();
		descriptionPane.setBackground(new Color(81, 86, 88));
		descriptionPane.setBorder(BorderFactory.createLineBorder(Color.gray));
		descriptionPane.setForeground(Color.white);

		JScrollPane scrollPane = new JScrollPane(descriptionPane);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));

		add(scrollPane, BorderLayout.CENTER);
	}

	public JDatePickerImpl getChooseDate() {
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		chooseDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		return chooseDate;
	}

	private class DateLabelFormatter extends AbstractFormatter {
		private static final long serialVersionUID = 4621424899864012578L;
		private String datePattern = "yyyy-MM-dd";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}
			return "";
		}

	}

	private Box getVerticalPanelBox() {
		Box verticalPanelBox = Box.createVerticalBox();
		for (int i = 0; i < 1; i++) {
			verticalPanelBox.add(Box.createVerticalStrut(10));
			Box horizontalCreateTop = Box.createHorizontalBox();
			Box positionLeftBox = Box.createHorizontalBox();
			Box positionRightBox = Box.createHorizontalBox();
			JLabel name = new JLabel("Name");
			name.setForeground(Color.white);
			nameField = new JTextField();
			nameField.setBackground(new Color(81, 86, 88));
			nameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			nameField.setForeground(Color.white);
			int limit = 20;
			nameField.setDocument(new PlainDocument() {
			    @Override
			    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			    	
			        if (str == null) {
			            return;
			        }

			        // Si el texto nuevo más el texto existente no supera el límite
			        if ((getLength() + str.length()) <= limit) {
			            super.insertString(offset, str, attr);
			        }
			    }});

			JLabel date = new JLabel("Date");
			date.setForeground(Color.white);
			positionLeftBox.add(name);
			positionLeftBox.add(Box.createHorizontalStrut(5));
			positionLeftBox.add(nameField);
			positionLeftBox.add(Box.createHorizontalStrut(5));
			JLabel  limitCaracter = new JLabel();
			limitCaracter.setForeground(Color.white);
			positionLeftBox.add(limitCaracter);
			nameField.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					limitCaracter.setText(e.getDocument().getLength()+"");

				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					limitCaracter.setText(e.getDocument().getLength()+"");
				
					
					

				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					

				}
			});
			positionRightBox.add(date);
			positionRightBox.add(Box.createHorizontalStrut(5));
			positionRightBox.add(getChooseDate());
			positionRightBox.add(Box.createHorizontalStrut(5));
			horizontalCreateTop.add(positionLeftBox);
			horizontalCreateTop.add(Box.createGlue());
			horizontalCreateTop.add(Box.createHorizontalStrut(5));
			horizontalCreateTop.add(positionRightBox);
			horizontalCreateTop.add(Box.createGlue());
			verticalPanelBox.add(horizontalCreateTop);
			verticalPanelBox.add(Box.createVerticalStrut(10));
		}
		return verticalPanelBox;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextPane getDescriptionPane() {
		return descriptionPane;
	}

	public LocalDate getDate() {
		Date selectedDate = (Date) chooseDate.getModel().getValue();
		if (selectedDate != null) {
			LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			return localDate;
		} else {
			JOptionPane.showMessageDialog(this, "You have not chosen a date for your task", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
		return LocalDate.now();
	}

	private JDatePickerImpl chooseDate;
	private JTextField nameField;
	private JTextPane descriptionPane;
}
