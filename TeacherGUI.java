
/**
* Write a description of class TeacherGUI here.
*
* @author Amiks Karki
* @version Java Second Coursework
*/
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class TeacherGUI {
    // Creating an arraylist
    ArrayList<Teacher> teacherList = new ArrayList<Teacher>();

    // creating instance variables for the GUI components
    private JFrame home_frame, lecturerFrame, tutorFrame, frame;
    private JPanel footerPanel, sidePanel, imagePanel, headerPanel, bodyPanel, panel1, panel2, panel3;

    // creating the TextAreas in the Home Page

    // Components for the Panel1
    private JLabel title, homeLabel, sideLabel, sideLabel2, imageLabel, lecturerLabel, tutorLabel, teacherID,displayLecturerLabel, displayTutorLabel,
            teacherName, address, workingType, employmentStatus, department, workingHours;
    private JTextField teacherID1, teacherID2, teacherID3, teacherID4, teacherID5, teacherName1, teacherName3, address1,
            address3, workingType1, workingType3, employmentStatus1, employmentStatus3,
            department1, department2, workingHours1, workingHours3, yearsOfExperience1, yearsOfExperience2, displayLecturerTextField, displayTutorTextField;

    // Components for the Panel2
    private JLabel yearsOfExperience, gradedScore, salary, specialization, academicQualifications, performanceIndex;
    private JTextField gradedScore1, salary3, salary4, specialization3, academicQualifications3, performanceIndex3,
            performanceIndex4;

    // buttons
    private JButton goToTutor, goToLecturer, addLecturer, gradeAssignment, addTutor, setSalary, removeTutor, display,
            clear, goBack;

    public TeacherGUI() {
        homePage();
    }

    public void homePage() {
        home_frame = new JFrame("Home Page");
        home_frame.setSize(1400, 1100);
        home_frame.setLayout(null);

        // -------Navigation Bar--------

        // Define the header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK); // Set background color
        headerPanel.setBounds(0, 0, 1400, 90); // Set preferred size
        headerPanel.setLayout(null);

        homeLabel = new JLabel("HOME");
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        homeLabel.setBounds(500, 20, 150, 50);

        lecturerLabel = new JLabel("LECTURER");
        lecturerLabel.setForeground(Color.WHITE);
        lecturerLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        lecturerLabel.setBounds(700, 20, 150, 50);

        tutorLabel = new JLabel("TUTOR");
        tutorLabel.setForeground(Color.WHITE);
        tutorLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        tutorLabel.setBounds(900, 20, 150, 50);

        // Add action listeners to buttons
        homeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                homePage();
                home_frame.dispose();
            }
        });
        lecturerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addLecturerFrame();
                home_frame.dispose();
            }
        });
        tutorLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addTutorFrame();
                home_frame.dispose();
            }
        });
        // Add JLabels to the header panel

        headerPanel.add(homeLabel);
        headerPanel.add(lecturerLabel);
        headerPanel.add(tutorLabel);

        // -----Side Panel-----
        sidePanel = new JPanel();
        sidePanel.setBounds(0, 90, 700, 1100);
        sidePanel.setBackground(Color.BLACK);
        sidePanel.setLayout(null);

        sideLabel = new JLabel("WELCOME");
        sideLabel.setBounds(200, 250, 600, 100);
        sideLabel.setForeground(Color.WHITE);
        sideLabel.setFont(new Font("Arial", Font.BOLD, 50)); // Set font

        String labelText = "<html><br>To the <b>Teacher Management System</b>, one-stop solution for managing your Lecturers and Tutors! <br>"
                +
                "Efficiently organize, track, and optimize your academic faculty resources with ease and precision.<br>This intuitive system simplifies the process of adding teacher profiles,complete with details like address,<br> department, and experience.<br>Need to track performance? Grade assignments for Lecturers and monitor their progress. <br>For Tutors, define their specializations and qualifications, and easily adjust their salaries as needed. <hr></html>";

        sideLabel2 = new JLabel(labelText);
        sideLabel2.setBounds(70, 170, 600, 600);
        sideLabel2.setForeground(Color.GRAY);
        sideLabel2.setFont(new Font("Arial", Font.PLAIN, 17)); // Set font

        sidePanel.add(sideLabel);
        sidePanel.add(sideLabel2);

        // image panel
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("images/teacher1.jpg"));
        imageLabel = new JLabel(imageIcon);

        imagePanel = new JPanel();
        imagePanel.setBounds(700, 80, 700, 1100);
        imagePanel.add(imageLabel);

        // ------Footer Panel-----
        // Define the footer panel
        footerPanel = new JPanel();
        footerPanel.setBackground(Color.BLACK); // Setting background color
        footerPanel.setBounds(0, 890, 1400, 90); // Setting preferred height and width
        footerPanel.setLayout(null);

        // Create a label for copyright information
        JLabel copyrightLabel = new JLabel("© 2024 All Rights Reserved");
        copyrightLabel.setForeground(Color.WHITE); // Set text color
        copyrightLabel.setFont(new Font("Arial", Font.BOLD, 15)); // Set font
        copyrightLabel.setBounds(650, 30, 900, 20);

        footerPanel.add(copyrightLabel);

        // adding components to home frame

        home_frame.add(headerPanel);
        home_frame.add(footerPanel);
        home_frame.add(sidePanel);
        home_frame.add(imagePanel);
        home_frame.setVisible(true);
        home_frame.setLayout(null);
        

    }

    public void addLecturerFrame() {
        lecturerFrame = new JFrame("Lecturer Page");
        lecturerFrame.setSize(1400, 1100);

        // components of panel1
        panel1 = new JPanel(new GridBagLayout());
        panel1.setBackground(Color.BLACK);
        GridBagConstraints constraints = new GridBagConstraints();
        panel1.setBounds(500, 0, 900, 900);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        // teacherID
        // -->Label
        teacherID = new JLabel("Teacher ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel1.add(teacherID, constraints);
        // -->Textfield
        teacherID1 = new JTextField(10);
        constraints.gridx = 1;
        panel1.add(teacherID1, constraints);

        // teacherName
        // -->Label
        teacherName = new JLabel("Teacher Name:");
        constraints.gridy = 1;
        constraints.gridx = 0;
        panel1.add(teacherName, constraints);
        // -->Textfield
        teacherName1 = new JTextField(20);
        constraints.gridx = 1;
        panel1.add(teacherName1, constraints);

        // address
        // -->Label
        address = new JLabel("Address:");
        constraints.gridy = 3;
        constraints.gridx = 0;
        panel1.add(address, constraints);
        // -->Textfield
        address1 = new JTextField();
        constraints.gridx = 1;
        panel1.add(address1, constraints);

        // workingType
        // -->Label
        workingType = new JLabel("Working Type:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel1.add(workingType, constraints);
        // -->Textfield
        workingType1 = new JTextField();
        constraints.gridx = 1;
        panel1.add(workingType1, constraints);

        // employmentStatus
        // -->Label
        employmentStatus = new JLabel("Employment Status: ");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel1.add(employmentStatus, constraints);

        // -->Textfield
        employmentStatus1 = new JTextField();
        constraints.gridx = 1;
        panel1.add(employmentStatus1, constraints);

        // yearsOfExperience
        // -->Label
        yearsOfExperience = new JLabel("Years Of Experience: ");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel1.add(yearsOfExperience, constraints);
        // -->Textfield
        yearsOfExperience1 = new JTextField();
        constraints.gridx = 1;
        panel1.add(yearsOfExperience1, constraints);

        // workingHours
        // -->Label
        workingHours = new JLabel("Working Hours: ");
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel1.add(workingHours, constraints);
        // -->Textfield
        workingHours1 = new JTextField();
        constraints.gridx = 1;
        panel1.add(workingHours1, constraints);

        // department
        // -->Label
        department = new JLabel("Department:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        panel1.add(department, constraints);
        // -->Textfield
        department1 = new JTextField();
        constraints.gridx = 1;
        panel1.add(department1, constraints);

        // buttons
        addLecturer = new JButton("Add Lecturer");
        constraints.gridx = 0;
        constraints.gridy = 9;
        panel1.add(addLecturer, constraints);

        gradeAssignment = new JButton("Grade Assignment");
        constraints.gridx = 2;
        constraints.gridy = 5;
        panel1.add(gradeAssignment, constraints);

        goBack = new JButton("Go Back");
        constraints.gridx = 1;
        constraints.gridy = 9;
        panel1.add(goBack, constraints);

        displayLecturerTextField = new JTextField("");
        constraints.gridx = 3;
        constraints.gridy = 8;
        panel1.add(displayLecturerTextField, constraints);

        displayLecturerLabel= new JLabel("Display Lecturer with ID: ");
        constraints.gridx = 2;
        panel1.add(displayLecturerLabel, constraints);

        display = new JButton("Display");
        constraints.gridx = 2;
        constraints.gridy = 9;
        panel1.add(display, constraints);

        // Clear button
        clear = new JButton("Clear");
        constraints.gridx = 3;
        panel1.add(clear, constraints);


        addLecturer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (teacherID1.getText().isEmpty() || teacherName1.getText().isEmpty() || address1.getText().isEmpty()
                        || workingType1.getText().isEmpty()
                        || employmentStatus1.getText().isEmpty() || workingHours1.getText().isEmpty()
                        || yearsOfExperience1.getText().isEmpty() || department1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(lecturerFrame,
                            "Empty fields present\nPlease ensure that all the text fields are filled.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int teacherId = Integer.parseInt(teacherID1.getText());
                        boolean lecturerIdMatch = false;
                        // checking if the lecturer object already has the teacher with the same
                        // teacherID
                        for (Teacher teacher : teacherList) {
                            if (teacherId == teacher.getID())// getID() method from Teacher class which returns the ID
                                                             // provided by user from constructor
                            {
                                lecturerIdMatch = true;
                                break;
                            }
                        }
                        if (lecturerIdMatch) {
                            JOptionPane.showMessageDialog(panel1, "Lecturer with the teacher ID: " + teacherId
                                    + " already exists. Please enter another Teacher ID.");
                        } else {
                            String teacherName = teacherName1.getText();
                            String address = address1.getText();
                            String workingType = workingType1.getText();
                            String employmentStatus = employmentStatus1.getText();
                            int workingHours = Integer.parseInt(workingHours1.getText());
                            String department = department1.getText();
                            int yearsOfExperience = Integer.parseInt(yearsOfExperience1.getText());
                            if (yearsOfExperience > 30 || workingHours > 12) {
                                JOptionPane.showMessageDialog(lecturerFrame,
                                        "Years of Experience cannot be greater than 30 years and\n"
                                                + "Working Hours per day cannot be greater than 12 hours",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {

                                // Creating the object named lecturer of the type Lecturer
                                Lecturer lecturer = new Lecturer(teacherId, teacherName, address, workingType,
                                        employmentStatus, workingHours, department, yearsOfExperience);
                                teacherList.add(lecturer);
                                JOptionPane.showMessageDialog(lecturerFrame,
                                        "Lecturer with teacher ID " + teacherId + " added Successfully.");
                            }
                        }
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(lecturerFrame,
                                "Incorrect data type entered\nPlease enter only integer values for Teacher ID,Years of Experience and Working Hours", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Components for grade assignment
        // teacherID
        // -->Label
        teacherID = new JLabel("Teacher ID:");
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel1.add(teacherID, constraints);
        // -->Textfield
        teacherID2 = new JTextField(10);
        constraints.gridx = 3;
        panel1.add(teacherID2, constraints);

        // gradedScore
        // -->Label
        gradedScore = new JLabel("Graded Score: ");
        constraints.gridx = 2;
        constraints.gridy = 1;
        panel1.add(gradedScore, constraints);
        // -->Textfield
        gradedScore1 = new JTextField();
        constraints.gridx = 3;
        panel1.add(gradedScore1, constraints);

        // department
        // -->Label
        department = new JLabel("Department:");
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel1.add(department, constraints);
        // -->Textfield
        department2 = new JTextField();
        constraints.gridx = 3;
        panel1.add(department2, constraints);

        // yearsOfExperience
        // -->Label
        yearsOfExperience = new JLabel("Years Of Experience: ");
        constraints.gridx = 2;
        constraints.gridy = 4;
        panel1.add(yearsOfExperience, constraints);
        // -->Textfield
        yearsOfExperience2 = new JTextField();
        constraints.gridx = 3;
        panel1.add(yearsOfExperience2, constraints);

        // Event handling for grade assignment button
        gradeAssignment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (teacherID2.getText().isEmpty() || gradedScore1.getText().isEmpty()
                        || department2.getText().isEmpty() || yearsOfExperience2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(lecturerFrame,
                            "Empty fields present\nPlease ensure that all the text fields are filled.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int teacherId = Integer.parseInt(teacherID2.getText());
                        int gradedScore = Integer.parseInt(gradedScore1.getText());
                        String department = department2.getText();
                        int yearsOfExperience = Integer.parseInt(yearsOfExperience2.getText());
                        if (gradedScore > 99 || yearsOfExperience > 30) {
                            JOptionPane.showMessageDialog(lecturerFrame,
                                    "Graded Score cannot be greater than 99 and\n"
                                            + "Years of Experience cannot be greater than 30",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        } else {

                            boolean lecturerIdMatch = false;
                            // variable of the type Teacher is created
                            Teacher foundLecturer = null;
                            // checking if the lecturer object already has the teacher with the same
                            // teacherID
                            for (Teacher lecturer : teacherList) {
                                if (teacherId == lecturer.getID()) {
                                    lecturerIdMatch = true;
                                    foundLecturer = lecturer;
                                    if (foundLecturer instanceof Lecturer) //here i could have just wrote lecturer instead of foundLecturer
                                    {
                                        // since the gui contains the object of teacher type we should typecast it into
                                        // lecturer type to access the method gradeAssignment
                                        Lecturer new_object = (Lecturer) foundLecturer;
                                        /*
                                         * By using (Lecturer) foundLecturer, we are telling Java to treat the
                                         * foundLecturer object as if it were a Lecturer's object.
                                         * this allows us to access the gradeAssignment method, which is defined in the
                                         * Lecturer class.
                                         */
                                        if(new_object.getDepartment().equals(department)&& yearsOfExperience>=5)
                                        {
        
                                            // calling the gradeAssignment method from the Lecturer class
                                        new_object.gradeAssignment(gradedScore, department, yearsOfExperience);
                                        // Display all data entered in an information dialog
                                        String message = "Teacher ID: " + teacherId + "\n"
                                                + "Graded Score: " + gradedScore + "\n"
                                                + "Department: " + department + "\n"
                                                + "Years of Experience: " + yearsOfExperience;
                                        JOptionPane.showMessageDialog(lecturerFrame, message, "Grading Result",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(lecturerFrame, "The lecturer is not eligible for grading!\nPlease check if the department is correct and\nYears of experience is>=5!!",
                                                    "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                        
                                    }
                                    break;
                                }
                            }
                            // checking if lecturer id matches and also if lecturer i.e foundLecturer is an
                            // instance of Lecturer before performing the typecasting.
                            /* it is done kinaki we should make sure the object we are typecasting is
                            actually an instance of lecturer class 
                            instance of helps us figure out what kind of object 
                            we are dealing with in your program, just like figure what type of toy a child is playing with*/
                             if(!lecturerIdMatch) {
                                JOptionPane.showMessageDialog(lecturerFrame, "No valid lecturer found with ID: " + teacherId,
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(frame,
                                "Incorrect data type entered.\nPlease enter only numeric values for teacher ID, graded score, and years of experience.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // for navigating back
        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePage();
                lecturerFrame.dispose();
            }
        });

        // setting the color of all GUI JLabels at once
        /*
         * Component is the foundation class for all Swing GUI elements.
         * Component itself is not a specific UI element like a button or a label. It's
         * the base class from which all Swing components inherit these core
         * functionalities.
         * Specific UI elements like JButton, JLabel, JPanel etc., extend Component and
         * add their own functionalities on top of the base properties.
         * it defines basic properties like position, size, visibility, and event
         * handling.
         */
        for (Component component : panel1.getComponents()) {
            /*
             * The getComponents method in Java Swing returns an array of type Component.
             * This array contains all the child components that are directly added; nested
             * components haru get gardaina
             */
            if (component instanceof JLabel) {// cause we just want to change the color of JLabels
                JLabel label = (JLabel) component;// Component type ko object lai chai Jlabel type ma cast
                                                  // gareko(explicit typecasting cause Component jLabel bhanda broader
                                                  // class)
                label.setForeground(Color.WHITE);
            }
        }
// Event handling for Display button
display.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (displayLecturerTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(lecturerFrame,
                    "Please enter a Teacher ID to display details.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Get the teacher ID to display
                int teacherId = Integer.parseInt(displayLecturerTextField.getText());

                // Create a table model
                DefaultTableModel model = new DefaultTableModel();
                // Adding columns to the table model
                model.addColumn("Teacher ID");
                model.addColumn("Name");
                model.addColumn("Address");
                model.addColumn("Working Type");
                model.addColumn("Employment Status");
                model.addColumn("Working Hours");
                model.addColumn("Department");
                model.addColumn("Years of Experience");
                model.addColumn("Graded Score");

                // Find the teacher with the specified ID and add their details to the table model
                boolean teacherFound = false;
                for (Teacher lecturer : teacherList) {
                    if (lecturer instanceof Lecturer && lecturer.getID() == teacherId) {
                        Lecturer lecturer_obj = (Lecturer) lecturer;
                        Object[] row = {lecturer_obj.getID(), lecturer_obj.getName(), lecturer_obj.getAddress(), lecturer_obj.getWorkingType(),
                            lecturer_obj.getEmploymentStatus(), lecturer_obj.getWorkingHours(), lecturer_obj.getDepartment(),
                            lecturer_obj.getYearsOfExperience(), lecturer_obj.getGradedScore()};
                        model.addRow(row);
                        teacherFound = true;
                        break;
                    }
                }

                if (!teacherFound) {
                    JOptionPane.showMessageDialog(lecturerFrame,
                            "No lecturer found with the given ID.\nPlease enter a valid teacher ID.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if no teacher is found
                }

                // Create a JTable with the table model
                JTable table = new JTable(model);

                // Create a JScrollPane to add the table to, in case there are many rows
                JScrollPane scrollPane = new JScrollPane(table);

                // Create a new JFrame to display the table
                JFrame tableFrame = new JFrame("Teacher Information");
                tableFrame.add(scrollPane);
                tableFrame.setSize(400, 400);
                tableFrame.setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(lecturerFrame,
                        "Invalid input in the Display Lecturer ID field.\nPlease enter a valid integer value.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
});

// Event handling for Clear button
clear.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all fields?",
                "Confirmation", JOptionPane.YES_NO_OPTION);

        // Reset fields only if user confirms
        if (confirm == JOptionPane.YES_OPTION) {
            // Resetting text fields
            teacherID1.setText("");
            teacherID2.setText("");
            teacherName1.setText("");
            address1.setText("");
            workingType1.setText("");
            employmentStatus1.setText("");
            workingHours1.setText("");
            yearsOfExperience1.setText("");
            yearsOfExperience2.setText("");
            gradedScore1.setText("");
            department1.setText("");
            department2.setText("");
        }

    }
});
        // -------Navigation Bar--------

        // Define the header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK); // Set background color
        headerPanel.setBounds(0, 0, 1400, 90); // Set preferred size
        headerPanel.setLayout(null);

        homeLabel = new JLabel("HOME");
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        homeLabel.setBounds(500, 20, 150, 50);

        lecturerLabel = new JLabel("LECTURER");
        lecturerLabel.setForeground(Color.WHITE);
        lecturerLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        lecturerLabel.setBounds(700, 20, 150, 50);

        tutorLabel = new JLabel("TUTOR");
        tutorLabel.setForeground(Color.WHITE);
        tutorLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        tutorLabel.setBounds(900, 20, 150, 50);

        // Add action listeners to buttons
        homeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                homePage();
                lecturerFrame.dispose();
            }
        });
        lecturerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addLecturerFrame();
                lecturerFrame.dispose();
            }
        });
        tutorLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addTutorFrame();
                lecturerFrame.dispose();
            }
        });
        // Add buttons to the header panel

        headerPanel.add(homeLabel);
        headerPanel.add(lecturerLabel);
        headerPanel.add(tutorLabel);

        // ------Footer Panel-----
        // Define the footer panel
        footerPanel = new JPanel();
        footerPanel.setBackground(Color.BLACK); // Setting background color
        footerPanel.setBounds(0, 890, 1400, 90); // Setting preferred height and width
        footerPanel.setLayout(null);

        // Create a label for copyright information
        JLabel copyrightLabel = new JLabel("© 2024 All Rights Reserved");
        copyrightLabel.setForeground(Color.WHITE); // Set text color
        copyrightLabel.setFont(new Font("Arial", Font.BOLD, 15)); // Set font
        copyrightLabel.setBounds(650, 30, 900, 20);

        footerPanel.add(copyrightLabel);

        // image Panel
        sidePanel = new JPanel();
        sidePanel.setBounds(0, 90, 500, 900);
        sidePanel.setBackground(Color.BLACK);
        sidePanel.setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("images/prabodhsir.png"));
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(40, 0, 500, 600);

        sidePanel.add(imageLabel);

        lecturerFrame.add(headerPanel);
        lecturerFrame.add(footerPanel);
        lecturerFrame.add(sidePanel);
        lecturerFrame.setLayout(null);
        lecturerFrame.setVisible(true);
        lecturerFrame.setResizable(true);
        lecturerFrame.getContentPane().add(panel1);

    }

    public void addTutorFrame() {
        tutorFrame = new JFrame(" Tutor Page");
        tutorFrame.setSize(1400, 1100);

        // For the tutor panel
        panel2 = new JPanel(new GridBagLayout());
        panel2.setBackground(Color.BLACK);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints = new GridBagConstraints();
        panel2.setBounds(500, 0, 900, 900);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        // teacherID
        // -->Label
        teacherID = new JLabel("Teacher ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel2.add(teacherID, constraints);
        // -->Textfield
        teacherID3 = new JTextField(10);
        constraints.gridx = 1;
        panel2.add(teacherID3, constraints);

        // teacherName
        // -->Label
        teacherName = new JLabel("Teacher Name:");
        constraints.gridy = 1;
        constraints.gridx = 0;
        panel2.add(teacherName, constraints);
        // -->Textfield
        teacherName3 = new JTextField(20);
        constraints.gridx = 1;
        panel2.add(teacherName3, constraints);

        // address
        // -->Label
        address = new JLabel("Address:");
        constraints.gridy = 2;
        constraints.gridx = 0;
        panel2.add(address, constraints);
        // -->Textfield
        address3 = new JTextField();
        constraints.gridx = 1;
        panel2.add(address3, constraints);

        // workingType
        // -->Label
        workingType = new JLabel("Working Type:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel2.add(workingType, constraints);
        // -->Textfield
        workingType3 = new JTextField();
        constraints.gridx = 1;
        panel2.add(workingType3, constraints);

        // employmentStatus
        // -->Label
        employmentStatus = new JLabel("Employment Status: ");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel2.add(employmentStatus, constraints);
        // -->Textfield
        employmentStatus3 = new JTextField();
        constraints.gridx = 1;
        panel2.add(employmentStatus3, constraints);

        // workingHours
        // -->Label
        workingHours = new JLabel("Working Hours: ");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel2.add(workingHours, constraints);
        // -->Textfield
        workingHours3 = new JTextField();
        constraints.gridx = 1;
        panel2.add(workingHours3, constraints);

        // salary
        // -->Label
        salary = new JLabel("Salary:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel2.add(salary, constraints);
        // -->Textfield
        salary3 = new JTextField();
        constraints.gridx = 1;
        panel2.add(salary3, constraints);

        // specialization
        // -->Label
        specialization = new JLabel("Specialization: ");
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel2.add(specialization, constraints);
        // -->Textfield
        specialization3 = new JTextField();
        constraints.gridx = 1;
        panel2.add(specialization3, constraints);

        // academicQualification
        // -->Label
        academicQualifications = new JLabel("Academic Qualification: ");
        constraints.gridx = 0;
        constraints.gridy = 8;
        panel2.add(academicQualifications, constraints);
        // -->Textfield
        academicQualifications3 = new JTextField();
        constraints.gridx = 1;
        panel2.add(academicQualifications3, constraints);

        // performanceIndex
        // -->Label
        performanceIndex = new JLabel("Performance Index:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        panel2.add(performanceIndex, constraints);
        // -->Textfield
        performanceIndex3 = new JTextField();
        constraints.gridx = 1;
        panel2.add(performanceIndex3, constraints);

        // button
        addTutor = new JButton("Add Tutor");
        constraints.gridx = 0;
        constraints.gridy = 10;
        panel2.add(addTutor, constraints);

        setSalary = new JButton("Set Salary");
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel2.add(setSalary, constraints);

        goBack = new JButton("Go Back");
        constraints.gridx = 1;
        constraints.gridy = 10;
        panel2.add(goBack, constraints);

        display = new JButton("Display");
        constraints.gridx = 2;
        panel2.add(display, constraints);

        clear = new JButton("Clear");
        constraints.gridx = 3;
        panel2.add(clear, constraints);

        displayTutorTextField = new JTextField("");
        constraints.gridx = 3;
        constraints.gridy = 9;
        panel2.add(displayTutorTextField, constraints);

        displayTutorLabel= new JLabel("Display Tutor with ID: ");
        constraints.gridx = 2;
        panel2.add(displayTutorLabel, constraints);
        

        // Setting Salary button
        // teacherID
        // -->Label
        teacherID = new JLabel("Teacher ID:");
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel2.add(teacherID, constraints);
        // -->Textfield
        teacherID4 = new JTextField(10);
        constraints.gridx = 3;
        panel2.add(teacherID4, constraints);

        // New Salary
        // -->Label
        salary = new JLabel("New Salary: ");
        constraints.gridx = 2;
        constraints.gridy = 1;
        panel2.add(salary, constraints);
        // -->Textfield
        salary4 = new JTextField();
        constraints.gridx = 3;
        panel2.add(salary4, constraints);

        // performanceIndex
        // -->Label
        performanceIndex = new JLabel("New Performance Index: ");
        constraints.gridx = 2;
        constraints.gridy = 2;
        panel2.add(performanceIndex, constraints);
        // -->Textfield
        performanceIndex4 = new JTextField();
        constraints.gridx = 3;
        panel2.add(performanceIndex4, constraints);

        // teacherID
        // -->Label
        teacherID = new JLabel("Teacher ID:");
        constraints.gridx = 2;
        constraints.gridy = 4;
        panel2.add(teacherID, constraints);
        // -->Textfield
        teacherID5 = new JTextField();
        constraints.gridx = 3;
        panel2.add(teacherID5, constraints);

        removeTutor = new JButton("Remove Tutor");
        constraints.gridx = 3;
        constraints.gridy = 5;
        panel2.add(removeTutor, constraints);

        

        // Event handling
        addTutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (teacherID3.getText().isEmpty() || teacherName3.getText().isEmpty() || address3.getText().isEmpty()
                        || workingType3.getText().isEmpty() ||
                        employmentStatus3.getText().isEmpty() || workingHours3.getText().isEmpty()
                        || salary3.getText().isEmpty() || specialization3.getText().isEmpty() ||
                        academicQualifications3.getText().isEmpty() || performanceIndex3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(tutorFrame,
                            "Empty fields present\nPlease ensure that all the text fields are filled.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int teacherId = Integer.parseInt(teacherID3.getText());
                        boolean tutorIdMatch = false;
                        // checking if the lecturer object already has the teacher with the same
                        // teacherID
                        for (Teacher teacher : teacherList) {
                            if (teacherId == teacher.getID()) {
                                tutorIdMatch = true;
                                break;
                            }
                        }
                        if (tutorIdMatch) {
                            JOptionPane.showMessageDialog(tutorFrame, "Tutor with the teacher ID: " + teacherId
                                    + " already exists. Please enter another Teacher ID.");
                        } else {
                            String teacherName = teacherName3.getText();
                            String address = address3.getText();
                            String workingType = workingType3.getText();
                            String employmentStatus = employmentStatus3.getText();
                            int workingHours = Integer.parseInt(workingHours3.getText());
                            double salary = Double.parseDouble(salary3.getText());
                            String specialization = specialization3.getText();
                            String academicQualifications = academicQualifications3.getText();
                            int performanceIndex = Integer.parseInt(performanceIndex3.getText());
                            if (workingHours>12||performanceIndex>9||performanceIndex<5) {
                                JOptionPane.showMessageDialog(tutorFrame,
                                "Working hours cannot be greater than 12 Hours per day and\nPerformance Index should be between 5 and 10", "Error",
                                JOptionPane.ERROR_MESSAGE);
                            }
                            else{

                                // Creating the object named tutor
                                Tutor tutor = new Tutor(teacherId, teacherName, address, workingType, employmentStatus,
                                workingHours,
                                salary, specialization, academicQualifications, performanceIndex);
                                teacherList.add(tutor);
                                
                                JOptionPane.showMessageDialog(tutorFrame,
                                "Tutor with teacher ID " + teacherId + " added Successfully.");
                            }
                        }
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(tutorFrame,
                                "Incorrect data type entered\nPlease enter only numeric values for Teacher ID, Working Hours, Salary and Performance Index ", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        setSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int teacherId = Integer.parseInt(teacherID4.getText());
                    double newSalary = Double.parseDouble(salary4.getText());
                    int newPerformanceIndex = Integer.parseInt(performanceIndex4.getText());
                    
                        boolean tutorIdMatch = false;
                        // variable of the type Teacher is created
                        Teacher foundTutor = null;
                        // checking if the tutor object already has the teacher with the same teacherID
                        for (Teacher tutor : teacherList) {
                            if (teacherId == tutor.getID()) {
                                tutorIdMatch = true;
                                foundTutor = tutor;
                                break;
                            }
                        }
                        // hecking if tutor id matches
                        // it is done kinaki we should make sure the object we are typecasting is
                        // actually an instance of lecturer class
                        if (tutorIdMatch && foundTutor instanceof Tutor) {
                            if (newPerformanceIndex<5 && Integer.parseInt(workingHours3.getText())<=20) {
                                JOptionPane.showMessageDialog(tutorFrame,
                                "Teacher id not certified yet!!!\nPerformance Index should be between 5 and 10 and\nWorking Hours should be greater than 20", "Error",
                                JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                
                                // since the gui contains the object of teacher type we should typecast it into
                                // lecturer type to access the method gradeAssignment
                                Tutor new_object = (Tutor) foundTutor;
                                /*
                                * By this, we are telling Java to treat the foundTutor object as if it were a
                                * Tutor's object.
                                * his allows us to access tutor class' method
                                */
                                new_object.setSalary(newSalary, newPerformanceIndex);
                                // Display all data entered in an information dialog
                                String message = "New Salary: " + newSalary + "\n"
                                + "New Performance Index: " + newPerformanceIndex;
                                JOptionPane.showMessageDialog(tutorFrame, message, "Setting Salary",
                                JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(tutorFrame, "No valid tutor found with ID: " + teacherId, "Error",
                            JOptionPane.ERROR_MESSAGE);
                        }
                    
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(tutorFrame,
                            "Empty fields present or Invalid input.\nPlease enter numeric values for teacher ID, Salary and Peformance Index",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Event handling for remove tutor button
        removeTutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (teacherID5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(lecturerFrame,
                            "Empty fields present\nPlease ensure that all the text fields are filled.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int teacherId = Integer.parseInt(teacherID5.getText());
                        boolean tutorIdMatch = false;
                        Teacher foundTutor = null;

                        // Checking if the tutor object already has the teacher with the same teacher ID
                        for (Teacher tutor : teacherList) {
                            if (teacherId == tutor.getID()) {
                                tutorIdMatch = true;
                                foundTutor = tutor;
                                break;
                            }
                        }
                        // Checking if tutor ID matches and if foundTutor is an instance of Tutor before
                        // performing typecasting
                        if (tutorIdMatch && foundTutor instanceof Tutor) {
                            int confirm = JOptionPane.showConfirmDialog(null,
                                    "Are you sure you want to remove the selected tutor?",
                                    "Confirmation", JOptionPane.YES_NO_OPTION);

                            // Reset fields only if user confirms
                            if (confirm == JOptionPane.YES_OPTION) {

                                // Typecasting the foundTutor object as Tutor
                                Tutor tutorToRemove = (Tutor) foundTutor;
                                tutorToRemove.removeTutor();
                                JOptionPane.showMessageDialog(frame,
                                "Tutor with ID: " + teacherId + " removed successfully.", "Remove Tutor",
                                JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            // Displaying error message if no valid tutor found with the entered ID
                            JOptionPane.showMessageDialog(frame, "No valid tutor found with ID: " + teacherId, "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        // Displaying error message if invalid input is provided
                        JOptionPane.showMessageDialog(frame,
                                "Empty data fields or Invalid input.\nPlease enter a numeric value for Teacher ID.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Event handling for Display button
        display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (teacherID3.getText().isEmpty() || teacherName3.getText().isEmpty() || address3.getText().isEmpty()
                        || workingType3.getText().isEmpty() ||
                        employmentStatus3.getText().isEmpty() || workingHours3.getText().isEmpty()
                        || salary3.getText().isEmpty() || specialization3.getText().isEmpty() ||
                        academicQualifications3.getText().isEmpty() || performanceIndex3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(lecturerFrame, "Empty fields present\nPlease add a Tutor first.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Create a table model
                    DefaultTableModel model = new DefaultTableModel();
                    // Adding columns to the table model
                    model.addColumn("Teacher ID");
                    model.addColumn("Name");
                    model.addColumn("Address");
                    model.addColumn("Working Type");
                    model.addColumn("Employment Status");
                    model.addColumn("Working Hours");
                    model.addColumn("Salary");
                    model.addColumn("Specialization");
                    model.addColumn("Academic Qualifications");
                    model.addColumn("Performance Index");

                    try {
                        // Get the teacher ID to display
                        int teacherId = Integer.parseInt(displayTutorTextField.getText());

                        // Find the teacher with the specified ID and add their details to the table model
                        boolean teacherFound = false;
                        for (Teacher tutor : teacherList) {
                            if (tutor instanceof Tutor && tutor.getID() == teacherId) {
                                Tutor tutor_obj = (Tutor) tutor;
                                Object[] row = {tutor_obj.getID(), tutor_obj.getName(), tutor_obj.getAddress(), tutor_obj.getWorkingType(),
                                    tutor_obj.getEmploymentStatus(), tutor_obj.getWorkingHours(), tutor_obj.getSalary(),
                                    tutor_obj.getSpecialization(), tutor_obj.getAcademicQualification(), tutor_obj.getPerformanceIndex()};
                                model.addRow(row);
                                teacherFound = true;
                                break;
                            }
                        }

                        if (!teacherFound) {
                            JOptionPane.showMessageDialog(tutorFrame,
                                    "No tutor found with the given ID.\nPlease enter a valid teacher ID.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                                    return;//it is used so that when the id is not found the program does not continue and displays the table
                        }

                        // Create a JTable with the table model
                        JTable table = new JTable(model);

                        // Create a JScrollPane to add the table to, in case there are many rows
                        JScrollPane scrollPane = new JScrollPane(table);

                        // Create a new JFrame to display the table
                        JFrame tableFrame = new JFrame("Teacher Information");
                        tableFrame.add(scrollPane);
                        tableFrame.setSize(400, 400);
                        tableFrame.setVisible(true);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(tutorFrame,
                                "Invalid input in the Display Tutor ID field.\nPlease enter a valid integer value.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Event handling for Clear button
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all fields?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);

                // Reset fields only if user confirms
                if (confirm == JOptionPane.YES_OPTION) {
                    // Resetting text fields
                    teacherID3.setText("");
                    teacherID4.setText("");
                    teacherID5.setText("");
                    teacherName3.setText("");
                    address3.setText("");
                    workingType3.setText("");
                    employmentStatus3.setText("");
                    workingHours3.setText("");
                    salary3.setText("");
                    specialization3.setText("");
                    academicQualifications3.setText("");
                    performanceIndex3.setText("");
                    salary4.setText("");
                    performanceIndex4.setText("");

                }

            }
        });
        // for navigating back
        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePage();
                tutorFrame.dispose();
            }
        });

        // setting the color of all GUI JLabels at once
        /*
         * Component is the foundation class for all Swing GUI elements.
         * Component itself is not a specific UI element like a button or a label. It's
         * the base class from which all Swing components inherit these core
         * functionalities.
         * Specific UI elements like JButton, JLabel, JPanel etc., extend Component and
         * add their own functionalities on top of the base properties.
         * it defines basic properties like position, size, visibility, and event
         * handling.
         */
        for (Component component : panel2.getComponents()) {
            /*
             * The getComponents method in Java Swing returns an array of type Component.
             * This array contains all the child components that are directly added; nested
             * components haru get gardaina
             */
            if (component instanceof JLabel) {// cause we just want to change the color of JLabels
                JLabel label = (JLabel) component;// Component type ko object lai chai Jlabel type ma cast
                                                  // gareko(explicit typecasting cause Component jLabel bhanda broader
                                                  // class)
                label.setForeground(Color.WHITE);
            }
        }

        // -------Navigation Bar--------

        // Define the header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK); // Set background color
        headerPanel.setBounds(0, 0, 1400, 90); // Set preferred size
        headerPanel.setLayout(null);

        homeLabel = new JLabel("HOME");
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        homeLabel.setBounds(500, 20, 150, 50);

        lecturerLabel = new JLabel("LECTURER");
        lecturerLabel.setForeground(Color.WHITE);
        lecturerLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        lecturerLabel.setBounds(700, 20, 150, 50);

        tutorLabel = new JLabel("TUTOR");
        tutorLabel.setForeground(Color.WHITE);
        tutorLabel.setFont(new Font("Arthur Sans", Font.CENTER_BASELINE, 20)); // Set font
        tutorLabel.setBounds(900, 20, 150, 50);

        // Add action listeners to buttons
        homeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                homePage();
                tutorFrame.dispose();
            }
        });
        lecturerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addLecturerFrame();
                tutorFrame.dispose();
            }
        });
        tutorLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addTutorFrame();
                tutorFrame.dispose();
            }
        });
        // Add buttons to the header panel

        headerPanel.add(homeLabel);
        headerPanel.add(lecturerLabel);
        headerPanel.add(tutorLabel);

        // ------Footer Panel-----
        // Define the footer panel
        footerPanel = new JPanel();
        footerPanel.setBackground(Color.BLACK); // Setting background color
        footerPanel.setBounds(0, 890, 1400, 90); // Setting preferred height and width
        footerPanel.setLayout(null);

        // Create a label for copyright information
        JLabel copyrightLabel = new JLabel("© 2024 All Rights Reserved");
        copyrightLabel.setForeground(Color.WHITE); // Set text color
        copyrightLabel.setFont(new Font("Arial", Font.BOLD, 15)); // Set font
        copyrightLabel.setBounds(650, 30, 900, 20);

        footerPanel.add(copyrightLabel);

        // image Panel
        sidePanel = new JPanel();
        sidePanel.setBounds(0, 0, 500, 900);
        sidePanel.setBackground(Color.BLACK);
        sidePanel.setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("images/ujjwalsir.png"));
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(40, 0, 500, 900);

        sidePanel.add(imageLabel);

        tutorFrame.add(headerPanel);
        tutorFrame.add(footerPanel);
        tutorFrame.add(sidePanel);
        tutorFrame.setLayout(null);
        tutorFrame.setVisible(true);
        tutorFrame.setResizable(true);
        tutorFrame.getContentPane().add(panel2);
    }

    public static void main(String[] args) {
        new TeacherGUI();
    }
}
