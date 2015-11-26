import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ControlFrame extends JFrame {
	/* New frame for control panel */

	private JPanel researchPanel;
	private JPanel websitePanel;
	
	private JButton ft;
	private JButton seekingAlpha;
	private JButton investorGuide;
	private JButton analystResearch;
	private JButton bloombergNews;
	private JButton plus500;
	private JButton googleNews;
	
	private JTextField tickerField;
	private JButton tradingView;
	private JButton stockScreener;
	



	public ControlFrame(String title){

		super(title);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(720,480);
		setMaximumSize(new Dimension(700,440));
		setVisible(true);
	
		
		//Set layout
		setLayout(new GridBagLayout());
		
		//Build panels
		buildResearchPanel();
		buildWebsitePanel();
		addActionListeners();
		
	
		//Add components to content pane
		Container container = getContentPane();

		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridy = 0;
		gc.gridx = 0;
		container.add(researchPanel, gc);
		
		gc.gridy = 1;
		container.add(websitePanel,gc);


	}
	
	
	public void buildResearchPanel(){
	
	researchPanel = new JPanel(new GridBagLayout());
	
	// Set panel size and border
	researchPanel.setPreferredSize(new Dimension(400,150));
	TitledBorder titled = new TitledBorder("Research Panel");
	researchPanel.setBorder(titled);
	
	// CREATE & FORMAT COMPONENTS
	JLabel findStock = new JLabel("Find a Stock:");
	stockScreener = new JButton("NASDAQ Stock Screener");
	stockScreener.setPreferredSize(new Dimension(200,25));
	stockScreener.setBackground(Color.BLUE);
	
	
	JLabel analyseStock = new JLabel("Analyse a stock:");
	tickerField = new JTextField();
	tickerField.setMinimumSize(new Dimension(150,25));
	tickerField.setUI(new HintTextFieldUI(" Enter Ticker",true));
	
	tradingView = new JButton("View Chart");
	tradingView.setPreferredSize(new Dimension(110,23));
	tradingView.setBackground(Color.BLUE);

	analystResearch = new JButton("Analyst Research");
	analystResearch.setPreferredSize(new Dimension(125,25));	
	analystResearch.setBackground(Color.BLUE);
	
	// ARRANGE COMPONENTS
	GridBagConstraints gc = new GridBagConstraints();
	gc.insets = new Insets(6,6,0,0);
	gc.anchor = GridBagConstraints.LINE_START;
	
	gc.gridy = 0;
	gc.gridx = 0;
	researchPanel.add(findStock, gc);
	
	gc.gridy = 1;
	gc.gridx = 0;
	researchPanel.add(stockScreener, gc);
	
	gc.gridy = 2;
	gc.gridx = 0;
	researchPanel.add(analyseStock, gc);
	

	gc.gridy = 3;
	gc.gridx = 0;
	researchPanel.add(tickerField, gc);	
	

	gc.gridx = 1;
	researchPanel.add(tradingView,gc);
	gc.gridx = 2;
	researchPanel.add(analystResearch, gc);
	
	
}
	
	
	public void buildWebsitePanel(){
		/* PANEL FOR USEFUL WEBSITES */
		
		websitePanel = new JPanel(new GridLayout(2,3));
		
		// Set panel size and border
		websitePanel.setPreferredSize(new Dimension(400,200));
		TitledBorder titled = new TitledBorder("Website Panel");
		websitePanel.setBorder(titled);
		
		// CREATE & FORMAT COMPONENTS
		JLabel websites = new JLabel("<html><b>Websites:</b></html>");
		
		ft = new JButton("FT.com");
		ft.setPreferredSize(new Dimension(200,40));
		ft.setBackground(Color.GREEN);
		
		seekingAlpha = new JButton("SeekingAlpha");
		seekingAlpha.setPreferredSize(new Dimension(200,40));
		seekingAlpha.setBackground(Color.GREEN);
		
		investorGuide = new JButton("InvestorGuide");
		investorGuide.setPreferredSize(new Dimension(200,40));
		investorGuide.setBackground(Color.GREEN);
		
		
		bloombergNews = new JButton("Bloomberg News");
		bloombergNews.setPreferredSize(new Dimension(200,40));	
		bloombergNews.setBackground(Color.GREEN);
		
		plus500 = new JButton("Plus 500 Platform");
		plus500.setPreferredSize(new Dimension(200,40));
		plus500.setBackground(Color.GREEN);
		
		googleNews = new JButton("Google News");
		googleNews.setPreferredSize(new Dimension(200,40));	
		googleNews.setBackground(Color.GREEN);
		
		// ARRANGE COMPONENTS
		websitePanel.add(ft);
		websitePanel.add(seekingAlpha);
		websitePanel.add(investorGuide);
		websitePanel.add(bloombergNews);
		websitePanel.add(plus500);
		websitePanel.add(googleNews);
			
		
	}
	
	
	
	public void addActionListeners(){
		/* Add event listeners to buttons */
		
		// Add ActionListeners to Research Panel buttons.
		tradingView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){	
				String ticker = tickerField.getText();
				String url = "http://www.tradingview.com/chart/?symbol=" + ticker;
				new Browser().launch(url);;
			}
		});
		
		analystResearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){			
				String ticker = tickerField.getText();
				String url = "http://www.nasdaq.com/symbol/"+ticker+"/analyst-research";
				new Browser().launch(url);
			}
		});
		
		stockScreener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){			
				new Browser().launch("http://www.nasdaq.com/reference/stock-screener.aspx");
			}
		});
		
		
		//Add ActionListeners to 'Websites Panel' buttons.
		ft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){			
				new Browser().launch("http://www.ft.com");;
			}
		});
				
				
		seekingAlpha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){			
				new Browser().launch("http://www.seekingalpha.com");;
			}
		});
		
				
		investorGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				new Browser().launch("http://www.investorguide.com");;
			}
		});
				
				
		bloombergNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){			
				new Browser().launch("http://www.bloomberg.com/businessweek");;
			}
		});

		
		plus500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){			
				new Browser().launch("http://www.plus500.co.uk");;
			}
		});
		
		googleNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){			
				new Browser().launch("http://www.news.google.co.uk");;
			}
		});

				
				
	}
	
	
}