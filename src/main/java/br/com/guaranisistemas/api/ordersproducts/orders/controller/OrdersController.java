package br.com.guaranisistemas.api.ordersproducts.orders.controller;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.common.model.dto.response.CustomPagingResponse;
import br.com.guaranisistemas.api.ordersproducts.common.model.dto.response.CustomResponse;
import br.com.guaranisistemas.api.ordersproducts.orders.mapper.CustomPageToCustomPagingResponseMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.mapper.OrdersToOrdersResponseMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersCreateRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersPagingRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersUpdateRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.response.OrdersResponse;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersCreateService;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersDeleteService;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersReadService;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller class named {@link OrdersController}
 * Exposes endpoints under "/api/v1/orders".
 */
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Validated
public class OrdersController {

    private final OrdersCreateService ordersCreateService;
    private final OrdersReadService ordersReadService;
    private final OrdersUpdateService ordersUpdateService;
    private final OrdersDeleteService ordersDeleteService;

    private final OrdersToOrdersResponseMapper ordersToOrdersResponseMapper = OrdersToOrdersResponseMapper.initialize();

    private final CustomPageToCustomPagingResponseMapper customPageToCustomPagingResponseMapper =
            CustomPageToCustomPagingResponseMapper.initialize();

    /**
     * Creates a new Orders.
     *
     * @param ordersCreateRequest the request body containing Orders creation details
     * @return a CustomResponse with the ID of the created orders upon successful creation
     */
    @PostMapping
    public CustomResponse<String> createOrders(@RequestBody @Valid final OrdersCreateRequest ordersCreateRequest) {

        final Orders createdOrders = ordersCreateService
                .createOrders(ordersCreateRequest);

        return CustomResponse.successOf(createdOrders.getId());
    }

    /**
     * Retrieves a Orders by its ID.
     *
     * @param ordersId the ID of the Orders to retrieve
     * @return a CustomResponse containing the Orders details
     */
    @GetMapping("/{ordersId}")
    public CustomResponse<OrdersResponse> getOrdersById(@PathVariable @UUID final String ordersId) {

        final Orders orders = ordersReadService.getOrdersById(ordersId);
        final OrdersResponse ordersResponse = ordersToOrdersResponseMapper.map(orders);
        return CustomResponse.successOf(ordersResponse);
    }

    /**
     * Retrieves a list of Orders based on pagination criteria.
     *
     * @param ordersPagingRequest the request body containing pagination parameters
     * @return a CustomResponse with paginated Orders details
     */
    @GetMapping
    public CustomResponse<CustomPagingResponse<OrdersResponse>> getAllOrders(
            @RequestBody @Valid final OrdersPagingRequest ordersPagingRequest) {

        final CustomPage<Orders> ordersPage = ordersReadService.getOrders(ordersPagingRequest);

        final CustomPagingResponse<OrdersResponse> ordersPagingResponse =
                customPageToCustomPagingResponseMapper.toPagingResponse(ordersPage);

        return CustomResponse.successOf(ordersPagingResponse);
    }

    @GetMapping("/findByFilters")
    public List<OrdersEntity> findOrdersByFilters(
            @RequestParam(required = false) int status,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate,
            @RequestParam(required = false) BigDecimal total) {
        return ordersReadService.findByFilters(status, startDate, endDate, total);
    }

    /**
     * Updates an existing Orders by its ID.
     *
     * @param ordersUpdateRequest the request body containing updated Orders details
     * @param ordersId            the ID of the Orders to update
     * @return a CustomResponse with updated Orders details
     */
    @PutMapping("/{ordersId}")
    public CustomResponse<OrdersResponse> updatedOrdersById(
            @RequestBody @Valid final OrdersUpdateRequest ordersUpdateRequest,
            @PathVariable @UUID final String ordersId) {

        final Orders updatedOrders = ordersUpdateService.updateOrdersById(ordersId, ordersUpdateRequest);

        final OrdersResponse ordersResponse = ordersToOrdersResponseMapper.map(updatedOrders);

        return CustomResponse.successOf(ordersResponse);
    }

    /**
     * Deletes a Orders by its ID.
     *
     * @param ordersId the ID of the Orders to delete
     * @return a CustomResponse indicating the success of the deletion operation
     */
    @DeleteMapping("/{ordersId}")
    @PreAuthorize("hasAnyAuthority('admin:delete')")
    public CustomResponse<Void> deleteOrdersById(@PathVariable @UUID final String ordersId) {

        ordersDeleteService.deleteOrdersById(ordersId);
        return CustomResponse.SUCCESS;
    }

}
