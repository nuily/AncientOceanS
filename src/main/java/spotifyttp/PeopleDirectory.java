package spotifyttp;

import java.util.HashMap;
import java.util.Map;

public enum PeopleDirectory {
    instance;

    private Map<String, People> peopleDirectory = new HashMap<String, People>();

    PeopleDirectory() {
        peopleDirectory.put("1", new People("1", "Lily", "San Francisco"));
        peopleDirectory.put("2", new People("2", "Sakura", "Tokyo"));
    }

    public Map<String, People> getPeopleDirectory() {
        return peopleDirectory;
    }
}
