package interview;

class VETService {

  public String applyValidation(String transactionEvent) {
    return transactionEvent;
  }

  public String applyEnrichment(String transactionEvent) {
    return transactionEvent;
  }
}

class DataNormalizeService {

  public String normalize(String tradeMsg) {
    return new String("Transaction Event JSON");
  }
}

class AggregationService {

  public String applyAggregation(String transactionEvent) {
    return transactionEvent;
  }
}

class SettlementService {

  public String settleTrade(String transactionEvent) {
    return transactionEvent;
  }
}

abstract class TradeProcessing {

  private final DataNormalizeService dataNormalizeService;
  private final VETService vetService;
  private final AggregationService aggregationService;
  private final SettlementService settlementService;

  public TradeProcessing(DataNormalizeService dataNormalizeService, VETService vetService, AggregationService aggregationService, SettlementService settlementService) {
    this.dataNormalizeService = dataNormalizeService;
    this.vetService = vetService;
    this.aggregationService = aggregationService;
    this.settlementService = settlementService;
  }

  public String normalize(String tradeMsg) {
    return dataNormalizeService.normalize(tradeMsg);
  }

  public String applyValidation(String transactionEvent) {
    transactionEvent = vetService.applyValidation(transactionEvent);
    transactionEvent = vetService.applyEnrichment(transactionEvent);
    return transactionEvent;
  }

  public String applyAggregation(String transactionEvent) {
    return aggregationService.applyAggregation(transactionEvent);
  }

  public String settleTrade(String transactionEvent) {
    return settlementService.settleTrade(transactionEvent);
  }

  public final String executeTrade(String tradeMsg) {
    String transactionEvent = normalize(tradeMsg);
    transactionEvent = applyValidation(transactionEvent);
    transactionEvent = applyAggregation(transactionEvent);
    transactionEvent = settleTrade(transactionEvent);
    return transactionEvent;
  }

}

class ProcessTrade extends TradeProcessing {

  public ProcessTrade(DataNormalizeService dataNormalizeService, VETService vetService, AggregationService aggregationService, SettlementService settlementService) {
    super(dataNormalizeService, vetService, aggregationService, settlementService);
  }

  public String executeTradeProcessing(String tradeMsg) {
    return executeTrade(tradeMsg);
  }
}

public class Main {

  private static final DataNormalizeService dataNormalizeService = new DataNormalizeService();
  private static final VETService vetService = new VETService();
  private static final AggregationService aggregationService = new AggregationService();
  private static final SettlementService settlementService = new SettlementService();

  public static void main(String[] args) {
    ProcessTrade processTrade = new ProcessTrade(dataNormalizeService, vetService, aggregationService, settlementService);
    String response = processTrade.executeTradeProcessing(args[0]);
  }

}
