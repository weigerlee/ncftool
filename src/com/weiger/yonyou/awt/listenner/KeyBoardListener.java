package com.weiger.yonyou.awt.listenner;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.weiger.yonyou.awt.WJTextField;
import com.weiger.yonyou.awt.WPanel;
import com.weiger.yonyou.brower.WebAutoTestBaseClass;
import com.weiger.yonyou.util.XlsUtil;
import com.weiger.yonyou.vo.SprInfo;
import com.weiger.yonyou.vo.XLSRecord;

public class KeyBoardListener extends JFrame {
    
	
	private static String filePath = null;
	private static String sheetIndex = null;
	private static String beginRowIdex = null;
	private static String col_2d_index = null;
	private static String col_3d_index = null;
	
	private static String browerDriveEvnPath=null;
	private static String browerDebugPort=null;
	private static String filePathLL = null;
	private static String col_2d_dl = null;
	private static String col_2d_ul = null;
	private static String col_2b_cons = null;
	private static String col_2b_sqls = null;
	
	private static String col_3d_dl = null;
	private static String col_3d_ul = null;
	private static String col_3b_cons = null;
	private static String col_3b_sqls = null;
	
	
	
    /**
     * 
     */
    private static final long serialVersionUID = 7158985419563418289L;
    private WPanel contentPane;
    private JTextField textField;
    private JTextField textField_3d;

    
    
    private JTextField textField_currentAPP;
    private JTextField textField_currentBusi;
    private JTextField textField_currentNO;
   
    JLabel label22;
    JLabel label23;
    JLabel labeltip;
   
    JButton button_init;
    JButton button_begin;
    JButton button_end ;
    JButton button_next ;
    JButton button_pre;
    
    JButton button_cleanPage ;
    JButton button_readPage ;
    JButton button_beginspr ;
    JButton button_endspr ;
    JButton button_writespr;
    
    
    private JTextField textField_2s_upload;
    private JTextField textField_2s_dowmload;
    private JTextField textField_2s_sqls;
    private JTextField textField_2s_cons;
    
    private JTextField textField_3s_upload;
    private JTextField textField_3s_dowmload;
    private JTextField textField_3s_sqls;
    private JTextField textField_3s_cons;
    
    
    WebAutoTestBaseClass auto;
    
    /**
     * Create the frame.
     */
    public KeyBoardListener() {
    	
    	init();
    	
    	setAlwaysOnTop(true);//���ڴ�����ǰ��
    	
        setTitle("\u5355\u70b9\u6548\u7387\u548c\u6d41\u91cf\u6d4b\u8bd5\u0020\u8f85\u52a9\u5668 V3.0 desgin by NC_FI");/* �����͵���Ч�� ������ */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100,635, 320);
        
        
        
        contentPane = new WPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //contentPane.setLayout(new GridLayout(3, 1, 5, 5));
        contentPane.setLayout(new GridLayout(7, 1,5,5));
        
        WPanel paneltip = new WPanel();
        //contentPane.add(paneltip);
        
        
        labeltip = new JLabel("NO.2 \u5df2\u6210\u529f\u5199\u5165\u0078\u006c\u0073 ��");/*�ѳɹ�д��xls*/
        paneltip.add(labeltip);
        labeltip.setVisible(false);
        labeltip.setForeground(new Color(255,0,0));
        
        label22 = new JLabel("NO.2 \u5df2\u6210\u529f\u5199\u5165\u0078\u006c\u0073 ��");/*�ѳɹ�д��xls*/
        paneltip.add(label22);
        label22.setVisible(false);
        label22.setForeground(new Color(255,0,0));
        
        label23 = new JLabel("NO.3 \u5df2\u6210\u529f\u5199\u5165\u0078\u006c\u0073��");/*�ѳɹ�д��xls*/
        paneltip.add(label23);
        label23.setVisible(false);
        label23.setForeground(new Color(255,0,0));
        
        
        WPanel panel1 = new WPanel();
        contentPane.add(panel1);
        
        //TODO ���xls�ļ�����D�̸�
        
        JLabel label1 = new JLabel("\u5f53\u524d\u5e94\u7528:");/*��ǰӦ��*/
        panel1.add(label1);
        
        textField_currentAPP = new JTextField();
        panel1.add(textField_currentAPP);
        textField_currentAPP.setColumns(20);
        textField_currentAPP.setEnabled(false);
        
        
       
       
        JLabel label2 = new JLabel("\u4e1a\u52a1\u52a8\u4f5c:");/*ҵ����*/
        panel1.add(label2);
        textField_currentBusi = new JTextField();
        panel1.add(textField_currentBusi);
        textField_currentBusi.setColumns(10);
        textField_currentBusi.setEnabled(false);
        
        
//        textField_currentNO = new JTextField();
//        textField_currentNO.setColumns(10);
//        panel1.add(textField_currentNO);
//        textField_currentNO.setEnabled(false);
        
        
        WPanel panel3 = new WPanel();
       
        
         button_init = new JButton("\u8bfb\u5165xls\u6587\u4ef6(ALT+I)");/*����xls�ļ�(ALT+I)*/
         button_begin = new JButton("\u5f00\u59cb(ALT+W)");/*��ʼ(ALT+B)*/
         button_end = new JButton("\u7ed3\u675f(ALT+S)");/*����(ALT+E)*/
         button_next  = new JButton("\u4e0b\u4e00\u4e2a(ALT+N)");/*��һ��(ALT+N)*/
        
         button_pre = new JButton("\u4e0a\u4e00\u4e2a(ALT+P)");/*��һ��(ALT+P)*/
        
        button_init.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel3.add(button_init);
        
        
        button_begin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        
//        button_begin.registerKeyboardAction(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent paramActionEvent) {
//				System.out.println("��ʼ��ݼ���������B");
//				do_button_actionPerformed(paramActionEvent);
//			}
//		},KeyStroke.getKeyStroke(KeyEvent.VK_B,0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        
        
        
        panel3.add(button_begin);
        
        button_end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
//        button_begin.registerKeyboardAction(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent paramActionEvent) {
//				System.out.println("��ʼ��ݼ���������D");
//				do_button_actionPerformed(paramActionEvent);
//			}
//		},KeyStroke.getKeyStroke(KeyEvent.VK_D,0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        panel3.add(button_end);
        button_next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel3.add(button_next);
        
        
        panel3.add(button_pre);
        button_pre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel3.add(button_pre);
        
        
        WPanel panel2 = new WPanel();
        contentPane.add(panel2);
        JLabel label21 = new JLabel("\u82b1\u8d39\u65f6\u95f4 :\u7b2c 2 \u6b21 S:");/*����ʱ�䣺��2��(S)*/
        panel2.add(label21);
        
        textField = new JTextField();
        panel2.add(textField);
        textField.setColumns(10);
        //textField.setEnabled(false);
        
        JLabel label28 = new JLabel("\u7b2c 3 \u6b21 S:");/*����ʱ�䣺��3��(S)*/
        panel2.add(label28);
        textField_3d = new JTextField();
        panel2.add(textField_3d);
        textField_3d.setColumns(10);
        
        
//        label22 = new JLabel("NO.2 \u5df2\u6210\u529f\u5199\u5165\u0078\u006c\u0073 ��");/*�ѳɹ�д��xls*/
//        panel2.add(label22);
//        label22.setVisible(false);
//        
//        label23 = new JLabel("NO.3 \u5df2\u6210\u529f\u5199\u5165\u0078\u006c\u0073��");/*�ѳɹ�д��xls*/
//        panel2.add(label23);
//        label23.setVisible(false);
//        
        
        contentPane.add(panel3);
        //panel3.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        JSeparator sep = new JSeparator(SwingConstants.CENTER);
        sep.setPreferredSize(new Dimension(this.getWidth(),20));
        sep.setBackground(new Color(153,153,153));
        //panel3.add(sep);
        //panel3.setSize(620, 45);
        
        
        globCL();
        
        /*************************************************************************************/
//        WPanel contentPane2 = new WPanel();
//        contentPane.add(contentPane2);
//        contentPane2.setLayout(new GridLayout(3,1,5,5));
        
        WPanel panel6 = new WPanel();
        contentPane.add(panel6);
        
        JLabel label61 = new JLabel("��2��:");/*ҵ����*/
        panel6.add(label61);
        JLabel label62 = new JLabel("���У�B��:");/*ҵ����*/
        panel6.add(label62);
        textField_2s_upload = new WJTextField();
        panel6.add(textField_2s_upload);
        JLabel label63 = new JLabel("���У�B��:");/*ҵ����*/
        panel6.add(label63);
        textField_2s_dowmload = new WJTextField();
        panel6.add(textField_2s_dowmload);
        JLabel label64 = new JLabel("SQL����:");/*ҵ����*/
        panel6.add(label64);
        textField_2s_sqls = new WJTextField();
        panel6.add(textField_2s_sqls);
        JLabel label65 = new JLabel("������:");/*ҵ����*/
        panel6.add(label65);
        textField_2s_cons = new WJTextField();
        panel6.add(textField_2s_cons);
        
        WPanel panel7 = new WPanel();
        contentPane.add(panel7);
        
        JLabel label71 = new JLabel("��3��:");/*ҵ����*/
        panel7.add(label71);
        JLabel label72 = new JLabel("���У�B��:");/*ҵ����*/
        panel7.add(label72);
        textField_3s_upload = new WJTextField();
        panel7.add(textField_3s_upload);
        JLabel label73 = new JLabel("���У�B��:");/*ҵ����*/
        panel7.add(label73);
        textField_3s_dowmload = new WJTextField();
        panel7.add(textField_3s_dowmload);
        JLabel label74 = new JLabel("SQL����:");/*ҵ����*/
        panel7.add(label74);
        textField_3s_sqls = new WJTextField();
        panel7.add(textField_3s_sqls);
        JLabel label75 = new JLabel("������:");/*ҵ����*/
        panel7.add(label75);
        textField_3s_cons = new WJTextField();
        panel7.add(textField_3s_cons);
        
        WPanel panel8 = new WPanel();
        contentPane.add(panel8);
        
        button_cleanPage = new JButton("����ҳ��ջ");/*��ʼspr*/
        button_readPage= new JButton("����ҳ��");/*��ʼspr*/
        button_beginspr = new JButton("��ʼspr");/*��ʼspr*/
        button_endspr = new JButton("����spr");/*��ʼspr*/
        button_writespr  = new JButton("��¼spr����");/*��¼spr*/
        
        button_cleanPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        button_readPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        button_beginspr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button_endspr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button_writespr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        panel8.add(button_cleanPage);
        panel8.add(button_readPage);
        panel8.add(button_beginspr);
        panel8.add(button_endspr);
        panel8.add(button_writespr);
        
        
        
        
        /*************************************************************************************/
        
        contentPane.add(paneltip);
        
        
    }
    
    
    
    
    long bt;
	long ed;
	long diff;
	
	private List<XLSRecord> xlsRecords;
	
	private int sheet;
	private int row;//2; // ���ڼ�¼xls��ǰ��
	private int col; // ���ڼ�¼xls��ǰ��
	
	//String xlsUrl = "D:\\����Ч����֤����.xlsx";
	String xlsUrl;
	
	
	
	private XLSRecord currentRecord;
	
	protected void do_key_actionPerformed(KeyEvent e){
		
		
		if(false){
    		dobusi_start();
    		 
    	
    	}
    	
    	if(false){
    		
    		dobusi_end();
    	}
		
		
	}
	
	
	   
	
	SprInfo info;
	
	
	/**
	 *   ���Ż� ·�ɷ���
	 * @param e
	 */
    protected void do_button_actionPerformed(ActionEvent e)  {
        //String username = textField.getText();// ����û���
        //String password = new String(passwordField.getPassword());// �������
    	
//    	if ((username.isEmpty()) || (password.isEmpty())) {// �ж��û����������Ƿ�Ϊ��
//            JOptionPane.showMessageDialog(this, "�û���������Ϊ�գ�", null, JOptionPane.WARNING_MESSAGE);
//            return;
//        }
    	
    	if(e.getActionCommand()=="����xls�ļ�(ALT+I)"){
    		
  		  
    		readXLSRecord();
    		
    		
    		//TODO  ���� ��ʼ����ť������
  	
    	}
    	
    	
    	if(e.getActionCommand()=="��ʼ(ALT+W)"){
    		dobusi_start();
    		 
    	
    	}
    	
    	if(e.getActionCommand()=="����(ALT+S)"){
    		
    		dobusi_end();
    		//auto.testOpenedPageandendSpr();
    		
    	}
    	
    	if(e.getActionCommand()=="��һ��(ALT+N)"){
    		
    		nextXLSRecord();
    	}
    	
    	
    	if(e.getActionCommand()=="��һ��(ALT+P)"){
    		
    		preXLSRecord();
    	}
    	
    	if(e.getActionCommand()=="��ʼspr"){
    		
    		
    		testOpenedPageandBeginSpr();
    	}
    	
    	if(e.getActionCommand()=="����spr"){
    		
    		//auto =new WebAutoTestBaseClass();
    		testOpenedPageandendSpr();
    		
			try {
				info = readSpr();
			
    		
    		if(flag){
    			
    			textField_2s_upload.setText(info.getUploadByte()+"");
    			textField_2s_dowmload.setText(info.getDownloadByte()+"");
    			textField_2s_sqls.setText(info.getSqlsCount()+"");
    			textField_2s_cons.setText(info.getConsCount()+"");
    			
    			
    		}else {
    			
    			textField_3s_upload.setText(info.getUploadByte()+"");
    			textField_3s_dowmload.setText(info.getDownloadByte()+"");
    			textField_3s_sqls.setText(info.getSqlsCount()+"");
    			textField_3s_cons.setText(info.getConsCount()+"");
    			
    		}
    		
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("����spr ����");
				
			}
    		
    		
    		
    	}
    	
    	if(e.getActionCommand()=="��¼spr����"){
    		
    		//auto =new WebAutoTestBaseClass();
    		
    		writSprtoxls();
    		
    	}
    	
    	if(e.getActionCommand()=="����ҳ��ջ"){
    		
    		//auto =new WebAutoTestBaseClass();
    		
    		clearpageHeap();
    		
    	}
    	
    	
    	if(e.getActionCommand()=="����ҳ��"){
    		
    		//auto =new WebAutoTestBaseClass();
    		
    		readpage();
    		
    	}
    	
    	
    }
    
    
    private void readpage() {
		// TODO Auto-generated method stub
		
    	Set<String> handles=driver.getWindowHandles();
		
    	if(handles.size()-haddleGlobSet.size()>1) {
    		
    		JOptionPane.showMessageDialog(this, "sorry��ֻ��ͬʱ���ص���ҳ�棡����", null, JOptionPane.WARNING_MESSAGE); 
			  return;
    		
    		
    	}
    	
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			 String str = it.next();
			if(!haddleGlobSet.contains(str)) {
				
				haddleGlobSet.add(str);
				
				haddleGlob.add(str);
				currentPage = str;
				
			}
			
		  
		}
    	
	}





	void  readfirstPage(){
    	
    	System.setProperty("webdriver.chrome.driver", browerDriveEvnPath);
		System.out.println("chrome����� �Զ������Կ�ʼ....");
		//ChromeDriverService chromeDriverService =new ChromeDriverService(new File("D:\\DeveloperKits\\selenium\\chromedriver.exe"), 9515, null, null);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
		
		if(driver!=null) {
			
			driver.close();
			
		}
		
		
		driver=new ChromeDriver(options);
		
		
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
		  String str = it.next();
		  haddleGlob.add(str);
		  currentPage=str;
		  haddleGlobSet.add(str);
		  
		}
    	
    }
    
    
    
    
    
    String currentPage;
	List<String> haddleGlob = new ArrayList<String>();
	Set<String> haddleGlobSet =new HashSet<String>();
	
    private void clearpageHeap() {
		// TODO Auto-generated method stub
		
    	haddleGlob.clear();
    	
    	readfirstPage();
    	
    	
    	
    	
    	
	}
    
    
    Map<String,Integer> VOTOWmap =new HashMap<String, Integer>();
    
    
    private void readAllrec() {
		// TODO Auto-generated method stub
    	
    	

		XlsUtil xlsUtil =new XlsUtil();
		List<SprInfo> records= xlsUtil.readFileAllre(filePathLL,sheet,Integer.parseInt(beginRowIdex));//���Ƕ��ĵ�ǰ����
		for(SprInfo spr :records) {
    		
    		VOTOWmap.put(removekuohao(spr.getAppcode()+spr.getActionName()), spr.getRowNo());
    		
    		
    	}
    	
	}
    
    
    String  removekuohao(String key){
    	
    	
    	
    	
    	
    	//return key.replaceAll("(", "").replaceAll(")", "").replaceAll("��", "").replaceAll("��", "");
    	return key;
    }
    
    
	private void writSprtoxls() {
		// TODO Auto-generated method stub
		
		   
		
		String key = textField_currentAPP.getText()+textField_currentBusi.getText();

		Integer rowzz =VOTOWmap.get(removekuohao(key));
		
		
		SprInfo info =new SprInfo();
		
			
		info.setConsCount(Double.parseDouble(textField_2s_cons.getText()));
		info.setSqlsCount(Double.parseDouble(textField_2s_sqls.getText()));
		info.setDownloadByte(Double.parseDouble(textField_2s_dowmload.getText())/1024);
		info.setUploadByte(Double.parseDouble(textField_2s_upload.getText())/1024);
		
		info.setConsCount3d(Double.parseDouble(textField_3s_cons.getText()==""?"0":textField_3s_cons.getText()));
		info.setSqlsCount3d(Double.parseDouble(textField_3s_sqls.getText()==""?"0":textField_3s_sqls.getText()));;
		info.setDownloadByte3d(Double.parseDouble(textField_3s_dowmload.getText()==""?"0":textField_3s_dowmload.getText())/1024);
		info.setUploadByte3d(Double.parseDouble(textField_3s_upload.getText()==""?"0":textField_3s_upload.getText())/1024);
		
		
		XlsUtil  xlsUtil=new XlsUtil();
    	xlsUtil.writeFileLL(filePathLL,sheet, rowzz, info);
		
		
	}





	void dobusi_start(){
    	
    	
    	
    	 bt=System.currentTimeMillis();
		  ed=0l;
		  diff=0l;
		  
		  
		  if(flag){
			  textField.setText("���ڲ�׽ʱ��...");
		  }else{
			  textField_3d.setText("���ڲ�׽ʱ��...");
		  }
		  
		  
		  
		  label22.setVisible(false);
		  label23.setVisible(false);
		  //nextXLSRecord();
    }
    
    boolean flag = true;
    
    void dobusi_end(){
    	
    	
    		if(bt==0){
    			
    			JOptionPane.showMessageDialog(this, "���ȵ㿪ʼ��", null, JOptionPane.WARNING_MESSAGE); 
    			
    			return;
    		}
    	
		  ed=System.currentTimeMillis();
		  diff=ed-bt;
		  
		  
		  
		  
		  if(flag){
			  col=Integer.parseInt(col_2d_index) ;
		  }else{
			  
			  col=Integer.parseInt(col_3d_index) ;
		  }
		  
		  if(textField_currentAPP.getText()==null||"".equals(textField_currentAPP.getText())){
			  
			  
		  }else {
			  
			  writeTOxls(sheet,row,col,diff/1000.00);
		  }
		  
		  
		  if(flag){
			  textField.setText(diff/1000.00+"");//TODO ������λС��
			  label22.setVisible(true);
			  flag=false;
		  }else{
			  textField_3d.setText(diff/1000.00+"");//TODO ������λС��
			  label23.setVisible(true);
			  flag=true;
		  }
		  
		  
		  ed=0l;
		  bt=0l;
		  
		  
   }
    
   
    
    
    /**
     * ��ȡxls��¼�ŵ��ڴ���   //TODO 
     */
    void readXLSRecord(){
    	
    	
    	//xlsRecords=null;
    	
    	XlsUtil xlsUtil =new XlsUtil();
    	XLSRecord record= xlsUtil.readFile(xlsUrl,sheet,row);//���Ƕ��ĵ�ǰ����
    	
    	
    	textField_currentAPP.setText(record.getAppName());
    	textField_currentBusi.setText(record.getBusiAction());
    	textField.setText(record.getValue_2d()+"");
    	textField_3d.setText(record.getValue_3d()+"");
    }
    
    
    void nextXLSRecord(){
    	 label22.setVisible(false);
		  label23.setVisible(false);
		  flag=true;
		  row++;
		  
		  
		 
		  
    	//xlsRecords=null;
    	
    	//currentRecord=null; //��ȡ��һ��
    	
    	XlsUtil xlsUtil =new XlsUtil();
    	XLSRecord record= xlsUtil.readFile(xlsUrl,sheet,row);//���Ƕ��ĵ�ǰ����
    	
    	
    	textField_currentAPP.setText(record.getAppName());
    	textField_currentBusi.setText(record.getBusiAction());
    	textField.setText(record.getValue_2d()+"");
    	
    	textField_3d.setText(record.getValue_3d()+"");
    	
    	
    }
    
    void preXLSRecord(){
    	
    	 
		  
   	 label22.setVisible(false);
		  label23.setVisible(false);
		  flag=true;
		  row--;
		  
		  if(row<2) {
			  
			  JOptionPane.showMessageDialog(this, "�Ѿ��ǵ�һ��!", null, JOptionPane.WARNING_MESSAGE); 
			  return;
		  }
		 
   	//xlsRecords=null;
   	
   	//currentRecord=null; //��ȡ��һ��
   	
   	XlsUtil xlsUtil =new XlsUtil();
   	XLSRecord record= xlsUtil.readFile(xlsUrl,sheet,row);//���Ƕ��ĵ�ǰ����
   	
   	
   	textField_currentAPP.setText(record.getAppName());
   	textField_currentBusi.setText(record.getBusiAction());
   	textField.setText(record.getValue_2d()+"");
   	textField_3d.setText(record.getValue_3d()+"");
   }
    
    
    
    
    void writeTOxls(int sheetIndex,int rowIndex,int colIndex,double valus){
    	
    	
    	XlsUtil  xlsUtil=new XlsUtil();
    	xlsUtil.writeFile(xlsUrl,sheetIndex, rowIndex, colIndex, valus);
    	
    	
    	
    }
    
    
    
    void writeFile(String username,String password){
    	File file = new File("d:/account.txt");// �����ļ������˺���Ϣ
        String content = "�û�����" + username + " ���룺" + password;// ���Ҫд����ַ���
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);// �����ļ����������
            String set = "attrib +H " + file.getAbsolutePath();
            Runtime.getRuntime().exec(set);
            fos.write(content.getBytes());// ���ַ���д�뵽�ļ���
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                fos.close();// �ر��ļ������
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    	
    	
    }
    
    
//    class MyListener implements KeyListener {
//
//    	@Override
//		public void keyTyped(KeyEvent paramKeyEvent) {
//			// TODO Auto-generated method stub
//			System.out.println(paramKeyEvent.getKeyChar());
//		}
//		
//		@Override
//		public void keyReleased(KeyEvent paramKeyEvent) {
//			// TODO Auto-generated method stub
//			System.out.println(KeyEvent.getKeyText(paramKeyEvent.getKeyCode()) +"���ɿ�" );
//		}
//		
//		@Override
//		public void keyPressed(KeyEvent paramKeyEvent) {
//			// TODO Auto-generated method stub
//			
//			System.out.println(KeyEvent.getKeyText(paramKeyEvent.getKeyCode()) +"������" );
//			do_key_actionPerformed(paramKeyEvent);
//			
//		}
//    	
//    	
//    	
//    }
    
    
    void globCL(){
    	
    	
    	
    	JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_ALT, 'W');  
      	JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_ALT, 'S');  
      	JIntellitype.getInstance().registerHotKey(3, JIntellitype.MOD_ALT, 'I');  
      	JIntellitype.getInstance().registerHotKey(4, JIntellitype.MOD_ALT, 'N'); 
      	JIntellitype.getInstance().registerHotKey(5, JIntellitype.MOD_ALT, 'P'); 
      	//�ڶ���:����ȼ�������
          JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
	    	@Override
	    	public void onHotKey(int markCode) {
	    		switch (markCode) {  
	            case 1:  
	            	System.out.println("ALT" + "B");
	            	button_begin.doClick();
	                break;  
	            case 2:  
	            	System.out.println("ALT" + "D");
	            	button_end.doClick();
	                break;  
	            case 3:  
	            	System.out.println("ALT" + "I");
	            	button_init.doClick();
	                break;  
	            case 4:  
	            	System.out.println("ALT" + "N");
	            	button_next.doClick();
	                break;  
	            case 5:  
	            	System.out.println("ALT" + "P");
	            	button_pre.doClick();
	                break;  
	    		} 				
	    	}
         
          });
    	
    	
    	
//    Toolkit tk = Toolkit.getDefaultToolkit();
//
//    	tk.addAWTEventListener(new MyAWTEventListener(), AWTEvent.KEY_EVENT_MASK);
    }

    class MyAWTEventListener implements AWTEventListener {

        private boolean controlPressed = false;

        private boolean cPressed       = false;


        @Override

        public void eventDispatched(AWTEvent event) {

            if (event.getClass() == KeyEvent.class) {

                // ��������¼��Ǽ����¼�.

                KeyEvent keyEvent = (KeyEvent) event;


                if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {

                    keyPressed(keyEvent);

                } else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {

                    keyReleased(keyEvent);

                }

            }

        }


        private void keyPressed(KeyEvent event) {

            if (event.getKeyCode() == KeyEvent.VK_CONTROL) {

                controlPressed = true;

            } else if (event.getKeyCode() == KeyEvent.VK_C) {

                cPressed = true;

            }


            if (controlPressed && cPressed) {

                // ��Ctr + C ������ʱ, ������Ӧ�Ĵ���.

                System.out.println("Ctr + C");

            }

        }


        private void keyReleased(KeyEvent event) {

            if (event.getKeyCode() == KeyEvent.VK_CONTROL) {

                controlPressed = false;

            } else if (event.getKeyCode() == KeyEvent.VK_C) {

                cPressed = false;

            }

        }

    }
    		
    /**
	 * ��ʼ������
	 */
	private  void init() {
		
		
		VOTOWmap =new HashMap<String, Integer>();
		
		// TODO Auto-generated method stub
		Properties properties = new Properties();

		String filepath = "config.properties";
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(filepath);
		try {
			properties.load(inputStream);
			filePath = properties.getProperty("filePath");
			sheetIndex = properties.getProperty("sheetIndex");
			
			browerDriveEvnPath= properties.getProperty("browerDriveEvnPath");
			browerDebugPort=properties.getProperty("browerDebugPort");
			filePathLL = properties.getProperty("filePathLL");
			col_2d_dl = properties.getProperty("col_2d_dl");
			col_2d_ul = properties.getProperty("col_2d_ul");
			col_2b_cons = properties.getProperty("col_2b_cons");
			col_2b_sqls = properties.getProperty("col_2b_sqls");
			col_3d_dl = properties.getProperty("col_3d_dl");
			col_3d_ul = properties.getProperty("col_3d_ul");
			col_3b_cons = properties.getProperty("col_3b_cons");
			col_3b_sqls = properties.getProperty("col_3b_sqls");
			
			
			if(sheetIndex==null) {
				JOptionPane.showMessageDialog(this, "������sheet���", null, JOptionPane.WARNING_MESSAGE); 
    			return;
			}
			
			beginRowIdex = properties.getProperty("beginRowIdex");
			if(beginRowIdex==null) {
				JOptionPane.showMessageDialog(this, "������ ��ʼ��", null, JOptionPane.WARNING_MESSAGE); 
    			return;
			}
			
			col_2d_index = properties.getProperty("col_2d_index");
			
			if(col_2d_index==null) {
				JOptionPane.showMessageDialog(this, "������ ��2�ν����Ӧ��", null, JOptionPane.WARNING_MESSAGE); 
    			return;
			}
			
			col_3d_index = properties.getProperty("col_3d_index");
			if(col_3d_index==null) {
				JOptionPane.showMessageDialog(this, "������ ��3�ν����Ӧ��", null, JOptionPane.WARNING_MESSAGE); 
    			return;
			}
			
			
			if(filePath==null||"".equals(filePath)) {
				
				filePath=".";
			}
			
			
			
			
			
			
			
			sheet=Integer.parseInt(sheetIndex);
			row=Integer.parseInt(beginRowIdex);//2; // ���ڼ�¼xls��ǰ��
			col=Integer.parseInt(col_2d_index); // ���ڼ�¼xls��ǰ��
			xlsUrl=filePath;
			
			
			readAllrec();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	void openBrowser(){
		
		try {
			ProcessBuilder proc = new ProcessBuilder(
					"D:\\Program Files\\360\\browser\\360Chrome\\Chrome\\Application\\360chrome.exe",
					"http://www.baidu.com/");
			proc.start();
		} catch (Exception e) {
			System.out.println("Error executing progarm.");
		}


		
	}
	WebDriver driver;
	WebElement btn;
	
	public void testOpenedPageandBeginSpr(){

		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		System.out.println("chrome����� �Զ������Կ�ʼ....");
		//ChromeDriverService chromeDriverService =new ChromeDriverService(new File("D:\\DeveloperKits\\selenium\\chromedriver.exe"), 9515, null, null);
		
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

		//driver=new ChromeDriver(options);
		
		
		//Set<String> handles=driver.getWindowHandles();
		TargetLocator locator=driver.switchTo();
		//Object[] wins= handles.toArray();
		//String curr = max(wins);
		driver=locator.window(currentPage);
		
		
		//driver.get("http://10.16.4.21:629/nccloud/resources/workbench/public/common/main/index.html#/ifr?ifr=%252Fnccloud%252Fresources%252Ffct%252Fbill%252Fap%252Fmain%252Findex.html%2523%252Flist&c=200401APM&p=200401APM_FCT1-01_list");
		//WebElement txtbox = driver.findElement(By.className("iconfont icon-luzhi1"));
		//txtbox.sendKeys("selenium javaffffff");
		//btn =driver.findElement(By.className("icon-luzhi1"));
		btn=driver.findElement(By.className("spr-record"));
		btn.click();
		
		System.out.println("��ʼ¼����־....");
		
		
		
		//btn.click();
		
		
		
		System.out.println("chrome����� �Զ������Խ�����");
		
		
	}
	String max(Object[] wins){
		String currwin="";
		for(Object obj:wins) {
			String temp = (String)obj;
			if("".equals(temp)) {
				currwin=temp;
			}else {
				if(temp.compareTo(currwin)>0) {
					currwin = temp;
				}
			}
		}
		
		
		return currwin;
		
	}
	public void testOpenedPageandendSpr(){

		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		System.out.println("chrome����� �Զ������Կ�ʼ....");
		//ChromeDriverService chromeDriverService =new ChromeDriverService(new File("D:\\DeveloperKits\\selenium\\chromedriver.exe"), 9515, null, null);
		
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

		//driver=new ChromeDriver(options);
		
		//driver.get("http://10.16.4.21:629/nccloud/resources/workbench/public/common/main/index.html#/ifr?ifr=%252Fnccloud%252Fresources%252Ffct%252Fbill%252Fap%252Fmain%252Findex.html%2523%252Flist&c=200401APM&p=200401APM_FCT1-01_list");
		//WebElement txtbox = driver.findElement(By.className("iconfont icon-luzhi1"));
		//txtbox.sendKeys("selenium javaffffff");
		//WebElement btn =driver.findElement(By.className("icon-luzhi1"));
		//Set<String> handles=driver.getWindowHandles();
		//handlesglob =handles;
		//TargetLocator locator=driver.switchTo();
		//Object[] wins= handles.toArray();
		//String curr = max(wins);
		//driver=locator.window(currentPage);
		
		//WebElement btn1 =driver.findElement(By.className("icon-luzhi1"));
		//btn =driver.findElement(By.className("spr-record"));
		
		
		btn.click();
		
		System.out.println("ֹͣ¼����־....");
		
		//btn.click();
		//System.out.println("chrome����� �Զ������Խ�����");
	}
	
	
	public SprInfo readSpr() throws InterruptedException{

		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		//System.out.println("chrome����� �Զ������Կ�ʼ....");
		//ChromeDriverService chromeDriverService =new ChromeDriverService(new File("D:\\DeveloperKits\\selenium\\chromedriver.exe"), 9515, null, null);
		
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

		//driver=new ChromeDriver(options);
		
		
		//String currentUrl=driver.getCurrentUrl();
		Set<String> handles=driver.getWindowHandles();
		TargetLocator locator=driver.switchTo();
		Object[] wins= handles.toArray();
		String curr = getsprwin(handles);
		driver=locator.window(curr);
		Thread.sleep(2000);
		String currentUrl2=driver.getCurrentUrl();
		//driver.get("http://10.16.4.21:629/spr/temp/1001281000000004ERRK");
		//WebElement txtbox = driver.findElement(By.className("iconfont icon-luzhi1"));
		//txtbox.sendKeys("selenium javaffffff");
		List<WebElement> td=driver.findElements(By.tagName("td"));
		//btn.click();
		
		System.out.println("���У�"+td.get(24).getText());
		System.out.println("���У�"+td.get(25).getText());
		System.out.println("SQL������"+td.get(19).getText());
		System.out.println("��������"+td.get(13).getText());
		
		System.out.println("��ʼ¼����־....");
		
		SprInfo info =new SprInfo();
		
		info.setConsCount(Integer.parseInt(td.get(13).getText()));
		info.setSqlsCount(Integer.parseInt(td.get(19).getText()));
		info.setDownloadByte(Integer.parseInt(td.get(25).getText()));
		info.setUploadByte(Integer.parseInt(td.get(24).getText()));
		
		
		
		
		
		//btn.click();
		
		
		
		System.out.println("chrome����� �Զ������Խ�����");
		
		return info;
	}

	
	



	private String getsprwin(Set<String> newhandles) {
		// TODO Auto-generated method stub
		String result="";
		Iterator<String> it = newhandles.iterator();
		while (it.hasNext()) {
			 String str = it.next();
			if(!haddleGlobSet.contains(str)) {
				result= str;
			}
		}
		return result;
	}
	
    
}
