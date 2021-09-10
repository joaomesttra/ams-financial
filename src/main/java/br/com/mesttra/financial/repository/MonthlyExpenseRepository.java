package br.com.mesttra.financial.repository;

import br.com.mesttra.financial.entity.MonthlyExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyExpenseRepository extends JpaRepository<MonthlyExpense, Long> {
}
