package io.turntabl.ui;

import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTabbedPane;
import com.intellij.ui.components.JBTextArea;

import javax.swing.*;
import java.awt.*;

public class NewRelicJavaProfilerToolWindow {

    private JLabel label, flameGraphLabel, callTreeLabel, methodListLabel;
    private JPanel mainPanel, flameGraphPanel,
            callTreePanel, methodListPanel, eventsPanel,
            metricPanel;
    private JTabbedPane tabbedPane;
    private JTextArea eventTextArea, metricTextArea;
    private JScrollPane eventScrollPane, metricScrollPane;

    public NewRelicJavaProfilerToolWindow(ToolWindow toolWindow) {
        label = new JLabel("NewRelic Profiler");

        mainPanel = new JPanel(new GridLayout(1, 1));

        flameGraphPanel = new JPanel();
        callTreePanel = new JPanel();
        methodListPanel = new JPanel();
        eventsPanel = new JPanel(new BorderLayout());
        metricPanel = new JPanel(new BorderLayout());

        eventTextArea = new JBTextArea();
        eventTextArea.setLineWrap(true);

        metricTextArea = new JBTextArea();
        metricTextArea.setLineWrap(true);

        eventScrollPane = new JBScrollPane(eventTextArea);
        metricScrollPane = new JBScrollPane(metricTextArea);

        flameGraphLabel = new JLabel("Flame Graph is displayed here!!!!!!!!!!!");
        callTreeLabel = new JLabel("Call Tree is displayed here!!!!!!!!!!!");
        methodListLabel = new JLabel("Method List is displayed here!!!!!!!!!!!");

        flameGraphPanel.add(flameGraphLabel);
        callTreePanel.add(callTreeLabel);
        methodListPanel.add(methodListLabel);

        eventTextArea.setBackground(eventsPanel.getBackground());
        metricTextArea.setBackground(eventsPanel.getBackground());

        eventsPanel.add(eventScrollPane, BorderLayout.CENTER);
        metricPanel.add(metricScrollPane, BorderLayout.CENTER);

        tabbedPane = new JBTabbedPane();

        tabbedPane.add("Flame Graph", flameGraphPanel);
        tabbedPane.add("Call Tree", callTreePanel);
        tabbedPane.add("Method List", methodListPanel);
        tabbedPane.add("Events", eventsPanel);
        tabbedPane.add("Metrics", metricPanel);
        tabbedPane.setSelectedIndex(3);

        mainPanel.add(tabbedPane);

    }

    public void updateEventPanelText(String text) {
        eventTextArea.append(text);
    }

    public void updateMetricPanelText(String text) {
        metricTextArea.append(text);
    }

    public JComponent getContent() {
        return mainPanel;
    }

}