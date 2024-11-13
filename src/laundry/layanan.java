/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laundry;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author ASUS TUF
 */
public class layanan extends javax.swing.JFrame {
    private DefaultTableModel model = null;

    
     
    public layanan() {
        initComponents();
        this.connection = (Connection) new DatabaseConnection().getConnection();
        getData();
        nonAktifButton();
        
        setRole();

    }
    
    private final Connection connection;

    
    public void setRole () {
        String role = login.UserSession.getRole();
        
        if (role.equals("admin")) {
            btnTransaksi.setEnabled(true);
            btnMember.setEnabled(true);
            btnLayanan.setEnabled(true);
            btnLaporan.setEnabled(true);
    
        } else if (role.equals("kasir")) {
            btnTransaksi.setEnabled(true);
            btnMember.setEnabled(true);
            btnLayanan.setEnabled(false);
            btnLaporan.setEnabled(false);
        }
    }

    private void resetForm() {
        txtJenis.setText("");
        txtHarga.setText("");
        txtWaktu.setText("");
        txtSatuanWaktu.setSelectedIndex(0);

       
    }

    private void nonAktifButton() {
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    
    
    public enum SatuanWaktu{
        jam, hari;
    }
    
    
    

    
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "Select * From layanan";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                int id_layanan = rs.getInt("id_layanan");
                String jenis = rs.getString("jenis_layanan");
                int harga = rs.getInt("harga");
                int waktu = rs.getInt("waktu_pengerjaan");
                String SatuanWaktu= rs.getString("satuan_waktu");
                
                
                Object[] rowData = {id_layanan, jenis, harga, waktu, SatuanWaktu};
                model.addRow(rowData);
                
                
            }
            
            rs.close();
            st.close();
        } catch (Exception e){
            Logger.getLogger(layanan.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        btnMember = new javax.swing.JButton();
        btnLayanan = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlabel7 = new javax.swing.JLabel();
        txtIdLayanan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        txtWaktu = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtSatuanWaktu = new javax.swing.JComboBox<>();
        txtHarga = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnkembali = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(55, 67, 117));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(610, 55));

        jLabel6.setFont(new java.awt.Font("Swis721 BT", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Layanan");

        btnDashboard.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home_11.png"))); // NOI18N
        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnTransaksi.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Wallet.png"))); // NOI18N
        btnTransaksi.setText("Transaksi");
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });

        btnMember.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/People_1.png"))); // NOI18N
        btnMember.setText("Member");
        btnMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberActionPerformed(evt);
            }
        });

        btnLayanan.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnLayanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Full Shopping Basket_1.png"))); // NOI18N
        btnLayanan.setText("Layanan");

        btnLaporan.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Graph Report.png"))); // NOI18N
        btnLaporan.setText("Laporan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnDashboard)
                .addGap(18, 18, 18)
                .addComponent(btnTransaksi)
                .addGap(18, 18, 18)
                .addComponent(btnMember)
                .addGap(18, 18, 18)
                .addComponent(btnLayanan)
                .addGap(18, 18, 18)
                .addComponent(btnLaporan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDashboard)
                    .addComponent(btnTransaksi)
                    .addComponent(btnMember)
                    .addComponent(btnLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16))
        );

        jlabel7.setFont(new java.awt.Font("Swis721 BT", 0, 15)); // NOI18N
        jlabel7.setText("ID Layanan");

        txtIdLayanan.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        txtIdLayanan.setEnabled(false);
        txtIdLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdLayananActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Swis721 BT", 0, 15)); // NOI18N
        jLabel8.setText("Cari");

        jLabel9.setFont(new java.awt.Font("Swis721 BT", 0, 15)); // NOI18N
        jLabel9.setText("Jenis");

        txtJenis.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        txtJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJenisActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Swis721 BT", 0, 15)); // NOI18N
        jLabel10.setText("Waktu");

        jLabel11.setFont(new java.awt.Font("Swis721 BT", 0, 15)); // NOI18N
        jLabel11.setText("Harga");

        txtCari.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        txtWaktu.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        txtWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWaktuActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(55, 67, 117));
        btnSimpan.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(55, 67, 117));
        btnEdit.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(170, 10, 39));
        btnDelete.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Swis721 BT", 0, 15)); // NOI18N
        jLabel12.setText("Satuan Waktu");

        txtSatuanWaktu.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        txtSatuanWaktu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jam", "Hari" }));
        txtSatuanWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSatuanWaktuActionPerformed(evt);
            }
        });

        txtHarga.setFont(new java.awt.Font("Swis721 BT", 0, 14)); // NOI18N
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdLayanan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSatuanWaktu, 0, 306, Short.MAX_VALUE)
                            .addComponent(txtJenis))))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(txtWaktu))
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSatuanWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Layanan", "Jenis", "Harga / kg", "Waktu Pengerjaan", "Satuan Waktu"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblData);

        btnkembali.setBackground(new java.awt.Color(55, 67, 117));
        btnkembali.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        btnkembali.setForeground(new java.awt.Color(255, 255, 255));
        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2))
                        .addGap(0, 9, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdLayananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdLayananActionPerformed

    private void txtJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJenisActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWaktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWaktuActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        // TODO add your handling code here:
        dashboard dashboard = new dashboard();
                dashboard.setVisible(true);
                
        this.dispose();
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String jenis = txtJenis.getText();
        String hargaStr = txtHarga.getText();
        String waktuStr = txtWaktu.getText();
        String satuanWaktu = txtSatuanWaktu.getSelectedItem().toString();
        
       
        int harga;
        try {
            harga = Integer.parseInt(hargaStr); 
            } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "Harga harus diisi dengan benar!", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
                }
        int waktu;
        try {
            waktu = Integer.parseInt(waktuStr); 
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(this, "Waktu harus diisi dengan benar", "Error", JOptionPane.ERROR_MESSAGE);
             return; 
            }
        
        if(jenis.isEmpty() || hargaStr.isEmpty() || waktuStr.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi !", "Validasi",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try{
            String sql = "INSERT INTO layanan (jenis_layanan, harga, waktu_pengerjaan, satuan_waktu) VALUES (?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, jenis); 
            st.setInt(2, harga);
            st.setInt(3, waktu);
            st.setString(4, satuanWaktu);
            
            int rowInserted = st.executeUpdate();
            if(rowInserted > 0){
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                getData();
            }
            
            st.close();
        } catch (Exception e) {
            Logger.getLogger(layanan.class.getName()).log(Level.SEVERE,null, e);
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
                
        
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblData.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diperbarui");
            return;
        }

        int id_layanan = (int) tblData.getValueAt(selectedRow, 0);  
        String jenis = txtJenis.getText();
        String hargaStr = txtHarga.getText();
        String waktuStr = txtWaktu.getText();
        String satuanWaktu = txtSatuanWaktu.getSelectedItem().toString();

        if (jenis.isEmpty() || hargaStr.isEmpty() || waktuStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int harga;
        try {
             harga = Integer.parseInt(hargaStr); 
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(this, "Harga harus diisi dengan benar!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int waktu;
        try {
            waktu = Integer.parseInt(waktuStr); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Waktu harus diisi dengan benar!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE layanan SET jenis_layanan=?, harga=?, waktu_pengerjaan=?, satuan_waktu=? WHERE id_layanan=?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, jenis); 
            st.setInt(2, harga);
            st.setInt(3, waktu);
            st.setString(4, satuanWaktu);
            st.setInt(5, id_layanan);

            int rowUpdate = st.executeUpdate();
            if (rowUpdate > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                getData();
            }

            st.close();
        } catch (Exception e) {
            Logger.getLogger(layanan.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
         
          
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblData.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus layanan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION );
        if(confirm == JOptionPane.YES_NO_OPTION){
            String id = tblData.getValueAt(selectedRow, 0).toString();
            
            try{
                String sql = "DELETE from layanan WHERE id_layanan=?";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, id);
                
                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){
                   JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    resetForm();
                    getData(); 
                }
                
                st.close();
            }catch (Exception e) {
                Logger.getLogger(layanan.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSatuanWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSatuanWaktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSatuanWaktuActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblData.getSelectedRow();
        if (selectedRow != -1) {
            String jenis = tblData.getValueAt(selectedRow, 1).toString();
            String hargaStr = tblData.getValueAt(selectedRow, 2).toString();
            String waktuStr = tblData.getValueAt(selectedRow, 3).toString();
            String SatuanWaktu  = tblData.getValueAt(selectedRow, 4).toString();
            

        txtJenis.setText(jenis);
        txtHarga.setText(hargaStr);
        txtWaktu.setText(waktuStr);
        
         // Menetapkan nilai pada JComboBox berdasarkan string dari tabel
        for (int i = 0; i < txtSatuanWaktu.getItemCount(); i++) {
            if (txtSatuanWaktu.getItemAt(i).equals(SatuanWaktu)) {
                txtSatuanWaktu.setSelectedIndex(i);
                break;
                }
            }
        }
        
        btnEdit.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tblDataMouseClicked

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);
        
        String cari = txtCari.getText();
        
        try {
            String sql = "Select * From layanan Where jenis_layanan Like? Or harga Like? Or waktu_pengerjaan Like? Or satuan_waktu Like?";
            PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1,"%" + cari + "%");
                st.setString(2,"%" + cari + "%");
                st.setString(3,"%" + cari + "%");
                st.setString(4,"%" + cari + "%");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                int id_layanan = rs.getInt("id_layanan");
                String jenis = rs.getString("jenis_layanan");
                int harga = rs.getInt("harga");
                int waktu = rs.getInt("waktu_pengerjaan");
                String SatuanWaktu= rs.getString("satuan_waktu");
                
                
                Object[] rowData = {id_layanan, jenis, harga, waktu, SatuanWaktu};
                model.addRow(rowData);
                
                
            }
            
            rs.close();
            st.close();
        } catch (Exception e){
            Logger.getLogger(layanan.class.getName()).log(Level.SEVERE,null, e);
        }
        
    }//GEN-LAST:event_txtCariKeyTyped

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        // TODO add your handling code here:
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        dashboard dashboard = new dashboard();  
        dashboard.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        // TODO add your handling code here:
        transaksi transaksi = new transaksi();
        transaksi.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberActionPerformed
        // TODO add your handling code here:
        member member = new member();
        member.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMemberActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(layanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(layanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(layanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(layanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new layanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnLayanan;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnkembali;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdLayanan;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JComboBox<String> txtSatuanWaktu;
    private javax.swing.JTextField txtWaktu;
    // End of variables declaration//GEN-END:variables

    
}
