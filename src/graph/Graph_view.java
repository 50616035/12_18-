package graph;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_view extends Frame implements ActionListener, WindowListener {
	private Button button1 = new Button("2D");
	private Button button2 = new Button("3D");
	private TextField text3 = new TextField("", 10);//10ï∂éöï™
	
	public Graph_view() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(button1);
		add(button2);
		button1.addActionListener(this);//botton1ÇâüÇ∑Ç∆ActionListenerÇ™ãNìÆ
		button2.addActionListener(this);
		
		addWindowListener(this);
		setTitle("Graph");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//ChartPanel cpanel = new ChartPanel(chart);
		//add(cpanel, BorderLayout.CENTER);
	
		
		
		
		
	}
	

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str =e.getActionCommand();
		
	if(str == "2D"){
		//text3.set("A");
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		// TODO Auto-generated method stub

		data.addValue(300, "USA", "2005");
		data.addValue(500, "USA", "2006");
		data.addValue(120, "USA", "2007");

		data.addValue(200, "China", "2005");
		data.addValue(400, "China", "2006");
		data.addValue(320, "China", "2007");
		JFreeChart chart = 
		      ChartFactory.createLineChart("Import Volume",
		                                   "Year",
		                                   "Ton",
		                                   data,
		                                   PlotOrientation.VERTICAL,
		                                   true,
		                                   false,
		                                   false);
		ChartFrame frame = new ChartFrame("Line Chart", chart);
		frame.pack();
		frame.setVisible(true);


			//èàóù
		}else if(str == "3D"){
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			// TODO Auto-generated method stub

			data.addValue(300, "USA", "2005");
			data.addValue(500, "USA", "2006");
			data.addValue(120, "USA", "2007");

			data.addValue(200, "China", "2005");
			data.addValue(400, "China", "2006");
			data.addValue(320, "China", "2007");
			JFreeChart chart = 
			      ChartFactory.createLineChart3D("Import Volume",
			                                   "Year",
			                                   "Ton",
			                                   data,
			                                   PlotOrientation.VERTICAL,
			                                   true,
			                                   false,
			                                   false);
			ChartFrame frame = new ChartFrame("Simple Pie Chart", chart);
			frame.pack();
			frame.setVisible(true);
		}
			
	  
	}

}
