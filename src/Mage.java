public class Mage implements Character {
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
    private Codex codex;

    public Mage() {
        this("Momo");
    }

    public Mage(String name) {
        this(name, 0);
    }

    public Mage(String name, int level) {
        this(name, 100, 50, 10, 10, 10, 10, level);
    }

    public Mage(String name, double baseHp, double baseMana, double baseAttack, double baseMagic, double baseDefense, double baseSpeed, int level) {
        this.name = name;
        this.level = level;
        this.baseHp = baseHp;
        this.hp = baseHp + (10 * level);
        this.maxHp = baseHp + (10 * level);
        this.baseMana = baseMana;
        this.mana = baseMana + (2 * level);
        this.maxMana = baseMana + (2 * level);
        this.baseAttack = baseAttack;
        this.attack = baseAttack * (1 + 0.1 * level);
        this.baseMagic = baseMagic;
        this.magic = baseMagic * (1 + 2 * level);
        this.baseDefense = baseDefense;
        this.defense = baseDefense * (1 + 0.1 * level);
        this.baseSpeed = baseSpeed;
        this.speed = baseSpeed + (0.1 + 0.03 * level);
        this.maxSpeed = baseSpeed + (0.1 + 0.03 * level);
    }
    
    private void calculateStats() {
        this.maxHp = baseHp + (10 * level);
        this.maxMana = baseMana + (2 * level);
        this.maxSpeed = baseSpeed + (0.1 + 0.03 * level);
        this.attack = baseAttack * (1 + 0.1 * level);
        this.magic = baseMagic * (1 + 2 * level);
        this.defense = baseDefense * (1 + 0.1 * level);
        this.maxSpeed = baseSpeed + (1 + 0.03 * level);
        if (codex != null) {
            speed = maxSpeed * (0.8 + 0.07 * codex.getLevel());
        } else {
            speed = maxSpeed;
        }
    }

    @Override
    public double getMagic() {
        return codex == null ? magic : magic + codex.getMagic();
    }

    Codex getCodex() {
        return codex;
    }

    public void setCodex(Codex codex) {
        this.codex = codex;
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
        } else if (target instanceof Mage) {
            Mage mage = (Mage) target;
            mage.getAttacked(this.getAttack());
        } else if (target instanceof Assassin) {
            Assassin assassin = (Assassin) target;
            assassin.getAttacked(this.getAttack());
        }
    }

    protected void getAttackedMagic(double damage) {
        if (codex != null) {
            damage -= this.getMagic() * 0.5;
        }
        if (damage > 0) {
            hp -= damage;
        }
    }

    public void attackMagic(Character target) {
        if (target instanceof Warrior) {
            Warrior warrior = (Warrior) target;
            warrior.getAttackedMagic(this.getMagic());
        } else if (target instanceof Mage) {
            Mage mage = (Mage) target;
            mage.getAttackedMagic(this.getMagic());
        } else if (target instanceof Assassin) {
            Assassin assassin = (Assassin) target;
            assassin.getAttackedMagic(this.getMagic());
        }
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
