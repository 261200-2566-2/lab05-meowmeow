public class Assassin implements Character {
    private String name;
    private int level;
    private double baseHp;
    private double hp;
    private double maxHp;
    private double baseMana;
    private double mana;
    private double maxMana;
    private double baseAttack;
    private double attack;
    private double baseMagic;
    private double magic;
    private double baseDefense;
    private double defense;
    private double baseSpeed;
    private double speed;
    private double maxSpeed;
    private Knife knife;

    public Assassin() {
        this("Samuel");
    }

    public Assassin(String name) {
        this(name, 0);
    }

    public Assassin(String name, int level) {
        this(name, 100, 50, 10, 10, 10, 10, level);
    }

    public Assassin(String name, double baseHp, double baseMana, double baseAttack, double baseMagic, double baseDefense, double baseSpeed, int level) {
        this.name = name;
        this.level = level;
        this.baseHp = baseHp;
        this.hp = baseHp + (10 * level);
        this.maxHp = baseHp + (10 * level);
        this.baseMana = baseMana;
        this.mana = baseMana + (2 * level);
        this.maxMana = baseMana + (2 * level);
        this.baseAttack = baseAttack;
        this.attack = baseAttack * (1 + 2 * level);
        this.baseMagic = baseMagic;
        this.magic = baseMagic * (1 + 0.1 * level);
        this.baseDefense = baseDefense;
        this.defense = baseDefense * (1 + 0.1 * level);
        this.baseSpeed = baseSpeed;
        this.speed = baseSpeed + (0.1 + 0.03 * level);
        this.maxSpeed = baseSpeed + (0.1 + 0.03 * level);
    }
    
    public void calculateStats() {
        this.maxHp = baseHp + (10 * level);
        this.maxMana = baseMana + (2 * level);
        this.maxSpeed = baseSpeed + (0.1 + 0.03 * level);
        this.attack = baseAttack * (1 + 2 * level);
        this.magic = baseMagic * (1 + 0.1 * level);
        this.defense = baseDefense * (1 + 0.1 * level);
        this.maxSpeed = baseSpeed + (1 + 0.05 * level);
        if (knife != null) {
            speed = maxSpeed * (0.8 + 0.07 * knife.getLevel());
        } else {
            speed = maxSpeed;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public double getMana() {
        return mana;
    }

    public double getMaxMana() {
        return maxMana;
    }

    public double getAttack() {
        return knife == null ? attack : attack + knife.getAttack();
    }

    public double getMagic() {
        return magic;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpeed() {
        return speed;
    }

    Knife getKnife() {
        return knife;
    }

    public void setKnife(Knife knife) {
        this.knife = knife;
    }
    
    public void upgrade() {
        level++;
        calculateStats();
    }

    protected void getAttacked(double damage) {
        hp -= damage;
    }
    
    public void attack(Character target) {
        if (target instanceof Warrior) {
            Warrior warrior = (Warrior) target;
            warrior.getAttacked(this.getAttack());
        } else if (target instanceof Assassin) {
            Assassin Assassin = (Assassin) target;
            Assassin.getAttacked(this.getAttack());
        } else if (target instanceof Assassin) {
            Assassin assassin = (Assassin) target;
            assassin.getAttacked(this.getAttack());
        }
    }

    protected void getAttackedMagic(double damage) {
        hp -= damage;
    }

    public void attackMagic(Character target) {
        if (target instanceof Warrior) {
            Warrior warrior = (Warrior) target;
            warrior.getAttackedMagic(this.getMagic());
        } else if (target instanceof Assassin) {
            Assassin Assassin = (Assassin) target;
            Assassin.getAttackedMagic(this.getMagic());
        } else if (target instanceof Assassin) {
            Assassin assassin = (Assassin) target;
            assassin.getAttackedMagic(this.getMagic());
        }
        mana--;
    }

    public void heal(double amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public void restoreMana(double amount) {
        mana += amount;
        if (mana > maxMana) {
            mana = maxMana;
        }
    }
}
