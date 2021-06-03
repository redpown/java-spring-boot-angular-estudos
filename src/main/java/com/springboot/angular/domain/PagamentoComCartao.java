package com.springboot.angular.domain;

import javax.persistence.Entity;

import com.springboot.angular.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	
		private static final long serialVersionUID = 1L;

		private Integer numeroParcelas;
		
		public PagamentoComCartao() {}

		public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcela) {
			super(id, estado, pedido);
			this.numeroParcelas = numeroParcela;
		}

		public Integer getNumeroParcelas() {
			return numeroParcelas;
		}

		public void setNumeroParcelas(Integer numeroParcelas) {
			this.numeroParcelas = numeroParcelas;
		}
	}
