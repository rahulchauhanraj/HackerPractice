package com.rahul.interviews.sixt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScriptRunner {

    public static void main(String[] s) {
        VulnerabilityScript script8 = new VulnerabilityScript(8, null);
        VulnerabilityScript script7 = new VulnerabilityScript(7, Arrays.asList(script8));
        VulnerabilityScript script6 = new VulnerabilityScript(6, Arrays.asList(script8));
        VulnerabilityScript script5 = new VulnerabilityScript(5, Arrays.asList(script8));
        VulnerabilityScript script4 = new VulnerabilityScript(4, null);
        VulnerabilityScript script3 = new VulnerabilityScript(3, Arrays.asList(script4, script8));
        VulnerabilityScript script2 = new VulnerabilityScript(2, Arrays.asList(script5, script6, script7));
        VulnerabilityScript script1 = new VulnerabilityScript(1, Arrays.asList(script2, script3, script4));
        executeScripts(script1);
    }

    public static void executeScripts(VulnerabilityScript script){
        executeScripts(script, new HashSet<>());
    }

    public static void executeScripts(VulnerabilityScript script, Set<Integer> executed){
        if(script != null) {
            executed.add(script.getScriptId());
            List<VulnerabilityScript> dependencies = script.getDependencies();
            if(dependencies != null) {
                for(VulnerabilityScript dependency : dependencies){
                    if(!executed.contains(dependency.getScriptId())) {
                        executeScripts(dependency, executed);
                    }
                }
            }
            System.out.println(script.getScriptId());
        }
    }


    static class VulnerabilityScript {
        private final int scriptId;
        private final List<VulnerabilityScript> dependencies;

        public VulnerabilityScript(int scriptId, List<VulnerabilityScript> dependencies) {
            this.scriptId = scriptId;
            this.dependencies = dependencies;
        }

        public int getScriptId() {
            return scriptId;
        }

        public List<VulnerabilityScript> getDependencies() {
            return dependencies;
        }
    }
}
