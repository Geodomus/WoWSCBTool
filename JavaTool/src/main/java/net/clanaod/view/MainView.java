package net.clanaod.view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

import net.clanaod.domain.Day;
import net.clanaod.domain.Player;
import net.clanaod.domain.PlayerPlaysDay;
import net.clanaod.domain.Ship;
import net.clanaod.domain_helper.DayHelper;
import net.clanaod.domain_helper.PlayerHelper;
import net.clanaod.domain_helper.ShipHelper;

@SuppressWarnings("unchecked")
class MainView {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JComboBox playerComboBox;
    private JButton loadButton;
    private JButton newButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JTextField playerName;
    private JTextArea playerNotes;
    private JPanel shipPanel;
    private JButton newButton1;
    private JButton saveButton1;
    private JTextField shipName;
    private JTextField shipType;
    private JPanel shipsPanel;
    private JButton dayButton;
    private JComboBox dayComboBox;
    private JPanel timePanel;
    private Player player;
    private final JComboBox[] jComboBoxes;
    private final JLabel[] noteLabels;
    private final JLabel[] shipLabels;

    private final ArrayList<JToggleButton> buttonList;
    private final ArrayList<JButton> shipButtonList;
    private List<Ship> shipList;
    private DayView dv;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainView");
        frame.setContentPane(new MainView().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void refreshComboBoxes(){

        List<Player> playerList = PlayerHelper.getPlayers();
        Collections.sort(playerList);
        Object[] oa = new Object[playerList.size() + 1];
        oa[0] = " - ";
        for (int i = 0; i < playerList.size(); i++) {
            oa[i + 1] = playerList.get(i);
        }
        Object o = comboBox1.getSelectedItem();
        comboBox1.setModel(new DefaultComboBoxModel(oa));
        comboBox1.setSelectedItem(o);
        o = comboBox2.getSelectedItem();
        comboBox2.setModel(new DefaultComboBoxModel(oa));
        comboBox2.setSelectedItem(o);
        o = comboBox3.getSelectedItem();
        comboBox3.setModel(new DefaultComboBoxModel(oa));
        comboBox3.setSelectedItem(o);
        o = comboBox4.getSelectedItem();
        comboBox4.setModel(new DefaultComboBoxModel(oa));
        comboBox4.setSelectedItem(o);
        o = comboBox5.getSelectedItem();
        comboBox5.setModel(new DefaultComboBoxModel(oa));
        comboBox5.setSelectedItem(o);
        o = comboBox6.getSelectedItem();
        comboBox6.setModel(new DefaultComboBoxModel(oa));
        comboBox6.setSelectedItem(o);
        o = comboBox7.getSelectedItem();
        comboBox7.setModel(new DefaultComboBoxModel(oa));
        comboBox7.setSelectedItem(o);
        playerComboBox.setModel(new DefaultComboBoxModel(oa));

        List<Day> dayList = DayHelper.getAllDays();
        Collections.sort(dayList);
        Object[] oa1 = new Object[8];
        oa1[0] = " - ";

        for (int i = 0; i < dayList.size(); i++) {
            oa1[i + 1] = dayList.get(i);
        }
        dayComboBox.setModel(new DefaultComboBoxModel(oa1));
    }

    private void loadShips(){
        ShipHelper.importShip("Des Moines", "CA");
        ShipHelper.importShip("Pobeda", "BB");
        ShipHelper.importShip("Brennus", "CA");
        ShipHelper.importShip("Montana","BB");
        ShipHelper.importShip("Midway","CV");
        ShipHelper.importShip("Z-52","DD");
        ShipHelper.importShip("Hindenburg","CA");
        ShipHelper.importShip("GK","BB");
        ShipHelper.importShip("Shimakaze","DD");
        ShipHelper.importShip("Harugumo","DD");
        ShipHelper.importShip("Yoshino","CA");
        ShipHelper.importShip("Zao","CA");
        ShipHelper.importShip("Yamato","BB");
        ShipHelper.importShip("Hakuryu","CV");
        ShipHelper.importShip("Khabarovsk","DD");
        ShipHelper.importShip("Grozovoi","DD");
        ShipHelper.importShip("Stalingrad","CA");
        ShipHelper.importShip("Moskva","CA");
        ShipHelper.importShip("Kreml","BB");
        ShipHelper.importShip("Daring","DD");
        ShipHelper.importShip("Gearing","DD");
        ShipHelper.importShip("Minotaur","CL");
        ShipHelper.importShip("Conqueror","BB");
        ShipHelper.importShip("Audacious","CV");
        ShipHelper.importShip("Kléber","DD");
        ShipHelper.importShip("Henri IV","CA");
        ShipHelper.importShip("République","BB");
        ShipHelper.importShip("Bourgogne","BB");
        ShipHelper.importShip("Yueyang","DD");
        ShipHelper.importShip("Salem","CA");
        ShipHelper.importShip("Wooster","CL");
    }
    private void loadDays(){
        DayHelper.importDay("Monday", (byte)0);
        DayHelper.importDay("Tuesday", (byte)1);
        DayHelper.importDay("Wednesday", (byte)2);
        DayHelper.importDay("Thursday", (byte)3);
        DayHelper.importDay("Friday", (byte)4);
        DayHelper.importDay("Saturday", (byte)5);
        DayHelper.importDay("Sunday", (byte)6);
    }

    private MainView() {
        loadShips();
        loadDays();
        shipList = ShipHelper.getAllShips();
        jComboBoxes = new JComboBox[7];
        shipLabels = new JLabel[7];
        noteLabels = new JLabel[7];
        Collections.sort(shipList);
        refreshComboBoxes();
        initializeArrays();
        refreshAllLabels();
        shipName.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed(shipName, saveButton1);
            }
            public void removeUpdate(DocumentEvent e) {
                changed(shipName, saveButton1);
            }
            public void insertUpdate(DocumentEvent e) {
                changed(shipName, saveButton1);
            }
        });
        playerName.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed(playerName, saveButton);
            }
            public void removeUpdate(DocumentEvent e) {
                changed(playerName, saveButton);
            }
            public void insertUpdate(DocumentEvent e) {
                changed(playerName, saveButton);
            }
        });
        timePanel.setLayout(new GridLayout(0,6));
        shipPanel.setLayout(new GridLayout(0,4));
        buttonList = new ArrayList<JToggleButton>();
        shipButtonList = new ArrayList<JButton>();
        shipsPanel.setLayout(new GridLayout(0, 8));
        refreshShips();
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(JToggleButton button : buttonList){
                        button.setSelected(false);
                        button.setEnabled(true);
                }
                player = (Player) playerComboBox.getSelectedItem();
                tabbedPane1.setEnabledAt(3, false);
                playerName.setText(player.getPlayerName());
                playerName.setEnabled(true);
                playerNotes.setText(player.getPlayerNote());
                playerNotes.setEnabled(true);
                saveButton.setEnabled(true);
                deleteButton.setEnabled(true);
                dayButton.setEnabled(true);
                for(Ship ship : player.getShips()){
                    for(JToggleButton button : buttonList){
                        if(button.getText().equals(ship.getShipName() + "(" + ship.getShipType()+ ")")){
                            button.setSelected(true);
                        }
                    }
                }
            }
        });
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player = new Player();
                for(JToggleButton button : buttonList){
                    button.setSelected(false);
                    button.setEnabled(true);
                }
                player.setShips(new HashSet<Ship>());
                tabbedPane1.setEnabledAt(3, false);
                playerName.setEnabled(true);
                playerName.setText("");
                playerNotes.setEnabled(true);
                playerNotes.setText("");
                deleteButton.setEnabled(false);
                saveButton.setEnabled(false);
                dayButton.setEnabled(false);
                saveButton.setEnabled(true);
            }
        });
        playerComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem() instanceof Player) {
                        loadButton.setEnabled(true);
                    } else {
                        loadButton.setEnabled(false);
                    }
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerName.setEnabled(false);
                tabbedPane1.setEnabledAt(3, true);
                playerName.setText("");
                playerNotes.setEnabled(false);
                playerNotes.setText("");
                dayButton.setEnabled(false);
                deleteButton.setEnabled(false);
                PlayerHelper.deletePlayer(player);
                refreshComboBoxes();
                refreshAllLabels();
                for(JToggleButton button : buttonList){
                    button.setSelected(false);
                    button.setEnabled(true);
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.setPlayerName(playerName.getText());
                player.setPlayerNote(playerNotes.getText());
                PlayerHelper.savePlayer(player);
                playerName.setEnabled(false);
                tabbedPane1.setEnabledAt(3, true);
                playerName.setText("");
                playerNotes.setEnabled(false);
                playerNotes.setText("");
                refreshComboBoxes();
                loadButton.setEnabled(false);
                saveButton.setEnabled(false);
                deleteButton.setEnabled(false);
                dayButton.setEnabled(false);
                for(JToggleButton button : buttonList){
                    button.setSelected(false);
                    button.setEnabled(true);
                }
            }
        });
        newButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveButton1.setEnabled(false);
                shipName.setEnabled(true);
                shipType.setEnabled(true);
            }
        });
        saveButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShipHelper.importShip(shipName.getText(), shipType.getText());
                shipName.setText("");
                shipType.setText("");
                shipName.setEnabled(false);
                shipType.setEnabled(false);
                saveButton1.setEnabled(false);
                shipList = ShipHelper.getAllShips();
                Collections.sort(shipList);
                refreshShips();
            }
        });
        dayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player.getId() != 0) {
                    dv = new DayView(player);
                    dv.setSize(500, 400);
                    dv.setVisible(true);
                }
            }
        });
        dayComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    timePanel.removeAll();
                    if(e.getItem() instanceof Day) {
                        Day d = (Day) e.getItem();
                        List<PlayerPlaysDay> playerPlaysDayList = DayHelper.getAllPlayersByDay(d);
                        Collections.sort(playerPlaysDayList);
                        for(PlayerPlaysDay ppd : playerPlaysDayList){
                            JLabel l1 = new JLabel(ppd.getPlayer().getPlayerName());
                            timePanel.add(l1);
                            StringBuilder sb = new StringBuilder("");
                            if(ppd.getTimeTo() != null || ppd.getTimefrom() != null) {
                                if(ppd.getTimefrom() != null){
                                    sb.append(ppd.getTimefrom().toString());
                                }
                                if(ppd.getTimeTo() != null){
                                    sb.append(" - ");
                                    sb.append(ppd.getTimeTo().toString());
                                }
                            }
                            JLabel l2 = new JLabel(sb.toString());
                            timePanel.add(l2);
                        }
                    }
                    timePanel.revalidate();
                    timePanel.repaint();
                }
            }
        });
    }

    public void changed(JTextField jtf, JButton jb) {
        if (jtf.getText().equals("")){
            jb.setEnabled(false);
        }
        else {
            jb.setEnabled(true);
        }
    }

    public void refreshShips(){
        shipList = ShipHelper.getAllShips();
        Collections.sort(shipList);
        shipPanel.removeAll();
        shipsPanel.removeAll();
        for(Ship ship : shipList){
            JToggleButton jtb = new JToggleButton(ship.getShipName() + "(" + ship.getShipType()+ ")");
            jtb.setEnabled(false);
            jtb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JToggleButton jtb1 = (JToggleButton)e.getSource();
                    if(jtb1.isSelected()){
                        player.addShip(ShipHelper.getShipByPublicString(jtb1.getText()));
                    }else {
                        player.removeShip(ShipHelper.getShipByPublicString(jtb1.getText()));
                    }
                }
            });
            shipPanel.add(jtb);
            buttonList.add(jtb);
            JButton jb = new JButton();
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader()
                    .getResource("trash.png"));
            jb.setIcon(imageIcon);
            jb.setName(ship.getPublicString());
            jb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    ShipHelper.deleteShipByPublicString(b.getName());
                    refreshShips();
                }
            });
            JLabel l = new JLabel(ship.getPublicString());
            l.setHorizontalAlignment(JLabel.RIGHT);
            shipsPanel.add(l);
            shipsPanel.add(jb);
        }
        shipPanel.revalidate();
        shipPanel.repaint();
        shipsPanel.revalidate();
        shipsPanel.repaint();
    }

    public void initializeArrays(){
        jComboBoxes[0]= comboBox1;
        jComboBoxes[1]= comboBox2;
        jComboBoxes[2]= comboBox3;
        jComboBoxes[3]= comboBox4;
        jComboBoxes[4]= comboBox5;
        jComboBoxes[5]= comboBox6;
        jComboBoxes[6]= comboBox7;
        shipLabels[0]=label1;
        shipLabels[1]=label3;
        shipLabels[2]=label5;
        shipLabels[3]=label7;
        shipLabels[4]=label9;
        shipLabels[5]=label11;
        shipLabels[6]=label12;
        noteLabels[0]=label2;
        noteLabels[1]=label4;
        noteLabels[2]=label6;
        noteLabels[3]=label8;
        noteLabels[4]=label10;
        noteLabels[5]=label13;
        noteLabels[6]=label14;
        for(int i=0;i<7;i++){
            jComboBoxes[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    for(int i=0;i<7;i++){
                        if(e.getSource().equals(jComboBoxes[i])){
                            if(e.getStateChange() == ItemEvent.SELECTED) {
                                if(e.getItem() instanceof Player){
                                    comboBoxChange(i,(Player)e.getItem());
                                } else {
                                    comboBoxChange(i,null);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void comboBoxChange(int counter, Player player) {
        if(player != null){
            Set<Ship> shipSet = player.getShips();
            ArrayList<Ship> shipList = new ArrayList<Ship>(shipSet);
            Collections.sort(shipList);
            noteLabels[counter].setText("<html>" + player.getPlayerNote() + "</html>");
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            if (shipList.size() < 8) {
                for (Ship ship : shipList) {
                    sb.append(ship.getPublicString());
                    sb.append("<br>");
                }
            } else if (shipList.size() < 15) {
                sb.append("<style> table, th, td {border: 0px;padding: 0px}table {border-spacing: 10px 0;}</style>");
                sb.append("<table>");
                for (int i = 0; i < shipList.size(); i++) {
                    if (i % 2 == 0) {
                        sb.append("<tr><td>");
                        sb.append(shipList.get(i).getPublicString());
                        sb.append("</td>");
                    } else {
                        sb.append("<td style=\"padding-left:71px\">");
                        sb.append(shipList.get(i).getPublicString());
                        sb.append("</td></tr>");
                    }
                }
                sb.append("</table>");
            } else if (shipList.size() < 22) {
                sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                sb.append("<table>");
                for (int i = 0; i < shipList.size(); i++) {
                    if (i % 3 == 0) {
                        sb.append("<tr><td>");
                        sb.append(shipList.get(i).getPublicString());
                        sb.append("</td>");
                    } else if (i % 3 == 1) {
                        sb.append("<td style=\"padding-left:35px\">");
                        sb.append(shipList.get(i).getPublicString());
                        sb.append("</td>");
                    } else {
                        sb.append("<td style=\"padding-left:35px\">");
                        sb.append(shipList.get(i).getPublicString());
                        sb.append("</td></tr>");
                    }
                }
                sb.append("</table>");
            } else {
                sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                sb.append("<table>");
                for (int i = 0; i < shipList.size(); i++) {
                    if (i % 4 == 0) {
                        sb.append("<tr><td>");
                        sb.append(shipList.get(i).getPublicString());
                        sb.append("</td>");
                    } else if (i % 4 != 3) {
                        sb.append("<td>");
                        sb.append(shipList.get(i).getPublicString());
                        sb.append("</td>");
                    } else {
                        sb.append("<td>");
                        sb.append(shipList.get(i).getPublicString());
                        sb.append("</td></tr>");
                    }
                }
                sb.append("</table>");
            }
            sb.append("</html>");
            shipLabels[counter].setText(sb.toString());
        } else {
            shipLabels[counter].setText("");
            noteLabels[counter].setText("");
        }
    }

    public void refreshLabels(JComboBox jcb){
        for(int i=0;i<7;i++){
            if(jComboBoxes[i].equals(jcb)){
                comboBoxChange(i,null);
            }
        }
    }
    public void refreshAllLabels(){
        refreshLabels(comboBox1);
        refreshLabels(comboBox2);
        refreshLabels(comboBox3);
        refreshLabels(comboBox4);
        refreshLabels(comboBox5);
        refreshLabels(comboBox6);
        refreshLabels(comboBox7);
    }
}
