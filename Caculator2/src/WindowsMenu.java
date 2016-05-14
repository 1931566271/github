import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


//��ʾ���߳�
class Show extends Thread
{
	public Show(JTextField cont, String result)
	{
		nowShow = cont;
		news = result;
	}
	public void run()
	{
		nowShow.setHorizontalAlignment(JTextField.RIGHT);
		nowShow.setText(news);
		nowShow.setCaretPosition(news.length());
		
	}
	
	private String news = "";
	private JTextField nowShow;
}




//������������


////��������ʾ�Ĵ��ڿ��
public class WindowsMenu extends JFrame implements ActionListener
{
	private JTextField input;   //��ʾ����ͱ��ʽ���ı���
	String copy;
	JPanel panel;
	JMenuBar menubar;               //�˵���
	JMenu    menu1,menu2,menu3,subMenu;          //�˵�
	JMenuItem item1,item2,item3,item4,item5;         // �˵���
	JMenuItem copyItem, pasteItem, tItem, sItem;
	public WindowsMenu(String s,int x,int y,int w,int h){
	{
		init(s);//��ʼ������
		this.setTitle("��ѧ������");
		this.setSize(375,490);
		this.setResizable(false);
		//this.setBackground(SystemColor.white);
		Container contentPane = this.getContentPane();
		CaculatePanel panel = new CaculatePanel();
		contentPane.add(panel);	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
	void init(String s){
		menubar = new JMenuBar();
		menu1 = new JMenu("�鿴��V��");
		menu2 = new JMenu("�༭��E��");
		menu3 = new JMenu("������H��");
		item1 = new JMenuItem("��ѧ��");
		item2 = new JMenuItem("�鿴����");
		item3 = new JMenuItem("��׼��");
		item3.addActionListener(this);
		item4 = new JMenuItem("����ת��");
		item4.addActionListener(this);
	   item5=new JMenuItem("�ⷽ��");
	item5.addActionListener(this);
         copyItem = new JMenuItem("����(C) Ctrl+C");       
		  copyItem.addActionListener(this);    
		    pasteItem= new JMenuItem("ճ��(P) Ctrl+V");      
 pasteItem.addActionListener(this);
 menu2.add(copyItem);        
 menu2.add(pasteItem); 
 tItem = new JMenuItem("�ﾫ���Ϳ�ѧ������");    
 tItem.addActionListener(this);    
 sItem = new JMenuItem( "����Ŷ�");        
 sItem.addActionListener(this);           
 menu3.add(tItem);       
menu3.add(sItem);
		item1.setAccelerator(KeyStroke.getKeyStroke('a'));
		//item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,InputEvent.CTRL_MASK));//ctrl+1��ݼ�
		item2.setAccelerator(KeyStroke.getKeyStroke("F1"));
		item3.setAccelerator(KeyStroke.getKeyStroke('q'));
		item4.setAccelerator(KeyStroke.getKeyStroke('w'));
		menu1.setMnemonic('V');//���ÿ�ݼ�alt+V
		menu2.setMnemonic('E');
		menu3.setMnemonic('H');
		menu1.add(item1);
		menu1.addSeparator();//�ָ�����
		menu1.add(item3);
		menu1.addSeparator();//�ָ�����
		menu1.add(item4);
		menu1.addSeparator();//�ָ�����
		menu1.add(item5);
		menu3.add(item2);
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar);
		// ���ü���
	}
//�������ٿ����
class CaculatePanel extends JPanel
{
	public CaculatePanel()
	{
		this.setLayout(null);
		input = new JTextField("0.0", 20);
		input.setBounds(15, 20, 340, 50);
		input.setHorizontalAlignment(JTextField.RIGHT);
		input.setFont(new Font("����", Font.BOLD, 35));
		input.setCaretColor(Color.WHITE);
		input.setForeground(Color.WHITE);
		input.setCaretPosition(3);
		input.setOpaque(false);
		ClickButton enter = new ClickButton("enter");	
		input.addActionListener(enter);
		add(input);		
		addButton();
		
	}
	//�������ı���
	/*public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		 Image img =  Toolkit.getDefaultToolkit().getImage("back.jpg");	
		 g.drawImage(img, -4, -6, 375, 500, null);
	}*/
	// ��ť���ı���ļ�����
    private class ClickButton implements ActionListener
    {
     	public ClickButton(String buttonScript)
     	{
     		value = buttonScript;
     		  		
     	}
        public void actionPerformed(ActionEvent event)
        {
        	
        	switch(value)
        	{
        	//������һ�еĴ���������¼�
        	case "n" :  
        		if(!isInEqual(express) && !isTwooperate(express,'!'))
        		{
        			express += "!"; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("�׳�.wav");
        		}
        		break;
        	case "f":   
        		if(!isInEqual(express) && !isTwooperate(express,'^'))
        		{
        			express += "^"; input.setText(express);
        		}
        		 break;
        	case "g" : 
        		if(!isInEqual(express)) 
        		{
        	    	express += "��"; input.setText(express);
        	    	
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("����.wav");
        		}
        	    break;
        	case "p": 
        		if(!isInEqual(express) && !isTwooperate(express,'��'))             
        		{
        			express += "��"; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("pi.wav");
        		}
        		break;
        	case "c" :  
        		express = ""; 
        		countNumber = 0; 
        		countChar = 0;
        		input.setText("0.0");
        		if(musicCheck.isSelected())
        		{
        			m.play("C.wav");
        		}	
          		break;
        	//�����ڶ��еĴ���������¼�
        	case "sin": 
        		if(!isInEqual(express))  
        		{
        			express += "sin("; input.setText(express); 
       			}
        		if(musicCheck.isSelected())
        		{
        			m.play("sin.wav");
        		}
        		break;
        	case "lc" :
        		if(!isInEqual(express)) 
        		{
        			express += "("; input.setText(express);
        		}
        		 break;
        	case "rc": 
        		if(!isInEqual(express))
        		{
        			express += ")"; input.setText(express); 
        		}
        		break;
        	case "e" : 
        		if(!isInEqual(express) && !isTwooperate(express,'e'))  
        		{
        			express += "e"; input.setText(express); 
       			}
        		break;
        	case "del":
        		int len = express.length();
        		countNumber = 0; 
        		countChar = 0;
        		String temp = "";
        		if(musicCheck.isSelected())
        		{
        			m.play("DEL.wav");
        		}
        		
        		if(express.charAt(len - 1) == '(' && express.charAt(len - 2) == 's') //�жϲ����ظ�����������Ͳ����еȺ�
        		{
        			temp = express.substring(0, len - 4);
        			len -= 4;
        		}
        		else if(express.charAt(len - 1) == '(' && express.charAt(len - 2) == 'n' && express.charAt(len - 3) != 'l' )
        		{
        			temp = express.substring(0, len - 4);
        			len -= 4;
        		}
        		else if(express.charAt(len - 1) == '(' && express.charAt(len - 2) == 'g' )
        		{
        			temp = express.substring(0, len - 4);
        			len -= 4;
        		}
        		else if((express.charAt(len - 1) == '(' && express.charAt(len - 2) == 'n' && express.charAt(len - 3) == 'l' ))
        		{
           			temp = express.substring(0, len - 3);
        			len -= 3;
        			
        		}
        		else
        		{
        			temp = express.substring(0, len - 1);
        			len -= 1;
        		}  
        		if(len <= 0)
        		{        
        			input.setText("0.0"); 
        			 express = "";
        		}
        		else
        		{
        			express = temp; 
        			input.setText(express);
        		}
        	
        		break;
        	//���������еĴ���������¼�
        	case "9" :   
        		if(!isInEqual(express))
        		{
        			express += "9"; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("9.wav");
        		}
        		break;
        	case "8" : 
        		if(!isInEqual(express)) 
        		{
        			express += "8"; input.setText(express);
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("8.wav");
        		}
        		 break;
        	case "7":  
        		if(!isInEqual(express)) 
        		{
        			express += "7"; input.setText(express);
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("7.wav");
        		}
        		 break;
        	case "cos":   
        		if(!isInEqual(express))
        		{
        			express += "cos("; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("cos.wav");
        		}
        		 break;
        	case "div" :  
        		if(!isInEqual(express) && !isTwooperate(express,'��'))//�жϲ����ظ�����������Ͳ����еȺ�
        		{
        			express += "��"; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("��.wav");
        		}
        		 break;
        	//���������еĴ���������¼�
        	case "tan" :
        		if(!isInEqual(express)) 
        		{
        			express += "tan("; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("tan.wav");
        		}
        		 break;
        	case "6":   
        		if(!isInEqual(express))
        		{
        			express += "6"; input.setText(express); 
        			
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("6.wav");
        		}
        		 break;
        	case "5":   
        		if(!isInEqual(express)) 
        		{
        			express += "5"; input.setText(express);
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("5.wav");
        		}
        		 break;
        	case "4" :  
        		if(!isInEqual(express)) 
        		{
        			express += "4"; input.setText(express); 
        		
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("4.wav");
        		}
        		 break;
        	case "mul" : 
        		if(!isInEqual(express) && !isTwooperate(express,'��'))//�жϲ����ظ�����������Ͳ����еȺ�
        		{
        			express += "��"; input.setText(express);
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("��.wav");
        		}
        		 break;
        	//���������еĴ���������¼�
        	case "ln":  
        		if(!isInEqual(express)) 
        		{
        			express += "ln("; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("ln.wav");
        		}
        		 break;
        	case "3":  
        		if(!isInEqual(express))
        		{
        			express += "3"; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("3.wav");
        		}
        		 break;
        	case "2":  
        		if(!isInEqual(express)) 
        		{
        			express += "2"; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("2.wav");
        		}
        		 break;
        	case "1" :   
        		if(!isInEqual(express))
        		{
        			express += "1"; input.setText(express); 
        		
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("1.wav");
        		}
        		 break;
        	case "sub" :  
        		if(!isInEqual(express) && !isTwooperate(express,'��'))//�жϲ����ظ�����������Ͳ����еȺ�
        		{
        			express += "��"; input.setText(express); 
        			
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("��.wav");
        		}
        		 break;
        	//���������еĴ���������¼�
           	case "log":  
           		if(!isInEqual(express)) 
           		{
           			express += "log("; input.setText(express);
           			
           		}
        		if(musicCheck.isSelected())
        		{
        			m.play("log.wav");
        		}
           	 break;
        	case "0":    
        		if(!isInEqual(express))
        		{
        			express += "0"; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("0.wav");
        		}
        		 break;
        	case "dot":  
        		if(!isInEqual(express) && !isTwooperate(express,'.'))//�жϲ����ظ�����������Ͳ����еȺ�
        		{
        			express += "."; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("��.wav");
        		}
        		 break;
         	 //�Ⱥż��İ�ť�¼�
        	case "res" :  
        		if(musicCheck.isSelected())
  		        {
        			m.play("=.wav");
  		        }
        		if(!isInEqual(express)&& !isTwooperate(express,'=')) //�жϲ����ظ�����������Ͳ����еȺ�
        		{
        			if(isRightExpress())
        			{
        		     	express += "=";
         		        String target = express.substring(0, express.length() - 1); //����ȡ���ַ���ȥ���Ⱥź�ֵ
         	
         		        if(caculate(target)) //���ü������Ĵ�����
         		        {
         		            //input.setText(express + right.format(last));
         		            Show n = new Show(input, express + right.format(last)); //��������ı����д�ӡ����        
         		            n.start();
         		            if(musicCheck.isSelected())
         		            {
         		    	        m.play("=.wav");
         		    	    	long done2= System.currentTimeMillis() ;
         		             	while(true)
         		   	           {
         		       	           long current = System.currentTimeMillis() ;
         		        	       if((current - done2) >= 800)
         		   		          break;
         		               }
         		    	      sheng( String.valueOf(right.format(last)));
         		             }
         		        }
         		        else
         		        {
         		        	input.setText("����"); 	    	
         		        }
        			}
         	    }
         
       		 break;
        	case "add" :  
        		if(!isInEqual(express) && !isTwooperate(express,'+'))
        		{
        			express += "+"; input.setText(express); 
        		}
        		if(musicCheck.isSelected())
        		{
        			m.play("��.wav");
        		}
        		 break;
        	 //�ı�����¼�
        	case "enter": 
        		express = input.getText();
        		if(musicCheck.isSelected())
  		        {
        			m.play("=.wav");
  		        }
        		if(!isInEqual(express) && !isTwooperate(express,'='))
        		{
        			countNumber = 0;
        			countChar = 0;        			
        		    express += "="; 
        		    input.setText(express); 
        		    String target = express.substring(0, express.length() - 1);
       
        		    if(caculate(target))
        		    {
        		    	input.setText(express + right.format(last));  
        		    	String c = express + right.format(last);
        		    	input.setCaretPosition(c.length());
        		    	if(musicCheck.isSelected())
          		        {
          		    	    
          		    		long done2= System.currentTimeMillis() ;
          		         	while(true)
          		   	       {
          		       	        long current = System.currentTimeMillis() ;
          		        	    if((current - done2) >= 400)
          		   		        break;
          		           }
          		    	   sheng(right.format(last));
          		       }
        		    }
        		    else
        		    {
        		    	input.setText("����"); 	    	
        		    }
        		}  			
        		 break;
        	case "m" :  break;
        	default :    input.setText("0.0");
        	}   	    
   	    }
        private String value = "0.0";
    }
    
        
 boolean isRightExpress()
 {
	 String temp = input.getText();
	 int tlc = 0;
	 int trc = 0;
	 int dotnum = 0;
	 for(int i = 0; i < temp.length(); i++)
	 {
		 if(temp.charAt(i) == '(')
		 {
			 tlc++;
			 if(i + 1 < temp.length())
			 {
				 if(temp.charAt(i + 1) == ')')
				 {
					 input.setText(temp + "���ʽ��ȱʧ��ֵ");
					 return false;
				 }
				 if(temp.charAt(i + 1) == '.')
				 {
					 input.setText(temp + "���ʽ����");
					 return false;
				 }
				 if(temp.charAt(i + 1) == '+' || temp.charAt(i + 1) == '^' || temp.charAt(i + 1)  == '��' || temp.charAt(i + 1) == '��' || temp.charAt(i + 1) =='!')
				 {
					 input.setText(temp + "���ʽ����");
					 return false;
				 }
			 }
			 
		 }
		 if(temp.charAt(i) == ')')
		 {
			 trc++;
			 if(i + 1 < temp.length())
			 {
				 if(isNumber(temp.charAt(i + 1)))
				 {
						input.setText(temp + "����ı��ʽ����");
					     return false;	
				 }
				 if(temp.charAt(i + 1) == '(')
				 {
						input.setText(temp + "����ı��ʽ����");
					     return false;
				 }
			 }
		 }
		 if(temp.charAt(i) == '��')	 
		 {
			 if(i + 1 < temp.length())
			 {
				 
				 if(!isNumber(temp.charAt(i + 1)))
				 {
		     		input.setText(temp + "����ı��ʽ����");
				     return false;	
				 }	
			 }
			 else
			 {
				input.setText(temp + "����ı��ʽ����");
			     return false;	
			 }
		 }
		 if(temp.charAt(i) == '.')
		 {
			if(!isNumber(temp.charAt(i + 1)))
			{	 
				input.setText(temp + "����ı��ʽ����");
			     return false;		
			}
			else
			{
				i++;
				for(; i < temp.length(); i++)
				{
					if(isD(temp.charAt(i)) || isS(temp.charAt(i)) || temp.charAt(i) == ')' ||temp.charAt(i) == '(')
					{
						 i -= 1;		
						break;
					}
				    if(temp.charAt(i) == '.')
				    {
				    	input.setText(temp + "����ı��ʽ����");
					    return false;	
				    }
				}
			}
		 }
			 
	 }
	 if(tlc > trc)
	 {
		 input.setText(temp + "���ʽȱʧ������");
		 return false;
	 }
	 else if(tlc < trc)
	 {
		 input.setText(temp + "���ʽȱʧ������");
		 return false;
	 }
	 else
	 {
		 express = temp;
		 return true;
	 }
	 	 
 }
 //�жϵ�Ŀ�����
 public boolean  isD(char a)
 {
	 if(a == '!' || a == 's' || a == 'c' || a == 't' || a == 'l' || a == '��')
	 {
		 return true;
	 }
	 else
		 return false;
 }
//�ж�˫Ŀ�����
 public boolean isS(char b)
 {

	 if(b == '^' || b == '��' || b == '��'  || b == '+' || b == '��' )
	 {
		 return true;
	 }
	 else
		 return false;
 }
   // �����ַ����������� 
	public void sheng(String s) 
	{
		
		int dot = -1;
		char c = 'a';
		
		//�ж�dot��λ��
		for(int i = 0;i < s.length();i++)
		{
			c = s.charAt(i);
			if(c == '.')
				dot = i	;
		}		
		int lg = s.length();		
		if(dot != -1)
		{
			lg = dot;	
		}		
		int lh = lg;		
	    if(s.charAt(0) == '-') //�ж��Ƿ��и���
        {
      	   lh--;
      	    m.play("��.wav");
    	    //�ӳٶ���
        	long done0= System.currentTimeMillis() ;
        	while(true)
    	    {
        	    long current = System.currentTimeMillis() ;
         	    if((current - done0) >= 400)
    		   break;
            }
        }
	    //��ʼ������
	    char d = 'a';
	    int zero = 0;
		for(int i = 0;i < lg;i++)
		{
	            d = s.charAt(i);
	            if(d == '0')
	            {
	            	if(zero == 0)
	            	{
	            		 m.play(d+".wav");
	            	}               
	                zero = 1;
	            }
	            else
	            {
	            	m.play(d+".wav");
	            }
		        long done1 = System.currentTimeMillis() ;//�ӳٶ���
	         	while(true)
		    	{
				     long current = System.currentTimeMillis() ;
				     if((current - done1) >= 400)
				    	break;
			    }	    		    	   
	            switch(lh)
		        {
		        	case 2: m.play("ʰ.wav"); break;
		        	case 3: m.play("��.wav"); break;
		        	case 4: m.play("ǧ.wav"); break;
			       	case 5: m.play("��.wav"); break;
		        	case 6: m.play("ʰ.wav"); break;
		        	case 7: m.play("��.wav"); break;
		    		case 8: m.play("ǧ.wav"); break;
				    case 9: m.play("��.wav"); break;
			 	    default: break;			
	             }	    
	    	lh--;	    	
	    	long done3 = System.currentTimeMillis() ; //�ӳٶ���
			while(true)
			{
				long current = System.currentTimeMillis() ;
				if((current  - done3) >= 400)
					break;
			}
		}	
		if(dot != -1)  //��С�����С��������ֵ
		{
			m.play("��.wav");		
			for(int j = lg; j < s.length(); j++)
			{
				char temp = s.charAt(j);
				long done4 = System.currentTimeMillis() ;//�ӳٶ���
				while(true)
				{
					long current = System.currentTimeMillis() ;
					if((current - done4) >= 400)
						break;
				}
				m.play(temp+".wav");				
			}
		}
	}
	
    //��Ӱ�ť�ĺ���
	public void addButton()
	{
		int l = 125;
		int h = 15;		
		
        //�ٿ����ĵ�1�а�ť
		musicCheck = new JCheckBox("����");
		musicCheck.setFont(new Font("����", Font.BOLD, 12));
		musicCheck.setForeground(Color.WHITE);
		ClickButton click0 = new ClickButton("m");		//����������
		musicCheck.addActionListener(click0);
		musicCheck.setBounds(13, 95, 60, 20);
		musicCheck.setOpaque(true);
		musicCheck.setBackground(Color.DARK_GRAY);
		add(musicCheck);
		
		JButton tempn = new JButton("!");	
		ClickButton click1 = new ClickButton("n");		//����������
		tempn.addActionListener(click1);
		tempn.setBounds(h, l, 60, 40);
		add(tempn);
		h += 70;			
		JButton tempf = new JButton("^");	
		ClickButton click2 = new ClickButton("f");	//����������
		tempf.addActionListener(click2);
		tempf.setBounds(h, l, 60, 40);
		add(tempf);
		h += 70;			
		JButton tempg = new JButton("sqrt");	
		ClickButton click3 = new ClickButton("g");	//����������
		tempg.addActionListener(click3);
		tempg.setBounds(h, l, 60, 40);
		add(tempg);	
		h += 70;		
		JButton tempp = new JButton("��");	
		ClickButton click4 = new ClickButton("p");	//����������
		tempp.addActionListener(click4);
		tempp.setBounds(h, l, 60, 40);
		add(tempp);	
		h += 70;		
		JButton tempc = new JButton("C");
		ClickButton click5 = new ClickButton("c");	//����������
		tempc.addActionListener(click5);
		tempc.setBounds(h, l, 60, 40);
		add(tempc);	
		h += 70;	
		
		//�ٿ����ĵ�2�а�ť
	    l += 55;
	    h = 15;		
		JButton tempsin = new JButton("sin");
		ClickButton click6 = new ClickButton("sin");	//����������
		tempsin.addActionListener(click6);
		tempsin.setBounds(h, l, 60, 40);
		add(tempsin);
		h += 70;	
		
		JButton templc = new JButton("(");	
		ClickButton click7 = new ClickButton("lc");	//����������
		templc.addActionListener(click7);	
		templc.setBounds(h, l, 60, 40);
		add(templc);
		h += 70;
		
		JButton temprc = new JButton(")");		
		ClickButton click8 = new ClickButton("rc");	//����������
		temprc.addActionListener(click8);
		temprc.setBounds(h, l, 60, 40);
		add(temprc);
		h += 70;
			
		JButton tempe= new JButton("e");		
		ClickButton click10 = new ClickButton("e");	//����������
		tempe.addActionListener(click10);
		tempe.setBounds(h, l, 60, 40);
		add(tempe);
		h += 70;
		
		JButton tempdel = new JButton("DEL");		
		ClickButton click9 = new ClickButton("del");	//����������
		tempdel.addActionListener(click9);
		tempdel.setBounds(h, l, 60, 40);
		add(tempdel);
	

		//�ٿ����ĵ�3�а�ť
	    l += 55;
	    h = 15;		
		JButton tempcos = new JButton("cos");
		ClickButton click11= new ClickButton("cos");	//����������
		tempcos.addActionListener(click11);
		tempcos.setBounds(h, l, 60, 40);
		add(tempcos);
		h += 70;	
		
		JButton temp9 = new JButton("9");	
		ClickButton click12= new ClickButton("9");	//����������
		temp9.addActionListener(click12);
		temp9.setBounds(h, l, 60, 40);
		add(temp9);
		h += 70;
		
		JButton temp8 = new JButton("8");	
		ClickButton click13= new ClickButton("8");	//����������
		temp8.addActionListener(click13);
		temp8.setBounds(h, l, 60, 40);
		add(temp8);
		h += 70;
		
		JButton temp7 = new JButton("7");	
		ClickButton click14 = new ClickButton("7");	//����������
		temp7.addActionListener(click14);
		temp7.setBounds(h, l, 60, 40);
		add(temp7);
		h += 70;	
		
		JButton tempdiv= new JButton("div");	
		ClickButton click15 = new ClickButton("div");	//����������
		tempdiv.addActionListener(click15);
		tempdiv.setBounds(h, l, 60, 40);
		add(tempdiv);

	
		//�ٿ����ĵ�4�а�ť
	    l += 55;
	    h = 15;		
		JButton temptan = new JButton("tan");
		ClickButton click16 = new ClickButton("tan");	//����������
		temptan.addActionListener(click16);
		temptan.setBounds(h, l, 60, 40);
		add(temptan);
		h += 70;	
		
		JButton temp6 = new JButton("6");	
		ClickButton click17 = new ClickButton("6");//����������	
		temp6.addActionListener(click17);
		temp6.setBounds(h, l, 60, 40);
		add(temp6);
		h += 70;
		
		JButton temp5 = new JButton("5");	
		ClickButton click18 = new ClickButton("5");	//����������
		temp5.addActionListener(click18);
		temp5.setBounds(h, l, 60, 40);
		add(temp5);
		h += 70;
		
		JButton temp4 = new JButton("4");	
		ClickButton click19 = new ClickButton("4");	//����������
		temp4.addActionListener(click19);
		temp4.setBounds(h, l, 60, 40);
		add(temp4);
		h += 70;	
		
		JButton tempmul = new JButton("��");	
		ClickButton click20 = new ClickButton("mul");	//����������
		tempmul.addActionListener(click20);
		tempmul.setBounds(h, l, 60, 40);
		add(tempmul);
		h += 70;

		//�ٿ����ĵ�5�а�ť
	    l += 55;
	    h = 15;		
		JButton templn = new JButton("ln");	
		ClickButton click21= new ClickButton("ln");	//����������
		templn.addActionListener(click21);
		templn.setBounds(h, l, 60, 40);
		add(templn);
		h += 70;
		
		JButton temp3 = new JButton("3");	
		ClickButton click22 = new ClickButton("3");	//����������
		temp3.addActionListener(click22);
		temp3.setBounds(h, l, 60, 40);
		add(temp3);
		h += 70;
		JButton temp2 = new JButton("2");
		ClickButton click23 = new ClickButton("2");	//����������
		temp2.addActionListener(click23);
		temp2.setBounds(h, l, 60, 40);
		add(temp2);
		h += 70;
		
		JButton temp1 = new JButton("1");	
		ClickButton click24 = new ClickButton("1");	//����������
		temp1.addActionListener(click24);
		temp1.setBounds(h, l, 60, 40);
		add(temp1);
		h += 70;
		
		JButton tempsub= new JButton("-");	
		ClickButton click25 = new ClickButton("sub");//����������	
		tempsub.addActionListener(click25);
		tempsub.setBounds(h, l, 60, 40);
		add(tempsub);
		
		//�ٿ����ĵ�6�а�ť
	    l += 55;
	    h = 15;		
		JButton templog = new JButton("log");	
		ClickButton click26 = new ClickButton("log");	//����������
		templog.addActionListener(click26);
		templog.setBounds(h, l, 60, 40);
		add(templog);
		h += 70;
		
		JButton temp0= new JButton("0");	
		ClickButton click27 = new ClickButton("0");	//����������
		temp0.addActionListener(click27);
		temp0.setBounds(h, l, 60, 40);
		add(temp0);
		h += 70;
		JButton tempdot = new JButton(".");
		ClickButton click28 = new ClickButton("dot");//����������	
		tempdot.addActionListener(click28);
		tempdot.setBounds(h, l, 60, 40);
		add(tempdot);
		h += 70;
		
		JButton tempres= new JButton("=");	
		ClickButton click29 = new ClickButton("res");//����������	
		tempres.addActionListener(click29);
		tempres.setBounds(h, l, 60, 40);
		add(tempres);
		h += 70;
		
		JButton tempadd = new JButton("+");	
		ClickButton click30 = new ClickButton("add");	//����������
		tempadd.addActionListener(click30);
		tempadd.setBounds(h, l, 60, 40);
		add(tempadd);
		
	}
	//�жϱ��ʽ���Ƿ��еȺ�
	boolean isInEqual(String test)
	{
		for(int i = 0; i < test.length(); i++)
		{
			if('=' == test.charAt(i))
				return true;		
		}
		return false;		
	}
	//�ж��Ƿ������β�����
	boolean isTwooperate(String test, char temp)
	{
		if(test.length() == 0)
		{
			if(temp == '��' || temp == 'e' )
				return false;
			else
				return true;
		}
		else 	
		{
			if(temp == '��' || temp == 'e' )
			{
				if(test.charAt(test.length() - 1) == '��' || test.charAt(test.length() - 1) == 'e' )
					return true;
				else
					return false;				
			}
			else
			{
				if(test.charAt(test.length() - 1) == temp || test.charAt(test.length() - 1) == '^' || test.charAt(test.length() - 1) == '.' || test.charAt(test.length() - 1) == '+' ||  test.charAt(test.length() - 1) == '��' ||  test.charAt(test.length() - 1) == '��' ||  test.charAt(test.length() - 1) == '��' )
				{
					return true;
				}
				else
					return false;
			}
			
		}
	}
	//���ձ��ʽ����ʼ����
	boolean caculate(String sb)
	{
		//�����ַ���,������ڲ��ܹ�ʶ��Ĺ淶���ʽ
		String temp = "";
		 
		for(int i = 0; i < sb.length(); i++)
		{
			if(sb.charAt(i) != 's' && sb.charAt(i) != 't' && sb.charAt(i) != 'c' && sb.charAt(i) != 'l')
			{
				temp += sb.charAt(i);	
				if(i + 1 < sb.length())
				{
		    		if(sb.charAt(i) == ')'&& (sb.charAt(i + 1) == 's' || sb.charAt(i + 1) == 't' || sb.charAt(i + 1) == 'c' || sb.charAt(i + 1) == 'l'|| sb.charAt(i + 1) == '��'|| sb.charAt(i + 1) == 'e'))
		    		{
		    			temp += '��';
		    		}
		    		if(sb.charAt(i) == '!' && isNumber(sb.charAt(i + 1)))
			    	{
		    			temp += '��';	
		        	}
		    		if(isNumber(sb.charAt(i)) && (sb.charAt(i + 1) == 's' || sb.charAt(i + 1) == 't' || sb.charAt(i + 1) == 'c' || sb.charAt(i + 1) == 'l'))
		    		{
		    			temp += '��';	
		    		}
			    	if(sb.charAt(i + 1) == '��' && isNumber(sb.charAt(i)))
			    	{
			     		temp += '��';	
			    	}
			    	if(isNumber(sb.charAt(i))  && sb.charAt(i + 1) == '(')
			    	{
			    		temp += '��';	
			    	}
			    	if(isNumber(sb.charAt(i + 1))  && sb.charAt(i) == ')')
			       	{
			    		temp += '��';	
			    	}
				}
				
			}
			else
			{
				if( sb.charAt(i) == 'l')	
				{
					if(sb.charAt(i + 1) == 'o')
					{
						i += 2;
						temp += "o";						
					}
					else
					{
						i += 1;
						temp += "n";											
					}	
				}
				else
				{
					i += 2;
					temp += sb.charAt(i - 2);					
				}
			}
	
		}
		temp += "#"; //��ӱ�Ǳ����Ѿ�������β
	
		//��ʼ������ʽ	
		character[countChar] = '#'; //��������ջ
		countChar++;

		int i = 0;
		while(countChar != 0) //����
		{

			if(isNumber(temp.charAt(i))) //�ж��Ƿ�������
			{
				double a;
				a = temp.charAt(i) - 48;		
				i++;
				while(isNumber(temp.charAt(i)) && i < temp.length())
				{
					a *= 10;
					double b = temp.charAt(i) - 48;
				
					a += b;
					i++;
				}
			
				if(temp.charAt(i) == '.') //�ж��Ƿ���С��
				{
					i++;
					int loc = i - 1;
					while(isNumber(temp.charAt(i)) && i < temp.length())
					{
						
						double b = temp.charAt(i) - 48;
						
						int t = 0;
						int w = i - loc;
						while(t < w)
						{
							b /= 10;
							t++;
						}
						a += b;
						i++;
					}
				}
	
				//�Ƿ��������ַ�e �� pI
				if(temp.charAt(i) == 'e') 
				{
					a *= e;
					i++;
				}
				else if(temp.charAt(i) == '��')
				{
					a *= pi;
					i++;
				}		
		
				number[countNumber] = a;  //ת�������ֵ��ջ
		
				countNumber++;	
			}
			else //������
			{
				if(temp.charAt(i) == 'e')
				{
					number[countNumber] = e;  //ת�������ֵ��ջ
					countNumber++;
					i++;
				}
				else if(temp.charAt(i) == '��')
				{
					number[countNumber] = pi;  //ת�������ֵ��ջ
					countNumber++;
					i++;
				}
				else if(temp.charAt(i) == '(' && temp.charAt(i + 1) == '��') //�ж��ǲ��Ǹ���
				{
					i = i + 2;
					double a = 0;
					if(temp.charAt(i) == 'e' || temp.charAt(i) == '��')
					{
						if(temp.charAt(i) == 'e')
						{
							a = e;
						}
						else
						{
							a = pi;
						}
					}
					else
					{
						a = (temp.charAt(i) - 48);
						i++;
						while(isNumber(temp.charAt(i)) && i < temp.length())
						{
							a *= 10;
							double b = temp.charAt(i) - 48;
							a += b;
							i++;
						}
						if(temp.charAt(i) == '.')
						{
							i++;
							while(isNumber(temp.charAt(i)) && i < temp.length())
							{
								
								double b = temp.charAt(i) - 48;
								b *= 0.1;
								a += b;
								i++;
							}
						}
						if(temp.charAt(i) == 'e') 
						{
							a *= e;
							i++;
						}
						else if(temp.charAt(i) == '��')
						{
							a *= pi;
							i++;
						}				
					}
					
					number[countNumber] = -1 * a;   //ת�������ֵ��ջ
					
					countNumber++;	
					i++;
				}
				else //�ǲ�����
				{				
					if(isHigh(temp.charAt(i)))
					{
					
						character[countChar] = temp.charAt(i);	 //��������ջ
						countChar++;
						i++;
					}
					else
					{
						if(!begin()) //��������ջ
						{
							if(temp.charAt(i) == ')')
							{
								i++;
							}							
						}									
					}					
				}				
			}			
		}
		//�������ֵ��ȫ�ֱ���last����ӡ���ı���
        last = number[0];
		return true;
	}
	//�ж��ǲ�������
	boolean isNumber(char a) 
	{
		if(a <= '9' && a >= '0')
			return true;
		else
			return false;
	}
	//�ж����ȼ��ߵ�
	boolean isHigh(char tchar)
	{
		switch(tchar) //�����ַ��������ȼ�
		{
		case '(':
			return true;
		case '+':  
			if(character[countChar - 1] == '#' || character[countChar - 1] == '(')
			{
				return true;
			}
			else
			{
				return false;
			}
			
		case '��':
	
			if(character[countChar - 1] == '#' || character[countChar - 1] == '(')
			{
				return true;
			}
			else
				return false;
		case '��' :
			
			if(character[countChar - 1] == '#' ||character[countChar - 1] == '+' || character[countChar - 1] == '��' || character[countChar - 1] == '(' )
				return true;
			else
				return false;
		case '��':
			if(character[countChar - 1] == '#' ||character[countChar - 1] == '+' || character[countChar - 1] == '��' || character[countChar - 1] == '(' )
			{
				return true;
			}
			else
				return false;
		case ')':
			return false;
		case '��':
			return true;
		case '!':
			return true;
		case '^':
			if(character[countChar - 1] == '!' )
				return false;
			else
			{
				return true;
			}
			
		case 's':
			if(character[countChar - 1] == '!' ||character[countChar - 1] == '��' )
			{
				return false;
			}
			else
			{
				return true;
			}

		case 'c':
			if(character[countChar - 1] == '!' ||character[countChar - 1] == '��' )
			{
				return false;
			}
			else
			{
				return true;
			}
		case 'o':
			if(character[countChar - 1] == '!' ||character[countChar - 1] == '��' )
			{
				return false;
			}
			else
			{
				return true;
			}
		case 'n':
			if(character[countChar - 1] == '!' ||character[countChar - 1] == '��')
			{
				return false;
			}
			else
			{
				return true;
			}
		case 't':
			if(character[countChar - 1] == '!' ||character[countChar - 1] == '��' )
			{
				return false;
			}
			else
			{
				return true;
			}
		case '#':  
			return false;
			
		default:
			return false;		    
		}
	}
	//��ջ��ȡֵ���м���
	boolean begin()
	{
		char operate = character[countChar - 1]; //�Ӳ�����ջ��ȡ��������
		countChar--;	
			
		if(operate == '(')
		{	
		
			return false;
		}
		else if(operate == '#')
		{
			return true;
		}
		//�ж��ǵ�Ŀ�����
		else if(operate == 's' || operate == 'o'  || operate == 'n' || operate == 'c' || operate == 't' || operate == '!' || operate == '��' )
		{
			double n1 = number[countNumber - 1];
			countNumber--;
			if(operate == 's')
			{
				  
				double tempNumber = Double.parseDouble(right.format(Math.sin(n1)));	
				if( tempNumber == -0.0)
				{
					tempNumber =0;
				}	
				number[countNumber] = tempNumber;			
				countNumber++;
			}
			else if(operate == 'o')
			{
				double tempNumber = Math.log10(n1);
				number[countNumber] = tempNumber;
				countNumber++;
			}
			else if(operate == 'n' )
			{
				
				double tempNumber = Math.log(n1)  ;
				number[countNumber] = tempNumber;			
				countNumber++;			
			}
			else if(operate == 'c')
			{
				double tempNumber = Double.parseDouble(right.format(Math.cos(n1)));	
				number[countNumber] = tempNumber;			
				countNumber++;	
				
			}
			else if( operate == 't' )
			{
				double tempNumber = Double.parseDouble(right.format(Math.tan(n1)));	
				number[countNumber] = tempNumber;
				countNumber++;					
			}
			else if(operate == '!' )
			{		
				if(n1 < 0)
				{
					return false;
				}
				else
				{
					double tempNumber  = 1;
					for(int j = 1; j <= n1; j++)
						tempNumber *= j;					
					number[countNumber] = tempNumber;
					countNumber++;		
				}
			}
			else
			{
				if(n1 < 0)
				{
					return false;
				}
				else
				{
					double tempNumber  = Math.sqrt(n1);
					number[countNumber] = tempNumber;
					countNumber++;		
				}
			}
							
		}
		else  //�ж���˫Ŀ�����
		{
			if(operate == '+')
			{

				double n1 = number[countNumber - 1];
				countNumber--;
				double n2 = number[countNumber - 1];
				countNumber--;				
				double tempNumber  = n1 + n2;	
				number[countNumber] = tempNumber;	
				countNumber++;				
				
			}
			else if(operate == '��')
			{
				double n1 = number[countNumber - 1];
				countNumber--;
				double n2 = number[countNumber - 1];
				countNumber--;	
		    	double tempNumber  = n2 - n1;			
				number[countNumber] = tempNumber;
				countNumber++;	
				
			}
			else if(operate == '��')
			{
				double n1 = number[countNumber - 1];
	           
				countNumber--;
				double n2 = number[countNumber - 1];
				countNumber--;				
				double tempNumber  = n1 * n2;
				number[countNumber] = tempNumber;
				countNumber++;	
				
			}
			else if(operate == '��')
			{
				double n1 = number[countNumber - 1];
				countNumber--;
				double n2 = number[countNumber - 1];
				countNumber--;
				if(n2 == 0)
					return false;			
				double tempNumber  = n2 * 1.0 / n1;
				number[countNumber] = tempNumber;
				countNumber++;				
			}
			else
			{
				double n1 = number[countNumber - 1];
				countNumber--;
				double n2 = number[countNumber - 1];
				countNumber--;		
				double tempNumber  = Math.pow(n2, n1);
				number[countNumber] = tempNumber;
				countNumber++;				
			}
		}
		return true;

	}
	
	//������������
	private Music m;
	private JCheckBox musicCheck ;
	private String express = "";  //���ڱ�����ʽ
	private double pi = Math.PI;  //��ֵpI
	private double e = Math.E;  //��ֵe
	private double last = 0.0;  //���ڱ�����
	
	private int countChar = 0;	 //�����ջ��Ԫ����
	private int countNumber = 0;  //��ֵջ��Ԫ����
	
	private char [] character  = new char[100];		//�����ջ
	private double [] number = new double[100];	    //��ֵջ
	
	private DecimalFormat right = new DecimalFormat("#.########");   //�޶����Ϊ��ȷС�����6λ
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object tem=e.getSource();
	    if(tem==item3){
	    	new CaculatePanel();
	    }
	if(tem==item4){
		new ScaleFrame().launchFrame();
		
	}
	if(tem==item5){
		Scanner reader=new Scanner(System.in);
		System.out.printf("a=");
		double x=reader.nextDouble();
		System.out.printf("b=");
		double y=reader.nextDouble();
		System.out.printf("c=");
		double z=reader.nextDouble();
		try {
			double[] results=new equ(x,y,z).analyze();
			for(int i = 0; i < results.length; i++){
				System.out.println("x = " + results[i]);
			}
		} catch (Exception e1) {
			System.out.println("No Result");
		
		}
	}
	//����'����'�˵��� 
	if (tem == copyItem) {    
		  copy = input.getText();       
		  }                  
		//����'ճ��'�˵���     
		if (tem == pasteItem) {          
			input.setText(copy);          }    
		if (tem == sItem){
		
			JOptionPane.showMessageDialog(panel,"\n�����Ϳ�ѧ������\n  ");       
		}
}

}
