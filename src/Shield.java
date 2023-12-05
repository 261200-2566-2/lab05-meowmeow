public class Shield implements Weapon {
    String name;
    int level;
    double baseAttack;
    double attack;
    double baseDefense;
    double defense;

    public Shield() {
        this("Stupid");
    }

    public Shield(String name) {
        this(name, 0);
    }

    public Shield(String name, int level) {
        this(name, 10, 10, level);
    }

    public Shield(String name, double baseAttack, double baseDefense, int level) {
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.level = level;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public void upgrade() {
        level++;
        baseAttack = baseAttack * (1 + 0.1 * level);
        baseDefense = baseDefense * (1 + 2 * level);
    }
}
