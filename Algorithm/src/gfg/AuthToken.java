package gfg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthToken {

    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        if (commands == null || commands.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> token : commands) {
            if (token.size() != 3) {
                return 0;
            }
            Integer tokenCommand = token.get(0);
            Integer tokenId = token.get(1);
            Integer tokenTime = token.get(2);
            if (tokenCommand == 0) {
                map.put(tokenId, tokenTime + expiryLimit);
            } else {
                if (map.containsKey(tokenId)) {
                    if (tokenTime <= map.get(tokenId)) {
                        map.put(tokenId, tokenTime + expiryLimit);
                    } else {
                        map.remove(tokenId);
                    }
                }
            }
        }
        Integer lastTime = commands.get(commands.size() - 1).get(2);
        return (int) map.values().stream().filter(tokenTime -> tokenTime >= lastTime).count();
    }
}
