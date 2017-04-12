/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan7;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormDataBuku extends javax.swing.JFrame {

    /**
     * Creates new form FormDataBuku
     */
    public FormDataBuku() {
        initComponents();
    }
        private DefaultTableModel model;
        private final Connection con = koneksi.getConnection();
        private Statement stt;
        private ResultSet rss;
        private PreparedStatement pst;

    private void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("JUDUL");
        model.addColumn("PENULIS");
        model.addColumn("HARGA");
        
        jTable1.setModel(model);
    }
    private boolean validasi(String judul){
        try {
            stt = con.createStatement();
            String sql = "SELECT * FROM buku WHERE judul='"+judul+"'";
            rss = stt.executeQuery(sql);
            if(rss.next())
                return true;
            else 
                return false;
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }
    
    private void TampilData(){
        try{
            String sql = "SELECT * FROM buku";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getString("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getInt("harga");
                model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public boolean UbahData(String id, String judul, String penulis, String harga){
        try{
            String sql = "UPDATE buku set judul ='"+judul
                    +"',penulis ='"+penulis+"', harga ="+harga
                    +" WHERE id="+id+";";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean HapusData(String id){
        try{
            String sql = "DELETE FROM buku WHERE id ="+id+";";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void TambahData(String judul, String penulis, String harga){
        try{
            
            String sql = "INSERT INTO buku VALUES (NULL,'"+judul+"','"+penulis+"',"+harga+")";
            stt = con.createStatement();
            stt.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
//    public void UpdateData(String judul, String penulis, String harga){
//        int baris = jTable1.getSelectedRow();
//        try{
//            String sql = "UPDATE buku set judul ='"+judul
//                    +"',penulis ='"+penulis+"', harga ="+harga
//                    +"WHERE id="+id+";";
//            stt = con.createStatement();
//            stt.executeUpdate(sql);
//            model.addRow(new Object[]{judul,penulis,harga});
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
    
    public void search(String sql){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFJudul = new javax.swing.JTextField();
        CBPenulis = new javax.swing.JComboBox<>();
        TFHarga = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TFSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CBSearch = new javax.swing.JComboBox<>();
        BSimpan = new javax.swing.JButton();
        BUbah = new javax.swing.JButton();
        BUlangi = new javax.swing.JButton();
        BKeluar = new javax.swing.JButton();
        BHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("FORM DATA BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Penulis");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Harga");

        TFJudul.setText("Masukkan Judul");
        TFJudul.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TFJudulCaretUpdate(evt);
            }
        });
        TFJudul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TFJudulMouseClicked(evt);
            }
        });

        CBPenulis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tere Liye", "W.S. Rendra", "Felix Slauw", "Asma Nadia", "Dewi Lestari" }));

        TFHarga.setText("Masukkan Harga");
        TFHarga.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TFHargaCaretUpdate(evt);
            }
        });
        TFHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFHargaKeyPressed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setText("Search :");

        TFSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFSearchKeyTyped(evt);
            }
        });

        jLabel6.setText("By :");

        CBSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judul", "Penulis", "Harga" }));

        BSimpan.setText("SIMPAN");
        BSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BSimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BSimpanMouseExited(evt);
            }
        });
        BSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSimpanActionPerformed(evt);
            }
        });

        BUbah.setText("UBAH");
        BUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BUbahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BUbahMouseExited(evt);
            }
        });
        BUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUbahActionPerformed(evt);
            }
        });

        BUlangi.setText("ULANGI");
        BUlangi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BUlangiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BUlangiMouseExited(evt);
            }
        });
        BUlangi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUlangiActionPerformed(evt);
            }
        });

        BKeluar.setText("KELUAR");
        BKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BKeluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BKeluarMouseExited(evt);
            }
        });
        BKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BKeluarActionPerformed(evt);
            }
        });

        BHapus.setText("HAPUS");
        BHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BHapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BHapusMouseExited(evt);
            }
        });
        BHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(BUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BUlangi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(BHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(TFJudul)
                            .addComponent(CBPenulis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BSimpan)
                            .addComponent(BUbah)
                            .addComponent(BUlangi)
                            .addComponent(BKeluar)
                            .addComponent(BHapus))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUbahActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(baris, 0).toString();
        String judul = TFJudul.getText();
        String penulis = CBPenulis.getSelectedItem().toString();
        String harga = TFHarga.getText();
        if(UbahData(id, judul, penulis, harga))
            JOptionPane.showMessageDialog(null,"Berhasil Ubah Data");
        else
            JOptionPane.showConfirmDialog(null,"Gagal Ubah Data");
        InitTable();TampilData();
    }//GEN-LAST:event_BUbahActionPerformed

    private void BSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSimpanActionPerformed
        // TODO add your handling code here:
        if (TFJudul.getText().length()!=0 && TFHarga.getText().length()!=0) {
            String judul = TFJudul.getText();
            String penulis = CBPenulis.getSelectedItem().toString();
            String harga = TFHarga.getText();
            
            if(validasi(judul)){
                JOptionPane.showMessageDialog(this, "Judul Sudah Ada");
            }
            else{
            TambahData(judul,penulis,harga);
            InitTable();
            TampilData();
            JOptionPane.showMessageDialog(this, "Berhasil Simpan Data");
            }
        } 
        else {
        JOptionPane.showMessageDialog(this, "Isi Data Terlebih Dahulu");    
        
        }
        
        
    }                                          

//    private void BUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                           
//        int baris = jTable1.getSelectedRow();
//        try {
//            jTable1.setValueAt(TFJudul.getText(), baris, 0);
//            jTable1.setValueAt(CBPenulis.getSelectedItem(), baris, 1);
//            jTable1.setValueAt(TFHarga.getText(), baris, 2);
//            
//            JOptionPane.showMessageDialog(this, "Data Berhasil Di Update");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Maaf, Silahkan Pilih Data Yang Ingin Diupdate Terlebih Dahulu");
//        }
//    }                                          

    private void btn_HapusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int pilih = JOptionPane.showConfirmDialog(this, "Ingin Menghapus Data?","Confirm Hapus",JOptionPane.YES_OPTION);
        
        if(pilih==JOptionPane.YES_OPTION){
            try {
                int baris = jTable1.getSelectedRow();
                model.removeRow(baris);
                JOptionPane.showMessageDialog(this, "Data Dengan"+"\nJudul : "+TFJudul.getText()+"\nPenulis : "+CBPenulis.getSelectedItem()+"\nHarga : "+TFHarga.getText()+"\nBerhasil Dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Tidak Ada Data Yang Dipilih Untuk Dihapus");
            }        
        }
    }//GEN-LAST:event_BSimpanActionPerformed

    private void BKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BKeluarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_formComponentShown

    private void BUlangiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUlangiActionPerformed
        // TODO add your handling code here:
        TFJudul.setText("");
        TFHarga.setText("");
        CBPenulis.setSelectedItem("");
        TFJudul.requestFocus();
    }//GEN-LAST:event_BUlangiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        
        TFJudul.setText(jTable1.getValueAt(baris, 1).toString());
        CBPenulis.setSelectedItem(jTable1.getValueAt(baris, 2).toString());
        TFHarga.setText(jTable1.getValueAt(baris, 3).toString());
//        String judul_edit = jTable1.getValueAt(baris, 0).toString();
//        String penulis_edit = jTable1.getValueAt(baris, 1).toString();
//        String harga_edit = jTable1.getValueAt(baris, 2).toString();
//        
//        TFJudul.setText(judul_edit);
//        CBPenulis.setSelectedItem(penulis_edit);
//        TFHarga.setText(harga_edit);
    }//GEN-LAST:event_jTable1MouseClicked

    private void TFSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFSearchKeyTyped
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        String searchby = CBSearch.getSelectedItem().toString();
        try {
            
             String sql="select * from buku where "+searchby+" like '%"+TFSearch.getText()+"%'";
           stt = con. createStatement();
            rss = stt. executeQuery(sql);
                       ResultSet rss=stt.executeQuery(sql);
            while (rss.next()) {
                Object[] o=new Object[4];
                o[0]=rss.getString("ID");
                o[1]=rss.getString("JUDUL");
                o[2]=rss.getString("PENULIS");
                o[3]=rss.getString("HARGA");
                
            model.addRow(o);
            }
            stt.close();
            rss.close();
        }catch(SQLException e) {
            System.out.println("Terjadi kesalahan");
        }
    }//GEN-LAST:event_TFSearchKeyTyped

    private void TFJudulCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TFJudulCaretUpdate
        // TODO add your handling code here:
        if (TFJudul.getText().length()== 0 || TFHarga.getText().length()==0) {
            BSimpan.setEnabled(false);
            BUlangi.setEnabled(false);
        }
        else if (TFJudul.getText().length()!=0 && TFHarga.getText().length()!=0){
            BSimpan.setEnabled(true);
            BUlangi.setEnabled(true);
        }
    }//GEN-LAST:event_TFJudulCaretUpdate

    private void TFHargaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TFHargaCaretUpdate
        // TODO add your handling code here:
        if (TFJudul.getText().length()== 0 || TFHarga.getText().length()==0) {
            BSimpan.setEnabled(false);
            BUlangi.setEnabled(false);
        }
        else if (TFJudul.getText().length()!=0 && TFHarga.getText().length()!=0){
            BSimpan.setEnabled(true);
            BUlangi.setEnabled(true);
        }
    }//GEN-LAST:event_TFHargaCaretUpdate

    private void TFHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFHargaKeyPressed
        // TODO add your handling code here:
        TFHarga.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
            char karakter1 = e.getKeyChar();
            if(!((karakter1 >= '0') && (karakter1 <= '9')) || (karakter1 == '\b')){
                e.consume();
            }
            }
        }); 
    }//GEN-LAST:event_TFHargaKeyPressed

    private void BSimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BSimpanMouseEntered
        // TODO add your handling code here:
        BSimpan.setBackground(Color.RED);
        BSimpan.setForeground(Color.BLACK);
    }//GEN-LAST:event_BSimpanMouseEntered

    private void BSimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BSimpanMouseExited
        // TODO add your handling code here:
        BSimpan.setBackground(Color.BLUE);
        BSimpan.setForeground(Color.BLACK);
    }//GEN-LAST:event_BSimpanMouseExited

    private void BUbahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUbahMouseExited
        // TODO add your handling code here:
        BUbah.setBackground(Color.RED);
        BUbah.setForeground(Color.BLACK);
    }//GEN-LAST:event_BUbahMouseExited

    private void BUbahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUbahMouseEntered
        // TODO add your handling code here:
        BUbah.setBackground(Color.BLUE);
        BUbah.setForeground(Color.BLACK);
    }//GEN-LAST:event_BUbahMouseEntered

    private void BHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BHapusMouseEntered
        // TODO add your handling code here:
        BHapus.setBackground(Color.ORANGE);
        BHapus.setForeground(Color.BLACK);
    }//GEN-LAST:event_BHapusMouseEntered

    private void BHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BHapusMouseExited
        // TODO add your handling code here:
        BHapus.setBackground(Color.WHITE);
        BHapus.setForeground(Color.BLACK);
    }//GEN-LAST:event_BHapusMouseExited

    private void BUlangiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUlangiMouseEntered
        // TODO add your handling code here:
        BUlangi.setBackground(Color.ORANGE);
        BUlangi.setForeground(Color.BLACK);
    }//GEN-LAST:event_BUlangiMouseEntered

    private void BUlangiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUlangiMouseExited
        // TODO add your handling code here:
        BUlangi.setBackground(Color.WHITE);
        BUlangi.setForeground(Color.BLACK);
    }//GEN-LAST:event_BUlangiMouseExited

    private void BKeluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BKeluarMouseEntered
        // TODO add your handling code here:
        BKeluar.setBackground(Color.ORANGE);
        BKeluar.setForeground(Color.BLACK);
    }//GEN-LAST:event_BKeluarMouseEntered

    private void BKeluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BKeluarMouseExited
        // TODO add your handling code here:
        BKeluar.setBackground(Color.WHITE);
        BKeluar.setForeground(Color.BLACK);
    }//GEN-LAST:event_BKeluarMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        TFJudul.setText("");
        TFHarga.setText("");
    }//GEN-LAST:event_formWindowOpened

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(baris, 0).toString();
        if(HapusData(id))
            JOptionPane.showMessageDialog(null,"Berhasil Hapus Data");
        else
            JOptionPane.showConfirmDialog(null, "Gagal Hapus Data");
        InitTable();TampilData();
    }//GEN-LAST:event_BHapusActionPerformed

    private void TFJudulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFJudulMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TFJudulMouseClicked

    
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
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BHapus;
    private javax.swing.JButton BKeluar;
    private javax.swing.JButton BSimpan;
    private javax.swing.JButton BUbah;
    private javax.swing.JButton BUlangi;
    private javax.swing.JComboBox<String> CBPenulis;
    private javax.swing.JComboBox<String> CBSearch;
    private javax.swing.JTextField TFHarga;
    private javax.swing.JTextField TFJudul;
    private javax.swing.JTextField TFSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
