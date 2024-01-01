import Database.KoneksiDatabase;
import Database.ResultSetTable;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import usu.widget.glass.PanelGlass;
import javax.swing.table.DefaultTableModel;

public class Form_Pengembalian extends javax.swing.JInternalFrame {

    ResultSet rs;
    KoneksiDatabase con;
    String status1;
    DefaultTableModel model = new DefaultTableModel();


    public Form_Pengembalian() {
        initComponents();
        table_transaksi1.setModel(model);
        model.addColumn("Nama Peminjam");
        model.addColumn("No Polisi");
        model.addColumn("Harga");
        model.addColumn("TGL Pinjam");
        model.addColumn("TGL Kembali");
        model.addColumn("Lama Pinjam");
        model.addColumn("Total");
        con = new KoneksiDatabase(new Database.Parameter().HOST_DB, new Database.Parameter().USERNAME_DB, new Database.Parameter().PASSWORD_DB);

        loadTabel();
        loadMobil();
    }

                      
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_transaksi1 = new javax.swing.JTable();
        panelGlass2 = new usu.widget.glass.PanelGlass();
        btn_Kembalikan_mobil = new usu.widget.ButtonGlass();
        jLabel2 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lbl_harga = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_Lama = new javax.swing.JLabel();
        boxnopol = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_nama = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbl_tgl_peminjaman = new javax.swing.JLabel();
        lbl_tgl_kembali = new javax.swing.JLabel();
        lbl_hari = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaksi = new javax.swing.JTable();
        btn_Refresh__addItem1 = new usu.widget.ButtonGlass();
        btn_Print = new usu.widget.ButtonGlass();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Form Pengembalian Mobil");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        table_transaksi1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama  Peminjam", "No Polisi", "Harga", "Tgl Pinjam", "Tgl Kembali", "Lama Pinjam", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_transaksi1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 940, 210));

        panelGlass2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Kembalikan_mobil.setForeground(new java.awt.Color(255, 255, 255));
        btn_Kembalikan_mobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kembali_mobil.png"))); // NOI18N
        btn_Kembalikan_mobil.setText("Kembalikan Mobil");
        btn_Kembalikan_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Kembalikan_mobilActionPerformed(evt);
            }
        });
        panelGlass2.add(btn_Kembalikan_mobil, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 220, 110));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data Mobil");
        panelGlass2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 39, -1, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Lama Pinjaman");
        panelGlass2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 110, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Harga (/hari)");
        panelGlass2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText(":");
        panelGlass2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 17, -1));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText(":");
        panelGlass2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 16, -1));

        lbl_harga.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_harga.setForeground(new java.awt.Color(255, 255, 255));
        lbl_harga.setText("lbl_harga");
        panelGlass2.add(lbl_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 79, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(":");
        panelGlass2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 14, -1));

        lbl_Lama.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_Lama.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Lama.setText("lama");
        panelGlass2.add(lbl_Lama, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, -1));

        boxnopol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxnopolActionPerformed(evt);
            }
        });
        panelGlass2.add(boxnopol, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 112, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("No. Polisi");
        panelGlass2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 75, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        panelGlass2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 110, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nama Peminjam");
        panelGlass2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 93, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(":");
        panelGlass2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 90, 14, -1));

        lbl_nama.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_nama.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nama.setText("lbl_nama");
        panelGlass2.add(lbl_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 86, -1, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Tanggal Peminjaman");
        panelGlass2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Tanggal Pengembalian");
        panelGlass2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText(":");
        panelGlass2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 16, -1));

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText(":");
        panelGlass2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 12, -1));

        lbl_tgl_peminjaman.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_tgl_peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tgl_peminjaman.setText("lbl_pinjam");
        panelGlass2.add(lbl_tgl_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 79, -1));

        lbl_tgl_kembali.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_tgl_kembali.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tgl_kembali.setText("lbl_kembali");
        panelGlass2.add(lbl_tgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 79, -1));

        lbl_hari.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_hari.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hari.setText("hari");
        panelGlass2.add(lbl_hari, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, -1, -1));

        table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama  Peminjam", "No Polisi", "Harga", "Tgl Pinjam", "Tgl Kembali", "Lama Pinjam", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_transaksi);

        panelGlass2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 940, 210));

        btn_Refresh__addItem1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Refresh__addItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh.png"))); // NOI18N
        btn_Refresh__addItem1.setText("Refresh");
        btn_Refresh__addItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh__addItem1ActionPerformed(evt);
            }
        });
        panelGlass2.add(btn_Refresh__addItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 210, 110));

        btn_Print.setForeground(new java.awt.Color(255, 255, 255));
        btn_Print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        btn_Print.setText("Print ");
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });
        panelGlass2.add(btn_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 210, 110));

        getContentPane().add(panelGlass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 940, 380));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>                        

    private void boxnopolActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String st = (String) boxnopol.getSelectedItem();
        ResultSet rst = con.querySelectAll("tb_transaksi", "nopol='" + st + "'");
        try {
            while (rst.next()) {
                this.lbl_nama.setText(rst.getString("peminjam"));
                this.lbl_tgl_kembali.setText(rst.getString("tgl_kembali"));
                this.lbl_tgl_peminjaman.setText(rst.getString("tgl_pinjaman"));
                this.lbl_Lama.setText(rst.getString("lama"));
                this.lbl_harga.setText(rst.getString("harga"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Form_Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }


    }                                        

    private void btn_Kembalikan_mobilActionPerformed(java.awt.event.ActionEvent evt) {                                                     

        try {
            hapus_transaksi();
            cekstatus();
            loadTabel();

        } catch (SQLException ex) {
            Logger.getLogger(Form_Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }
   }                                                    

    private void btn_Refresh__addItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        loadTabel();

    }                                                     

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {                                          
        cetak();        // TODO add your handling code here:
    }                                         


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Form_Pengembalian().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JComboBox boxnopol;
    private usu.widget.ButtonGlass btn_Kembalikan_mobil;
    private usu.widget.ButtonGlass btn_Print;
    private usu.widget.ButtonGlass btn_Refresh__addItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Lama;
    private javax.swing.JLabel lbl_harga;
    private javax.swing.JLabel lbl_hari;
    private javax.swing.JLabel lbl_nama;
    private javax.swing.JLabel lbl_tgl_kembali;
    private javax.swing.JLabel lbl_tgl_peminjaman;
    private usu.widget.glass.PanelGlass panelGlass2;
    private javax.swing.JTable table_transaksi;
    private javax.swing.JTable table_transaksi1;
    // End of variables declaration                   

    private void loadMobil() {  // mengambil database

        rs = con.querySelectAll("tb_transaksi");
        try {
            while (rs.next()) {
                boxnopol.addItem(rs.getString("nopol"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Form_Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cekstatus() throws SQLException {
        rs = con.querySelectAll("tb_mobil", "nopol ='" + boxnopol.getSelectedItem().toString() + "'");
        while (rs.next()) {
            status1 = rs.getString("status");

        }
        String update_status = "Tersedia";
        String kolom[] = {"status"};
        String isi[] = {update_status};
        con.queryUpdate("tb_mobil", kolom, isi, "nopol='" + boxnopol.getSelectedItem().toString() + "'");




    }

    public void hapus_transaksi() {
        if (JOptionPane.showConfirmDialog(this, "Yakin Mengembalikan Mobil ?", "Peringatan", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            con.queryDelete("tb_transaksi", "nopol='" + boxnopol.getSelectedItem().toString() + "'");
        }

    }

private void loadTabel() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            PreparedStatement ps = con.koneksiDatabase().prepareStatement("SELECT * FROM tb_transaksi");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Object[] obj = new Object[7];
                obj[0] = rs.getString("peminjam");
                obj[1] = rs.getString("nopol");
                obj[2] = rs.getString("harga");
                obj[3] = rs.getString("tgl_pinjaman");
                obj[4] = rs.getString("tgl_kembali");
                obj[5] = rs.getString("lama");
                obj[6] = rs.getString("total");
                
                model.addRow(obj);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

public void cetak() {
        try {
            table_transaksi1.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Data Transaksi"), null);
        } catch (PrinterException ex) {
            Logger.getLogger(Form_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
