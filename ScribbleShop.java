import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.*;

public class ScribbleShop extends JFrame {
	public static ScribbleShop program;
	protected JMenuBar MenuBar;
	protected JMenu FileMenu, AboutMenu;
	protected JMenuItem NewMenuItem, CloseMenuItem, CloseAllMenuItem,
			ExitMenuItem, HelpMenuItem, AuthorMenuItem;
	protected static JDesktopPane desktop;
	static int openFrameCount = 0;

	public ScribbleShop() {
		super("ScribbleShop - Warumporn Chantakraiwat 5431295721");
		initGUI();
	}

	public void initGUI() {
		setupMenu();
		desktop = new JDesktopPane();
		setContentPane(desktop);
	}

	public static void createFrame() {
		Scribble internalFrame = new Scribble();
		internalFrame.setSize(900, 600);
		internalFrame.setVisible(true);
		desktop.add(internalFrame);
		try {
			internalFrame.setSelected(true);
		} catch (Exception e) {
		}

	}

	public void setupMenu() {
		MenuBar = new JMenuBar();

		FileMenu = new JMenu("File");
		MenuBar.add(FileMenu);

		NewMenuItem = new JMenuItem("New");
		FileMenu.add(NewMenuItem);
		NewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		NewMenuItem.addActionListener(new MenuListener());

		FileMenu.addSeparator();

		CloseMenuItem = new JMenuItem("Close");
		CloseAllMenuItem = new JMenuItem("Close All");
		FileMenu.add(CloseMenuItem);
		FileMenu.add(CloseAllMenuItem);
		CloseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				ActionEvent.CTRL_MASK));
		CloseAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));
		CloseMenuItem.addActionListener(new MenuListener());
		CloseAllMenuItem.addActionListener(new MenuListener());

		FileMenu.addSeparator();

		ExitMenuItem = new JMenuItem("Exit");
		FileMenu.add(ExitMenuItem);
		ExitMenuItem.addActionListener(new MenuListener());

		AboutMenu = new JMenu("About");
		MenuBar.add(AboutMenu);

		HelpMenuItem = new JMenuItem("Help");
		AuthorMenuItem = new JMenuItem("Author");
		AboutMenu.add(HelpMenuItem);
		AboutMenu.add(AuthorMenuItem);
		HelpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		HelpMenuItem.addActionListener(new MenuListener());
		AuthorMenuItem.addActionListener(new MenuListener());

		setJMenuBar(MenuBar);
	}

	public class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			AbstractButton source = (AbstractButton) e.getSource();
			if(source.getText().equals("Author")){
				showAuthorDialog();
			}else if(source.getText().equals("Help")){
				showHelpDialog();
			}else if(source.getText().equals("New")){
				ScribbleShop.createFrame();

			}else if(source.getText().equals("Close")){

				if(ScribbleShop.openFrameCount!=0){
					try {
						ScribbleShop.desktop.getSelectedFrame().setClosed(true);
						ScribbleShop.openFrameCount--;

						if(ScribbleShop.openFrameCount != 1) ScribbleShop.desktop.selectFrame(true);
					} catch (PropertyVetoException e1) {						
						e1.printStackTrace();
					} 
				}


			}else if(source.getText().equals("Close All")){
				for(int i = 0; i < ScribbleShop.openFrameCount; i++){
					try {
						ScribbleShop.desktop.getSelectedFrame().setClosed(true);
						if(i > 0) ScribbleShop.desktop.selectFrame(true);
					} catch (PropertyVetoException e1) {
						e1.printStackTrace();
					}
				}
				ScribbleShop.openFrameCount = 0;
			}else if(source.getText().equals("Exit")){
				System.exit(0);
			}else{}
		}

		private void showHelpDialog() {
			final JDialog helpDialog = new JDialog();
			helpDialog.setLayout(new BorderLayout());
			JLabel newText = new JLabel("  Hello! This is a paint program that can open many windows if you don't know it yet! ;)");
			helpDialog.getContentPane().add(newText, BorderLayout.CENTER);
			JButton closeButton = new JButton("Okay. Got it.");
			helpDialog.getContentPane().add(closeButton,BorderLayout.SOUTH);
			closeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					helpDialog.dispose();
				}
			});
			helpDialog.setModal(true);
			helpDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			helpDialog.setSize(500,100);
			helpDialog.setLocationRelativeTo(null);
			//helpDialog.pack();
			helpDialog.setVisible(true);

		}

		public void showAuthorDialog(){
			final JDialog dialog = new JDialog();
			dialog.setLayout(new BorderLayout());
			dialog.getContentPane().add(new MyAvatar(), BorderLayout.CENTER);
			JButton OKButton = new JButton("Does this really look like me? No? (Yeah, I think so.)");
			dialog.getContentPane().add(OKButton,BorderLayout.SOUTH);
			OKButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					dialog.dispose();
				}
			});
			dialog.setModal(true);
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.setSize(360,420);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		}
	}
	
	private static void createAndShowGUI() {
		program = new ScribbleShop();
		program.setPreferredSize(new Dimension(1100, 700));
		program.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		program.pack();
		program.setLocationRelativeTo(null);
		program.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}