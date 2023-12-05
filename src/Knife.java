public class Knife implements Weapon {
    String name;
    int level;
    double baseAttack;
    double attack;

    public Knife() {
        this("Stupid");
    }

    public Knife(String name) {
        this(name, 0);
    }

    public Knife(String name, int level) {
        this(name, 20, level);
    }

    public Knife(String name, double baseAttack, int level) {
        this.name = name;
        this.baseAttack = baseAttack;
        this.level = level;
    }

    public double getAttack() {
        return attack;
    }

    public void upgrade() {
        level++;
        baseAttack = baseAttack * (1 + 0.1 * level);
    }
}
