public class Codex implements Weapon {
    String name;
    int level;
    double baseMagic;
    double magic;

    public Codex() {
        this("Stupid");
    }

    public Codex(String name) {
        this(name, 0);
    }

    public Codex(String name, int level) {
        this(name, 10, level);
    }

    public Codex(String name, double baseMagic, int level) {
        this.name = name;
        this.baseMagic = baseMagic;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getMagic() {
        return magic;
    }

    public void upgrade() {
        level++;
        baseMagic = baseMagic * (1 + 0.1 * level);
    }
}
