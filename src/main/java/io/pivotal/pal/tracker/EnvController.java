package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.Map;

public class EnvController {

    private Map<String, String> env = new HashMap<>();

    public EnvController(String port, String memory, String cfInstanceIndex, String cfInstanceAddress) {
        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memory);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddress);
    }

    public Map<String, String> getEnv() {
        return env;
    }
}
