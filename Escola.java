package escola;

import java.util.List;
import javax.swing.JOptionPane;

public class Escola {
    public static void main(String[] args) {
        boolean fimprog = false;
        
        do {            
            menuPrincipal();
            Aluno alu = new Aluno();
            String opcao = JOptionPane.showInputDialog("Informe a opcao");
            
            switch(opcao) {        
                case "1":   alu.setNomaluno(JOptionPane.showInputDialog("Nome do Aluno"));
                            alu.setMedaluno(Float.parseFloat(JOptionPane.showInputDialog("Média do Aluno")));
                            if (alu.IncluirAluno()) {
                                JOptionPane.showMessageDialog(null, "Aluno Cadastrado com Sucesso");
                            } else {
                                JOptionPane.showMessageDialog(null,"Problema ao cadastrar aluno");
                            }
                            break;

                case "2":   alu.setCodaluno(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código do Aluno")));
                            alu.setNomaluno(JOptionPane.showInputDialog("Nome do Aluno"));
                            alu.setMedaluno(Float.parseFloat(JOptionPane.showInputDialog("Média do Aluno")));
                            if (alu.AlterarAluno()) {
                                JOptionPane.showMessageDialog(null, "Aluno Alterado com Sucesso");
                            } else {
                                JOptionPane.showMessageDialog(null,"Problema ao alterar o Aluno","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
                            }
                            break;                        
                
                case "3":   alu.setCodaluno(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código do Aluno")));
                            if (alu.ExcluirAluno()) {
                                JOptionPane.showMessageDialog(null, "Aluno Removido com Sucesso");
                            } else {
                                JOptionPane.showMessageDialog(null,"Problema ao remover o Aluno","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
                            }
                            break;                               
                case "4" :  Aluno alu1 = new Aluno();
                            List<Aluno> alunos = alu1.consultaAlunos();
                            for (Aluno a : alunos) {
                                System.out.println("Aluno :" + a.getCodaluno());
                                System.out.println("Nome :" + a.getNomaluno());
                                System.out.println("Média :" + a.getMedaluno());
                            }
               
                case "9" :  fimprog = true;
                            JOptionPane.showMessageDialog(null,"Programa Finalizado \n com Sucesso !!!","Atenção",JOptionPane.WARNING_MESSAGE);
                            break;
                default: JOptionPane.showMessageDialog(null,"Opção Inválida. Redigite !","ERRO",JOptionPane.ERROR_MESSAGE);
            }
        } while (!fimprog);        
    }
    
    public static void menuPrincipal(){
        System.out.println("+------------------------------+");
        System.out.println("|       MENU PRINCIPAL         |");
        System.out.println("+------------------------------+");
        System.out.println("| ALUNO              NOTAS     |");
        System.out.println("| 1. Incluir       5. Incluir  |");
        System.out.println("| 2. Alterar       6. Alterar  |");
        System.out.println("| 3. Excluir       7. Excluir  |");
        System.out.println("| 4. Consultar     8. Consultar|");
        System.out.println("|        9 = FIM               |");        
        System.out.println("+------------------------------+");
    }
}
