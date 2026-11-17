package lld.splitwise;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class BalanceSheet {

  private Map<String, Map<String, Double>> balanceSheet;

}
