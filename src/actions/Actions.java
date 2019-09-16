package actions;

import mechanics.Country;

import java.util.*;

public class Actions {
    //Класс обертка для квестов
    private HashMap<String, LinkedList<Action>> actionList = new HashMap<>();

    public void put(Action action) {
        if (!actionList.containsKey(action.getStoryName())) {
            actionList.put(action.getStoryName(), new LinkedList<>());
        }
        actionList.get(action.getStoryName()).add(action);
    }

    public void start(Country country) {
        while (true) {
            remove(country);
            if(actionList.isEmpty()) return;
            String randKey = getRandomKey();
            if (actionList.get(randKey).isEmpty()) continue;
            for (Action action : actionList.get(randKey)) {
                if (!action.getComplete()) {
                    action.start(country);
                    return;
                } else actionList.get(randKey).remove(action);
            }
        }
    }

    private String getRandomKey() {
        Random random = new Random();
        List<String> keys = new ArrayList<>(actionList.keySet());
        return keys.get(random.nextInt(keys.size()));
    }

    private void remove(Country country){
        actionList.forEach((k, v) -> {
            for (Iterator<Action> iter = v.iterator(); iter.hasNext(); ) {
                Action action = iter.next();
                if (action instanceof StepAction) {
                    if (action.getComplete() && ((StepAction) action).getStep() < country.getSteps()) iter.remove();
                } else {
                    if (action.getComplete()) iter.remove();
                }
            }
        });
        actionList.keySet().removeIf(k -> actionList.get(k).isEmpty());
    }

    private void checkSteps(Country country){
        actionList.forEach((k, v) -> v.forEach(action -> {
            if (action instanceof StepAction) {
                ((StepAction) action).checkSteps(country);
            }
        }));

    }

    public void doStep(Country country) {
        //remove(country);
        checkSteps(country);
    }
}
