
import Database.Star_server;

public class Home extends javax.swing.JFrame {
    public Home() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        btn_log_Off.setVisible(false);
        btn_formMobil.setVisible(false);
        btn_formPeminjam.setVisible(false);
        btn_formUser.setVisible(false);
        btn_transaksi.setVisible(false);
        




    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btn_formUser = new usu.widget.ButtonGlass();
        btn_transaksi = new usu.widget.ButtonGlass();
        btn_formPeminjam = new usu.widget.ButtonGlass();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        btn_formMobil = new usu.widget.ButtonGlass();
        btn_login = new usu.widget.ButtonGlass();
        btn_log_Off = new usu.widget.ButtonGlass();
        btn_closee = new usu.widget.ButtonGlass();
        btn_closee1 = new usu.widget.ButtonGlass();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Server");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_formUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_formUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_iconn.png"))); 
        btn_formUser.setText("Add User");
        btn_formUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_formUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_formUserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_formUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 210, 80));

        btn_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transaksi.png"))); 
        btn_transaksi.setText("Pengembalian Mobil");
        btn_transaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 210, 80));

        btn_formPeminjam.setForeground(new java.awt.Color(255, 255, 255));
        btn_formPeminjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pinjam.png"))); // NOI18N
        btn_formPeminjam.setText("Pinjam Mobil");
        btn_formPeminjam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_formPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_formPeminjamActionPerformed(evt);
            }
        });
        getContentPane().add(btn_formPeminjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 80));
        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1220, 891));

        btn_formMobil.setForeground(new java.awt.Color(255, 255, 255));
        btn_formMobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_mobil.png"))); // NOI18N
        btn_formMobil.setText("Add Mobil");
        btn_formMobil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_formMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_formMobilActionPerformed(evt);
            }
        });
        getContentPane().add(btn_formMobil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 210, 80));

        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginoke.png"))); // NOI18N
        btn_login.setText("Login");
        btn_login.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 80));

        btn_log_Off.setForeground(new java.awt.Color(255, 255, 255));
        btn_log_Off.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log_off copy.png"))); // NOI18N
        btn_log_Off.setText("Log Off");
        btn_log_Off.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_log_Off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_log_OffActionPerformed(evt);
            }
        });
