package br.com.mesttra.financial.amqp.messages;

import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.enums.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FinancialMessage {

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    private Double amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dueDate;

    private String correlationId;

    public MonthlyExpense toEntity() {
        MonthlyExpense monthlyExpense = new MonthlyExpense();
        BeanUtils.copyProperties(this, monthlyExpense);
        return  monthlyExpense;
    }
}
