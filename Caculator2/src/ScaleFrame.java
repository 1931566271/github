

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;
public class ScaleFrame extends JFrame implements ItemListener, KeyListener
{
    /**
     * 
     */
    private static final long serialVersionUID = 2007836309679852768L;
    JRadioButton              oldDecimalRadix;
    JRadioButton              oldBinaryRadix;
    JRadioButton              oldOctalRadix;
    JRadioButton              oldHexRadix;

    JRadioButton              oldOtherRadix;

    ButtonGroup               oldScaleGroup;

    JRadioButton              newDecimalRadix;
    JRadioButton              newBinaryRadix;
    JRadioButton              newOctalRadix;
    JRadioButton              newHexRadix;

    JRadioButton              newOtherRadix;
    ButtonGroup               newScaleGroup;
    int                       oldRadix;
    int                       newRadix;

    TextField                 newValue;
    TextField                 oldValue;

    TextField                 oldCustomRadixTF;
    TextField                 newCustomRadixTF;

    public void launchFrame()
    {
        this.setTitle("Java 万能进制转换器");
        this.setVisible(true);
        
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Panel oldRadixPanel = new Panel();
        oldValue = new TextField(10);
        Panel oldValuePanel = new Panel();
        oldValuePanel.add(new Label("转换前的值: "));
        oldValuePanel.add(oldValue);

        oldRadixPanel.setBackground(Color.white);
        oldRadixPanel.setLayout(new GridLayout(3, 1));
        oldRadixPanel.add(oldValuePanel);
        Label oldRadixLabel = new Label("转换前的进制如下:");
        oldCustomRadixTF = new TextField(10);
        oldCustomRadixTF.addFocusListener(new FocusListener()
        {

            @Override
            public void focusLost(FocusEvent arg0)
            {
                //                System.out.println();
                String text = oldCustomRadixTF.getText();
                int oldTextInt = 0;
                if (text.indexOf(".") == -1)
                {
                    oldTextInt = Integer.parseInt(text);
                }
                if (oldTextInt == 10 || oldTextInt == 2 || oldTextInt == 8 || oldTextInt == 16)
                {
                    switch (oldTextInt)
                    {
                        case 10:
                            oldDecimalRadix.setSelected(true);
                            break;
                        case 2:
                            oldBinaryRadix.setSelected(true);
                            break;
                        case 8:
                            oldOctalRadix.setSelected(true);
                            break;
                        case 16:
                            oldHexRadix.setSelected(true);
                            break;
                    }
                }
                else
                {
                    if (0 != oldTextInt)//当输入不是10、2、8、16 的整数时。
                    {
                        if (oldDecimalRadix.isSelected())
                        {
                            oldOtherRadix.setSelected(true);
                        }
                        else if (oldBinaryRadix.isSelected())
                        {
                            oldOtherRadix.setSelected(true);
                        }
                        else if (oldOctalRadix.isSelected())
                        {
                            oldOtherRadix.setSelected(true);
                        }
                        else if (oldHexRadix.isSelected())
                        {
                            oldOtherRadix.setSelected(true);
                        }
                        if (oldOtherRadix.isSelected())
                        {
                            oldCustomRadixTF.setText(text);
                        }
                    }
                }

            }

            @Override
            public void focusGained(FocusEvent arg0)
            {

            }
        });
        newCustomRadixTF = new TextField(10);
        newCustomRadixTF.addFocusListener(new FocusListener()
        {

            @Override
            public void focusLost(FocusEvent arg0)
            {
                String text = newCustomRadixTF.getText();
                int newTextInt = 0;
                if (text.indexOf(".") == -1)
                {
                    newTextInt = Integer.parseInt(text);
                }
                if (newTextInt == 10 || newTextInt == 2 || newTextInt == 8 || newTextInt == 16)
                {
                    switch (newTextInt)
                    {
                        case 10:
                            newDecimalRadix.setSelected(true);
                            break;
                        case 2:
                            newBinaryRadix.setSelected(true);
                            break;
                        case 8:
                            newOctalRadix.setSelected(true);
                            break;
                        case 16:
                            newHexRadix.setSelected(true);
                            break;
                    }
                }
                else
                {
                    if (0 != newTextInt)//当输入不是10、2、8、16 的整数时。
                    {
                        if (newDecimalRadix.isSelected())
                        {
                            //                            System.out.println("10");
                            newOtherRadix.setSelected(true);

                        }
                        else if (newBinaryRadix.isSelected())
                        {
                            newOtherRadix.setSelected(true);
                        }
                        else if (newOctalRadix.isSelected())
                        {
                            newOtherRadix.setSelected(true);
                        }
                        else if (newHexRadix.isSelected())
                        {
                            newOtherRadix.setSelected(true);
                        }
                        if (newOtherRadix.isSelected())
                        {
                            newCustomRadixTF.setText(text);
                        }
                    }
                }

            }

            @Override
            public void focusGained(FocusEvent arg0)
            {

            }
        });
        Panel oldCustomPanel = new Panel();
        oldCustomPanel.add(oldRadixLabel);
        oldCustomPanel.add(oldCustomRadixTF);
        oldRadixLabel.setAlignment(1);
        oldRadixPanel.add(oldCustomPanel);
        //        oldRadixPanel.add(radixRadios);
        oldDecimalRadix = new JRadioButton(ScaleUtil.SCALE_DECIMAL_STR);
       oldBinaryRadix = new JRadioButton(ScaleUtil.SCALE_BINARY_STR);
       oldOctalRadix = new JRadioButton(ScaleUtil.SCALE_OCTAL_STR);
        oldHexRadix = new JRadioButton(ScaleUtil.SCALE_HEX_STR);
        oldOtherRadix = new JRadioButton("");
        oldOtherRadix.setVisible(false);
        oldScaleGroup = new ButtonGroup();
        oldScaleGroup.add(oldDecimalRadix);
        oldScaleGroup.add(oldBinaryRadix);
        oldScaleGroup.add(oldOctalRadix);
        oldScaleGroup.add(oldHexRadix);
        oldScaleGroup.add(oldOtherRadix);
        Panel oldRadixRadioButton = new Panel();
        oldRadixRadioButton.add(oldDecimalRadix);
        oldRadixRadioButton.add(oldBinaryRadix);
        oldRadixRadioButton.add(oldOctalRadix);
        oldRadixRadioButton.add(oldHexRadix);
        oldRadixPanel.add(oldRadixRadioButton);
        oldDecimalRadix.addItemListener(this);
        oldBinaryRadix.addItemListener(this);
        oldOctalRadix.addItemListener(this);
        oldHexRadix.addItemListener(this);
        oldDecimalRadix.addKeyListener(this);
        oldBinaryRadix.addKeyListener(this);
        oldOctalRadix.addKeyListener(this);
        oldHexRadix.addKeyListener(this);

        Panel newRadixPanel = new Panel();
        newRadixPanel.setBackground(new Color(255, 200, 200));
        Button excuButton = new Button();

        newDecimalRadix = new JRadioButton(ScaleUtil.SCALE_DECIMAL_STR);
        newBinaryRadix = new JRadioButton(ScaleUtil.SCALE_BINARY_STR);
        newOctalRadix = new JRadioButton(ScaleUtil.SCALE_OCTAL_STR);
        newHexRadix = new JRadioButton(ScaleUtil.SCALE_HEX_STR);
        newOtherRadix = new JRadioButton("");
        newOtherRadix.setVisible(false);
        newScaleGroup = new ButtonGroup();
        newScaleGroup.add(newDecimalRadix);
        newScaleGroup.add(newBinaryRadix);
        newScaleGroup.add(newOctalRadix);
        newScaleGroup.add(newHexRadix);
        newScaleGroup.add(newOtherRadix);
        Panel newRadixRadioButton = new Panel();
        newRadixRadioButton.add(newDecimalRadix);
        newRadixRadioButton.add(newBinaryRadix);
        newRadixRadioButton.add(newOctalRadix);
        newRadixRadioButton.add(newHexRadix);

        newRadixPanel.setLayout(new GridLayout(2, 1));

        newDecimalRadix.addItemListener(this);
        newBinaryRadix.addItemListener(this);
        newOctalRadix.addItemListener(this);
        newHexRadix.addItemListener(this);
        newDecimalRadix.addKeyListener(this);
        newBinaryRadix.addKeyListener(this);
        newOctalRadix.addKeyListener(this);
        newHexRadix.addKeyListener(this);

        excuButton.setLabel("转化");
        Panel newCustomPanel = new Panel();
        newCustomPanel.add(newCustomRadixTF);
        newCustomPanel.add(excuButton);

        excuButton.addActionListener(new MyActionListener());
        newRadixPanel.add(newRadixRadioButton);
        newRadixPanel.add(newCustomPanel);
        Panel newValuePanel = new Panel();
        Label newValueLabel = new Label("转换后的值: ");
        //        newValueLabel.setAlignment(0);
        newValuePanel.add(newValueLabel);
        newValuePanel.setLayout(new FlowLayout());
        newValue = new TextField(20);
        newValue.setBackground(Color.white);
        newValue.setSize(100, 200);
        newValue.setEditable(false);
        newValuePanel.add(newValue);
        newValuePanel.setBackground(new Color(200, 200 , 255));
        this.setLayout(new BorderLayout());
        this.add(oldRadixPanel, BorderLayout.NORTH);
        this.add(newRadixPanel, BorderLayout.CENTER);
        this.add(newValuePanel, BorderLayout.SOUTH);
        this.pack();
        this.setBounds(300, 200, 500, 230);
        this.setResizable(false);

    }

   /* public static void main(String[] args)
    {
        new ScaleFrame().launchFrame();
    }*/

    // 事件 单选 在用户已选定或取消选定某项时调用。
    public void itemStateChanged(ItemEvent e)
    {
        oldCustomRadixTF.setText("");
        if (e.getSource() == oldDecimalRadix)
        {
            oldRadix = ScaleUtil.SCALE_DECIMAL;
        }
        else if (e.getSource() == oldBinaryRadix)
        {
            oldRadix = ScaleUtil.SCALE_BINARY;
        }
        else if (e.getSource() == oldOctalRadix)
        {
            oldRadix = ScaleUtil.SCALE_OCTAL;
        }
        else if (e.getSource() == oldHexRadix)
        {
            oldRadix = ScaleUtil.SCALE_HEX;
        }

        if (e.getSource() == newDecimalRadix)
        {
            newRadix = ScaleUtil.SCALE_DECIMAL;
        }
        else if (e.getSource() == newBinaryRadix)
        {
            newRadix = ScaleUtil.SCALE_BINARY;
        }
        else if (e.getSource() == newOctalRadix)
        {
            newRadix = ScaleUtil.SCALE_OCTAL;
        }
        else if (e.getSource() == newHexRadix)
        {
            newRadix = ScaleUtil.SCALE_HEX;
        }
        if (oldRadix != 0)
        {
            oldCustomRadixTF.setText("" + oldRadix);
        }
        if (newRadix != 0)
        {
            newCustomRadixTF.setText("" + newRadix);
        }
    }

    class MyActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            //            System.out.println("execute!");
            //            System.out.println(oldRadix+" ,"+newRadix);
            //            newValue.setText(oldRadix+" ,"+newRadix);
            newValue.setText("");
            int oldCustomRadInt = 0;
            int newCustomRadInt = 0;
            String oldV = oldValue.getText();
            String oldCustomRad = oldCustomRadixTF.getText();
            String newCustomRad = newCustomRadixTF.getText();
            if (oldCustomRad.indexOf(".") == -1 && !oldCustomRad.equals(""))
            {
                oldCustomRadInt = Integer.parseInt(oldCustomRad);
            }
            if (newCustomRad.indexOf(".") == -1 && !newCustomRad.equals(""))
            {
                newCustomRadInt = Integer.parseInt(newCustomRad);
            }
            if (0 != oldCustomRadInt)
            {
                oldRadix = oldCustomRadInt;
            }
            if (0 != newCustomRadInt)
            {
                newRadix = newCustomRadInt;
            }
            if (oldRadix > 0 && newRadix > 0 && oldV.indexOf(".") == -1)
            {
                String newV = ScaleUtil.scaleConversion(oldV, oldRadix, newRadix);
                newValue.setText(newV);
                if (!(null == newV || "".equals(newV)))
                {
                    System.out.println(newV);
                }
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent arg0)
    {

    }

    @Override
    public void keyReleased(KeyEvent arg0)
    {

    }

    @Override
    public void keyTyped(KeyEvent arg0)
    {

    }

}
