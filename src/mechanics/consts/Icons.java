package mechanics.consts;

public enum Icons {
    HAPPINESS_ICON("☺"),
    BUDGET_ICON("$"),
    ECOLOGY_ICON("ECO"),
    TOURISM_ICON("Т"),

    ;

    private String icon;

    Icons(String icon) {
        this.icon = icon;
    }

    public String get() {
        return icon;
    }
}
