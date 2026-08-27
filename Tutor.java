/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinveterinaria;

/**
 *
 * @author diego
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Tutor {
    
    // 1. Atributos privados correspondentes às colunas da tabela TUTOR
    private int id_tutor;
    private String nome;
    private String cidade; 
    private String telefone;
    private String cpf;

    // 2. Construtor Padrão (Sem parâmetros) - Obrigatório pelo RNF 0007
    public Tutor() {
    }

    // 3. Construtor Completo (Com todos os parâmetros) - Obrigatório pelo RNF 0007
    public Tutor(int id_tutor, String nome, String cidade, String telefone, String cpf) {
        this.id_tutor = id_tutor;
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    // 4. Métodos Getters e Setters para todos os atributos
    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // 5. Método toString() - Obrigatório pelo RNF 0007
    @Override
    public String toString() {
        return "Tutor{" + "id_tutor=" + id_tutor + ", nome=" + nome + ", cidade=" + cidade + ", telefone=" + telefone + ", cpf=" + cpf + '}';
    }
    
    
    // metodo salvar
    
    public void salvar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/CLINICA_VETERINARIA", "root", "1234");
            Statement comando = conexao.createStatement();
            
            String sql = "INSERT INTO TUTOR (NOME, CIDADE, TELEFONE, CPF) VALUES ('"
                    + this.nome + "', '"
                    + this.cidade + "', '"
                    + this.telefone + "', '"
                    + this.cpf + "')";
            
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Tutor cadastrado com sucesso!");
            
            comando.close();
            conexao.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar tutor no banco: " + erro.getMessage());
        }
    }
    
    // metodo alterar
    
    public void alterar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/CLINICA_VETERINARIA", "root", "1234");
            Statement comando = conexao.createStatement();
            
            String sql = "UPDATE TUTOR SET NOME = '" + this.nome 
                    + "', CIDADE = '" + this.cidade 
                    + "', TELEFONE = '" + this.telefone 
                    + "', CPF = '" + this.cpf 
                    + "' WHERE ID_TUTOR = " + this.id_tutor;
            
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Tutor alterado com sucesso!");
            
            comando.close();
            conexao.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar tutor no banco: " + erro.getMessage());
        }
    }

    //metodo excluir
    
    public void excluir() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/CLINICA_VETERINARIA", "root", "1234");
            Statement comando = conexao.createStatement();
            
            String sql = "DELETE FROM TUTOR WHERE ID_TUTOR = " + this.id_tutor;
            
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Tutor excluído com sucesso!");
            
            comando.close();
            conexao.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir tutor no banco: " + erro.getMessage());
        }
    }
    
    // metodo listar
    
    public java.sql.ResultSet listar() {
        java.sql.ResultSet resultado = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection conexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/CLINICA_VETERINARIA", "root", "1234");
            java.sql.Statement comando = conexao.createStatement();
            
            String sql = "SELECT * FROM TUTOR ORDER BY NOME";
            resultado = comando.executeQuery(sql);
            
        } catch (Exception erro) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao listar tutores: " + erro.getMessage());
        }
        return resultado;
    }
    
}
