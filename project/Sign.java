import javax.swing.*;
import java.awt.*;

public class Sign extends JFrame {
    private JTextField usernameField, emailField, securityAnswerField;
    private JPasswordField passwordField, confirmPasswordField;
    private JComboBox<String> securityQuestionBox;

    public Sign() {
        setTitle("Signup Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(null);

        // 3D Gradient Background Panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Layer 1: Deep Background Gradient
                GradientPaint gradient1 = new GradientPaint(0, 0, new Color(10, 30, 60),
                        getWidth(), getHeight(), new Color(20, 100, 160));
                g2d.setPaint(gradient1);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Layer 2: Soft Highlight Gradient (Creates a 3D Effect)
                GradientPaint gradient2 = new GradientPaint(getWidth() / 2, getHeight() / 2, new Color(255, 255, 255, 50),
                        getWidth(), getHeight(), new Color(10, 30, 60, 100));
                g2d.setPaint(gradient2);
                g2d.fillOval(-200, -200, getWidth() + 400, getHeight() + 400);
            }
        };
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\singh\\OneDrive\\Desktop\\JAVA PROJECT\\download.png");
        Image i2 = i1.getImage().getScaledInstance(430, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 400, 400);
        backgroundPanel.add(image);
        backgroundPanel.setBounds(0, 0, 1200, 800);
        backgroundPanel.setLayout(null);

        // Signup Panel with Rounded Corners and Shadow Effect
        ShadowPanel signupPanel = new ShadowPanel();
        signupPanel.setBounds(700, 50, 400, 630);
        signupPanel.setLayout(null);

        // Welcome Label
        JLabel welcomeLabel = new JLabel("Create an Account");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setBounds(100, 20, 250, 30);
        signupPanel.add(welcomeLabel);

        // Username Label & Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(70, 70, 220, 20);
        signupPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(70, 90, 250, 35);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        signupPanel.add(usernameField);

        // Email Label & Field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(70, 140, 220, 20);
        signupPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(70, 160, 250, 35);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        signupPanel.add(emailField);

        // Password Label & Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(70, 210, 220, 20);
        signupPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(70, 230, 250, 35);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        signupPanel.add(passwordField);

        // Confirm Password Label & Field
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(70, 280, 220, 20);
        signupPanel.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(70, 300, 250, 35);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        signupPanel.add(confirmPasswordField);

        // Security Question Label & Combo Box
        JLabel securityQuestionLabel = new JLabel("Security Question:");
        securityQuestionLabel.setBounds(70, 350, 220, 20);
        signupPanel.add(securityQuestionLabel);

        String[] securityQuestions = {
                "What is your pet’s name?",
                "What is your mother’s maiden name?",
                "What is your favorite book?",
                "What is the name of your first school?"
        };
        securityQuestionBox = new JComboBox<>(securityQuestions);
        securityQuestionBox.setBounds(70, 370, 250, 35);
        signupPanel.add(securityQuestionBox);

        // Security Answer Label & Field
        JLabel securityAnswerLabel = new JLabel("Answer:");
        securityAnswerLabel.setBounds(70, 420, 220, 20);
        signupPanel.add(securityAnswerLabel);

        securityAnswerField = new JTextField();
        securityAnswerField.setBounds(70, 440, 250, 35);
        signupPanel.add(securityAnswerField);

        // Signup Button
        GradientButton signupButton = new GradientButton("SIGN UP");
        signupButton.setBounds(70, 500, 250, 45);
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        signupPanel.add(signupButton);

        // Login Redirect Button
        GradientButton loginRedirectButton = new GradientButton("BACK TO LOGIN");
        loginRedirectButton.setBounds(70, 560, 250, 45);
        loginRedirectButton.setFont(new Font("Arial", Font.BOLD, 16));
        signupPanel.add(loginRedirectButton);

        // Add Components to Frame
        backgroundPanel.add(signupPanel);
        add(backgroundPanel);

        setVisible(true);
    }

    // Custom JPanel for Rounded Corners and Shadow Effect
    class ShadowPanel extends JPanel {
        private int shadowOffset = 8;  // Distance of shadow from panel
        private int arcSize = 40;  // Radius for rounded corners

        public ShadowPanel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw shadow
            g2d.setColor(new Color(0, 0, 0, 100));
            g2d.fillRoundRect(shadowOffset, shadowOffset, width - shadowOffset, height - shadowOffset, arcSize, arcSize);

            // Draw main panel with gradient
            GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 255, 255, 230),
                    0, height - shadowOffset, new Color(240, 240, 240, 230));
            g2d.setPaint(gradient);
            g2d.fillRoundRect(0, 0, width - shadowOffset, height - shadowOffset, arcSize, arcSize);

            g2d.dispose();
            super.paintComponent(g);
        }
    }

    // Custom JButton with 3D Gradient Effect
    class GradientButton extends JButton {
        public GradientButton(String text) {
            super(text);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setForeground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Gradient color for button
            GradientPaint gradient = new GradientPaint(0, 0, new Color(72, 61, 139),
                    getWidth(), getHeight(), new Color(147, 112, 219));
            g2d.setPaint(gradient);
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

            super.paintComponent(g);
            g2d.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sign::new);
    }
}
