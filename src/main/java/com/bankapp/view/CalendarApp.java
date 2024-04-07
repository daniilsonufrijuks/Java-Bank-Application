package view;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarApp extends JPanel {
    private JLabel monthLabel;
    private JPanel calendarPanel;
    private LocalDate currentDate;

    public CalendarApp() {
        setLayout(new BorderLayout());
        // Create components
        monthLabel = new JLabel("", JLabel.CENTER);
        calendarPanel = new JPanel(new GridLayout(7, 7));
        JButton prevMonthButton = new JButton("<-");
        JButton nextMonthButton = new JButton("->");

        // Add action listeners to the buttons
        prevMonthButton.addActionListener(e -> displayCalendar(currentDate.minusMonths(1)));
        nextMonthButton.addActionListener(e -> displayCalendar(currentDate.plusMonths(1)));

        // Set the bounds of the buttons
        Dimension buttonSize = new Dimension(20, 20); // Adjust as needed
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
        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : dayNames) {
            JLabel label = new JLabel(day, JLabel.CENTER);
            calendarPanel.add(label);
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
            calendarPanel.add(label);
        }

        // Repaint the calendar
        calendarPanel.revalidate();
        calendarPanel.repaint();
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
