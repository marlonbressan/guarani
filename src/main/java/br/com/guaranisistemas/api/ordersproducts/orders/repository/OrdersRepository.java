package br.com.guaranisistemas.api.ordersproducts.orders.repository;

import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface named {@link OrdersRepository} for managing CustomerEntity objects in the database.
 */
public interface OrdersRepository extends JpaRepository<OrdersEntity, String> {

    List<OrdersEntity> findByStatus(int status);

    @Query("SELECT o FROM OrdersEntity o " +
            "LEFT JOIN o.items od " +
            "WHERE (:status IS NULL OR o.status = :status) " +
            "AND (:startDate IS NULL OR o.createdAt >= :startDate) " +
            "AND (:endDate IS NULL OR o.createdAt <= :endDate) " +
            "AND (:total IS NULL OR o.total >= :total)")
    List<OrdersEntity> findByFilters(@Param("status") int status,
                                     @Param("startDate") LocalDateTime startDate,
                                     @Param("endDate") LocalDateTime endDate,
                                     @Param("total") BigDecimal total);
}
