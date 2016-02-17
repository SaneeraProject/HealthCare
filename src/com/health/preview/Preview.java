package com.health.preview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class Preview extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreviewPane panpreview;

	public Preview(Window parent, String title, PreviewData data) {
		super(parent, title);
		setModal(true);
		JPanel panmain = new JPanel();
		panpreview = new PreviewPane(data);

		panpreview.setMinimumSize(new Dimension(7 * 96, 8 * 96));
		panpreview.setMaximumSize(new Dimension(7 * 96, 8 * 96));
		panpreview.setPreferredSize(new Dimension(7 * 96, 8 * 96));

		panpreview.setBackground(Color.WHITE);

		panmain.add(panpreview);

		JScrollPane jsp = new JScrollPane(panmain);

		JToolBar jtb = new JToolBar();
		JButton btnPrint = new JButton(" Print ");
		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					PrinterJob pjob = PrinterJob.getPrinterJob();
					pjob.setPrintable(panpreview);
					if (pjob.printDialog()) {
						pjob.print();
					}
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		jtb.add(btnPrint);

		add(jtb, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);

		setSize(500, 500);
		setVisible(true);
	}

	public void load() {

	}

}

class PreviewPane extends JPanel implements Printable {

	/**
	 * 
	 */
//	ConfigDB db = ConfigDB.getConfig();
	private PreviewData data;
	private static final long serialVersionUID = 1L;

	public PreviewPane(PreviewData data) {
		this.data = data;
	}

	@Override
	protected void paintComponent(Graphics g2) {
		// TODO Auto-generated method stub
		super.paintComponent(g2);
		Graphics2D g = (Graphics2D) g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
//		g.drawString(db.getCompany(), 50, 50);
//
//		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
//
//		g.drawString("PAN : " + db.getPan(), 400, 50);
//		g.drawString("TAN : " + db.getTan(), 400, 70);
//
//		g.drawString("Address : " + db.getAddress(), 50, 65);
//		g.drawString(db.getCity(), 50, 80);
//		g.drawString("Contact No : " + db.getContact(), 50, 95);
//		g.drawString("E-mail : " + db.getEmail() + " Website : " + db.getWeb(),
//				50, 110);

		g.drawLine(0, 130, getWidth(), 130);

		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		g.drawString(data.getTitle(), 50, 145);

		g.drawLine(0, 150, getWidth(), 150);
		int y = 170;
		if (data.getHeaderMap() != null) {
			for (Entry<String, String> entry : data.getHeaderMap().entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				g.drawString(key + " : ", 50, y);
				String line[] = value.split("\n");
				for (String text : line) {
					g.drawString(value,
							g.getFontMetrics().stringWidth(key) + 80, y);
					y = y + 15;
				}
			}
		}

		y = y + 30;

		if (data.getModel() != null) {
			for (int i = 0; i < data.getModel().getColumnCount(); i++) {
				g.drawString(data.getModel().getColumnName(i),
						10 + (i - 1) * 100, y);
			}
		}
		y = y + 10;
		g.drawLine(0, y - 5, getWidth(), y - 5);
		y = y + 10;

		if (data.getModel() != null) {
			for (int i = 0; i < data.getModel().getRowCount(); i++) {
				for (int j = 0; j < data.getModel().getColumnCount(); j++) {
					String str1 = data.getModel().getValueAt(i, j).toString();
					g.drawString(str1, 10 + (j - 1) * 100, y);
				}
				y = y + 10;
				g.drawLine(0, y - 5, getWidth(), y - 5);
				y = y + 10;
			}

		}

		y = y + 50;

		if (data.getFooterMap() != null) {
			for (Entry<String, String> entry : data.getFooterMap().entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				g.drawString(key + " : ", 400, y);
				g.drawString(value, g.getFontMetrics().stringWidth(key) + 440,
						y);
				y = y + 15;
			}
		}
		y = y + 10;
		g.drawLine(0, y - 5, getWidth(), y - 5);
		y = y + 10;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) graphics;
		g2.scale(0.75, 0.75);
		if (pageIndex >= 1) {
			return Printable.NO_SUCH_PAGE;
		} else {
			printAll(g2);
			return Printable.PAGE_EXISTS;
		}
	}

}
