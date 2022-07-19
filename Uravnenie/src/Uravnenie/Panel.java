package Uravnenie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    LexicalAnalysis lexicalAnalysis = new LexicalAnalysis();
    LogicAnalysis logicAnalysis = new LogicAnalysis();
    private String textFieldValueArifmetic;
    private String textFieldValueLogic;
    private String ans = "-";
    JLabel answer = new JLabel();


    public Panel() {

        add(new JLabel("Введите арифметическое выражение"));
        JTextField jTextFieldArifmetic = new JTextField(25);
        add(jTextFieldArifmetic);
        jTextFieldArifmetic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws RuntimeException {
                try {
                    textFieldValueArifmetic = jTextFieldArifmetic.getText();
                    lexicalAnalysis.analysis(textFieldValueArifmetic);
                    ans = lexicalAnalysis.read();
                    lexicalAnalysis.clear();
                    answer.setText(ans);
                }
                catch (RuntimeException q) {
                    answer.setText(q.getMessage());
                }
                finally {
                    lexicalAnalysis.clear();
                }
            }
        });

        add(new JLabel("Используемые обозначения:"));
        add(new JLabel("xor - @, and - &, or - |,"));
        add(new JLabel("true - t, false - f"));

        add(new JLabel("Введите логическое выражение"));
        JTextField jTextFieldLogic = new JTextField(25);
        add(jTextFieldLogic);
        jTextFieldLogic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws RuntimeException {
                try {
                    textFieldValueLogic = jTextFieldLogic.getText();
                    logicAnalysis.analysis(textFieldValueLogic);
                    ans = logicAnalysis.readLogic();
                    logicAnalysis.clearLogic();
                    answer.setText(ans);
                }
                catch (RuntimeException q) {
                    answer.setText(q.getMessage());
                }
                finally {
                    logicAnalysis.clearLogic();
                }
            }
        });

        add(new JLabel("Ответ:"));
        add(answer);
    }
}
