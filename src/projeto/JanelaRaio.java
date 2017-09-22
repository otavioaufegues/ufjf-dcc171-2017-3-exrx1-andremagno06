/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ice
 */
class JanelaRaio extends JFrame {

    private final List<Raio> raios;
    private final JList<Raio> lstRaios = new JList<>(new DefaultListModel<>());
    private final JButton criaRaio = new JButton("Cria Raio");
    private final JButton excluirRaio = new JButton("Exclui Raio");
    private final JButton alteraRaio = new JButton("Altera Raio");

    private final JTextField txtLatitude = new JTextField("Latitude");
    private final JTextField txtLongitude = new JTextField("Longitude");
    private final JTextField txtData = new JTextField("Data");
    private final JTextField txtDescricao = new JTextField("Descrição");

    DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    
    
    public JanelaRaio(List<Raio> sampleData) {

        super("Raios");
        this.raios = sampleData;

        lstRaios.setModel(new RaioListModel(raios));

        add(new JScrollPane(lstRaios), BorderLayout.WEST);

        JPanel txt = new JPanel(new GridLayout(4, 1));

        add(txt, BorderLayout.EAST);

        txt.add(txtLatitude);
        txt.add(txtLongitude);
        txt.add(txtData);
        txt.add(txtDescricao);

        JPanel botoes = new JPanel(new GridLayout(1, 4));

        add(botoes, BorderLayout.SOUTH);
        botoes.add(criaRaio);
        botoes.add(alteraRaio);
        botoes.add(excluirRaio);

        criaRaio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                

                Raio t = null;
                try {
                    t = new Raio(Double.parseDouble(txtLatitude.getText()),
                            Double.parseDouble(txtLongitude.getText()),
                            (Date) formatter.parse(txtData.getText()),
                            txtDescricao.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(JanelaRaio.class.getName()).log(Level.SEVERE, null, ex);
                }

                raios.add(t);
                lstRaios.updateUI();
            }

        });

        alteraRaio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Raio selecionada = lstRaios.getSelectedValue();
                if (selecionada != null) {
                    txtLongitude.setText(Double.toString(selecionada.getLongitude()));
                    txtLatitude.setText(Double.toString(selecionada.getLatitude()));
                    txtData.setText(formatter.format(selecionada.getData()));
                    txtDescricao.setText(selecionada.getDescrição());

                } else {
                    lstRaios.setModel(new DefaultListModel<>());
                }
            }

        }
        );
    }

}

/*
    
    
package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaTurmas extends JFrame {

    private final List<Turma> turmas;
    private final JList<Turma> lstTurmas = new JList<>(new DefaultListModel<>());
    private final JList<Aluno> lstAlunos = new JList<>(new DefaultListModel<>());
    private final JButton criaTurma = new JButton("Cria Turma");
    private final JButton criaAluno = new JButton("Cria Aluno");
    private final JButton excluirTurma = new JButton("Exclui Turma");
    private final JButton excluirAluno = new JButton("Exclui Aluno");
    private final JanelaAluno janelaAluno = new JanelaAluno();

    public JanelaTurmas(List<Turma> sampleData) {
        super("Turmas");
        this.turmas = sampleData;

        lstTurmas.setModel(new TurmasListModel(turmas));

        add(new JScrollPane(lstTurmas), BorderLayout.WEST);
        add(new JScrollPane(lstAlunos), BorderLayout.CENTER);
        add(criaTurma, BorderLayout.SOUTH);
        //Box botoes = Box.createHorizontalBox();
        JPanel botoes = new JPanel(new GridLayout(1, 4));
        add(botoes, BorderLayout.SOUTH);
        botoes.add(criaTurma);
        botoes.add(excluirTurma);
        botoes.add(criaAluno);
        botoes.add(excluirAluno);

        lstTurmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lstTurmas.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Turma selecionada = lstTurmas.getSelectedValue();
                if (selecionada != null) {
                    System.out.println(selecionada);
                    lstAlunos.setModel(new AlunosListModel(selecionada.getAlunos()));
                } else {
                    lstAlunos.setModel(new DefaultListModel<>());
                }
            }
        });

        criaTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = JOptionPane.showInputDialog("Codigo da Nova turma");
                if (cod != null & !cod.isEmpty()) {
                    Turma t = new Turma(cod);
                    turmas.add(t);
                    lstTurmas.updateUI();
                }

            }
        });

        excluirTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstTurmas.isSelectionEmpty()) {
                    return;
                }
                turmas.remove(lstTurmas.getSelectedValue());
                lstTurmas.clearSelection();
                lstTurmas.updateUI();
            }
        });

        criaAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAluno.setVisible(true);
                janelaAluno.setLocationRelativeTo(null);
            }
        });

        janelaAluno.setJanelaTurma(this);

        excluirAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public void AdicionaAluno(Aluno a) {
        lstTurmas.getSelectedValue().getAlunos().add(a);
        lstAlunos.updateUI();
        lstTurmas.updateUI();
        janelaAluno.setVisible(false);
    }

}
 */
