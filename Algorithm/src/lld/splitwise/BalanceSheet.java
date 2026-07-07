package lld.splitwise;

import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
public class BalanceSheet {
  private Map<String, Map<String, Double>> balanceMap;
}
