package br.com.mesttra.financial.service;


import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.repository.MonthlyExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    MonthlyExpenseRepository monthlyExpenseRepository;

    public ExpenseService(MonthlyExpenseRepository monthlyExpenseRepository) {
        this.monthlyExpenseRepository = monthlyExpenseRepository;
    }

    public void addMonthlyExpense(MonthlyExpense monthlyExpense) {
        this.monthlyExpenseRepository.save(monthlyExpense);
    }
}
