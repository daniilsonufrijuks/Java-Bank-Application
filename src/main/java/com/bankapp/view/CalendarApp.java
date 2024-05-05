package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarApp extends JPanel {
    private JLabel monthLabel;
    private JPanel calendarPanel;
    private JButton prevMonthButton;
    private JButton nextMonthButton;
    private LocalDate currentDate;
    private Color textColor;

    public CalendarApp() {
        setLayout(new BorderLayout());
        // Create components
        monthLabel = new JLabel("", JLabel.CENTER);
        calendarPanel = new JPanel(new GridLayout(0, 7));
        prevMonthButton = new JButton("<");
        nextMonthButton = new JButton(">");
        prevMonthButton.setFont(new Font("Arial", Font.PLAIN, 10));
        nextMonthButton.setFont(new Font("Arial", Font.PLAIN, 10));
        
        // Add action listeners to the buttons
        prevMonthButton.addActionListener(e -> displayCalendar(currentDate.minusMonths(1)));
        nextMonthButton.addActionListener(e -> displayCalendar(currentDate.plusMonths(1)));

        // Set the bounds of the buttons
        Dimension buttonSize = new Dimension(40, 25); // Adjust as needed
        prevMonthButton.setPreferredSize(buttonSize);
        nextMonthButton.setPreferredSize(buttonSize);

        // Add components to panel
        add(monthLabel, BorderLayout.NORTH);
        add(prevMonthButton, BorderLayout.WEST);
        add(nextMonthButton, BorderLayout.EAST);
        add(calendarPanel, BorderLayout.CENTER);

        // Display the calendar for the current month
        currentDate = LocalDate.now();
        displayCalendar(currentDate);
    }

    private void displayCalendar(LocalDate date) {
        // Set the current date
        currentDate = date;

        // Set the month label
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        monthLabel.setText(date.format(formatter));

        // Clear the previous calendar
        calendarPanel.removeAll();

        // Add day names
        String[] dayNames = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (String day : dayNames) {
            //JLabel label = new JLabel(day, JLabel.CENTER);
            //calendarPanel.add(label);
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayLabel.setForeground(textColor);              // set Label foreground color when a button is pressed
            calendarPanel.add(dayLabel);
            //calendarPanel.add(new JLabel(day, JLabel.CENTER));
        }

        // Calculate the start day of the month
        LocalDate firstDayOfMonth = date.withDayOfMonth(1);
        int startDay = firstDayOfMonth.getDayOfWeek().getValue();

        // Fill in the days
        for (int i = 1; i < startDay; i++) {
            calendarPanel.add(new JLabel(""));
        }
        for (int i = 1; i <= date.lengthOfMonth(); i++) {
            JLabel label = new JLabel(Integer.toString(i), JLabel.CENTER);
            if (textColor != null) {    // if textcolor is set
                label.setForeground(this.textColor);
            }
            calendarPanel.add(label);
        }

        // Repaint the calendar
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public void changeColors(Color backgroundColor, Color buttonColor, Color headingColor, Color txtColor) {    // method to change Calendar colors
        this.textColor = txtColor;
        this.monthLabel.setOpaque(true);
        this.monthLabel.setBackground(backgroundColor);
        this.monthLabel.setForeground(headingColor);
        this.calendarPanel.setOpaque(true);
        this.calendarPanel.setBackground(backgroundColor);
        for (Component component : this.calendarPanel.getComponents()){    // get all components from calendarPanel and change their color
            component.setForeground(this.textColor);
        }
        this.prevMonthButton.setBackground(buttonColor);
        this.prevMonthButton.setForeground(txtColor);
        this.nextMonthButton.setBackground(buttonColor);
        this.nextMonthButton.setForeground(txtColor);
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         JFrame frame = new JFrame("Calendar Panel");
    //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //         frame.setSize(500, 300);
    //         frame.setLocationRelativeTo(null);

    //         CalendarApp calendarPanel = new CalendarApp();
    //         frame.add(calendarPanel);
    //         frame.setVisible(true);
    //     });
    // }
}
