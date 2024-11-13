import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AgendaDiaria {
    private JTextField inputDesc;
    private JPanel agenda;
    private JSpinner seletorDatas;
    private JButton btnAdd;
    private JTable tabela;
    private JButton btnDel;

    public static void main(String[] args){

        JFrame tela = new JFrame("Agenda Diaria");
        tela.setContentPane(new AgendaDiaria().agenda);
        tela.pack();
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setVisible(true);

    }

    public AgendaDiaria(){

        SpinnerDateModel dataModel = new SpinnerDateModel();
        seletorDatas.setModel(dataModel);
        JSpinner.DateEditor formatoDDMMAA = new JSpinner.DateEditor(seletorDatas, "dd/MM/yyyy");
        seletorDatas.setEditor(formatoDDMMAA);

        String[] colunas = {"Descrição", "Data"};
        DefaultTableModel tabelaModel = new DefaultTableModel(colunas, 0);
        tabela.setModel(tabelaModel);
        Object[] novaLinha = {"DESCRIÇÃO", "DATA"};
        tabelaModel.addRow(novaLinha);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date dataEscolhida = (Date) seletorDatas.getValue();

                Object[] novaLinha = {inputDesc.getText(), dataEscolhida};
                tabelaModel.addRow(novaLinha);

            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tabelaModel.removeRow(tabela.getSelectedRow());

            }
        });

    }
}
