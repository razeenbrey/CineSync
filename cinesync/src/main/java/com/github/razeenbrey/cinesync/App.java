package com.github.razeenbrey.cinesync;
import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;  // For Dracula mode
import com.formdev.flatlaf.FlatDarkLaf;     // For Dark mode
import com.formdev.flatlaf.FlatLightLaf;    // For Light mode
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class App extends JFrame implements ActionListener
{
    JPanel connWind;
    Connection conn;
    JTextField a3;
    JTextField a5;
    JTextField a7;
    JButton a8;
    JButton discon;
    JLabel ci1;
    JLabel ci4;
    JLabel ci6;
    JLabel ci8;

    public static void main(String[] args) {
        App mainApp = new App();
        mainApp.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {   
        String cmd = e.getActionCommand();

        if (cmd.equals("Connect..."))
        {
            String urlStr = a3.getText();
            String userStr = a5.getText();
            String pwdStr = a7.getText();
            try {
                conn = DriverManager.getConnection(urlStr, userStr, pwdStr);
                String[] connInf = urlStr.split(":");
                ci1.setText("• Connected");
                ci1.setForeground(Color.decode("#1aed44"));
                ci4.setText(connInf[0]);
                ci6.setText(connInf[1]);
                ci8.setText(connInf[2]);
                setTitle("CineSync | " + urlStr);
                discon.setEnabled(true);
                a8.setEnabled(false);
            } catch (SQLException e1) {
                System.out.println("Failed to connect.");
            }
        }
        else if (cmd.equals("Disconnect"))
        {
            try
            {   
                conn.close();
                ci1.setText("• Disconnected");
                ci1.setForeground(Color.decode("#fc0303"));
                ci4.setText("N/A");
                ci6.setText("N/A");
                ci8.setText("N/A");
                setTitle("CineSync");
                discon.setEnabled(false);
                a8.setEnabled(true);
            } catch (SQLException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else
        {System.out.println("I'm skipping everything");}
    }

    public App()
    {
        super("CineSync");
        setSize(1920, 1080);
        setLayout(new GridLayout(2, 1, 0,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //FlatLightLaf Setup;
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        // Create JTabbedPane
        JTabbedPane mainTabbedPane = new JTabbedPane();

        // File Panel | Connection - Settings - About
        JPanel fileTab = new JPanel();
        fileTab.setLayout(new BorderLayout());

        JTabbedPane fileTabs = new JTabbedPane(JTabbedPane.LEFT);

            // connection subpanel
            JPanel connPanel = new JPanel();
            connPanel.setSize(1080, 720);
            connPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            fileTabs.addTab("Connection", connPanel);
                // Status Lable
                JLabel stsTitle = new JLabel("Status");
                stsTitle.setFont(new Font("Segoe", Font.PLAIN, 20));
                c.gridx = 0;
                c.gridy = 0;
                c.ipady = 10;
                c.anchor = GridBagConstraints.FIRST_LINE_START;
                c.fill = GridBagConstraints.BOTH;
                connPanel.add(stsTitle, c);
                // Connection information panel
                JPanel connInfPanel = new JPanel();
                connInfPanel.setSize(1080, 720);
                connInfPanel.setLayout(new GridLayout(4, 2, 1, 1));
                connInfPanel.setBackground(Color.decode("#e1e7f0"));
                    ci1 = new JLabel("• Disconnected");
                    ci1.setForeground(Color.decode("#fc0303"));
                    connInfPanel.add(ci1);
                    JLabel ci2 = new JLabel(" ");
                    connInfPanel.add(ci2);
                    JLabel ci3 = new JLabel("Server");
                    connInfPanel.add(ci3);
                    ci4 = new JLabel("N/A");
                    connInfPanel.add(ci4);
                    JLabel ci5 = new JLabel("Port");
                    connInfPanel.add(ci5);
                    ci6 = new JLabel("N/A");
                    connInfPanel.add(ci6);
                    JLabel ci7 = new JLabel("Instance");
                    connInfPanel.add(ci7);
                    ci8 = new JLabel("N/A");
                    connInfPanel.add(ci8);
                c.gridx = 0;
                c.gridy = 1;
                c.ipadx = 175;
                c.ipady = 50;
                connPanel.add(connInfPanel, c);
                // Disconnect button
                discon = new JButton("Disconnect");
                discon.setEnabled(false);
                discon.addActionListener(this);
                discon.setSize(650, 50);
                c.ipadx = 0;
                c.ipady = 0;
                c.gridx = 0;
                c.insets = new Insets(5,0,5,0);
                c.gridy = 2;
                c.anchor = GridBagConstraints.CENTER;
                c.fill = GridBagConstraints.NONE;
                connPanel.add(discon, c);
                // Connect panel
                JPanel connWind = new JPanel();
                connWind.setSize(1080, 720);
                connWind.setLayout(new GridBagLayout());
                GridBagConstraints g = new GridBagConstraints();
                connWind.setBackground(Color.decode("#e1e7f0"));
                    JLabel a1 = new JLabel("Create Connection");
                    g.gridx = 0;
                    g.gridy = 0;
                    g.fill = GridBagConstraints.BOTH;
                    g.insets = new Insets(5,0,5,0);
                    connWind.add(a1, g);
                    g.gridx = 1;
                    g.gridy = 0;
                    g.fill = GridBagConstraints.BOTH;
                    JLabel a2 = new JLabel("URL:Port:Instance");
                    g.gridx = 0;
                    g.gridy = 1;
                    g.insets = new Insets(5,0,1,0);
                    connWind.add(a2, g);
                    a3 = new JTextField(25);
                    g.gridx = 0;
                    g.gridy = 2;
                    g.insets = new Insets(1,0,5,0);
                    connWind.add(a3, g);
                    JLabel a4 = new JLabel("Username");
                    g.gridx = 0;
                    g.gridy = 3;
                    g.insets = new Insets(5,0,1,0);
                    connWind.add(a4, g);
                    a5 = new JTextField(20);
                    g.gridx = 0;
                    g.gridy = 4;
                    g.insets = new Insets(1,0,5,0);
                    connWind.add(a5, g);
                    JLabel a6 = new JLabel("Password");
                    g.gridx = 0;
                    g.gridy = 5;
                    g.insets = new Insets(5,0,5,0);
                    connWind.add(a6, g);
                    a7 = new JTextField(20);
                    g.gridx = 0;
                    g.gridy = 6;
                    g.insets = new Insets(1,0,5,0);
                    connWind.add(a7, g);
                    a8 = new JButton("Connect...");
                    a8.addActionListener(this);
                    g.gridx = 3;
                    g.gridy = 7;
                    g.insets = new Insets(0,5,5,0);
                    connWind.add(a8, g);
                c.gridx = 0;
                c.gridy = 3;
                c.ipadx = 10;
                c.ipady = 0;
                c.insets = new Insets(0,0,5,0);
                c.anchor = GridBagConstraints.LAST_LINE_START;
                connPanel.add(connWind, c);

            // about subpanel
            JPanel aboutPanel = new JPanel();
            fileTabs.addTab("About", aboutPanel);
            JLabel aboutJLabel = new JLabel("CineSync | Version Alpha (0.1.1) ");
            aboutPanel.add(aboutJLabel);
            JLabel aboutJLabel2 = new JLabel("Author: Razeen Brey");
            aboutPanel.add(aboutJLabel2);
            fileTab.add(fileTabs, BorderLayout.WEST);

        mainTabbedPane.addTab("File", fileTab);

        // Main panel | Overview
        JPanel mainTab = new JPanel();
        mainTab.add(new JLabel("Overview"));
        mainTabbedPane.addTab("Main", mainTab);

        // Edit panel | create new/ edit existing
        JPanel editTab = new JPanel();
        editTab.add(new JLabel("Edit panel | create new/ edit existing"));
        mainTabbedPane.addTab("Edit", editTab);

        // Search panel | Search functionality
        JPanel searchTab = new JPanel();
        searchTab.add(new JLabel("Search panel | Search functionality"));
        mainTabbedPane.addTab("Search", searchTab);

        add(mainTabbedPane, BorderLayout.NORTH);
        //mainFrame.add(mainTabbedPane, BorderLayout.NORTH);
        //mainFrame.setVisible(true);

    }
}
