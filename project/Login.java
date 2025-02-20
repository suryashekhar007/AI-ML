import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Login Page");
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

        // Login Panel with Rounded Corners and Shadow Effect
        ShadowPanel loginPanel = new ShadowPanel();
        loginPanel.setBounds(700, 150, 400, 500);
        loginPanel.setLayout(null);

        // Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome Back!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setBounds(130, 30, 250, 30);
        loginPanel.add(welcomeLabel);

        // Username Label & Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(70, 90, 220, 20);
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(70, 110, 250, 35);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        loginPanel.add(usernameField);

        // Password Label & Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(70, 160, 220, 20);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(70, 180, 250, 35);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        loginPanel.add(passwordField);

        // Forgot Password Label
        JLabel forgotPassword = new JLabel("Forgot Password?");
        forgotPassword.setForeground(Color.BLUE);
        forgotPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        forgotPassword.setBounds(70, 220, 150, 20);
        loginPanel.add(forgotPassword);

        // Login Button
        GradientButton loginButton = new GradientButton("LOGIN");
        loginButton.setBounds(70, 250, 250, 45);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginPanel.add(loginButton);

        // Sign Up Button
        GradientButton signUpButton = new GradientButton("SIGN UP");
        signUpButton.setBounds(70, 310, 250, 45);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginPanel.add(signUpButton);

        // Add Components to Frame
        backgroundPanel.add(loginPanel);
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
        SwingUtilities.invokeLater(Login::new);
    }
}
