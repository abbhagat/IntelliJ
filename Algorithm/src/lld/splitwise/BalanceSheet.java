package lld.splitwise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class BalanceSheet {

  private Map<String, Map<String, Double>> balanceSheet;

}
