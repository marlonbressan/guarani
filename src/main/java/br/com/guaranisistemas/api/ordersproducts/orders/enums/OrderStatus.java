package br.com.guaranisistemas.api.ordersproducts.orders.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CONCLUIDO("CONCLUÍDO"),
    PENDENTE("PENDENTE"),
    CANCELADO("CANCELADO");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

}
