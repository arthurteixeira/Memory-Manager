/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Paralelo.FilaCircular;
import Paralelo.mapeamentoHeap;
import java.awt.CardLayout;

/**
 *
 * @author anderson
 */
public class InterfaceParalela extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Interface
     */
    public InterfaceParalela() {
        initComponents();
    }
    
    private mapeamentoHeap mp;
    private FilaCircular fila;
    private int     tamHeap;
    private int     nReq;
    private int     valMin;
    private int     valMax;
    private float   limMax;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        Heap = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSLimMax = new javax.swing.JSpinner();
        jSTamHeap = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        btnAlocar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Requisicoes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSnReq = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jSValMin = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSValMax = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Resultados = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pHeap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tHeap = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tContHeap = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pFila = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tReq = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtLogFila = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pLogHeap = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtLogHeapAloca = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtLogHeapDesaloca = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pControl = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        Base.setName("Base"); // NOI18N
        Base.setLayout(new java.awt.CardLayout());

        Heap.setName("Heap"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 48)); // NOI18N
        jLabel6.setText("Configurações da Heap");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jLabel7.setText("Tamanho da heap");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jLabel8.setText("%");
        jLabel8.setName("jLabel8"); // NOI18N

        jSLimMax.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jSLimMax.setModel(new javax.swing.SpinnerNumberModel(50, 50, 100, 5));
        jSLimMax.setName("jSLimMax"); // NOI18N
        jSLimMax.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSLimMaxStateChanged(evt);
            }
        });

        jSTamHeap.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jSTamHeap.setModel(new javax.swing.SpinnerNumberModel(10, 10, null, 1));
        jSTamHeap.setName("jSTamHeap"); // NOI18N
        jSTamHeap.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSTamHeapStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jLabel17.setText("Limiar Maximo");
        jLabel17.setName("jLabel17"); // NOI18N

        btnAlocar.setBackground(new java.awt.Color(51, 204, 255));
        btnAlocar.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        btnAlocar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlocar.setText("Alocar");
        btnAlocar.setBorder(null);
        btnAlocar.setName("btnAlocar"); // NOI18N
        btnAlocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlocarActionPerformed(evt);
            }
        });

        jLabel2.setText("Paralela");
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout HeapLayout = new javax.swing.GroupLayout(Heap);
        Heap.setLayout(HeapLayout);
        HeapLayout.setHorizontalGroup(
            HeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeapLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAlocar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(HeapLayout.createSequentialGroup()
                .addGroup(HeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeapLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel6))
                    .addGroup(HeapLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addGroup(HeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel17))
                        .addGap(165, 165, 165)
                        .addGroup(HeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSLimMax, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSTamHeap, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(HeapLayout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jLabel2)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        HeapLayout.setVerticalGroup(
            HeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeapLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(HeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSTamHeap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(HeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSLimMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btnAlocar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        Base.add(Heap, "cHeap");

        Requisicoes.setName("Requisicoes"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 48)); // NOI18N
        jLabel1.setText("Configurações de Requisições");
        jLabel1.setName("jLabel1"); // NOI18N

        jSnReq.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jSnReq.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSnReq.setName("jSnReq"); // NOI18N
        jSnReq.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSnReqStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jLabel3.setText("Valor minimo");
        jLabel3.setName("jLabel3"); // NOI18N

        jSValMin.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jSValMin.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSValMin.setName("jSValMin"); // NOI18N
        jSValMin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSValMinStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jLabel4.setText("Valor maximo");
        jLabel4.setName("jLabel4"); // NOI18N

        jSValMax.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jSValMax.setModel(new javax.swing.SpinnerNumberModel(2, 2, null, 1));
        jSValMax.setName("jSValMax"); // NOI18N
        jSValMax.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSValMaxStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jLabel9.setText("Número de requisições:");
        jLabel9.setName("jLabel9"); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 204, 255));
        jButton1.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Calcular");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RequisicoesLayout = new javax.swing.GroupLayout(Requisicoes);
        Requisicoes.setLayout(RequisicoesLayout);
        RequisicoesLayout.setHorizontalGroup(
            RequisicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequisicoesLayout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addGroup(RequisicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RequisicoesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RequisicoesLayout.createSequentialGroup()
                        .addGroup(RequisicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(156, 156, 156)
                        .addGroup(RequisicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSValMin)
                            .addComponent(jSValMax)
                            .addComponent(jSnReq, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RequisicoesLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        RequisicoesLayout.setVerticalGroup(
            RequisicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequisicoesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(RequisicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSnReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(RequisicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSValMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(RequisicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSValMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        Base.add(Requisicoes, "cRequisitos");

        Resultados.setName("Resultados"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        pHeap.setName("pHeap"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tHeap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posição", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tHeap.setName("tHeap"); // NOI18N
        jScrollPane1.setViewportView(tHeap);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tContHeap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posição", "Id Requisição", "Bit Validade", "Tamanho Restante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tContHeap.setName("tContHeap"); // NOI18N
        jScrollPane2.setViewportView(tContHeap);

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel15.setText("Heap");
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel16.setText("Tabela de Controle da Heap");
        jLabel16.setName("jLabel16"); // NOI18N

        javax.swing.GroupLayout pHeapLayout = new javax.swing.GroupLayout(pHeap);
        pHeap.setLayout(pHeapLayout);
        pHeapLayout.setHorizontalGroup(
            pHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeapLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(pHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pHeapLayout.setVerticalGroup(
            pHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHeapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Heap", pHeap);

        pFila.setName("pFila"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        tReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID da Requisição", "Tamanho"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tReq.setName("tReq"); // NOI18N
        jScrollPane3.setViewportView(tReq);

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        txtLogFila.setColumns(20);
        txtLogFila.setRows(5);
        txtLogFila.setName("txtLogFila"); // NOI18N
        jScrollPane4.setViewportView(txtLogFila);

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel13.setText("Log da fila circular");
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel14.setText("Requisições");
        jLabel14.setName("jLabel14"); // NOI18N

        javax.swing.GroupLayout pFilaLayout = new javax.swing.GroupLayout(pFila);
        pFila.setLayout(pFilaLayout);
        pFilaLayout.setHorizontalGroup(
            pFilaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFilaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pFilaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(pFilaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pFilaLayout.setVerticalGroup(
            pFilaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFilaLayout.createSequentialGroup()
                .addGroup(pFilaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFilaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pFilaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pFilaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fila circular", pFila);

        pLogHeap.setName("pLogHeap"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        txtLogHeapAloca.setColumns(20);
        txtLogHeapAloca.setRows(5);
        txtLogHeapAloca.setName("txtLogHeapAloca"); // NOI18N
        jScrollPane5.setViewportView(txtLogHeapAloca);

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        txtLogHeapDesaloca.setName("txtLogHeapDesaloca"); // NOI18N
        jScrollPane6.setViewportView(txtLogHeapDesaloca);

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel11.setText("Log de alocação da Heap");
        jLabel11.setName("jLabel11"); // NOI18N

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel12.setText("Log de desalocação da Heap");
        jLabel12.setName("jLabel12"); // NOI18N

        javax.swing.GroupLayout pLogHeapLayout = new javax.swing.GroupLayout(pLogHeap);
        pLogHeap.setLayout(pLogHeapLayout);
        pLogHeapLayout.setHorizontalGroup(
            pLogHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLogHeapLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pLogHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addGroup(pLogHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
                        .addComponent(jScrollPane6)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pLogHeapLayout.setVerticalGroup(
            pLogHeapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLogHeapLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Log da Heap", pLogHeap);

        pControl.setName("pControl"); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Button-Add-icon.png"))); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Button-Turn-Off-icon.png"))); // NOI18N
        jButton3.setHideActionText(true);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton3.setName("jButton3"); // NOI18N

        javax.swing.GroupLayout pControlLayout = new javax.swing.GroupLayout(pControl);
        pControl.setLayout(pControlLayout);
        pControlLayout.setHorizontalGroup(
            pControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pControlLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(262, 262, 262))
        );
        pControlLayout.setVerticalGroup(
            pControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pControlLayout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addGroup(pControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );

        jTabbedPane1.addTab("Controle", pControl);

        javax.swing.GroupLayout ResultadosLayout = new javax.swing.GroupLayout(Resultados);
        Resultados.setLayout(ResultadosLayout);
        ResultadosLayout.setHorizontalGroup(
            ResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        ResultadosLayout.setVerticalGroup(
            ResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Base.add(Resultados, "cResultados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1023, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlocarActionPerformed
        this.mp = new mapeamentoHeap(this.limMax, this.tamHeap);
        CardLayout card = (CardLayout) Base.getLayout();
        card.show(Base, "cRequisitos");
    }//GEN-LAST:event_btnAlocarActionPerformed

    private void jSTamHeapStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSTamHeapStateChanged
        this.tamHeap = this.jSTamHeap.getValue().hashCode();
    }//GEN-LAST:event_jSTamHeapStateChanged

    private void jSLimMaxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSLimMaxStateChanged
        this.limMax = (float) this.jSLimMax.getValue().hashCode() / 100;
    }//GEN-LAST:event_jSLimMaxStateChanged

    private void jSnReqStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSnReqStateChanged
        this.nReq = this.jSnReq.getValue().hashCode();
    }//GEN-LAST:event_jSnReqStateChanged

    private void jSValMinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSValMinStateChanged
        this.valMin = this.jSValMin.getValue().hashCode();
        this.jSValMax.setValue(this.jSValMin.getValue().hashCode() + 5);
        this.valMax = this.jSValMin.getValue().hashCode() + 5;
    }//GEN-LAST:event_jSValMinStateChanged

    private void jSValMaxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSValMaxStateChanged
        this.valMax = this.jSValMax.getValue().hashCode();
    }//GEN-LAST:event_jSValMaxStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.jSValMax.getValue().hashCode() >= this.valMax){
            System.out.println(jSValMin.getValue().hashCode() + "," + jSValMax.getValue().hashCode());
            
            this.fila = new FilaCircular(this.nReq, this.valMin, this.valMax, mp, this);
            CardLayout card = (CardLayout) Base.getLayout();
            card.show(Base, "cResultados");
        }else{
            System.out.println("minimo maior que maximo");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceParalela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceParalela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceParalela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceParalela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Base;
    public javax.swing.JPanel Heap;
    public javax.swing.JPanel Requisicoes;
    public javax.swing.JPanel Resultados;
    public javax.swing.JButton btnAlocar;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JSpinner jSLimMax;
    public javax.swing.JSpinner jSTamHeap;
    public javax.swing.JSpinner jSValMax;
    public javax.swing.JSpinner jSValMin;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JSpinner jSnReq;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JPanel pControl;
    public javax.swing.JPanel pFila;
    public javax.swing.JPanel pHeap;
    public javax.swing.JPanel pLogHeap;
    public javax.swing.JTable tContHeap;
    public javax.swing.JTable tHeap;
    public javax.swing.JTable tReq;
    public javax.swing.JTextArea txtLogFila;
    public javax.swing.JTextArea txtLogHeapAloca;
    public javax.swing.JTextPane txtLogHeapDesaloca;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        new InterfaceParalela().setVisible(true);
    }
}
