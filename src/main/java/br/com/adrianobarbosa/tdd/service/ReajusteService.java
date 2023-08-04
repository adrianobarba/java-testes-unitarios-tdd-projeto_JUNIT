package br.com.adrianobarbosa.tdd.service;

import java.math.BigDecimal;

import br.com.adrianobarbosa.tdd.modelo.Desempenho;
import br.com.adrianobarbosa.tdd.modelo.Funcionario;


public class ReajusteService {

  public void concederReajuste(Funcionario funcionario, Desempenho desempenho){
	  BigDecimal percentual = desempenho.percentualReajuste();
      BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
      funcionario.reajustarSalario(reajuste);
  }

}