public interface Weapon {
    String name = "Stupid";
    int level = 0;
    
    default String getName() {
        return name;
    }

    default int getLevel() {
        return level;
    }
    
    void upgrade();
}
