import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class Scribble extends JInternalFrame {
	Color color;
	MyCanvas pad = new MyCanvas();
	JFrame frame = new JFrame();
	static final int xOffset = 5, yOffset = 5;

	
	public Scribble() {
		super("Untitled-" + (ScribbleShop.openFrameCount++), true, true, true,
				true);
		setLocation(xOffset * ScribbleShop.openFrameCount, yOffset
				* ScribbleShop.openFrameCount);
		setSize(500, 600);
		setGUI();
	}	
	
	protected void setGUI() {
		add(pad, BorderLayout.CENTER);
		JPanel scroll = new JPanel();
		JPanel button = new JPanel(new BorderLayout());
		JLabel brush_text = new JLabel("Brush Size");
		JButton clearButton = new JButton("CLEAR");
		JSlider size = new JSlider(JSlider.HORIZONTAL, 1, 50, 5);
		size.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					pad.brushSize = (int) source.getValue();
				}
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pad.clear();
			}
		});
		button.setLayout(new BoxLayout(button, BoxLayout.LINE_AXIS));
		button.add(brush_text);
		button.add(size);
		brush_text.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		scroll.setLayout(new BoxLayout(scroll, BoxLayout.LINE_AXIS));
		scroll.add(new BottomPanel());
scroll.add(clearButton);
		
		add(scroll, BorderLayout.SOUTH);
		add(button, BorderLayout.NORTH);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	class BottomPanel extends JPanel implements ChangeListener {
		JColorChooser brushColor;

		public BottomPanel() {
			setLayout(new BorderLayout());
			brushColor = new JColorChooser();
			brushColor.getSelectionModel().addChangeListener(this);
			add(brushColor, BorderLayout.NORTH);
		}

		public void stateChanged(ChangeEvent e) {
			color = brushColor.getColor();
		}
	}

	class MyCanvas extends JComponent {
		Image image;
		Graphics2D graphics2D;
		int newX, newY, x, y;
		int brushSize;

		public MyCanvas() {
			setDoubleBuffered(false);

			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x = e.getX();
					y = e.getY();

				}
			});
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					newX = e.getX();
					newY = e.getY();
					graphics2D.setColor(color);
					if (graphics2D != null)
						graphics2D.setStroke(new BasicStroke(brushSize));
					graphics2D.drawLine(x, y, newX, newY);
					repaint();
					x = newX;
					y = newY;
				}
			});
		}

		public void paintComponent(Graphics g) {
			if (image == null) {
				image = createImage(getSize().width, getSize().height);
				graphics2D = (Graphics2D) image.getGraphics();
				graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				clear();
			}
			g.drawImage(image, 0, 0, null);
		}

		public void clear() {
			graphics2D.setPaint(Color.white);
			graphics2D.fillRect(0, 0, getSize().width, getSize().height);
			graphics2D.setPaint(Color.black);
			repaint();
		}
	}

}
