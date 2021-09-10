package br.com.mesttra.financial.amqp;

import br.com.mesttra.financial.amqp.messages.FinancialMessage;
import br.com.mesttra.financial.service.ExpenseService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FromContractConsumer {

    ExpenseService expenseService;
    RabbitTemplate rabbitTemplate;

    public FromContractConsumer(ExpenseService expenseService, RabbitTemplate rabbitTemplate) {
        this.expenseService = expenseService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_TO_FINANCIAL)
    public void consume(@Payload FinancialMessage financialMessage) {
        this.expenseService.addMonthlyExpense(financialMessage.toEntity());
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY_FINANCIAL_TO_CONTRACT, financialMessage);
    }

}
