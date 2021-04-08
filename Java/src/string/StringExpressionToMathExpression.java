package string;

import javax.script.ScriptEngineManager;

public class StringExpressionToMathExpression {
    public static void main(String[] args) throws Exception {
        System.out.println(new ScriptEngineManager().getEngineByName("nashorn").eval("40^3+2").toString());
    }
}
