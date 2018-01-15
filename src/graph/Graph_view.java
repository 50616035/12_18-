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
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_view extends Frame implements ActionListener, WindowListener {
	private Button button1 = new Button("2D");
	private Button button2 = new Button("3D");
	private TextField text3 = new TextField("", 10);//10文字分
	
	public Graph_view() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(button1);
		add(button2);
		button1.addActionListener(this);//botton1を押すとActionListenerが起動
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
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		// TODO Auto-generated method stub

		int id,ton;
		String name,year;
		ResultSet rs;
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();//テーブルから情報を持ってきてrsに代入
		try {
			while(rs.next()){
				id = rs.getInt("id");
				name = rs.getString("name");
				year = rs.getString("year");
				ton = rs.getInt("ton");
				//System.out.println("ID：" + id);
				//System.out.println("name：" + name);
				//System.out.println("year：" + year);
				//System.out.println("ton：" + ton);
				data.addValue(ton,name,year);
			}  //try catchで囲む
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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


			//処理
		}else if(str == "3D"){
			//text3.set("A");
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			// TODO Auto-generated method stub

			int id,ton;
			String name,year;
			ResultSet rs;
			MySQL mysql = new MySQL();
			rs = mysql.selectAll();//テーブルから情報を持ってきてrs代入
			try {
				while(rs.next()){
					id = rs.getInt("id");
					name = rs.getString("name");
					year = rs.getString("year");
					ton = rs.getInt("ton");
					//System.out.println("ID：" + id);
					//System.out.println("name：" + name);
					//System.out.println("year：" + year);
					//System.out.println("ton：" + ton);
					data.addValue(ton,name,year);
				}  //try catchで囲む
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JFreeChart chart = 
			      ChartFactory.createLineChart3D("Import Volume",
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


		}
			
	  
	}

}
