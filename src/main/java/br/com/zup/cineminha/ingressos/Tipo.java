package br.com.zup.cineminha.ingressos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Tipo {

    INTEIRA {

        @Override
        public BigDecimal calcula(BigDecimal preco) {
            return preco;
        }

    },
    MEIA_ENTRADA {

        @Override
        public BigDecimal calcula(BigDecimal preco) {
            return preco.divide(new BigDecimal("2.0"), RoundingMode.CEILING);
        }

    },
    CORTESIA {

        @Override
        public BigDecimal calcula(BigDecimal preco) {
            return BigDecimal.ZERO;
        }

    };


    public abstract BigDecimal calcula(BigDecimal preco);
}
