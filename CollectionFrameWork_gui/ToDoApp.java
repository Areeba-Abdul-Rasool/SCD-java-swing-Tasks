package CollectionFrameWork_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private JPanel app;
    private JButton newTaskButton;
    private JLabel title;
    private JLabel listtitle;
    private JLabel Today;
    private JPanel taskpanel;
    private ArrayList<String> tasks;
    private ArrayList<JRadioButton> radioButtons;
    private ArrayList<JLabel> taskLabels;

    public ToDoApp() {
        tasks = new ArrayList<>();
        radioButtons = new ArrayList<>();
        taskLabels = new ArrayList<>();


        taskpanel.setLayout(new BoxLayout(taskpanel, BoxLayout.Y_AXIS));

        newTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddTaskMenu();
            }
        });
    }

    private void showAddTaskMenu() {
        String taskTitle = JOptionPane.showInputDialog("Enter Task Title"); //input
        if (taskTitle != null && !taskTitle.isEmpty()) {
            addNewTask(taskTitle);
        }
    }

    private void addNewTask(String taskTitle) {
        tasks.add(taskTitle);

        JLabel taskLabel = new JLabel(taskTitle);
        JRadioButton taskRadioButton = new JRadioButton();

        int index =tasks.size()-1;

        taskRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (taskRadioButton.isSelected()) {

                    tasks.remove(index);

                    radioButtons.remove(index);
                    taskLabels.remove(index);
                    refreshTaskPanel();
                }
            }
        });

            taskLabels.add(taskLabel);
        radioButtons.add(taskRadioButton);

        JPanel taskRow = new JPanel(new FlowLayout());
        taskRow.add(taskLabel);
        taskRow.add(taskRadioButton);

        taskpanel.add(taskRow);

        // Refresh the panel
        taskpanel.revalidate();
        taskpanel.repaint();
    }

    private void refreshTaskPanel() {
        taskpanel.removeAll();

        for (int i = 0; i < tasks.size(); i++) {
            String taskTitle = tasks.get(i);
            JLabel taskLabel = taskLabels.get(i);
            JRadioButton taskRadioButton = radioButtons.get(i);

            if (taskTitle != null) {
                JPanel taskRow = new JPanel(new FlowLayout());

                taskRow.add(taskRadioButton);
                taskRow.add(taskLabel);

                taskpanel.add(taskRow);
            }
        }

        taskpanel.revalidate();
        taskpanel.repaint();
    }


    public static void main(String[] args) {
        ToDoApp app = new ToDoApp();
        app.setContentPane(app.app);
        app.setTitle("TO DO APP K22-4821");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 400);
        app.setVisible(true);
    }
}
