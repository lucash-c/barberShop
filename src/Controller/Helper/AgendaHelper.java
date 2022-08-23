/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas
 */
public class AgendaHelper implements IHelper {
    private Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }
    
    
        
    

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
      
      DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        
        //percorrer a lista de agendamentos prenchendo a tabela
        
        for( Agendamento agendamento : agendamentos){
            
            tableModel.addRow(new Object[] {
            
            agendamento.getId(),
            agendamento.getCliente().getNome(),
            agendamento.getServico().getDescricao(),
            agendamento.getValor(),
            agendamento.getDataFormatada(),
            agendamento.getHoraFormatada(),
            agendamento.getObservacao()
          
            
            
            
            });
            
            
            
        }
        
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        
        for (Cliente cliente : clientes) {
            
            comboBoxModel.addElement(cliente);
            
        }
        
        
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
        
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);
        }
    }
    
    public Cliente ObterCliente() {
        return (Cliente)view.getjComboBoxCliente().getSelectedItem();
    }

    public Servico ObterServico() {
        return (Servico)view.getjComboBoxServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getCampoValor().setText(valor+"");
    }

    @Override
    public Agendamento obterModelo() {
        
        String idString = view.getCampoId().getText();
        int id = Integer.parseInt(idString);
        
        Cliente cliente = this.ObterCliente();
        
        Servico servico = this.ObterServico();
        
        String valorString = view.getCampoValor().getText();
        float valor = Float.parseFloat(valorString);
        
        String data = view.getCampoData().getText();
        String hora = view.getCampoHora().getText();
        String dataHora = data+" "+hora;
        
        String observacao = view.getCampoObservacao().getText();
        
      Agendamento agendamento = new Agendamento(id,cliente,servico,valor,dataHora,observacao);
      
      return agendamento;
    }

    @Override
    public void limparTela() { 
                 
     view.getCampoId().setText("0");
     view.getCampoData().setText("");
     view.getCampoHora().setText("");
     view.getCampoObservacao().setText("");
    }
    

    
   
            
    
    
    
}
