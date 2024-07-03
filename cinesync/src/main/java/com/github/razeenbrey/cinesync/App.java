package com.github.razeenbrey.cinesync;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;

public class App 
{
    public static void main( String[] args )
    {
        //FlatLightLaf Setup;
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        // Mainframe
        JFrame mainFrame = new JFrame("CineSync");
        mainFrame.setSize(750, 500);
        mainFrame.setLayout(new GridLayout(2, 1, 0,1));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JTabbedPane
        JTabbedPane mainTabbedPane = new JTabbedPane();

        // File Panel | Connection - Settings - About
        JPanel fileTab = new JPanel();
        fileTab.setLayout(new BorderLayout());

        JTabbedPane fileTabs = new JTabbedPane(JTabbedPane.LEFT);

            // connection subpanel
            JPanel connPanel = new JPanel(new GridLayout(4, 1, 5, 5));
            fileTabs.addTab("Connection", connPanel);
                // Status Lable
                JLabel stsTitle = new JLabel("Status");
                connPanel.add(stsTitle);
                // Connection information panel
                JPanel connInfPanel = new JPanel();
                connInfPanel.setSize(700, 450);
                connInfPanel.setLayout(new GridLayout(4, 2, 1, 1));
                connInfPanel.setBackground(Color.decode("#b1e0e0"));
                    JLabel ci1 = new JLabel("• Connected");
                    ci1.setForeground(Color.decode("#1aed44"));
                    connInfPanel.add(ci1);
                    JLabel ci2 = new JLabel(" ");
                    connInfPanel.add(ci2);
                    JLabel ci3 = new JLabel("Server");
                    connInfPanel.add(ci3);
                    JLabel ci4 = new JLabel("N/A");
                    connInfPanel.add(ci4);
                    JLabel ci5 = new JLabel("Port");
                    connInfPanel.add(ci5);
                    JLabel ci6 = new JLabel("N/A");
                    connInfPanel.add(ci6);
                    JLabel ci7 = new JLabel("Instance");
                    connInfPanel.add(ci7);
                    JLabel ci8 = new JLabel("N/A");
                    connInfPanel.add(ci8);
                connPanel.add(connInfPanel);
                // Disconnect button
                JButton discon = new JButton("Disconnect");
                discon.setSize(650, 50);
                connPanel.add(discon);
                // Connect panel
                JPanel connWind = new JPanel();
                connWind.setSize(700, 450);
                connWind.setBackground(Color.RED);
                connPanel.add(connWind);

            // about subpanel
            JPanel aboutPanel = new JPanel();
            fileTabs.addTab("About", aboutPanel);

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

        mainFrame.add(mainTabbedPane, BorderLayout.NORTH);
        mainFrame.setVisible(true);

    }
}
