package br.com.guaranisistemas.api.ordersproducts.orders.controller;

import br.com.guaranisistemas.api.ordersproducts.orders.enums.OrderStatus;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersReportService;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Controller class named {@link OrdersReportsController}
 */
@RestController
@RequestMapping("/api/v1/orders_report")
@RequiredArgsConstructor
@Validated
public class OrdersReportsController {

    private final OrdersReportService ordersReportService;

    @GetMapping("/reportByStatus")
    public ResponseEntity<byte[]> buildReportByStatus(@RequestParam("status") int status) {

        List<OrdersEntity> pedidos = ordersReportService.findByStatus(status);

        try (PDDocument document = new PDDocument(); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            // Criar uma nova página
            PDPage page = new PDPage();
            document.addPage(page);

            // Criar conteúdo da página
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            contentStream.beginText();
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(25, 750);

            // Título
            String filter = status == -1 ? "TODOS" : OrderStatus.values()[status].getStatus();
            contentStream.showText("RELATÓRIO DE PEDIDOS (Filtro - Status: " + filter + ")");
            contentStream.newLine();
            contentStream.newLine();

            // Listar os pedidos no PDF
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            for (OrdersEntity pedido : pedidos) {
                contentStream.newLine();
                contentStream.newLine();
                contentStream.showText("Pedido ID: " + pedido.getId());
                contentStream.newLine();
                contentStream.showText("Status: " + OrderStatus.values()[pedido.getStatus()]);
                contentStream.newLine();
                contentStream.showText("Criado: " + pedido.getCreatedBy() == null ? "" : pedido.getCreatedBy());
                contentStream.newLine();
                contentStream.newLine();
                contentStream.showText("Cliente: " + pedido.getCustomer().getName());
                contentStream.showText(" Endereço: " + pedido.getCustomer().getEndereco());
                contentStream.newLine();
                contentStream.newLine();
                contentStream.showText(
                        "Sub-Total: " + pedido.getSubTotal() +
                                " Desconto: " + pedido.getDiscount() +
                                " Frete: " + pedido.getFreight() +
                                " TOTAL: " + (pedido.getTotal()));
                contentStream.newLine();
                contentStream.showText("_".repeat(100));

            }

            // Fechar o conteúdo
            contentStream.endText();
            contentStream.close();

            // Salvar documento no ByteArrayOutputStream
            document.save(baos);

            // Headers para retorno do PDF
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "OrdersReport.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(baos.toByteArray());

        } catch (IOException e) {
            return ResponseEntity.noContent().build();
        }

    }
}
